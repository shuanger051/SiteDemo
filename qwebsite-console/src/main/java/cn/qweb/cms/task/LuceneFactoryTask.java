package cn.qweb.cms.task;

import cn.qweb.cms.biz.service.ContentExtService;
import cn.qweb.cms.biz.service.bo.ContentExtUpdateBO;
import cn.qweb.cms.biz.service.dto.ContentExtDTO;
import cn.qweb.cms.biz.service.query.ContentExtQUERY;
import cn.qweb.cms.biz.web.LuceneController;
import cn.qweb.cms.core.lucene.LuceneUtils;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.*;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.store.Directory;
import org.apache.lucene.util.BytesRef;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Author: caijl
 * Package:cn.qweb.cms.task
 * Project:qwebsite
 * Description:
 * Date: 2017/6/13
 * Time: 10:25
 * 系统版本:1.0.0
 */
@Component
@ConfigurationProperties(prefix = "indexresource")
public class LuceneFactoryTask {

    private static final Logger logger = LoggerFactory.getLogger(LuceneFactoryTask.class);

    private String baseIndexPath;

    @Autowired
    private ContentExtService contentExtService;

    @Scheduled(cron = " 0 0 0 * * ?")
    public void createLuceneIndex(){
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
                    documentActivity.add(new LongField("id",contentExtDTO.getId(), Field.Store.YES));
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
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getBaseIndexPath() {
        return baseIndexPath;
    }

    public void setBaseIndexPath(String baseIndexPath) {
        this.baseIndexPath = baseIndexPath;
    }
}
