package cn.qweb.cms.front.directive;

import cn.qweb.cms.biz.service.TeacherService;
import cn.qweb.cms.biz.service.dto.TeacherDTO;
import cn.qweb.cms.core.exception.BizException;
import cn.qweb.cms.core.exception.builder.ErrorBuilder;
import cn.qweb.cms.core.freemarker.BaseDirective;
import cn.qweb.cms.core.freemarker.DirectiveUtils;
import freemarker.core.Environment;
import freemarker.template.TemplateDirectiveBody;
import freemarker.template.TemplateDirectiveModel;
import freemarker.template.TemplateException;
import freemarker.template.TemplateModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Map;

/**
 * Created by xuebj on 2017/4/20.
 */
@Component("teacher")
public class TeacherDirective extends BaseDirective implements TemplateDirectiveModel{
    /**
     * 输入参数，下一篇。
     */
    private static final String PARAM_NEXT = "next";

    private static final String PARAM_TYPE = "type";

    private static final String PARAM_LEVLE = "level";

    @Override
    public void execute(Environment env, Map params, TemplateModel[] loopVars, TemplateDirectiveBody body) throws TemplateException, IOException {
        Long id = DirectiveUtils.getLong(PARAM_ID,params);
        Boolean next = DirectiveUtils.getBool(PARAM_NEXT, params);
        TeacherDTO content = null;
        if(next == null){
            if(null != id){
                content = teacherService.get(id);
            }else{
                throw new BizException(ErrorBuilder.buildBizError(PARAM_ID + "参数不能为空"));
            }
        }else{
            String  type = DirectiveUtils.getString(PARAM_TYPE,params);
            Integer level = DirectiveUtils.getInt(PARAM_LEVLE,params);
            content = teacherService.getNext(id,type,level,next);
        }
        setBeanVar(content, env, params,body);
    }

    @Autowired
    private TeacherService teacherService;
}
