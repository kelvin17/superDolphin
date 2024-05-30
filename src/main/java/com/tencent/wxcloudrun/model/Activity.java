package com.tencent.wxcloudrun.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class Activity  implements Serializable {

    int id;
    String name;
    String description;
    Date date;
    int fee;
    int limitCountLower;
    int limitCountHigher;
    String coachName;

}
