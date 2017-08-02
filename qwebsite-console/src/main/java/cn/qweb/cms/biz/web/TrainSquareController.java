package cn.qweb.cms.biz.web;

import cn.qweb.cms.biz.service.TrainSquareService;
import cn.qweb.cms.biz.service.bo.TrainSquareRemoveBO;
import cn.qweb.cms.biz.service.bo.TrainSquareSaveBO;
import cn.qweb.cms.biz.service.bo.TrainSquareUpdateBO;
import cn.qweb.cms.biz.service.dto.TrainSquareDTO;
import cn.qweb.cms.biz.service.query.TrainSquareQUERY;
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
@RequestMapping("/train_square")
public class TrainSquareController extends BaseController{

    @Autowired
    private TrainSquareService trainService;

    @ApiOperation(value = "获取列表")
    @ApiImplicitParam(name = "bean", value = "查询对象", dataType = "TrainSquareQUERY")
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public Pagination<TrainSquareDTO> getTrainSquareList(@Valid TrainSquareQUERY bean){
        return trainService.list(bean);
    }

    @ApiOperation(value = "获取列表")
    @ApiImplicitParam(name = "bean", value = "查询对象", dataType = "ActivityApplyQUERY")
    @RequestMapping(value = "/queryList",method = RequestMethod.GET)
    public Pagination<TrainSquareDTO> getActivityApplyListByLike(@Valid TrainSquareQUERY bean){
        bean.setTitle("%"+bean.getTitle()+"%");
        return trainService.list(bean);
    }

    @ApiOperation(value = "根据ID获取对象")
    @ApiImplicitParam(name = "id", value = "ID", required = true, paramType = "path", dataType = "Long")
    @RequestMapping(value = "/get",method = RequestMethod.GET)
    public TrainSquareDTO getTrainSquare(Long id){
        return trainService.get(id);
    }

    @ApiOperation(value="创建")
    @ApiImplicitParam(name = "bean", value = "详细实体信息", required = true, dataType = "TrainSquareSaveBO")
    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public Long postTrainSquare(@Valid TrainSquareSaveBO bean){
        bean.setTxt(StrUtil.unescapeHtml(bean.getTxt()));
        return trainService.doSave(bean);
    }


    @ApiOperation(value="更新详细信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name="bean", value = "需要更新的实体信息",required = true, dataType = "TrainSquareUpdateBO")
    })
    @RequestMapping(value = "/edit",method = RequestMethod.POST)
    public String putTrainSquare(@Valid TrainSquareUpdateBO bean){
        bean.setTxt(StrUtil.unescapeHtml(bean.getTxt()));
        trainService.doUpdate(bean);
        return SUCCESS;
    }

    @ApiOperation(value="删除", notes="根据url的id来指定删除对象")
    @ApiImplicitParam(name = "id", value = "ID", required = true, dataType = "Long")
    @RequestMapping(value="/del", method=RequestMethod.DELETE)
    public String deleteTrainSquare(Long id) {
        trainService.doRemove(id);
        return SUCCESS;
    }

    @ApiOperation(value="删除", notes="根据条件删除对象")
    @ApiImplicitParam(name = "bean", value = "", required = true,  dataType = "TrainSquareRemoveBO")
    @RequestMapping(value="/remove", method=RequestMethod.DELETE)
    public String removeTrainSquare(TrainSquareRemoveBO bean) {
        trainService.doRemove(bean);
        return SUCCESS;
    }

}