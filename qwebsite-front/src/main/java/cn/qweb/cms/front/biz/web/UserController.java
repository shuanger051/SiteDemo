package cn.qweb.cms.front.biz.web;

import cn.qweb.cms.biz.service.LessonService;
import cn.qweb.cms.biz.service.UserExtService;
import cn.qweb.cms.biz.service.UserService;
import cn.qweb.cms.biz.service.bo.UserExtSaveBO;
import cn.qweb.cms.biz.service.bo.UserSaveBO;
import cn.qweb.cms.biz.service.dto.LessonNumberDTO;
import cn.qweb.cms.biz.service.query.LessonQUERY;
import cn.qweb.cms.core.base.BaseController;
import cn.qweb.cms.core.base.Pagination;
import cn.qweb.cms.core.crypto.RSACryptoHelper;
import cn.qweb.cms.core.exception.BizException;
import cn.qweb.cms.core.exception.builder.ErrorBuilder;
import cn.qweb.cms.core.mvc.ShiroPasswordService;
import cn.qweb.cms.core.utils.IpUtil;
import cn.qweb.cms.core.validator.RegExpConstants;
import cn.qweb.cms.front.biz.manager.TripartiteManager;
import cn.qweb.cms.front.biz.manager.bo.BaseBO;
import cn.qweb.cms.front.biz.manager.bo.LoginBO;
import cn.qweb.cms.front.biz.manager.bo.param.*;
import cn.qweb.cms.front.biz.manager.dto.OrderDTO;
import cn.qweb.cms.front.biz.manager.dto.WithdrawalDTO;
import cn.qweb.cms.front.biz.web.entity.SessionUser;
import cn.qweb.cms.front.constant.LoginConstant;
import com.hazelcast.util.MD5Util;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.lang.reflect.InvocationTargetException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * Created by xuebj on 2017/4/17.
 */
@Controller()
@RequestMapping("/account")
public class UserController extends BaseController{

    @Autowired
    private UserService userService;

    @Autowired
    private UserExtService userExtService;

    @Autowired
    private ShiroPasswordService passwordService;

    @Autowired
    private TripartiteManager manager;



    /**
     * 支持手机号，邮箱和用户名
     * @param account 登入用户名，有手机号 邮箱和用户名3种格式
     * @param password 密码
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public Boolean login(String account, String password, HttpServletRequest request){
        if(StringUtils.isBlank(account) || StringUtils.isBlank(password)){
            throw getExcept();
        }

        password = RSACryptoHelper.decrypt(password);
//        if(match(account, RegExpConstants.MOBILE)){//手机号
//            return mobileLogin(account,password,request);
//        }else if(match(account,RegExpConstants.EMAIL)){
//            return emailLogin(account,password,request);
//        }
        return userNameLogin(account, password,request);
    }

    @ResponseBody
    @RequestMapping(value = "/modify",method = RequestMethod.POST)
    public Boolean update(UpdateUserInfoPAR userInfoPAR,HttpServletRequest request){
        SessionUser user = (SessionUser) request.getSession().getAttribute(LoginConstant.CURRENT_USER);
        BaseBO<UpdateUserInfoPAR> baseBO = new BaseBO<>();
        baseBO.setAccount(user.getUserName());
        baseBO.setMethod("updateUser");
        baseBO.setParam(userInfoPAR);
        baseBO.setSignature(user.getUserName() + "-" + user.getPassword());
        Map<String,Object> result = manager.modify(baseBO);
        if(isSuccess(result.get("result"))){
            user.setRealName(userInfoPAR.getName());
            user.setNickName(userInfoPAR.getNick_name());
            user.setCityId(userInfoPAR.getCity_id());
            user.setProvinceId(userInfoPAR.getProvince_id());
            user.setDistrictId(StringUtils.trimToEmpty(userInfoPAR.getDistrict_id()));
            return Boolean.TRUE;
        }else{
            throw new BizException(ErrorBuilder.buildBizError((String)result.get("message")));
        }
    }

    /**
     * 发送短信验证码
     * @param bean
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/send_code",method = RequestMethod.POST)
    public Boolean sendMsg(@Valid  SendMsgPAR bean){
        bean.setType("0");//找回密码
        BaseBO<SendMsgPAR> baseBO = new BaseBO<>();
        baseBO.setAccount(bean.getLogin_id());
        baseBO.setParam(bean);
        baseBO.setMethod("getPhoneCode");
        Map<String,Object> result = manager.sendMsg(baseBO);
        if(isSuccess(result.get("result"))){
            return Boolean.TRUE;
        }else{
            throw new BizException(ErrorBuilder.buildBizError((String)result.get("message")));
        }
    }

    @ResponseBody
    @RequestMapping(value = "/reset",method = RequestMethod.POST)
    public Boolean restPwd(RestPwdPAR bean){
        BaseBO<RestPwdPAR> baseBO = new BaseBO<>();
        bean.setNew_passwd(MD5Util.toMD5String(RSACryptoHelper.decrypt(bean.getNew_passwd())).toUpperCase());
        baseBO.setMethod("retriveAccount");
        baseBO.setAccount(bean.getMobile());
        baseBO.setParam(bean);
        Map<String,Object> result = manager.restPwd(baseBO);
        if(isSuccess(result.get("result"))){
            return Boolean.TRUE;
        }else{
            throw new BizException(ErrorBuilder.buildBizError((String)result.get("message")));
        }
    }

    @ResponseBody
    @RequestMapping(value = "/modify_pwd",method = RequestMethod.POST)
    public Boolean updatePwd(UpdatePwdPAR updatePwdPAR,HttpServletRequest request){
        updatePwdPAR.setOld_passwd(MD5Util.toMD5String(RSACryptoHelper.decrypt(updatePwdPAR.getOld_passwd())).toUpperCase());
        updatePwdPAR.setNew_passwd(MD5Util.toMD5String(RSACryptoHelper.decrypt(updatePwdPAR.getNew_passwd())).toUpperCase());
        SessionUser user = (SessionUser) request.getSession().getAttribute(LoginConstant.CURRENT_USER);
        BaseBO<UpdatePwdPAR> baseBO = new BaseBO<>();
        baseBO.setAccount(user.getUserName());
        baseBO.setMethod("updateAccount");
        baseBO.setParam(updatePwdPAR);
        baseBO.setSignature(user.getUserName() + "-" + user.getPassword());
        Map<String,Object> result = manager.modifyPwd(baseBO);
        if(isSuccess(result.get("result"))){
            user.setPassword(updatePwdPAR.getNew_passwd());
            return Boolean.TRUE;
        }else{
            throw new BizException(ErrorBuilder.buildBizError((String)result.get("message")));
        }
    }

    @ResponseBody
    @RequestMapping(value = "/user_info",method = RequestMethod.GET)
    public Map<String,Object> getUserInfo(HttpServletRequest request){
        SessionUser user = (SessionUser) request.getSession().getAttribute(LoginConstant.CURRENT_USER);
        BaseBO<Map> baseBO = new BaseBO<>();
        baseBO.setMethod("queryUser");
        baseBO.setParam(new HashMap<String,String>());
        baseBO.setSignature(user.getUserName() + "-" + user.getPassword());
        Map<String,Object> result = manager.getUserInfo(baseBO);
        if(isSuccess(result.get("result"))){
            return (Map<String, Object>) result.get("data");
        }else{
            throw new BizException(ErrorBuilder.buildBizError((String)result.get("message")));
        }
    }

    @ResponseBody
    @RequestMapping(value = "/orders",method = RequestMethod.GET)
    public Pagination<OrderDTO> queryOrder(Integer page, Integer pageSize,@RequestParam(required = false) String status,HttpServletRequest request) {
        SessionUser user = (SessionUser) request.getSession().getAttribute(LoginConstant.CURRENT_USER);
        BaseBO<PagePAR> baseBO = new BaseBO<>();
        baseBO.setAccount(user.getUserName());
        baseBO.setMethod("queryBill");
        baseBO.setSignature(user.getUserName() + "-" + user.getPassword());
        OrderPAR parame = new OrderPAR();
        parame.setPage_count(pageSize);
        parame.setPage_num(page);
        if(StringUtils.isNotBlank(status)){
            parame.setStatus(status);
        }
        baseBO.setParam(parame);
        Map<String,Object> result = manager.queryOrder(baseBO);
        if(isSuccess(result.get("result"))){
            Pagination<OrderDTO> orders = new Pagination<>();
            Map<String,Object> data = (Map<String, Object>) result.get("data");
            orders.setTotal(Long.parseLong(String.valueOf(data.get("record_count"))));
            List<Map> bills = (List<Map>) data.get("bills");
            List<OrderDTO> list = bills.stream().map(map -> {
                OrderDTO orderDTO = new OrderDTO();
                try {
                    BeanUtils.populate(orderDTO,map);
                    return orderDTO;
                } catch (IllegalAccessException | InvocationTargetException e) {
                    throw new BizException(ErrorBuilder.buildBizError("转换属性错误，稍后再试。"));

                }
            }).collect(Collectors.toList());
            orders.setData(list);
            return orders;
        }else{
            throw new BizException(ErrorBuilder.buildBizError((String)result.get("message")));
        }
    }

    @ResponseBody
    @RequestMapping(value = "/withdrawals",method = RequestMethod.GET)
    public Pagination<WithdrawalDTO> queryWithdrawals(Integer page, Integer pageSize, @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date start_time, @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")  Date end_time, HttpServletRequest request) {
        SessionUser user = (SessionUser) request.getSession().getAttribute(LoginConstant.CURRENT_USER);
        BaseBO<PagePAR> baseBO = new BaseBO<>();
        baseBO.setAccount(user.getUserName());
        baseBO.setMethod("queryWithdrawals");
        baseBO.setSignature(user.getUserName() + "-" + user.getPassword());
        WithDrawalPAR parame = new WithDrawalPAR();
        parame.setPage_count(pageSize);
        parame.setPage_num(page);
        baseBO.setParam(parame);
        if(null != start_time){
            parame.setStart_time(start_time.getTime());
            parame.setEnd_time(end_time.getTime());
        }
        Map<String,Object> result = manager.queryWithdrawals(baseBO);
        if(isSuccess(result.get("result"))){
            Pagination<WithdrawalDTO> withdrawals = new Pagination<>();
            Map<String,Object> data = (Map<String, Object>) result.get("data");
            withdrawals.setTotal(Long.parseLong(String.valueOf(data.get("record_count"))));
            List<Map> wallet = (List<Map>) data.get("wallet_details");
            List<WithdrawalDTO> list = wallet.stream().map(map -> {
                WithdrawalDTO dto = new WithdrawalDTO();
                try {
                    BeanUtils.populate(dto,map);
                    return dto;
                } catch (IllegalAccessException | InvocationTargetException e) {
                    throw new BizException(ErrorBuilder.buildBizError("转换属性错误，稍后再试。"));

                }
            }).collect(Collectors.toList());
            withdrawals.setData(list);
            return withdrawals;
        }else{
            throw new BizException(ErrorBuilder.buildBizError((String)result.get("message")));
        }
    }

    private void setUserSession(SessionUser user, HttpServletRequest request){
        request.getSession().setAttribute(LoginConstant.CURRENT_USER,user);
    }

    @ResponseBody
    @RequestMapping(value = "/regist",method = RequestMethod.POST)
    public Long regist(String account,String password,HttpServletRequest request){
        if(StringUtils.isBlank(account) || StringUtils.isBlank(password)){
            throw new BizException(ErrorBuilder.buildBizError("用户名或者密码格式错误"));
        }
        String pwd = RSACryptoHelper.decrypt(password);
        validPwd(pwd);
        if(!match(account,RegExpConstants.USERNAME)){
            throw new BizException(ErrorBuilder.buildBizError(RegExpConstants.USERNAME_MESSAGE));
        }
        UserSaveBO userSaveBO = new UserSaveBO();
        userSaveBO.setPassword(passwordService.encryptPassword(password,account));
        userSaveBO.setIsAdmin("0");//非管理员
        userSaveBO.setRegisterIp(IpUtil.getRemoteAddr(request));
        userSaveBO.setUserName(account);
        return userService.doSave(userSaveBO,new UserExtSaveBO());
    }

    /**
     * 退出
     * @param request
     * @return
     */
    @RequestMapping(value = "/logout",method = RequestMethod.GET)
    public String logout(HttpServletRequest request){
        request.getSession().removeAttribute(LoginConstant.CURRENT_USER);
        request.getSession().invalidate();
        return "redirect:/index.htm";
    }

    /**
     * 用户名登录
     * @param userName
     * @param password
     * @return
     */
    public Boolean userNameLogin(String userName,String password, HttpServletRequest request){
        String pwd = StringUtils.upperCase(MD5Util.toMD5String(password));
        LoginBO loginBO = new LoginBO();
        loginBO.setAccount(userName);
        loginBO.setParam(new HashMap<String,String>());
        loginBO.setSignature(userName + "-" + pwd);
        loginBO.setMethod("login");
        Map<String,Object> result = manager.login(loginBO);
        if(isSuccess(result.get("result"))){
            SessionUser user = new SessionUser();
            user.setUserName(userName);
            user.setPassword(pwd);
            //TODO 获取用户基本信息
            BaseBO<Map> userInfo = new BaseBO<>();
            userInfo.setAccount(userName);
            userInfo.setParam(new HashMap());
            userInfo.setSignature(userName + "-" + pwd);
            userInfo.setMethod("queryUser");
            Map<String,Object> userInfoResult = manager.getUserInfo(userInfo);
            if(isSuccess(userInfoResult.get("result"))){
               Map<String,Object> userInfoBean = (Map<String, Object>)((List)((Map)userInfoResult.get("data")).get("user_ids")).get(0);
               user.setUserId(String.valueOf(userInfoBean.get("user_id")));
               user.setMobile(String.valueOf(userInfoBean.get("phone_number")));
               user.setRealName(String.valueOf(userInfoBean.get("name")));
               user.setNickName(String.valueOf(userInfoBean.get("nick_name")));
               user.setAvatarAddress(String.valueOf(userInfoBean.get("avatar_address")));
               user.setProvinceId(String.valueOf(userInfoBean.get("province_id")));
               user.setCityId(String.valueOf(userInfoBean.get("city_id")));
               user.setDistrictId(String.valueOf(userInfoBean.get("district_id")));
            }else{
                throw new BizException(ErrorBuilder.buildBizError((String)userInfoResult.get("message")));
            }
            LessonQUERY query = new LessonQUERY();
            query.setTeacherId(user.getUserId());
            LessonNumberDTO dto = lessonService.queryLessonNumber(query);
            user.setTotalLesson(dto.getTotal());
            setUserSession(user,request);
            return Boolean.TRUE;
        }else{
            throw new BizException(ErrorBuilder.buildBizError((String)result.get("message")));
        }
    }


    private Boolean match(String account,String regex){
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(account);
        return matcher.matches();
    }

    private BizException getExcept(){
        if(null == exception){
            exception = new BizException(ErrorBuilder.buildBizError("账号或者密码错误"));
        }
        return exception;
    }


    /**
     * 验证密码是否符合要求
     * @param pwd 密码
     */
    private void validPwd(String pwd){
        Pattern pattern = Pattern.compile(RegExpConstants.PASSWORD);
        if(!pattern.matcher(pwd).matches()){
            throw new BizException(ErrorBuilder.buildBizError("密码格式错误"));
        }
    }

    private boolean isSuccess(Object success){
        if(1 == (Integer) success){
            return Boolean.TRUE;
        }else{
            return Boolean.FALSE;
        }
    }

    public static void main(String[] args) {
        System.out.println(MD5Util.toMD5String("1234567"));
    }

    /**
     * 统一的错误提示
     */
    private BizException  exception ;

    @Autowired
    private LessonService lessonService;
}
