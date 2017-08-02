package cn.qweb.cms.front.biz.manager;

import cn.qweb.cms.front.biz.manager.bo.BaseBO;
import cn.qweb.cms.front.biz.manager.bo.param.*;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

/**
 * Created by xuebj on 2017/5/9.
 */
@FeignClient(name = "tripartiteService",url = "${feign.url}")
public interface TripartiteManager {

    @RequestMapping(method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
    Map<String,Object> login(BaseBO<Map> bean);

    @RequestMapping(method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
    Map<String,Object> modify(BaseBO<UpdateUserInfoPAR> bean);

    @RequestMapping(method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
    Map<String,Object> modifyPwd(BaseBO<UpdatePwdPAR> bean);

    @RequestMapping(method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
    Map<String,Object> getUserInfo(BaseBO<Map> bean);

    /**
     * 发送短信验证码
     * @param bean
     * @return
     */
    @RequestMapping(method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
    Map<String,Object> sendMsg(BaseBO<SendMsgPAR> bean);

    /**
     * 重置密码
     * @param bean
     * @return
     */
    @RequestMapping(method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
    Map<String,Object> restPwd(BaseBO<RestPwdPAR> bean);

    /**
     * 获取订单列表
     * @param bean
     * @return
     */
    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    Map<String,Object> queryOrder(BaseBO<PagePAR> bean);

    /**
     * 获取提现列表
     * @param bean
     * @return
     */
    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    Map<String,Object> queryWithdrawals(BaseBO<PagePAR> bean);

}
