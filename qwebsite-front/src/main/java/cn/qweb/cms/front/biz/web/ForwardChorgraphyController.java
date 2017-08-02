package cn.qweb.cms.front.biz.web;

import cn.qweb.cms.biz.service.ChorgraphyAttachmentService;
import cn.qweb.cms.biz.service.ChorgraphyService;
import cn.qweb.cms.biz.service.dto.ChorgraphyAttachmentDTO;
import cn.qweb.cms.biz.service.dto.ChorgraphyDTO;
import cn.qweb.cms.biz.service.query.ChorgraphyAttachmentQUERY;
import cn.qweb.cms.core.mvc.BaseForwardController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

/**
 * Created by xuebj on 2017/5/12.
 */
@Controller
@RequestMapping("/chorgraphy")
public class ForwardChorgraphyController extends BaseForwardController{


    @Autowired
    private ChorgraphyService chorgraphyService;

    @Autowired
    private ChorgraphyAttachmentService attachmentService;

    @RequestMapping(value = "/content/{id}.htm",method = RequestMethod.GET)
    public ModelAndView forward(@PathVariable("id") Long id, HttpServletRequest request, HttpServletResponse response, @ModelAttribute("s")Map<String,Object> root){
        ModelAndView mv = new ModelAndView("dance_book/content");
        ChorgraphyDTO chorgraphy =  chorgraphyService.get(id);
        ChorgraphyAttachmentQUERY queryBean = new ChorgraphyAttachmentQUERY();
        queryBean.setPageSize(1000);
        queryBean.setChorgraphyId(id);
        List<ChorgraphyAttachmentDTO> attachment = attachmentService.list(queryBean).getData();
        mv.addObject("book",chorgraphy);
        mv.addObject("attachment",attachment);
        super.setRequest(request,response,root, chorgraphy.getDanceType().equalsIgnoreCase("2"));
        return mv;
    }
}
