package com.qweb.cms.test;

import java.io.IOException;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.IntField;
import org.apache.lucene.document.LongField;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.index.Term;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;


/**
 * Author: caijl
 * Package:com.qweb.cms.test
 * Project:qwebsite
 * Description:
 * Date: 2017/4/9
 * Time: 11:17
 * 系统版本:1.0.0
 */

public class Lucene5Test {

    private static String[] ids={"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
    private static String[] emails={"aa@aa.org","cc@cc.org","dd@dd.org","bb@bb.org","ee@ee.org","ff@ff.org","cc@cc.org","dd@dd.org","bb@bb.org","ee@ee.org","ff@ff.org","cc@cc.org","dd@dd.org","bb@bb.org","ee@ee.org","ff@ff.org","cc@cc.org","dd@dd.org","bb@bb.org","ee@ee.org","ff@ff.org","cc@cc.org","dd@dd.org","bb@bb.org","ee@ee.org","ff@ff.org","cc@cc.org","dd@dd.org","bb@bb.org","ee@ee.org","ff@ff.org"};
    private static String[] contents={"你好啊，小张","你好啊，小李","你好啊，小赵","你好啊，小王","校长好","大家好","高利贷","人民币","黄昏","天龙寺","天泉","龙门山","太阳","大地","清水","狂风","沙暴","白云","蓝天","细沙","钱塘江","珠江湾","黄河","少林寺","大哥","少妇","小弟","金币","机枪","砖头","羽毛"};
    private static String[] names={"liwu","zhangsan","xiaoqinag","laona","dabao","lisi","zhangsan","xiaoqinag","laona","dabao","lisi","zhangsan","xiaoqinag","laona","dabao","lisi","zhangsan","xiaoqinag","laona","dabao","lisi","zhangsan","xiaoqinag","laona","dabao","lisi","zhangsan","xiaoqinag","laona","dabao","lisi"};
    private static int[] attachs={1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31};
    private static Date[] dates=null ;

    //创建索引
    private static Directory directory = null ;
    //创建IndexWriter
    private static IndexWriter indexWriter = null ;
    //创建IndexReader
    private static IndexReader indexReader = null ;
    //创建searcher
    private static IndexSearcher search = null ;
    static {
        try {
            setDate() ;
            directory = FSDirectory.open(Paths.get("E:\\lucene_doc")) ;
            indexWriter = new IndexWriter(directory, new IndexWriterConfig(new StandardAnalyzer())) ;
            indexReader = DirectoryReader.open(directory) ;
            search = new IndexSearcher(indexReader);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void setDate() {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-mm-kk");
        try {
            dates=new Date[ids.length];
            dates[0]=sdf.parse("2010-08-17");
            dates[1]=sdf.parse("2011-02-17");
            dates[2]=sdf.parse("2012-03-17");
            dates[3]=sdf.parse("2011-04-17");
            dates[4]=sdf.parse("2012-05-17");
            dates[5]=sdf.parse("2011-07-17");
            dates[6]=sdf.parse("2011-02-17");
            dates[7]=sdf.parse("2012-03-17");
            dates[8]=sdf.parse("2011-04-17");
            dates[9]=sdf.parse("2012-05-17");
            dates[10]=sdf.parse("2011-07-17");
            dates[11]=sdf.parse("2011-02-17");
            dates[12]=sdf.parse("2012-03-17");
            dates[13]=sdf.parse("2011-04-17");
            dates[14]=sdf.parse("2012-05-17");
            dates[15]=sdf.parse("2011-07-17");
            dates[16]=sdf.parse("2011-02-17");
            dates[17]=sdf.parse("2012-03-17");
            dates[18]=sdf.parse("2011-04-17");
            dates[19]=sdf.parse("2012-05-17");
            dates[20]=sdf.parse("2011-07-17");
            dates[21]=sdf.parse("2011-02-17");
            dates[22]=sdf.parse("2012-03-17");
            dates[23]=sdf.parse("2011-04-17");
            dates[24]=sdf.parse("2012-05-17");
            dates[25]=sdf.parse("2011-07-17");
            dates[26]=sdf.parse("2011-02-17");
            dates[27]=sdf.parse("2012-03-17");
            dates[28]=sdf.parse("2011-04-17");
            dates[29]=sdf.parse("2012-05-17");
            dates[30]=sdf.parse("2011-07-17");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
          //createIndex () ;
         //delete() ;
        search () ;
        //paserQuery() ;
       // searchBypage02(1,2,"welcome to you");
    }


    /**
     * 创建/更新索引
     */
    public static void createIndex () {
        try {
            //清空当前所有索引
            indexWriter.deleteAll() ;
            //创建写入流
//            reader = new java.io.BufferedReader(new InputStreamReader(new FileInputStream("D:\\lucene\\files\\产品名称-拼音.txt"),"GBK"));
            for (int i = 0 ; i<=30; i++) {
                Document d = new Document();
                System.out.println(ids[i]+"-"+emails[i]+"-"+contents[i]+"-"+names[i]+"-"+attachs[i]+"-"+dates[i]);
                d.add(new Field("id",ids[i],TextField.TYPE_STORED)) ;
                d.add(new Field("email",emails[i],TextField.TYPE_STORED)) ;
                d.add(new Field("content",contents[i],TextField.TYPE_STORED)) ;
                d.add(new Field("name",names[i],TextField.TYPE_STORED)) ;
                d.add(new IntField("attach",1,IntField.TYPE_STORED)) ;
                d.add(new LongField("date",dates[i].getTime(),LongField.TYPE_STORED)) ;
                indexWriter.addDocument(d) ;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                //在这里writer必须要关掉或者commit。不然，会写入不进去数据
                indexWriter.commit() ;
//                indexWriter.close() ;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    //简单的查询
    public static void search (){
        System.out.println(indexReader.maxDoc()); //输出所有的DOC数
        System.out.println(indexReader.numDocs()); //输出可用的DOC数
        System.out.println(indexReader.numDeletedDocs()); //输出删除的DOC数
        try {
            //获取搜索域--shouzimu
            QueryParser parser = new QueryParser("content",new StandardAnalyzer()) ;
            //设置查询条件
            Query query = parser.parse("好");
            //设置查找结果 -最多为10条
            TopDocs tocs =  search.search(query,10) ;
            //遍历查询结果
            ScoreDoc[] docs = tocs.scoreDocs ;
            for (ScoreDoc sd : docs) {
                Document doc = search.doc(sd.doc) ;
                //这里的content输出为null。因为我们没有保存哦~
                System.out.println(doc.get("id")+":" + doc.get("email") + "-" + doc.get("content")+"-" + doc.get("name")+"-" + doc.get("attach")+"-" + doc.get("date"));
            }
        } catch (org.apache.lucene.queryparser.classic.ParseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //删除索引

    public static void delete () {
        try {
            //删除，放置在回收站中，可恢复
            indexWriter.deleteDocuments(new Term("shouzimu","xxxxlxw")) ;
            //删除，不可恢复
            indexWriter.forceMergeDeletes() ;
            indexWriter.commit() ;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //5中的方法 暂时不会啊= =、
    public static void undelete () {
    }

    //详解ParserQuery
    public static void paserQuery () {
        //这里我们定义一个基于标准分词器的Query;搜索域默认为content
        QueryParser parser = new QueryParser("content",new StandardAnalyzer()) ;
//        parser.setAllowLeadingWildcard(true) ;
        try {
            //在默认域中查找 有you的
            Query query = parser.parse("you");
            //在默认域中查找有 boy 或者girl 的
            query = parser.parse("boy girl");
            query = parser.parse("boy OR girl");
            //在name域中查号 name 为xiaoqinag的
            query = parser.parse("name:xiaoqinag");
            query = parser.parse("name : xiaoqinag");
            //查找邮箱结尾为@dd.org的   通配符查询不能用？！！！  待解决
            query = parser.parse("email:a?@aa.org");  //会报错 提示通配符不能放在首位
            //在默认域中查找 有how 且有 you的
            query = parser.parse("how AND you");
            //在默认域中查找 有hello 但是没有 girl的   千万要注意空格！
            query = parser.parse("-girl +hello");
            //完全匹配hello a boy
            query = parser.parse("\"hello a girl\"");
            //显示id 2-4 的闭区间 TO大写
            query = parser.parse("id:[2 TO 4]");
            //显示id 2-4 的开区间 TO大写
            query = parser.parse("id:{2 TO 4}");
            //显示id hello 和 boy 之间有小于1的
            query = parser.parse("\"hello boy\"~1");
            //模糊查询
            query = parser.parse("name:xiaoqiang~");
            query = parser.parse("attach:{2 TO 4}");
            TopDocs tdocs = search.search(query, 10) ;
            ScoreDoc[] sdoc = tdocs.scoreDocs;
            for (ScoreDoc sd : sdoc) {
                Document doc = search.doc(sd.doc) ;
                System.out.println(doc.get("id")+":" + doc.get("email") + "-" + doc.get("content")+"-" + doc.get("name")+"-" + doc.get("attach")+"-" + doc.get("date"));
            }
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //分页查询一
    public static void searchBypage01 (int page,int pageSize,String str) {
        int start = (page-1) * pageSize ;
        int end = start + pageSize ;
        QueryParser parser = new QueryParser("content",new StandardAnalyzer()) ;
        try {
            Query query = parser.parse(str) ;
            TopDocs tdos = search.search(query, 100) ;
            ScoreDoc[] sds = tdos.scoreDocs ;
            for (int i = start ;i <end;i++ ) {
                Document doc = search.doc(sds[i].doc) ;
                System.out.println(doc.get("id")+":" + doc.get("email") + "-" + doc.get("content")+"-" + doc.get("name")+"-" + doc.get("attach")+"-" + doc.get("date"));
            }
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //分页查询二
    public static void searchBypage02 (int page,int pageSize,String str) {
        int start = (page-1) * pageSize ;
//            int end = start + pageSize ;
        QueryParser parser = new QueryParser("content",new StandardAnalyzer()) ;
        try {
            Query query = parser.parse(str) ;
            TopDocs tdos = search.search(query, 100) ;
            ScoreDoc[] sds = tdos.scoreDocs ;
            tdos = search.searchAfter(sds[start], query, pageSize) ;
            sds = tdos.scoreDocs ;
            for (ScoreDoc sd : sds) {
                Document doc = search.doc(sd.doc) ;
                System.out.println(doc.get("id")+":" + doc.get("email") + "-" + doc.get("content")+"-" + doc.get("name")+"-" + doc.get("attach")+"-" + doc.get("date"));
            }
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
