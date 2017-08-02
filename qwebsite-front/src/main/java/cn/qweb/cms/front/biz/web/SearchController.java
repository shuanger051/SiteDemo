package cn.qweb.cms.front.biz.web;

import cn.qweb.cms.biz.service.dto.LuceneDTO;
import cn.qweb.cms.biz.service.query.LuceneQUERY;
import cn.qweb.cms.core.base.BaseController;
import cn.qweb.cms.core.base.Pagination;
import cn.qweb.cms.core.lucene.LuceneUtils;
import cn.qweb.cms.core.lucene.Page;
import io.swagger.annotations.ApiOperation;
import org.apache.lucene.document.*;
import org.apache.lucene.search.Sort;
import org.apache.lucene.search.SortField;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 * Author: caijl
 * Package:cn.qweb.cms.front.biz.web
 * Project:qwebsite
 * Description:
 * Date: 2017/6/8
 * Time: 13:50
 * 系统版本:1.0.0
 */
@RestController
@RequestMapping("/search")
@ConfigurationProperties(prefix = "indexresource")
public class SearchController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(SearchController.class);

    private String baseIndexPath;

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

    public String getBaseIndexPath() {
        return baseIndexPath;
    }

    public void setBaseIndexPath(String baseIndexPath) {
        this.baseIndexPath = baseIndexPath;
    }
}
