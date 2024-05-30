package com.tencent.wxcloudrun.dto;

import lombok.Data;

import java.util.Date;

@Data
public class ActivityRequest {
    public String activityName;
    public String description;
    public Date date;
    //可以制定其他人为coach
    public String coachName;
    //费用/默认为0
    public int fee = 0;
    //人数下限
    public int limitLower;
    //人数上限
    public int limitHigher;
}
