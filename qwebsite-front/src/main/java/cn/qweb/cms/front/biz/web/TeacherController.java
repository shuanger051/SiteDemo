package cn.qweb.cms.front.biz.web;

import cn.qweb.cms.biz.service.TeacherService;
import cn.qweb.cms.biz.service.bo.TeacherUpdateBO;
import cn.qweb.cms.biz.service.dto.TeacherDTO;
import cn.qweb.cms.biz.service.query.TeacherQUERY;
import cn.qweb.cms.core.base.Pagination;
import cn.qweb.cms.core.mvc.BaseForwardController;
import cn.qweb.cms.front.util.URLHelper;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.Map;

/**
 * Created by xuebj on 2017/4/20.
 */
@Controller
@RequestMapping("/teacher")
public class TeacherController extends BaseForwardController {

    @Autowired
    private TeacherService teacherService;

    @RequestMapping(value = "/{id}.htm",method = RequestMethod.GET)
    public ModelAndView forward(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("s")Map<String,Object> root){
        String[] paths = URLHelper.getPaths(request);
        String p = paths[1];
        if(StringUtils.equals(p,"index")){
            ModelAndView mv =  new ModelAndView("teacher/index");
            return mv;
        }
        TeacherDTO teacher = teacherService.get(Long.parseLong(p));
        super.setRequest(request,response,root, teacher.getType().equalsIgnoreCase("2"));
        ModelAndView mv =  new ModelAndView("teacher/content");
        mv.addObject("bean", teacher);
        return mv;
    }

    @ApiOperation(value = "获取列表")
    @ApiImplicitParam(name = "bean", value = "查询对象", dataType = "ContentQUERY")
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    @ResponseBody
    public Pagination<TeacherDTO> getContentList(@Valid TeacherQUERY bean){
        return teacherService.list(bean);
    }



    @ApiOperation(value = "导师浏览次统计")
    @ApiImplicitParam(name = "导师id", value = "id", dataType = "java.lang.Long")
    @RequestMapping(value = "/view",method = RequestMethod.GET)
    @ResponseBody
    public String view(@Valid Long id){
        TeacherDTO teacherDTO = teacherService.get(id);
        TeacherUpdateBO updateBO = new TeacherUpdateBO();
        updateBO.setId(id);
        updateBO.setViews(teacherDTO.getViews() + 1);
        teacherService.doUpdate(updateBO);
        return "success";
    }
}
