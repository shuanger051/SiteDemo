package cn.qweb.cms.biz.web;

import cn.qweb.cms.biz.constant.ContentConstant;
import cn.qweb.cms.biz.service.CompetitionSquareApplyService;
import cn.qweb.cms.biz.service.bo.CompetitionSquareApplyRemoveBO;
import cn.qweb.cms.biz.service.bo.CompetitionSquareApplySaveBO;
import cn.qweb.cms.biz.service.bo.CompetitionSquareApplyUpdateBO;
import cn.qweb.cms.biz.service.dto.CompetitionSquareApplyDTO;
import cn.qweb.cms.biz.service.query.CompetitionSquareApplyQUERY;
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
@RequestMapping("/competition_square_apply")
public class CompetitionSquareApplyController extends BaseController{

    private static final Logger logger = LoggerFactory.getLogger(CompetitionSquareApplyController.class);

    @Autowired
    private CompetitionSquareApplyService competitionApplyService;

    @ApiOperation(value = "获取列表")
    @ApiImplicitParam(name = "bean", value = "查询对象", dataType = "CompetitionSquareApplyQUERY")
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public Pagination<CompetitionSquareApplyDTO> getCompetitionSquareApplyList(@Valid CompetitionSquareApplyQUERY bean){
        return competitionApplyService.list(bean);
    }

    @ApiOperation(value = "根据ID获取对象")
    @ApiImplicitParam(name = "id", value = "ID", required = true, paramType = "path", dataType = "Long")
    @RequestMapping(value = "/get",method = RequestMethod.GET)
    public CompetitionSquareApplyDTO getCompetitionSquareApply(Long id){
        return competitionApplyService.get(id);
    }

    @ApiOperation(value="创建")
    @ApiImplicitParam(name = "bean", value = "详细实体信息", required = true, dataType = "CompetitionSquareApplySaveBO")
    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public Long postCompetitionSquareApply(@Valid CompetitionSquareApplySaveBO bean){
        return competitionApplyService.doSave(bean);
    }


    @ApiOperation(value="更新详细信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name="bean", value = "需要更新的实体信息",required = true, dataType = "CompetitionSquareApplyUpdateBO")
    })
    @RequestMapping(value = "/edit",method = RequestMethod.POST)
    public String putCompetitionSquareApply(@Valid CompetitionSquareApplyUpdateBO bean){
        competitionApplyService.doUpdate(bean);
        return SUCCESS;
    }

    @ApiOperation(value="删除", notes="根据url的id来指定删除对象")
    @ApiImplicitParam(name = "id", value = "ID", required = true, dataType = "Long")
    @RequestMapping(value="/del", method=RequestMethod.DELETE)
    public String deleteCompetitionSquareApply(Long id) {
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
    public void exportExcel(HttpServletRequest request, HttpServletResponse response,CompetitionSquareApplyQUERY bean){
        bean.setPageSize(Integer.MAX_VALUE);
        List<CompetitionSquareApplyDTO> list = competitionApplyService.list(bean).getData();
        try{
            // 生成Excel并使用浏览器下载
            ExcelKit.$Export(CompetitionSquareApplyDTO.class, response).toExcel(list, "赛事报名列表");
        }catch (Exception e){
            logger.error("导出excel失败"+e.getMessage());
        }
    }

    @ApiOperation(value="导出", notes="检查需要导出的数据总条数，大于5000条，则不能执行导出操作")
    @RequestMapping(value = "/checkExport",method = RequestMethod.GET)
    public String checkExport(HttpServletRequest request, HttpServletResponse response,CompetitionSquareApplyQUERY bean){
        Integer count = competitionApplyService.checkExport(bean);
        if(count != null && count < ContentConstant.MAX_EXPORT_COUNT){
            return SUCCESS;
        }else{
            return FAILURE;
        }
    }


    @ApiOperation(value="删除", notes="根据条件删除对象")
    @ApiImplicitParam(name = "bean", value = "", required = true,  dataType = "CompetitionSquareApplyRemoveBO")
    @RequestMapping(value="/remove", method=RequestMethod.DELETE)
    public String removeCompetitionSquareApply(CompetitionSquareApplyRemoveBO bean) {
        competitionApplyService.doRemove(bean);
        return SUCCESS;
    }

}