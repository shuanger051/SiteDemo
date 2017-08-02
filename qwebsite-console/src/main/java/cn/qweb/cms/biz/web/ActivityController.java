package cn.qweb.cms.biz.web;
import cn.qweb.cms.core.base.BaseController;
import cn.qweb.cms.biz.service.ActivityService;
import cn.qweb.cms.biz.service.bo.ActivitySaveBO;
import cn.qweb.cms.biz.service.query.ActivityQUERY;
import cn.qweb.cms.biz.service.bo.ActivityRemoveBO;
import cn.qweb.cms.biz.service.dto.ActivityDTO;
import cn.qweb.cms.biz.service.bo.ActivityUpdateBO;
import cn.qweb.cms.core.base.Pagination;
import cn.qweb.cms.core.utils.StrUtil;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;


@RestController
@RequestMapping("/activity")
public class ActivityController extends BaseController{

    @Autowired
    private ActivityService activityService;

    @ApiOperation(value = "获取列表")
    @ApiImplicitParam(name = "bean", value = "查询对象", dataType = "ActivityQUERY")
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public Pagination<ActivityDTO> getActivityList(@Valid ActivityQUERY bean){
        return activityService.list(bean);
    }

    @ApiOperation(value = "获取列表")
    @ApiImplicitParam(name = "bean", value = "查询对象", dataType = "ActivityApplyQUERY")
    @RequestMapping(value = "/queryList",method = RequestMethod.GET)
    public Pagination<ActivityDTO> getActivityApplyListByLike(@Valid ActivityQUERY bean){
        bean.setTitle("%"+bean.getTitle()+"%");
        return activityService.list(bean);
    }

    @ApiOperation(value = "根据ID获取对象")
    @ApiImplicitParam(name = "id", value = "ID", required = true, paramType = "path", dataType = "Long")
    @RequestMapping(value = "/get",method = RequestMethod.GET)
    public ActivityDTO getActivity(Long id){
        return activityService.get(id);
    }

    @ApiOperation(value="创建")
    @ApiImplicitParam(name = "bean", value = "详细实体信息", required = true, dataType = "ActivitySaveBO")
    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public Long postActivity(@Valid ActivitySaveBO bean){
        bean.setTxt(StrUtil.unescapeHtml(bean.getTxt()));
        return activityService.doSave(bean);
    }


    @ApiOperation(value="更新详细信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name="bean", value = "需要更新的实体信息",required = true, dataType = "ActivityUpdateBO")
    })
    @RequestMapping(value = "/edit",method = RequestMethod.POST)
    public String putActivity(@Valid ActivityUpdateBO bean){
        bean.setTxt(StrUtil.unescapeHtml(bean.getTxt()));
        activityService.doUpdate(bean);
        return SUCCESS;
    }

    @ApiOperation(value="删除", notes="根据url的id来指定删除对象")
    @ApiImplicitParam(name = "id", value = "ID", required = true, dataType = "Long")
    @RequestMapping(value="/del", method=RequestMethod.DELETE)
    public String deleteActivity(Long id) {
        activityService.doRemove(id);
        return SUCCESS;
    }

    @ApiOperation(value="删除", notes="根据条件删除对象")
    @ApiImplicitParam(name = "bean", value = "", required = true,  dataType = "ActivityRemoveBO")
    @RequestMapping(value="/remove", method=RequestMethod.DELETE)
    public String removeActivity(ActivityRemoveBO bean) {
        activityService.doRemove(bean);
        return SUCCESS;
    }

}