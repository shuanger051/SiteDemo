package cn.qweb.cms.biz.web;

import cn.qweb.cms.biz.constant.ContentConstant;
import cn.qweb.cms.biz.service.ActivitySquareApplyService;
import cn.qweb.cms.biz.service.bo.ActivitySquareApplyRemoveBO;
import cn.qweb.cms.biz.service.bo.ActivitySquareApplySaveBO;
import cn.qweb.cms.biz.service.bo.ActivitySquareApplyUpdateBO;
import cn.qweb.cms.biz.service.dto.ActivitySquareApplyDTO;
import cn.qweb.cms.biz.service.query.ActivitySquareApplyQUERY;
import cn.qweb.cms.core.base.BaseController;
import cn.qweb.cms.core.base.Pagination;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.wuwz.poi.ExcelKit;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/activity_square_apply")
public class ActivitySquareApplyController extends BaseController{

    private static final Logger logger = LoggerFactory.getLogger(ActivitySquareApplyController.class);

    @Autowired
    private ActivitySquareApplyService activityApplyService;

    @ApiOperation(value = "获取列表")
    @ApiImplicitParam(name = "bean", value = "查询对象", dataType = "ActivitySquareApplyQUERY")
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public Pagination<ActivitySquareApplyDTO> getActivitySquareApplyList(@Valid ActivitySquareApplyQUERY bean){
        return activityApplyService.list(bean);
    }

    @ApiOperation(value = "获取列表")
    @ApiImplicitParam(name = "bean", value = "查询对象", dataType = "ActivitySquareApplyQUERY")
    @RequestMapping(value = "/queryList",method = RequestMethod.GET)
    public Pagination<ActivitySquareApplyDTO> getActivitySquareApplyListByLike(@Valid ActivitySquareApplyQUERY bean){
        bean.setRealName("%"+bean.getRealName()+"%");
        return activityApplyService.list(bean);
    }

    @ApiOperation(value = "根据ID获取对象")
    @ApiImplicitParam(name = "id", value = "ID", required = true, paramType = "path", dataType = "Long")
    @RequestMapping(value = "/get",method = RequestMethod.GET)
    public ActivitySquareApplyDTO getActivitySquareApply(Long id){
        return activityApplyService.get(id);
    }

    @ApiOperation(value = "根据idNo获取对象")
    @RequestMapping(value = "/getInfoByIdNo",method = RequestMethod.GET)
    public boolean getActivitySquareApply(@Valid ActivitySquareApplyQUERY bean){
        List<ActivitySquareApplyDTO> list = activityApplyService.queryList(bean);
        boolean flag = false;
        if (null != list && list.size() != 0){
            flag = true;
        }
        return flag;
    }


    @ApiOperation(value="创建")
    @ApiImplicitParam(name = "bean", value = "详细实体信息", required = true, dataType = "ActivitySquareApplySaveBO")
    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public Long postActivitySquareApply(@Valid ActivitySquareApplySaveBO bean){
        return activityApplyService.doSave(bean);
    }


    @ApiOperation(value="更新详细信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name="bean", value = "需要更新的实体信息",required = true, dataType = "ActivitySquareApplyUpdateBO")
    })
    @RequestMapping(value = "/edit",method = RequestMethod.POST)
    public String putActivitySquareApply(@Valid ActivitySquareApplyUpdateBO bean){
        activityApplyService.doUpdate(bean);
        return SUCCESS;
    }

    @ApiOperation(value="删除", notes="根据url的id来指定删除对象")
    @ApiImplicitParam(name = "id", value = "ID", required = true, dataType = "Long")
    @RequestMapping(value="/del", method=RequestMethod.DELETE)
    public String deleteActivitySquareApply(Long id) {
        activityApplyService.doRemove(id);
        return SUCCESS;
    }

    @ApiOperation(value="批量删除", notes="根据url的ids来指定删除对象")
    @RequestMapping(value="/delSelectedBox", method=RequestMethod.DELETE)
    public String deleteActivitySquareApply(String ids) {
        try {
            if (null != ids && !"".equals(ids.trim())){
                String[] idArr = ids.split(",");
                for(int i=0;i<idArr.length;i++){
                    activityApplyService.doRemove(Long.valueOf(idArr[i]));
                }
            }
            return SUCCESS;
        }catch (Exception e){
            logger.error("批量删除活动报名信息失败"+e.getMessage());
            return FAILURE;
        }
    }

    @ApiOperation(value="删除", notes="根据条件删除对象")
    @ApiImplicitParam(name = "bean", value = "", required = true,  dataType = "ActivitySquareApplyRemoveBO")
    @RequestMapping(value="/remove", method=RequestMethod.DELETE)
    public String removeActivitySquareApply(ActivitySquareApplyRemoveBO bean) {
        activityApplyService.doRemove(bean);
        return SUCCESS;
    }

    @ApiOperation(value="导出", notes="根据条件导出EXCEL")
    @RequestMapping(value = "/export",method = RequestMethod.GET)
    public void exportExcel(HttpServletRequest request, HttpServletResponse response){

        String realName = request.getParameter("realName");
        String sex = request.getParameter("sex");
        String readFlag = request.getParameter("readFlag");

        ActivitySquareApplyQUERY bean = new ActivitySquareApplyQUERY();
        if(null != realName && !"".equals(realName.trim())){
            bean.setRealName("%"+realName+"%");
        }
        if(null != sex && !"".equals(sex.trim())){
            bean.setSex(sex);
        }
        if(null != readFlag && !"".equals(readFlag.trim())){
            bean.setReadFlag(readFlag);
        }

        List<ActivitySquareApplyDTO> list = activityApplyService.queryList(bean);
        try{
            // 生成Excel并使用浏览器下载
            ExcelKit.$Export(ActivitySquareApplyDTO.class, response).toExcel(list, "活动报名列表");
        }catch (Exception e){
            logger.error("导出excel失败"+e.getMessage());
        }

    }

    @ApiOperation(value="导出", notes="检查需要导出的数据总条数，大于5000条，则不能执行导出操作")
    @RequestMapping(value = "/checkExport",method = RequestMethod.GET)
    public String checkExport(HttpServletRequest request, HttpServletResponse response,ActivitySquareApplyQUERY bean){
        Integer count = activityApplyService.checkExport(bean);
        if(count != null && count < ContentConstant.MAX_EXPORT_COUNT){
            return SUCCESS;
        }else{
            return FAILURE;
        }
    }

}