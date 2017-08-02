package cn.qweb.cms.biz.web;

import cn.qweb.cms.biz.service.*;
import cn.qweb.cms.biz.service.bo.*;
import cn.qweb.cms.biz.service.dto.*;
import cn.qweb.cms.biz.service.query.*;
import cn.qweb.cms.core.base.BaseController;
import cn.qweb.cms.core.base.Pagination;
import cn.qweb.cms.core.lucene.LuceneUtils;
import cn.qweb.cms.core.lucene.Page;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.*;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.search.Sort;
import org.apache.lucene.search.SortField;
import org.apache.lucene.store.Directory;
import org.apache.lucene.util.BytesRef;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/lucene")
@ConfigurationProperties(prefix = "indexresource")
public class LuceneController extends BaseController{

    private static final Logger logger = LoggerFactory.getLogger(LuceneController.class);

    private String baseIndexPath;

    @Autowired
    private ContentExtService contentExtService;

    @ApiOperation(value="创建")
    @RequestMapping(value = "/create",method = RequestMethod.GET)
    public String createLuceneIndex(){

        try {
            logger.info("开始创建索引...");
            Directory directory = LuceneUtils.openFSDirectory(baseIndexPath);
            IndexWriterConfig indexWriterConfig = new IndexWriterConfig(new StandardAnalyzer());
            IndexWriter indexWriter = new IndexWriter(directory,indexWriterConfig);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String now = simpleDateFormat.format(new Date());
            logger.info("开始获取索引数据...");

            logger.info("开始添加#内容数据#索引...");
            int extTotalNum = contentExtService.queryUnIndexTotalNum();
            int extTotalPage = LuceneUtils.getTotalPageNum(extTotalNum);
            for(int i = 0;i < extTotalPage;i++){
                ContentExtQUERY contentExtQUERY = new ContentExtQUERY();
                contentExtQUERY.setPage(i+1);
                contentExtQUERY.setPageSize(LuceneUtils.lucenePageSize);
                List<ContentExtDTO> list = contentExtService.queryUnIndexList(contentExtQUERY);
                for (ContentExtDTO contentExtDTO : list){
                    Document documentActivity = new Document();
                    documentActivity.add(new LongField("id",contentExtDTO.getId(),Field.Store.YES));
                    documentActivity.add(new TextField("title", contentExtDTO.getTitle(), Field.Store.YES));
                    documentActivity.add(new StringField("gmtAdd",now,Field.Store.YES));
                    documentActivity.add(new StringField("gmtCreate",now,Field.Store.YES));
                    documentActivity.add(new SortedDocValuesField("gmtAdd", new BytesRef(now)));
                    documentActivity.add(new SortedDocValuesField("gmtCreate", new BytesRef(now)));
                    documentActivity.add(new TextField("content", contentExtDTO.getDescription() == null ? "本篇资讯暂未获取到任何与此相关的描述内容，请直接点击链接，进入内容详情页查看具体内容信息。" : contentExtDTO.getDescription(), Field.Store.YES));

                    //根据content_id查询出所属栏目，然后拼接详情链接
                    String channel = contentExtService.queryChannelByContentID(contentExtDTO.getContentId());
                    if(null != channel && channel != ""){
                        documentActivity.add(new StringField("link",channel + "/" + contentExtDTO.getContentId() + ".jhtm",Field.Store.YES));
                    }else{
                        documentActivity.add(new StringField("link","#",Field.Store.YES));
                    }

                    indexWriter.addDocument(documentActivity);
                    //更新索引时间
                    ContentExtUpdateBO contentExtUpdateBO = new ContentExtUpdateBO();
                    contentExtUpdateBO.setGmtIndex(new Date());
                    contentExtUpdateBO.setId(contentExtDTO.getId());
                    contentExtUpdateBO.setContentId(contentExtDTO.getContentId());
                    contentExtService.doUpdate(contentExtUpdateBO);
                }
            }

            logger.info("数据添加完成，准备提交...");
            indexWriter.commit();
            LuceneUtils.closeIndexWriter(indexWriter);

            logger.info("创建全站搜索索引完成...");
            return SUCCESS;

        } catch (IOException e) {
            e.printStackTrace();
            return FAILURE;
        }
    }

    @ApiOperation(value = "分页查询索引信息")
    @RequestMapping(value = "/queryIndex",method = RequestMethod.GET)
    public Pagination<LuceneDTO> queryLuceneIndexPage(@Valid LuceneQUERY bean){
        Pagination<LuceneDTO> result = new Pagination<>();
        List<LuceneDTO> list = new ArrayList<LuceneDTO>();
        if(bean == null || null == bean.getQueryString() ||  "".equals(bean.getQueryString().trim())){
            result.setData(list);
            result.setTotal(0L);
            return result;
        }

        try {
            Page<Document> page = LuceneUtils.pageQuery(bean.getQueryString(), bean.getFieldName(), baseIndexPath, bean.getPage(), bean.getPageSize(),new Sort(new SortField("gmtAdd", SortField.Type.STRING,true)));
            if(page == null || page.getItems() == null || page.getItems().size() == 0)  {
                result.setData(list);
                result.setTotal(0L);
                return result;
            }else{
                for (Document doc : page.getItems()){
                    LuceneDTO luceneDTO = new LuceneDTO();
                    luceneDTO.setId(Long.parseLong(doc.get("id")));
                    luceneDTO.setTitle(doc.get("title"));
                    luceneDTO.setGmtAdd(doc.get("gmtAdd"));
                    luceneDTO.setGmtAdd(doc.get("gmtCreate"));
                    luceneDTO.setContent(doc.get("content"));
                    luceneDTO.setLink(doc.get("link"));
                    list.add(luceneDTO);
                }
                result.setData(list);
                result.setTotal((long) page.getTotalRecord());
                return result;
            }
        }catch (Exception e){
            e.printStackTrace();
            result.setData(list);
            result.setTotal(0L);
            return result;
        }
    }

    @ApiOperation(value="删除", notes="删除索引目录下所有索引文件")
    @RequestMapping(value="/delIndex", method=RequestMethod.DELETE)
    public String deleteLucene() {
        try {

            //获取未索引数据总条数
            int extTotalNum = contentExtService.queryIndexTotalNum();
            int extTotalPage = LuceneUtils.getTotalPageNum(extTotalNum);
            for (int i = 0;i < extTotalPage;i++){
                ContentExtQUERY contentExtQUERY = new ContentExtQUERY();
                contentExtQUERY.setPage(i+1);
                contentExtQUERY.setPageSize(LuceneUtils.lucenePageSize);
                List<ContentExtDTO> list = contentExtService.queryIndexList(contentExtQUERY);
                for (ContentExtDTO contentExtDTO: list){
                    ContentExtUpdateBO contentExtUpdateBO = new ContentExtUpdateBO();
                    contentExtUpdateBO.setId(contentExtDTO.getId());
                    contentExtUpdateBO.setContentId(contentExtDTO.getContentId());
                    contentExtService.updateIndexTime(contentExtUpdateBO);
                }
            }

            logger.info("开始删除索引...");
            Directory directory = LuceneUtils.openFSDirectory(baseIndexPath);
            IndexWriterConfig indexWriterConfig = new IndexWriterConfig(new StandardAnalyzer());
            IndexWriter indexWriter = new IndexWriter(directory,indexWriterConfig);
            indexWriter.deleteAll() ;
            indexWriter.commit();
            indexWriter.close();
            return SUCCESS;
        }catch (Exception e){
            logger.error(e.getMessage());
            return FAILURE;
        }
    }

    public String getBaseIndexPath() {
        return baseIndexPath;
    }

    public void setBaseIndexPath(String baseIndexPath) {
        this.baseIndexPath = baseIndexPath;
    }
}