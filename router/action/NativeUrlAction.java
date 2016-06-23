package com.leoao.fitness.router.action;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import com.leoao.fitness.router.WeightModel;
import com.leoao.fitness.utils.AppManager;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


/**
 * native 路由
 */
public class NativeUrlAction extends Action {

    public NativeUrlAction(Context context) {
        super(context);
    }

    /**
     * 原生跳转
     */
    @Override
    public void doAction(WeightModel weight) {
       String classa =  weight.getUrl().split("://")[1];
        try {
            Intent intent = new Intent(mContext, Class.forName(mContext.getPackageName()+"."+classa));
            //截取参数进行传递
            Map<String, String> map = urlParma(weight.getUrl());
            Iterator iter = map.entrySet().iterator();
            while (iter.hasNext()) {
                Map.Entry entry = (Map.Entry) iter.next();
                intent.putExtra(entry.getKey() + "", entry.getValue() + "");
            }
            mContext.startActivity(intent);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 将url 的参数 转成hasmap
     */
    private Map<String, String> urlParma(String url) {
        Map<String, String> mapRequest = new HashMap<String, String>();
        String[] arrSplit = null;
        String strUrlParam = truncateUrlPage(url);
        if (strUrlParam == null) {
            return mapRequest;
        }
        arrSplit = strUrlParam.split("[&]");
        for (String strSplit : arrSplit) {
            String[] arrSplitEqual = null;
            arrSplitEqual = strSplit.split("[=]");
            if (arrSplitEqual.length > 1) {
                mapRequest.put(arrSplitEqual[0], arrSplitEqual[1]);
            } else {
                if (arrSplitEqual[0] != "") {
                    mapRequest.put(arrSplitEqual[0], "");
                }
            }
        }
        return mapRequest;
    }

    /**
     * 截断连接中的参数 给activity 参数使用
     */
    private String truncateUrlPage(String strURL) {
        String strAllParam = null;
        String[] arrSplit = null;
        strURL = strURL.trim().toLowerCase();
        arrSplit = strURL.split("[?]");
        if (strURL.length() > 1) {
            if (arrSplit.length > 1) {
                if (arrSplit[1] != null) {
                    strAllParam = arrSplit[1];
                }
            }
        }
        return strAllParam;
    }
}
