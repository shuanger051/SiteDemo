package cn.qweb.cms.biz.web;

import cn.qweb.cms.biz.service.ActivitySquareService;
import cn.qweb.cms.biz.service.bo.ActivitySquareRemoveBO;
import cn.qweb.cms.biz.service.bo.ActivitySquareSaveBO;
import cn.qweb.cms.biz.service.bo.ActivitySquareUpdateBO;
import cn.qweb.cms.biz.service.dto.ActivitySquareDTO;
import cn.qweb.cms.biz.service.query.ActivitySquareQUERY;
import cn.qweb.cms.core.base.BaseController;
import cn.qweb.cms.core.base.Pagination;
import cn.qweb.cms.core.utils.StrUtil;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;


@RestController
@RequestMapping("/activity_square")
public class ActivitySquareController extends BaseController{

    @Autowired
    private ActivitySquareService activityService;

    @ApiOperation(value = "获取列表")
    @ApiImplicitParam(name = "bean", value = "查询对象", dataType = "ActivitySquareQUERY")
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public Pagination<ActivitySquareDTO> getActivitySquareList(@Valid ActivitySquareQUERY bean){
        return activityService.list(bean);
    }

    @ApiOperation(value = "获取列表")
    @ApiImplicitParam(name = "bean", value = "查询对象", dataType = "ActivitySquareApplyQUERY")
    @RequestMapping(value = "/queryList",method = RequestMethod.GET)
    public Pagination<ActivitySquareDTO> getActivitySquareApplyListByLike(@Valid ActivitySquareQUERY bean){
        bean.setTitle("%"+bean.getTitle()+"%");
        return activityService.list(bean);
    }

    @ApiOperation(value = "根据ID获取对象")
    @ApiImplicitParam(name = "id", value = "ID", required = true, paramType = "path", dataType = "Long")
    @RequestMapping(value = "/get",method = RequestMethod.GET)
    public ActivitySquareDTO getActivitySquare(Long id){
        return activityService.get(id);
    }

    @ApiOperation(value="创建")
    @ApiImplicitParam(name = "bean", value = "详细实体信息", required = true, dataType = "ActivitySquareSaveBO")
    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public Long postActivitySquare(@Valid ActivitySquareSaveBO bean){
        bean.setTxt(StrUtil.unescapeHtml(bean.getTxt()));
        return activityService.doSave(bean);
    }


    @ApiOperation(value="更新详细信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name="bean", value = "需要更新的实体信息",required = true, dataType = "ActivitySquareUpdateBO")
    })
    @RequestMapping(value = "/edit",method = RequestMethod.POST)
    public String putActivitySquare(@Valid ActivitySquareUpdateBO bean){
        bean.setTxt(StrUtil.unescapeHtml(bean.getTxt()));
        activityService.doUpdate(bean);
        return SUCCESS;
    }

    @ApiOperation(value="删除", notes="根据url的id来指定删除对象")
    @ApiImplicitParam(name = "id", value = "ID", required = true, dataType = "Long")
    @RequestMapping(value="/del", method=RequestMethod.DELETE)
    public String deleteActivitySquare(Long id) {
        activityService.doRemove(id);
        return SUCCESS;
    }

    @ApiOperation(value="删除", notes="根据条件删除对象")
    @ApiImplicitParam(name = "bean", value = "", required = true,  dataType = "ActivitySquareRemoveBO")
    @RequestMapping(value="/remove", method=RequestMethod.DELETE)
    public String removeActivitySquare(ActivitySquareRemoveBO bean) {
        activityService.doRemove(bean);
        return SUCCESS;
    }

}