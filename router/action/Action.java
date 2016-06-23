package com.leoao.fitness.router.action;

import android.content.Context;

import com.leoao.fitness.router.WeightModel;


/**
 * action 基类
 */
abstract public class Action {

    protected Context mContext;

    public Action(Context context){
        mContext = context;
    }

    abstract public void doAction(WeightModel weight);
}
