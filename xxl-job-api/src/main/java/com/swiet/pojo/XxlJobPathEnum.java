package com.swiet.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum XxlJobPathEnum {
    LOGIN("/login", "登录"),
    ADD("/jobinfo/add", "添加Job"),
    UPDATE("/jobinfo/update", "更新Job"),
    REMOVE("/jobinfo/remove", "删除Job"),
    PAGE_JOB("/jobinfo/pageList", "查询Job"),
    PAGE_GROUP("/jobgroup/pageList", "查询Job组");

    private String path;
    private String desc;
}
