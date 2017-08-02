package cn.qweb.cms.front.biz.web;

import cn.qweb.cms.biz.service.LessonService;
import cn.qweb.cms.biz.service.WxActivityService;
import cn.qweb.cms.biz.service.dto.LessonDTO;
import cn.qweb.cms.biz.service.dto.WxActivityDTO;
import cn.qweb.cms.biz.service.query.LessonQUERY;
import cn.qweb.cms.biz.service.query.WxActivityQUERY;
import cn.qweb.cms.core.base.Pagination;
import cn.qweb.cms.core.crypto.Coder;
import cn.qweb.cms.core.crypto.CryptoCache;
import cn.qweb.cms.core.crypto.RSACryptoHelper;
import cn.qweb.cms.core.exception.BizException;
import cn.qweb.cms.core.exception.builder.ErrorBuilder;
import cn.qweb.cms.front.jwt.AccessToken;
import cn.qweb.cms.front.jwt.Audience;
import cn.qweb.cms.front.jwt.JwtHelper;
import cn.qweb.cms.front.jwt.LoginBO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * Created by xuebj on 2017/5/17.
 */
@RestController
@RequestMapping("/api/v1")
@ConfigurationProperties(prefix = "uploadresource")
@EnableConfigurationProperties(Audience.class)
public class ApiController {

    @Autowired
    private Audience audience;

    @Autowired
    private LessonService lessonService;

    @Autowired
    private WxActivityService activityService;

    /**
     * 文件访问路径
     */
    private String viewPath;

    /**
     * 获取RSAkey
     * @return
     */
    @RequestMapping(value = "/key",method = RequestMethod.GET)
    public String key(){
        return StringUtils.replaceEachRepeatedly(CryptoCache.getRASPublicKey(), new String[]{"\r\n", "\n"}, new String[]{"", ""});
    }

    @RequestMapping(value = "/encrypt",method = RequestMethod.GET)
    public String encrypt(String content){
        return StringUtils.replaceEachRepeatedly(RSACryptoHelper.encrypt(content), new String[]{"\r\n", "\n"}, new String[]{"", ""});
    }

    /**
     * 登录
     * @return
     */
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public AccessToken login(@Valid LoginBO bean) throws Exception {
        String pwd = RSACryptoHelper.decrypt(bean.getPassword());
        String dbPwd = new String (Coder.decryptBASE64(audience.getPassword()));
        if(StringUtils.equals(bean.getAccount(),audience.getAccount()) && StringUtils.equals(pwd,dbPwd)){
            String jwtToken = JwtHelper.createJWT(audience.getAccount(),audience.getExpiresSecond(),audience.getMd5String());
            return new AccessToken(jwtToken,audience.getType(), audience.getExpiresSecond());
        }else{
            throw new BizException(ErrorBuilder.buildBizError("用户名或者密码错误"));
        }
    }

    /**
     * 查询课程
     * @param bean
     * @return
     */
    @RequestMapping("/lesson/query")
    public Pagination<LessonDTO> queryLesson(LessonQUERY bean){
        Pagination<LessonDTO> result = lessonService.list(bean);
        result.getData().stream().forEach(lessonDTO -> lessonDTO.setLessonPic(viewPath + lessonDTO.getLessonPic()));
        return result;
    }


    /**
     * 查询 赛事活动
     * @param bean
     * @return
     */
    @RequestMapping("/activity/query")
    public Pagination<WxActivityDTO> queryActivity(WxActivityQUERY bean){
        Pagination<WxActivityDTO> result = activityService.list(bean);
        result.getData().stream().forEach(dto -> dto.setActivityPic(viewPath + dto.getActivityPic()));
        return result;
    }

    public String getViewPath() {
        return viewPath;
    }

    public void setViewPath(String viewPath) {
        this.viewPath = viewPath;
    }
}
