package cn.qweb.cms.biz.web;

import cn.qweb.cms.biz.constant.ContentConstant;
import cn.qweb.cms.core.base.BaseController;
import cn.qweb.cms.biz.service.TrainApplyService;
import cn.qweb.cms.biz.service.bo.TrainApplySaveBO;
import cn.qweb.cms.biz.service.query.TrainApplyQUERY;
import cn.qweb.cms.biz.service.bo.TrainApplyRemoveBO;
import cn.qweb.cms.biz.service.dto.TrainApplyDTO;
import cn.qweb.cms.biz.service.bo.TrainApplyUpdateBO;
import cn.qweb.cms.core.base.Pagination;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.wuwz.poi.ExcelKit;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/train_apply")
public class TrainApplyController extends BaseController{

    private static final Logger logger = LoggerFactory.getLogger(TrainApplyController.class);

    @Autowired
    private TrainApplyService trainApplyService;

    @ApiOperation(value = "获取列表")
    @ApiImplicitParam(name = "bean", value = "查询对象", dataType = "TrainApplyQUERY")
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public Pagination<TrainApplyDTO> getTrainApplyList(@Valid TrainApplyQUERY bean){
        return trainApplyService.list(bean);
    }

    @ApiOperation(value = "获取列表")
    @ApiImplicitParam(name = "bean", value = "查询对象", dataType = "ActivityApplyQUERY")
    @RequestMapping(value = "/queryList",method = RequestMethod.GET)
    public Pagination<TrainApplyDTO> getTrainApplyListByLike(@Valid TrainApplyQUERY bean){
        bean.setRealName("%"+bean.getRealName()+"%");
        bean.setTitle("%"+bean.getTitle()+"%");
        return trainApplyService.list(bean);
    }

    @ApiOperation(value = "根据ID获取对象")
    @ApiImplicitParam(name = "id", value = "ID", required = true, paramType = "path", dataType = "Long")
    @RequestMapping(value = "/get",method = RequestMethod.GET)
    public TrainApplyDTO getTrainApply(Long id){
        return trainApplyService.get(id);
    }

    @ApiOperation(value = "根据idNo获取对象")
    @RequestMapping(value = "/getInfoByIdNo",method = RequestMethod.GET)
    public boolean getTrainApply(@Valid TrainApplyQUERY bean){
        List<TrainApplyDTO> list = trainApplyService.queryList(bean);
        boolean flag = false;
        if (null != list && list.size() != 0){
            flag = true;
        }
        return flag;
    }

    @ApiOperation(value="创建")
    @ApiImplicitParam(name = "bean", value = "详细实体信息", required = true, dataType = "TrainApplySaveBO")
    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public Long postTrainApply(@Valid TrainApplySaveBO bean){
        return trainApplyService.doSave(bean);
    }


    @ApiOperation(value="更新详细信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name="bean", value = "需要更新的实体信息",required = true, dataType = "TrainApplyUpdateBO")
    })
    @RequestMapping(value = "/edit",method = RequestMethod.POST)
    public String putTrainApply(@Valid TrainApplyUpdateBO bean){
        trainApplyService.doUpdate(bean);
        return SUCCESS;
    }

    @ApiOperation(value="批量更新阅读状态")
    @RequestMapping(value = "/updeateReadFlagList",method = RequestMethod.POST)
    public String putTrainApply(@Valid String ids){
        try {
            if (null != ids && !"".equals(ids.trim())){
                String[] idArr = ids.split(",");
                for(int i=0;i<idArr.length;i++){
                    TrainApplyUpdateBO bean = new TrainApplyUpdateBO();
                    bean.setId(Long.valueOf(idArr[i]));
                    bean.setReadFlag("1");//0 未读,1 已读
                    trainApplyService.doUpdate(bean);
                }
            }
            return SUCCESS;
        }catch (Exception e){
            logger.error("批量删除活动报名信息失败"+e.getMessage());
            return FAILURE;
        }
    }

    @ApiOperation(value="删除", notes="根据url的id来指定删除对象")
    @ApiImplicitParam(name = "id", value = "ID", required = true, dataType = "Long")
    @RequestMapping(value="/del", method=RequestMethod.DELETE)
    public String deleteTrainApply(Long id) {
        trainApplyService.doRemove(id);
        return SUCCESS;
    }

    @ApiOperation(value="批量删除", notes="根据url的ids来指定删除对象")
    @RequestMapping(value="/delSelectedBox", method=RequestMethod.DELETE)
    public String deleteTrainApply(String ids) {
        try {
            if (null != ids && !"".equals(ids.trim())){
                String[] idArr = ids.split(",");
                for(int i=0;i<idArr.length;i++){
                    trainApplyService.doRemove(Long.valueOf(idArr[i]));
                }
            }
            return SUCCESS;
        }catch (Exception e){
            logger.error("批量删除活动报名信息失败"+e.getMessage());
            return FAILURE;
        }
    }

    @ApiOperation(value="删除", notes="根据条件删除对象")
    @ApiImplicitParam(name = "bean", value = "", required = true,  dataType = "TrainApplyRemoveBO")
    @RequestMapping(value="/remove", method=RequestMethod.DELETE)
    public String removeTrainApply(TrainApplyRemoveBO bean) {
        trainApplyService.doRemove(bean);
        return SUCCESS;
    }

    @ApiOperation(value="导出", notes="根据条件导出EXCEL")
    @RequestMapping(value = "/export",method = RequestMethod.GET)
    public void exportExcel(HttpServletRequest request, HttpServletResponse response){

        String realName = request.getParameter("realName");
        String sex = request.getParameter("sex");
        String readFlag = request.getParameter("readFlag");
        String idNo = request.getParameter("idNo");

        TrainApplyQUERY bean = new TrainApplyQUERY();
        if(null != realName && !"".equals(realName.trim())){
            bean.setRealName("%"+realName+"%");
        }
        if(null != sex && !"".equals(sex.trim())){
            bean.setSex(sex);
        }
        if(null != readFlag && !"".equals(readFlag.trim())){
            bean.setReadFlag(readFlag);
        }
        if(null != idNo && !"".equals(idNo.trim())){
            bean.setIdNo(idNo);
        }
        bean.setPageSize(ContentConstant.MAX_EXPORT_COUNT);
        List<TrainApplyDTO> list = trainApplyService.queryList(bean);
        try{
            // 生成Excel并使用浏览器下载
            ExcelKit.$Export(TrainApplyDTO.class, response).toExcel(list, "培训报名列表");
        }catch (Exception e){
            logger.error("导出excel失败"+e.getMessage());
        }

    }

    @ApiOperation(value="导出", notes="检查需要导出的数据总条数，大于5000条，则不能执行导出操作")
    @RequestMapping(value = "/checkExport",method = RequestMethod.GET)
    public String checkExport(HttpServletRequest request, HttpServletResponse response,TrainApplyQUERY bean){

        if(null != bean.getRealName() && !"".equals(bean.getRealName().trim())){
            bean.setRealName("%"+bean.getRealName()+"%");
        }

        Integer count = trainApplyService.checkExport(bean);
        if(count != null && count < ContentConstant.MAX_EXPORT_COUNT){
            return SUCCESS;
        }else{
            return FAILURE;
        }
    }


}