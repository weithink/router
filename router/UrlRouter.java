package com.leoao.fitness.router;

import android.content.Context;

import com.leoao.fitness.router.action.Action;
import com.leoao.fitness.router.action.H5UrlAction;
import com.leoao.fitness.router.action.NativeUrlAction;
import com.leoao.fitness.router.action.ThirdUrlAction;


/**
 * 路由总入口
 */
public class UrlRouter {

    private Context mContext;

    public UrlRouter(Context context) {
        mContext = context;
    }

    /**
     * 说明
     *
     * 针对一个url 进行路由跳转 分为三大类
     *
     * 如果是以leoao:// 开头的,统一跳转原生activity
     *              如果要带参数,就像url 的get 参数一样传
     *              key 要和原生定义的key 一样即可
     *
     * 如果是以http:// 开头的,跳转自带webView 打开
     *
     * 如果是以url://  开头的,统一跳转 第三方浏览器
     */
    public void router(String url) {
        if (null!=url) {
            WeightModel weight = new WeightModel();
            weight.setOriginInfo(url);
            weight.setUrl(url);
            weight.setProtocol(url.split("://")[0]);
            router(weight);
        }
    }

    private void router(WeightModel weight) {
        Action action = null;
        switch (weight.getProtocol()) {
            case UrlProtocol.RO_H5://第三方浏览器打开
                action = new H5UrlAction(mContext);
                break;
            case UrlProtocol.RO_PROTOCOL_HEADER://原生的
                action = new NativeUrlAction(mContext);
                break;
            case UrlProtocol.RO_URL_PARMA://url
                action = new ThirdUrlAction(mContext);
                break;
        }
        action.doAction(weight);
    }
}
