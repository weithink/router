package com.leoao.fitness.router.action;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

import com.leoao.fitness.router.WeightModel;


/**
 * 第三方跳转 路由
 */
public class ThirdUrlAction extends Action {

    public ThirdUrlAction(Context context) {
        super(context);
    }

    /**
     * 跳转手机自带浏览器打开网页
     */
    @Override
    public void doAction(WeightModel weight) {
        Intent intent= new Intent();
        intent.setAction("android.intent.action.VIEW");
        Uri contentUrl = Uri.parse(weight.getUrl().replaceFirst("[a-zA-Z0-9]+://", "http://"));
        intent.setData(contentUrl);
        mContext.startActivity(intent);
    }
}
