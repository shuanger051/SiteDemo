package cn.qweb.cms.biz.web;

import cn.qweb.cms.biz.service.UserExtService;
import cn.qweb.cms.biz.service.UserService;
import cn.qweb.cms.biz.service.bo.UserExtSaveBO;
import cn.qweb.cms.biz.service.bo.UserExtUpdateBO;
import cn.qweb.cms.biz.service.bo.UserSaveBO;
import cn.qweb.cms.biz.service.bo.UserUpdateBO;
import cn.qweb.cms.biz.service.dto.UserDTO;
import cn.qweb.cms.biz.service.dto.UserExtDTO;
import cn.qweb.cms.biz.service.query.UserQUERY;
import cn.qweb.cms.core.base.BaseController;
import cn.qweb.cms.core.base.Pagination;
import cn.qweb.cms.core.crypto.RSACryptoHelper;
import cn.qweb.cms.core.exception.BizException;
import cn.qweb.cms.core.exception.builder.ErrorBuilder;
import cn.qweb.cms.core.mvc.ShiroPasswordService;
import cn.qweb.cms.core.utils.IpUtil;
import cn.qweb.cms.core.validator.RegExpConstants;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.regex.Pattern;


@RestController
@RequestMapping("/user")
public class UserController extends BaseController{

    @Autowired
    private UserService userService;

    @Autowired
    private UserExtService userExtService;

    @Autowired
    private ShiroPasswordService passwordService;

    @ApiOperation(value = "获取列表")
    @ApiImplicitParam(name = "bean", value = "查询对象", dataType = "UserQUERY")
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public Pagination<UserDTO> getUserList(@Valid UserQUERY bean){
        return userService.list(bean);
    }

    @ApiOperation(value = "根据ID获取对象")
    @ApiImplicitParam(name = "id", value = "ID", required = true, paramType = "path", dataType = "Long")
    @RequestMapping(value = "/get",method = RequestMethod.GET)
    public UserDTO getUser(Long id){
        return userService.get(id);
    }

    @ApiOperation(value = "根据ID获取对象")
    @ApiImplicitParam(name = "id", value = "ID", required = true, paramType = "path", dataType = "Long")
    @RequestMapping(value = "/ext/get",method = RequestMethod.GET)
    public UserExtDTO getUserExt(Long id){
        return userExtService.getByUserId(id);
    }

    @ApiOperation(value="创建")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "bean", value = "详细实体信息", required = true, dataType = "UserSaveBO"),
            @ApiImplicitParam(name="useExtBean", value = "需要保存的用户扩展信息",required = true, dataType = "UserExtSaveBO")
    })
    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public Long postUser(HttpServletRequest request,@Valid UserSaveBO bean, @Valid UserExtSaveBO userExtBean){
        bean.setRegisterIp(IpUtil.getRemoteAddr(request));
        String pwd = RSACryptoHelper.decrypt(bean.getPassword());
        validPwd(pwd);
        bean.setPassword(passwordService.encryptPassword(pwd,bean.getUserName()));
        return userService.doSave(bean,userExtBean);
    }


    @ApiOperation(value="更新详细信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name="bean", value = "需要更新的实体信息",required = true, dataType = "UserUpdateBO"),
            @ApiImplicitParam(name="useExtBean", value = "需要更新的用户扩展信息",required = true, dataType = "UserExtUpdateBO")
    })
    @RequestMapping(value = "/edit",method = RequestMethod.PUT)
    public String putUser(@Valid UserUpdateBO bean, @Valid UserExtUpdateBO useExtBean){
        UserDTO userDTO = userService.get(bean.getId());
        if(userDTO == null){
            throw new BizException(ErrorBuilder.buildBizError("用户不存在"));
        }
        if(StringUtils.isNotEmpty(bean.getPassword())){
            String pwd = RSACryptoHelper.decrypt(bean.getPassword());
            validPwd(pwd);
            bean.setPassword(passwordService.encryptPassword(pwd,userDTO.getUserName()));
        }
        userService.doUpdate(bean,useExtBean);
        return SUCCESS;
    }

//    @ApiOperation(value="删除", notes="根据url的id来指定删除对象")
//    @ApiImplicitParam(name = "id", value = "ID", required = true, dataType = "Long")
//    @RequestMapping(value="/del", method=RequestMethod.DELETE)
//    public String deleteUser(Long id) {
//        userService.doRemove(id);
//        return SUCCESS;
//    }
//
//    @ApiOperation(value="删除", notes="根据条件删除对象")
//    @ApiImplicitParam(name = "bean", value = "", required = true,  dataType = "UserRemoveBO")
//    @RequestMapping(value="/remove", method=RequestMethod.DELETE)
//    public String removeUser(UserRemoveBO bean) {
//        userService.doRemove(bean);
//        return SUCCESS;
//    }

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

}