package com.tencent.wxcloudrun.service.impl;

import com.tencent.wxcloudrun.dao.DolphinActivityMapper;
import com.tencent.wxcloudrun.model.Activity;
import com.tencent.wxcloudrun.service.CoachService;
import org.springframework.stereotype.Service;

@Service
public class CoachServiceImpl implements CoachService {

    final DolphinActivityMapper dolphinActivityMapper;

    public CoachServiceImpl(DolphinActivityMapper dolphinActivityMapper) {
        this.dolphinActivityMapper = dolphinActivityMapper;
    }

    @Override
    public void createActivity(Activity activity) {
        dolphinActivityMapper.createActivity(activity);
    }

    @Override
    public Activity getActivityDetail(int id) {
        return dolphinActivityMapper.getActivityDetail(id);
    }
}
