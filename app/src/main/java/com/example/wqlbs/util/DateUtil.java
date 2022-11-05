package com.example.wqlbs.util;

/**
 * ************************************
 * 项目名称: GraduationProject
 *
 * @Author xushu
 * 创建时间: 2022/4/10 21:50
 * 用途：计算两个时间戳之间的间隔
 * 修改记录：
 *************************************/
public class DateUtil {
    public static String getDistanceTime(long time1, long time2) {
        long day = 0;
        long diff;

        if (time1 < time2) {
            diff = time2 - time1;
        } else {
            diff = time1 - time2;
        }
        day = diff / (24 * 60 * 60 * 1000);
        int re =  (int) day;
        if(re==0)
            return "一天内";
        if(re==1)
            return "两天内";
        if(re==2)
            return "三天内";
        if(re>2&&re<7)
            return "近几天";
        if(re>=7&&re<=14)
            return "一周前";
        if(re>14&&re<=30)
            return "一个月内";
        if(re>30&&re<90)
            return "三个月内";
        if(re>90&&re<180)
            return "半年内";
        else
            return "一年内";
    }

}
