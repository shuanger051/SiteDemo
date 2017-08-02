package cn.qweb.cms.biz.web;
import cn.qweb.cms.core.base.BaseController;
import cn.qweb.cms.biz.service.ChorgraphyAttachmentService;
import cn.qweb.cms.biz.service.bo.ChorgraphyAttachmentSaveBO;
import cn.qweb.cms.biz.service.query.ChorgraphyAttachmentQUERY;
import cn.qweb.cms.biz.service.bo.ChorgraphyAttachmentRemoveBO;
import cn.qweb.cms.biz.service.dto.ChorgraphyAttachmentDTO;
import cn.qweb.cms.biz.service.bo.ChorgraphyAttachmentUpdateBO;
import cn.qweb.cms.core.base.Pagination;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;


@RestController
@RequestMapping("/chorgraphy_attachment")
public class ChorgraphyAttachmentController extends BaseController{

    @Autowired
    private ChorgraphyAttachmentService chorgraphyAttachmentService;

    @ApiOperation(value = "获取列表")
    @ApiImplicitParam(name = "bean", value = "查询对象", dataType = "ChorgraphyAttachmentQUERY")
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public Pagination<ChorgraphyAttachmentDTO> getChorgraphyAttachmentList(@Valid ChorgraphyAttachmentQUERY bean){
        return chorgraphyAttachmentService.list(bean);
    }

    @ApiOperation(value = "根据ID获取对象")
    @ApiImplicitParam(name = "id", value = "ID", required = true, paramType = "path", dataType = "Long")
    @RequestMapping(value = "/get",method = RequestMethod.GET)
    public ChorgraphyAttachmentDTO getChorgraphyAttachment(Long id){
        return chorgraphyAttachmentService.get(id);
    }

    @ApiOperation(value="创建")
    @ApiImplicitParam(name = "bean", value = "详细实体信息", required = true, dataType = "ChorgraphyAttachmentSaveBO")
    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public Long postChorgraphyAttachment(@Valid ChorgraphyAttachmentSaveBO bean){
        return chorgraphyAttachmentService.doSave(bean);
    }


    @ApiOperation(value="更新详细信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name="bean", value = "需要更新的实体信息",required = true, dataType = "ChorgraphyAttachmentUpdateBO")
    })
    @RequestMapping(value = "/edit",method = RequestMethod.PUT)
    public String putChorgraphyAttachment(@Valid ChorgraphyAttachmentUpdateBO bean){
        chorgraphyAttachmentService.doUpdate(bean);
        return SUCCESS;
    }

    @ApiOperation(value="删除", notes="根据url的id来指定删除对象")
    @ApiImplicitParam(name = "id", value = "ID", required = true, dataType = "Long")
    @RequestMapping(value="/del", method=RequestMethod.DELETE)
    public String deleteChorgraphyAttachment(Long id) {
        chorgraphyAttachmentService.doRemove(id);
        return SUCCESS;
    }

    @ApiOperation(value="删除", notes="根据条件删除对象")
    @ApiImplicitParam(name = "bean", value = "", required = true,  dataType = "ChorgraphyAttachmentRemoveBO")
    @RequestMapping(value="/remove", method=RequestMethod.DELETE)
    public String removeChorgraphyAttachment(ChorgraphyAttachmentRemoveBO bean) {
        chorgraphyAttachmentService.doRemove(bean);
        return SUCCESS;
    }

}