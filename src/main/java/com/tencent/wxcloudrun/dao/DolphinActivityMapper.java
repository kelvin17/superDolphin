package com.tencent.wxcloudrun.dao;

import com.tencent.wxcloudrun.model.Activity;
import org.apache.ibatis.annotations.Param;

public interface DolphinActivityMapper {

    void createActivity(Activity activity);

    Activity getActivityDetail(@Param("id") Integer id);
}
