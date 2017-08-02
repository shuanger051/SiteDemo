package cn.qweb.cms.core.utils;

import cn.qweb.cms.core.constants.SymbolConstants;
import org.apache.commons.lang3.CharUtils;
import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

/**
 * 字符串工具类
 * Created by xuebojie on 16/4/22.
 */
public final class StrUtil {

    private static final char UNDERLINE = CharUtils.toChar(SymbolConstants.UNDERLINE);

    /**
     * 驼峰规则的字符串转换为下划线的字符串
     *
     * @param str 被转换字符串
     * @return
     */
    public static final String camel2Underline(String str) {
        if (StringUtils.isBlank(str)) {
            return "";
        }
        int length = str.length();
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < length; i++) {
            char c = str.charAt(i);
            if (Character.isUpperCase(c)) {
                result.append(UNDERLINE);
                result.append(Character.toLowerCase(c));
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }

    /**
     * 下划线字符串转换为驼峰规则的字符串
     *
     * @param str 被转换字符串
     * @return
     */
    public static final String underline2Camel(String str) {
        if (StringUtils.isBlank(str)) {
            return "";
        }
        int length = str.length();
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < length; i++) {
            char c = str.charAt(i);
            if (c == UNDERLINE && ++i < length) {
                //已经增加了1
                result.append(Character.toUpperCase(str.charAt(i)));
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }

    /**
     * 将容易引起xss漏洞的半角字符直接替换成全角字符
     *
     * @param s
     * @return
     */
    public static String xssEncode(String s) {
        if (s == null || s.equals("")) {
            return s;
        }
        //< > ' " \ / # &
        s = s.replaceAll("<", "&lt;").replaceAll(">", "&gt;");
        s = s.replaceAll("\\(", "&#40;").replaceAll("\\)", "&#41;");
        s = s.replaceAll("'", "&#39;");
        s = s.replaceAll("eval\\((.*)\\)", "");
        s = s.replaceAll("[\\\"\\\'][\\s]*javascript:(.*)[\\\"\\\']", "\"\"");
        s = s.replaceAll("script", "");
        s = s.replaceAll("#", "＃");
        s = s.replaceAll("%", "％");
        try {
            s = URLDecoder.decode(s, "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return s;
    }

    /**
     * 对页面特殊字符进行编码
     *
     * @param s
     * @return
     */
    public static String escapeHtml(String s) {
        if (StringUtils.isBlank(s)) {
            return s;
        }
        s = s.replaceAll("&", "&amp;");
        s = s.replaceAll("<", "&lt;");
        s = s.replaceAll(">", "&gt;");
//        s = s.replaceAll(" ", "&nbsp;");
        s = s.replaceAll("\'", "&#39;");
        s = s.replaceAll("\"", "&quot;");
        return s;
    }

    /**
     * 对数据库特殊字符进行解码
     *
     * @param s
     * @return
     */
    public static String unescapeHtml(String s) {
        if (StringUtils.isBlank(s)) {
            return s;
        }
        s = s.replaceAll("&amp;", "&");
        s = s.replaceAll("&lt;", "<");
        s = s.replaceAll("&gt;", ">");
//        s = s.replaceAll("&nbsp;", " ");
        s = s.replaceAll("&#39;", "\'");
        s = s.replaceAll("&quot;", "\"");
        return s;
    }

    public static void main(String[] args) {
        String s1 = StrUtil.escapeHtml("&我是<大数据>实地了解'多少\"<p>\\\\是的福建省</p><span>河南老家</span>alter();");
        System.out.println(s1);
        String s2 = StrUtil.unescapeHtml("&amp;我是&lt;大数据&gt;实地了解&#39;多少&quot;&lt;p&gt;\\\\是的福建省&lt;/p&gt;&lt;span&gt;河南老家&lt;/span&gt;alter();");
        System.out.println(s2);
        String s3 = StringEscapeUtils.unescapeHtml4("&amp;我是&lt;大数据&gt;实地了解&#39;多少&quot;&lt;p&gt;\\\\是的福建省&lt;/p&gt;&lt;span&gt;河南老家&lt;/span&gt;alter();");
        System.out.println(s3);
    }

}
