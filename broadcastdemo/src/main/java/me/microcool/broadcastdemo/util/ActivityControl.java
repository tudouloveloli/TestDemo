package me.microcool.broadcastdemo.util;

import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Activity控制类
 *
 * @author gaoshiwei
 * @date 2018/1/3
 */

public class ActivityControl {

    private static final ActivityControl actiivtyControl = new ActivityControl();

    private ActivityControl() {
    }

    /**
     * 单例ActivityControl
     *
     * @return
     */
    private static ActivityControl newInstance() {
        return actiivtyControl;
    }

    private List<AppCompatActivity> activityList = new ArrayList<>();

    private List<AppCompatActivity> getActivityList() {
        return activityList;
    }


    /**
     * @param appCompatActivity
     */
    public static void addActivity(AppCompatActivity appCompatActivity) {

        newInstance().getActivityList().add(appCompatActivity);
    }

    /**
     * @param appCompatActivity
     */

    public static void removeActivity(AppCompatActivity appCompatActivity) {
        newInstance().getActivityList().remove(appCompatActivity);
    }

    /**
     * 退出所有的Activity
     */
    public static void destortAllActivity() {

        for (AppCompatActivity activity : newInstance().getActivityList()) {
            activity.finish();
        }
    }


}
