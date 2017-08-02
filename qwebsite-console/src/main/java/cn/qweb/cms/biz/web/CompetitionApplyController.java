package cn.qweb.cms.biz.web;

import cn.qweb.cms.biz.constant.ContentConstant;
import cn.qweb.cms.biz.service.CompetitionApplyService;
import cn.qweb.cms.biz.service.bo.CompetitionApplyRemoveBO;
import cn.qweb.cms.biz.service.bo.CompetitionApplySaveBO;
import cn.qweb.cms.biz.service.bo.CompetitionApplyUpdateBO;
import cn.qweb.cms.biz.service.dto.CompetitionApplyDTO;
import cn.qweb.cms.biz.service.query.CompetitionApplyQUERY;
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
@RequestMapping("/competition_apply")
public class CompetitionApplyController extends BaseController{

    private static final Logger logger = LoggerFactory.getLogger(CompetitionApplyController.class);

    @Autowired
    private CompetitionApplyService competitionApplyService;

    @ApiOperation(value = "获取列表")
    @ApiImplicitParam(name = "bean", value = "查询对象", dataType = "CompetitionApplyQUERY")
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public Pagination<CompetitionApplyDTO> getCompetitionApplyList(@Valid CompetitionApplyQUERY bean){
        return competitionApplyService.list(bean);
    }

    @ApiOperation(value = "根据ID获取对象")
    @ApiImplicitParam(name = "id", value = "ID", required = true, paramType = "path", dataType = "Long")
    @RequestMapping(value = "/get",method = RequestMethod.GET)
    public CompetitionApplyDTO getCompetitionApply(Long id){
        return competitionApplyService.get(id);
    }

    @ApiOperation(value="创建")
    @ApiImplicitParam(name = "bean", value = "详细实体信息", required = true, dataType = "CompetitionApplySaveBO")
    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public Long postCompetitionApply(@Valid CompetitionApplySaveBO bean){
        return competitionApplyService.doSave(bean);
    }


    @ApiOperation(value="更新详细信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name="bean", value = "需要更新的实体信息",required = true, dataType = "CompetitionApplyUpdateBO")
    })
    @RequestMapping(value = "/edit",method = RequestMethod.POST)
    public String putCompetitionApply(@Valid CompetitionApplyUpdateBO bean){
        competitionApplyService.doUpdate(bean);
        return SUCCESS;
    }

    @ApiOperation(value="删除", notes="根据url的id来指定删除对象")
    @ApiImplicitParam(name = "id", value = "ID", required = true, dataType = "Long")
    @RequestMapping(value="/del", method=RequestMethod.DELETE)
    public String deleteCompetitionApply(Long id) {
        competitionApplyService.doRemove(id);
        return SUCCESS;
    }


    @ApiOperation(value="批量删除", notes="根据url的ids来指定删除对象")
    @RequestMapping(value="/delSelectedBox", method=RequestMethod.DELETE)
    public String deleteTrainApply(String ids) {
        if (null != ids && !"".equals(ids.trim())){
            String[] idArr = ids.split(",");
            for(int i=0;i<idArr.length;i++){
                competitionApplyService.doRemove(Long.valueOf(idArr[i]));
            }
        }
        return SUCCESS;
    }

    @ApiOperation(value="导出", notes="根据条件导出EXCEL")
    @RequestMapping(value = "/export",method = RequestMethod.GET)
    public void exportExcel(HttpServletRequest request, HttpServletResponse response,CompetitionApplyQUERY bean){
        bean.setPageSize(Integer.MAX_VALUE);
        List<CompetitionApplyDTO> list = competitionApplyService.list(bean).getData();
        try{
            // 生成Excel并使用浏览器下载
            ExcelKit.$Export(CompetitionApplyDTO.class, response).toExcel(list, "赛事报名列表");
        }catch (Exception e){
            logger.error("导出excel失败"+e.getMessage());
        }
    }

    @ApiOperation(value="导出", notes="检查需要导出的数据总条数，大于5000条，则不能执行导出操作")
    @RequestMapping(value = "/checkExport",method = RequestMethod.GET)
    public String checkExport(HttpServletRequest request, HttpServletResponse response,CompetitionApplyQUERY bean){
        Integer count = competitionApplyService.checkExport(bean);
        if(count != null && count < ContentConstant.MAX_EXPORT_COUNT){
            return SUCCESS;
        }else{
            return FAILURE;
        }
    }


    @ApiOperation(value="删除", notes="根据条件删除对象")
    @ApiImplicitParam(name = "bean", value = "", required = true,  dataType = "CompetitionApplyRemoveBO")
    @RequestMapping(value="/remove", method=RequestMethod.DELETE)
    public String removeCompetitionApply(CompetitionApplyRemoveBO bean) {
        competitionApplyService.doRemove(bean);
        return SUCCESS;
    }

}