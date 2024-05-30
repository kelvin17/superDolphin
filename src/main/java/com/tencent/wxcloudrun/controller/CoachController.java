package com.tencent.wxcloudrun.controller;

import com.tencent.wxcloudrun.config.ApiResponse;
import com.tencent.wxcloudrun.dto.ActivityRequest;
import com.tencent.wxcloudrun.model.Activity;
import com.tencent.wxcloudrun.service.CoachService;
import com.tencent.wxcloudrun.service.CounterService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CoachController {

    final Logger logger;
    final CoachService coachService;

    public CoachController(@Autowired CoachService coachService) {
        this.logger = LoggerFactory.getLogger(CoachController.class);
        this.coachService = coachService;
    }


    /**
     * 创建新的活动
     *
     * @param request
     * @return
     */
    @PostMapping(value = "/api/coach/create_activity")
    public ApiResponse createActivity(ActivityRequest request) {
        //获取登陆态
        String coachName = request.getCoachName();
        Activity activity = new Activity();
        activity.setName(request.getActivityName());
        activity.setCoachName(coachName);
        activity.setDescription(request.getDescription());
        activity.setDate(request.getDate());
        activity.setLimitCountLower(request.getLimitLower());
        activity.setLimitCountHigher(request.getLimitHigher());
        ApiResponse response;
        try {
            coachService.createActivity(activity);
            response = ApiResponse.ok("创建活动成功");
            logger.info("{} 发起活动 {} 成功", activity.getCoachName(), activity.getName());
        } catch (Exception e) {
            logger.error("创建活动时异常", e);
            response = ApiResponse.error(e.getMessage());
        }

        return response;


    }

    /**
     * 查看活动报名详情
     *
     * @param activityId
     * @return
     */
    @GetMapping(value = "/api/coach/query_detail")
    public ApiResponse queryDetail(int activityId) {

        ApiResponse response;
        try {
            Activity activity = coachService.getActivityDetail(activityId);
            //todo 还需要查询以下报名详情表
            response = ApiResponse.ok(activity);

        } catch (Exception e) {
            logger.error("查询活动报名详情异常", e);
            response = ApiResponse.error(e.getMessage());
        }

        return response;

    }

    /**
     * 编辑活动
     *
     * @param request
     * @return
     */
//    @PostMapping(value = "/api/coach/edit_activity")
//    public ApiResponse editActivity(ActivityRequest request) {
//
//    }

    /**
     * 查看活动列表 - 自己的
     *
     * @return
     */
//    @GetMapping(value = "/api/coach/query_activities")
//    public ApiResponse queryActivities() {
//
//    }
}
