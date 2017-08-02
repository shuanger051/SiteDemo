package cn.qweb.cms.front.directive;

import cn.qweb.cms.biz.service.TeacherService;
import cn.qweb.cms.biz.service.dto.TeacherDTO;
import cn.qweb.cms.biz.service.query.TeacherQUERY;
import cn.qweb.cms.core.freemarker.BaseDirective;
import cn.qweb.cms.core.freemarker.DirectiveUtils;
import freemarker.core.Environment;
import freemarker.template.TemplateDirectiveBody;
import freemarker.template.TemplateDirectiveModel;
import freemarker.template.TemplateException;
import freemarker.template.TemplateModel;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Created by xuebj on 2017/4/11.
 */
@Component("teacher_list")
public class TeacherListDirective extends BaseDirective implements TemplateDirectiveModel{

    private static final String PARAM_TYPE = "type";

    private static final String PARAM_LEVEL = "level";

    /**
     * 默认1 表示显示
     */
    private static final String PARAM_IS_ENABLED = "isEnabled";

    /**
     * 条数
     */
    private static final String PARAM_SIZE = "size";

    @Override
    public void execute(Environment env, Map params, TemplateModel[] loopVars, TemplateDirectiveBody body) throws TemplateException, IOException {
        String type = DirectiveUtils.getString(PARAM_TYPE,params);
        Integer level = DirectiveUtils.getInt(PARAM_LEVEL, params);
        String isEnabled = DirectiveUtils.getString(PARAM_IS_ENABLED,params);
        Integer size = DirectiveUtils.getInt(PARAM_SIZE,params);

        TeacherQUERY queryBean = new TeacherQUERY();
        queryBean.setLevel(level == null ? null: level);
        queryBean.setType(StringUtils.isBlank(type)? null : type);
        queryBean.setIsEnabled(StringUtils.isBlank(isEnabled)? "1":null);
        queryBean.setPageSize(null == size ? 100 : size);
        List<TeacherDTO> teachers = teacherService.queryList(queryBean);
        setListVar(teachers,env,params,body);
    }

    @Autowired
    private TeacherService teacherService;
}
