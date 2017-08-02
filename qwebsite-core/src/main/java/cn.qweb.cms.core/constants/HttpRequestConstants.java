package cn.qweb.cms.core.constants;

/**
 * http请求相关常量集合
 * Created by xuebj on 16/6/13.
 */
public interface HttpRequestConstants {
    /**
     * request 请求头中的accept
     */
    String HEADER_ACCEPT = "accept";

    /**
     * request 请求头中的accept 的json内容
     */
    String HEADER_ACCEPT_JSON = "application/json";

    /**
     * request 请求头中的X-Requested-With
     */
    String HEADER_XREQUESTEDWITH  = "X-Requested-With";

    /**
     * request 请求头中的X-Requested-With  XMLHttpRequest
     */
    String HEADER_XREQUESTEDWITH_XMLHTTPREQUEST = "XMLHttpRequest";
}
