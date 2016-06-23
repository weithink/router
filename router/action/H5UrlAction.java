package com.leoao.fitness.router.action;

import android.content.Context;
import android.content.Intent;

import com.leoao.fitness.WebViewActivity_;
import com.leoao.fitness.router.WeightModel;


/**
 * h5 action.
 */
public class H5UrlAction extends Action {

    public H5UrlAction(Context context) {
        super(context);
    }

    @Override
    public void doAction(WeightModel weight) {
        Intent h5Intent = new Intent(mContext, WebViewActivity_.class);
        h5Intent.putExtra("detail", weight.getUrl());
        mContext.startActivity(h5Intent);
    }
}
