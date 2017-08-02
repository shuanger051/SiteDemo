package cn.qweb.cms.biz.web;
import cn.qweb.cms.core.base.BaseController;
import cn.qweb.cms.biz.service.TrainService;
import cn.qweb.cms.biz.service.bo.TrainSaveBO;
import cn.qweb.cms.biz.service.query.TrainQUERY;
import cn.qweb.cms.biz.service.bo.TrainRemoveBO;
import cn.qweb.cms.biz.service.dto.TrainDTO;
import cn.qweb.cms.biz.service.bo.TrainUpdateBO;
import cn.qweb.cms.core.base.Pagination;
import cn.qweb.cms.core.utils.StrUtil;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;


@RestController
@RequestMapping("/train")
public class TrainController extends BaseController{

    @Autowired
    private TrainService trainService;

    @ApiOperation(value = "获取列表")
    @ApiImplicitParam(name = "bean", value = "查询对象", dataType = "TrainQUERY")
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public Pagination<TrainDTO> getTrainList(@Valid TrainQUERY bean){
        return trainService.list(bean);
    }

    @ApiOperation(value = "获取列表")
    @ApiImplicitParam(name = "bean", value = "查询对象", dataType = "ActivityApplyQUERY")
    @RequestMapping(value = "/queryList",method = RequestMethod.GET)
    public Pagination<TrainDTO> getActivityApplyListByLike(@Valid TrainQUERY bean){
        bean.setTitle("%"+bean.getTitle()+"%");
        return trainService.list(bean);
    }

    @ApiOperation(value = "根据ID获取对象")
    @ApiImplicitParam(name = "id", value = "ID", required = true, paramType = "path", dataType = "Long")
    @RequestMapping(value = "/get",method = RequestMethod.GET)
    public TrainDTO getTrain(Long id){
        return trainService.get(id);
    }

    @ApiOperation(value="创建")
    @ApiImplicitParam(name = "bean", value = "详细实体信息", required = true, dataType = "TrainSaveBO")
    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public Long postTrain(@Valid TrainSaveBO bean){
        bean.setTxt(StrUtil.unescapeHtml(bean.getTxt()));
        return trainService.doSave(bean);
    }


    @ApiOperation(value="更新详细信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name="bean", value = "需要更新的实体信息",required = true, dataType = "TrainUpdateBO")
    })
    @RequestMapping(value = "/edit",method = RequestMethod.POST)
    public String putTrain(@Valid TrainUpdateBO bean){
        bean.setTxt(StrUtil.unescapeHtml(bean.getTxt()));
        trainService.doUpdate(bean);
        return SUCCESS;
    }

    @ApiOperation(value="删除", notes="根据url的id来指定删除对象")
    @ApiImplicitParam(name = "id", value = "ID", required = true, dataType = "Long")
    @RequestMapping(value="/del", method=RequestMethod.DELETE)
    public String deleteTrain(Long id) {
        trainService.doRemove(id);
        return SUCCESS;
    }

    @ApiOperation(value="删除", notes="根据条件删除对象")
    @ApiImplicitParam(name = "bean", value = "", required = true,  dataType = "TrainRemoveBO")
    @RequestMapping(value="/remove", method=RequestMethod.DELETE)
    public String removeTrain(TrainRemoveBO bean) {
        trainService.doRemove(bean);
        return SUCCESS;
    }

}