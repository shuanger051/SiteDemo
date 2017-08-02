package cn.qweb.cms.front.biz.web;

import cn.qweb.cms.biz.service.ChannelService;
import cn.qweb.cms.biz.service.ContentService;
import cn.qweb.cms.biz.service.dto.ChannelDTO;
import cn.qweb.cms.biz.service.dto.ContentDTO;
import cn.qweb.cms.biz.service.query.ChannelQUERY;
import cn.qweb.cms.core.mvc.BaseForwardController;
import cn.qweb.cms.front.util.URLHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

/**
 * Created by xuebj on 2017/4/12.
 */
@Controller
public class ForwardContentController extends BaseForwardController{

    @RequestMapping("/**/*.jhtm")
    public ModelAndView forward(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("s") Map<String, Object> root){
//        String[] params = URLHelper.getParams(request);
        String[] paths = URLHelper.getPaths(request);
        Integer len = paths.length;
        if(len == 2){//
            if(paths[1].equals(INDEX)){
                //栏目主页
                return channel(request,response,root,paths,paths[0]);
            }else{
                //内容
                Long contentId = Long.parseLong(paths[1]);
                return content(request,response,root,paths, contentId);
            }
        }
        return new ModelAndView("404");
    }

    private ModelAndView channel(HttpServletRequest request, HttpServletResponse response, Map<String, Object> root,String[] paths,String path){
        ModelAndView mav = new ModelAndView();
        ChannelQUERY queryBean = new ChannelQUERY();
        queryBean.setChannelPath(path);
        List<ChannelDTO> channels = channelService.list(queryBean).getData();
        if(!channels.isEmpty()){
            ChannelDTO channel = channels.get(0);
            mav.setViewName(channel.getTplChannel() + "/index");
            mav.addObject("channel",channel);
            setRequest(request,response,root,channel);
        }
        return mav;
    }

    private ModelAndView content(HttpServletRequest request, HttpServletResponse response, Map<String, Object> root,String[] paths,Long contentId){
        ContentDTO content = contentService.get(contentId);
        ModelAndView mav=new ModelAndView(content.getChannel().getTplContent() + "/content");
        mav.addObject("detail",content);
        setRequest(request,response,root,content.getChannel());
        return mav;
    }

    private void setRequest(HttpServletRequest request, HttpServletResponse response, Map<String, Object> root,ChannelDTO channel){
        ChannelDTO dto =  channelService.get(channel.getParentId());
        super.setRequest(request,response,root,dto.getParentId() == 34);
    }


    private static final String INDEX = "index";

    @Autowired
    private ContentService contentService;

    @Autowired
    private ChannelService channelService;
}
