package cn.qweb.cms.front.biz.web;

import cn.qweb.cms.biz.service.*;
import cn.qweb.cms.biz.service.bo.*;
import cn.qweb.cms.biz.service.dto.ActivityDTO;
import cn.qweb.cms.biz.service.dto.CompetitionDTO;
import cn.qweb.cms.biz.service.dto.TrainDTO;
import cn.qweb.cms.biz.service.query.ActivityQUERY;
import cn.qweb.cms.biz.service.query.CompetitionQUERY;
import cn.qweb.cms.biz.service.query.TrainQUERY;
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
@RequestMapping("/apply")
public class ApplyController extends BaseController{

    @Autowired
    private TrainService trainService;

    @Autowired
    private TrainApplyService trainApplyService;

    @Autowired
    private ActivityService activityService;

    @Autowired
    private ActivityApplyService activityApplyService;

    @Autowired
    private CompetitionApplyService competitionApplyService;

    @Autowired
    private CompetitionService competitionService;


    /**
     * 保存赛事报名
     * @param bean
     * @return
     */
    @RequestMapping(value = "/competition", method = RequestMethod.POST)
    public String competition(@Valid CompetitionApplySaveBO bean){
        competitionApplyService.doSave(bean);
        return SUCCESS;
    }

    /**
     * 70周年报名活动专属函数-团队报名
     * @param bean
     * @return
     */
    @RequestMapping(value = "/seventyYearCompetitionForTeam", method = RequestMethod.POST)
    public String seventyYearCompetitionForTeam(@Valid CompetitionApplyForSeventyYearTeamSaveBO bean){
        //团队长姓名在个人角度也是个人真实姓名
        bean.setRealName(bean.getCaptainName());
        Long id = competitionApplyService.doSaveForSeventyYearTeam(bean);
        //更新团队编号
        CompetitionApplyUpdateBO competitionApplyUpdateBO = new CompetitionApplyUpdateBO();
        competitionApplyUpdateBO.setGroupCode(Integer.parseInt(id.toString()));
        competitionApplyUpdateBO.setId(id);
        competitionApplyService.doUpdate(competitionApplyUpdateBO);
        return "{\"success\":\"success\",\"group_code\":"+id+"}";
    }

    /**
     * 70周年报名活动专属函数-个人报名
     * @param bean
     * @return
     */
    @RequestMapping(value = "/seventyYearCompetitionForPerson", method = RequestMethod.POST)
    public String seventyYearCompetitionForPerson(@Valid CompetitionApplyForSeventyYearPersonSaveBO bean){
        competitionApplyService.doSaveForSeventyYearPerson(bean);
        return SUCCESS;
    }


    @RequestMapping(value = "/competition/get", method = RequestMethod.GET)
    public CompetitionDTO competition(Long id){
        return competitionService.get(id);
    }

    @RequestMapping(value = "/competition/list", method = RequestMethod.GET)
    public Pagination<CompetitionDTO> competition(CompetitionQUERY bean){
        bean.setGmtEnd(new Date());
        return competitionService.list(bean);
    }

    @RequestMapping(value = "/train",method = RequestMethod.POST)
    public String train(@Valid TrainApplySaveBO bean){
        trainApplyService.doSave(bean);
        return SUCCESS;
    }

    @RequestMapping(value = "/activity",method = RequestMethod.POST)
    public String activity(@Valid ActivityApplySaveBO bean){
        activityApplyService.doSave(bean);
        return SUCCESS;
    }

    @RequestMapping(value = "/train/list",method = RequestMethod.GET)
    public Pagination<TrainDTO> list(TrainQUERY bean){
        bean.setGmtEnd(new Date());
        return trainService.list(bean);
    }

    @RequestMapping(value = "/train/get",method = RequestMethod.GET)
    public TrainDTO get(Long id){
        return trainService.get(id);
    }

    @RequestMapping(value = "/activity/list", method = RequestMethod.GET)
    public Pagination<ActivityDTO> list(ActivityQUERY bean){
        bean.setGmtEnd(new Date());
        return activityService.list(bean);
    }

    @RequestMapping(value = "/activity/get", method = RequestMethod.GET)
    public ActivityDTO getActivity(Long id){
        return activityService.get(id);
    }
}
