package com.tencent.wxcloudrun.service;


import com.tencent.wxcloudrun.model.Activity;

public interface CoachService {

    void createActivity(Activity activity);

    Activity getActivityDetail(int id);
}
