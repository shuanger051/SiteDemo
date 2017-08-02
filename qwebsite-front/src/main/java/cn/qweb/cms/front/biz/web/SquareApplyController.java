package cn.qweb.cms.front.biz.web;

import cn.qweb.cms.biz.service.*;
import cn.qweb.cms.biz.service.bo.ActivitySquareApplySaveBO;
import cn.qweb.cms.biz.service.bo.CompetitionSquareApplySaveBO;
import cn.qweb.cms.biz.service.bo.TrainSquareApplySaveBO;
import cn.qweb.cms.biz.service.dto.ActivitySquareDTO;
import cn.qweb.cms.biz.service.dto.CompetitionSquareDTO;
import cn.qweb.cms.biz.service.dto.TrainSquareDTO;
import cn.qweb.cms.biz.service.query.ActivitySquareQUERY;
import cn.qweb.cms.biz.service.query.CompetitionSquareQUERY;
import cn.qweb.cms.biz.service.query.TrainSquareQUERY;
import cn.qweb.cms.core.base.BaseController;
import cn.qweb.cms.core.base.Pagination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Date;

/**
 * Created by xuebj on 2017/4/20.
 */
@RestController
@RequestMapping("/square_apply")
public class SquareApplyController extends BaseController{

    @Autowired
    private TrainSquareService trainService;

    @Autowired
    private TrainSquareApplyService trainApplyService;

    @Autowired
    private ActivitySquareService activityService;

    @Autowired
    private ActivitySquareApplyService activityApplyService;

    @Autowired
    private CompetitionSquareApplyService competitionApplyService;

    @Autowired
    private CompetitionSquareService competitionService;


    /**
     * 保存赛事报名
     * @param bean
     * @return
     */
    @RequestMapping(value = "/competition", method = RequestMethod.POST)
    public String competition(@Valid CompetitionSquareApplySaveBO bean){
        competitionApplyService.doSave(bean);
        return SUCCESS;
    }


    @RequestMapping(value = "/competition/get", method = RequestMethod.GET)
    public CompetitionSquareDTO competition(Long id){
        return competitionService.get(id);
    }

    @RequestMapping(value = "/competition/list", method = RequestMethod.GET)
    public Pagination<CompetitionSquareDTO> competition(CompetitionSquareQUERY bean){
        bean.setGmtEnd(new Date());
        return competitionService.list(bean);
    }

    @RequestMapping(value = "/train",method = RequestMethod.POST)
    public String train(@Valid TrainSquareApplySaveBO bean){
        trainApplyService.doSave(bean);
        return SUCCESS;
    }

    @RequestMapping(value = "/activity",method = RequestMethod.POST)
    public String activity(@Valid ActivitySquareApplySaveBO bean){
        activityApplyService.doSave(bean);
        return SUCCESS;
    }

    @RequestMapping(value = "/train/list",method = RequestMethod.GET)
    public Pagination<TrainSquareDTO> list(TrainSquareQUERY bean){
        bean.setGmtEnd(new Date());
        return trainService.list(bean);
    }

    @RequestMapping(value = "/train/get",method = RequestMethod.GET)
    public TrainSquareDTO get(Long id){
        return trainService.get(id);
    }

    @RequestMapping(value = "/activity/list", method = RequestMethod.GET)
    public Pagination<ActivitySquareDTO> list(ActivitySquareQUERY bean){
        bean.setGmtEnd(new Date());
        return activityService.list(bean);
    }

    @RequestMapping(value = "/activity/get", method = RequestMethod.GET)
    public ActivitySquareDTO getActivity(Long id){
        return activityService.get(id);
    }
}
