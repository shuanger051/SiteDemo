package com.qweb.cms.test;

import cn.qweb.cms.Application;
import cn.qweb.cms.biz.service.ActivityService;
import cn.qweb.cms.biz.service.TrainApplyService;
import cn.qweb.cms.biz.service.dto.ActivityDTO;
import cn.qweb.cms.biz.service.dto.TrainApplyDTO;
import cn.qweb.cms.biz.service.query.ActivityQUERY;
import cn.qweb.cms.biz.service.query.TrainApplyQUERY;
import cn.qweb.cms.biz.web.LuceneController;
import cn.qweb.cms.core.lucene.LuceneUtils;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.*;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.Directory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.wltea.analyzer.lucene.IKAnalyzer;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Author: caijl
 * Package:PACKAGE_NAME
 * Project:qwebsite
 * Description:
 * Date: 2017/4/8
 * Time: 17:26
 * 系统版本:1.0.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=Application.class)
public class LuceneUtilsTest {
    private static final Logger logger = LoggerFactory.getLogger(LuceneUtilsTest.class);

    private static final String indexPath = "E://GIT//QWEBSITE//QWEBSITE//qwebsite-console//src//main//resources//static//lucene//";

    @Autowired
    private TrainApplyService trainApplyService;
    @Autowired
    private ActivityService activityService;


    @Test
    public void createIndex() throws IOException {

        long startTime = System.currentTimeMillis();

        Directory directory = LuceneUtils.openFSDirectory(indexPath);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        Analyzer analyzer = new StandardAnalyzer();

        IndexWriterConfig indexWriterConfig = new IndexWriterConfig(analyzer);

        IndexWriter indexWriter = LuceneUtils.getIndexWrtier(directory,indexWriterConfig);

        ActivityQUERY activityQUERY = new ActivityQUERY();
        List<ActivityDTO> activityDTOList = activityService.queryLuceneList(activityQUERY);

        for (int i = 0 ; i < activityDTOList.size(); i++) {
            Document documentActivity = new Document();
            ActivityDTO activityDTO = activityDTOList.get(i);
            System.out.println(activityDTO.getTitle());
            documentActivity.add(new Field("id",Long.toString(activityDTO.getId()),TextField.TYPE_STORED));
            documentActivity.add(new Field("title", activityDTO.getTitle(), TextField.TYPE_STORED));
            documentActivity.add(new Field("gmtAdd",simpleDateFormat.format(new Date()),TextField.TYPE_STORED));
            documentActivity.add(new Field("link","https://www.baidu.com",TextField.TYPE_STORED));
            indexWriter.addDocument(documentActivity);
        }
        logger.info("开始添加#活动数据#索引...");


        indexWriter.commit();
        LuceneUtils.closeIndexWriter(indexWriter);

        System.out.println(System.currentTimeMillis()-startTime);

    }

    @Test
    public void search() throws Exception{
        //0、搜索关键字
        String queryString ="好";

       Directory directory = LuceneUtils.openFSDirectory(indexPath);
        Analyzer analyzer = new StandardAnalyzer();
        IndexReader reader = LuceneUtils.getIndexReader(directory);
        IndexSearcher search = new IndexSearcher(reader);
        QueryParser parser = new QueryParser("title", analyzer);
        Query query = parser.parse(queryString);

        TopDocs tocs = search.search(query, 100);
        System.out.println("总共有【" + tocs.totalHits + "】条匹配结果");

        //遍历查询结果
        ScoreDoc[] docs = tocs.scoreDocs ;
        for (ScoreDoc sd : docs) {
            Document doc = search.doc(sd.doc) ;
            //这里的content输出为null。因为我们没有保存哦~
            System.out.println("title     = " + doc.get("title"));
        }

        reader.close();


    }

}
