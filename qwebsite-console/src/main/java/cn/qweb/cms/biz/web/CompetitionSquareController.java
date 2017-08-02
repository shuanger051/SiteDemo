package cn.qweb.cms.biz.web;

import cn.qweb.cms.biz.service.CompetitionSquareService;
import cn.qweb.cms.biz.service.bo.CompetitionSquareRemoveBO;
import cn.qweb.cms.biz.service.bo.CompetitionSquareSaveBO;
import cn.qweb.cms.biz.service.bo.CompetitionSquareUpdateBO;
import cn.qweb.cms.biz.service.dto.CompetitionSquareDTO;
import cn.qweb.cms.biz.service.query.CompetitionSquareQUERY;
import cn.qweb.cms.core.base.BaseController;
import cn.qweb.cms.core.base.Pagination;
import cn.qweb.cms.core.utils.StrUtil;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;


@RestController
@RequestMapping("/competition_square")
public class CompetitionSquareController extends BaseController{

    @Autowired
    private CompetitionSquareService competitionService;

    @ApiOperation(value = "获取列表")
    @ApiImplicitParam(name = "bean", value = "查询对象", dataType = "CompetitionSquareQUERY")
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public Pagination<CompetitionSquareDTO> getCompetitionSquareList(@Valid CompetitionSquareQUERY bean){
        return competitionService.list(bean);
    }

    @ApiOperation(value = "根据ID获取对象")
    @ApiImplicitParam(name = "id", value = "ID", required = true, paramType = "path", dataType = "Long")
    @RequestMapping(value = "/get",method = RequestMethod.GET)
    public CompetitionSquareDTO getCompetitionSquare(Long id){
        return competitionService.get(id);
    }

    @ApiOperation(value="创建")
    @ApiImplicitParam(name = "bean", value = "详细实体信息", required = true, dataType = "CompetitionSquareSaveBO")
    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public Long postCompetitionSquare(@Valid CompetitionSquareSaveBO bean, String txt){
        if(StringUtils.isNotBlank(txt)){
           bean.setContent(StrUtil.unescapeHtml(txt));
        }
        return competitionService.doSave(bean);
    }


    @ApiOperation(value="更新详细信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name="bean", value = "需要更新的实体信息",required = true, dataType = "CompetitionSquareUpdateBO")
    })
    @RequestMapping(value = "/edit",method = RequestMethod.POST)
    public String putCompetitionSquare(@Valid CompetitionSquareUpdateBO bean, String txt){
        if(StringUtils.isNotBlank(txt)){
            bean.setContent(StrUtil.unescapeHtml(txt));
        }
        competitionService.doUpdate(bean);
        return SUCCESS;
    }

    @ApiOperation(value="删除", notes="根据url的id来指定删除对象")
    @ApiImplicitParam(name = "id", value = "ID", required = true, dataType = "Long")
    @RequestMapping(value="/del", method=RequestMethod.DELETE)
    public String deleteCompetitionSquare(Long id) {
        competitionService.doRemove(id);
        return SUCCESS;
    }

    @ApiOperation(value="删除", notes="根据条件删除对象")
    @ApiImplicitParam(name = "bean", value = "", required = true,  dataType = "CompetitionSquareRemoveBO")
    @RequestMapping(value="/remove", method=RequestMethod.DELETE)
    public String removeCompetitionSquare(CompetitionSquareRemoveBO bean) {
        competitionService.doRemove(bean);
        return SUCCESS;
    }

}