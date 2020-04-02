package com.hisense.splashscreenplugin;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;

import com.gyf.barlibrary.ImmersionBar;

import androidx.annotation.NonNull;
import androidx.annotation.StyleRes;

/**
 * @author zhangxuening
 */
public class SplashScreenDialog extends Dialog {

    private Activity activity;
    private ImmersionBar immersionBar;
    public SplashScreenDialog(@NonNull Context context, @StyleRes int themeResId) {
        super(context, themeResId);
        this.activity = (Activity) context;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setCancelable(false);
        this.setContentView(R.layout.launch_screen);
    }

    @Override
    protected void onStart() {
        super.onStart();
        if(this.immersionBar == null) {
            this.immersionBar = ImmersionBar.with(this.activity, this, "PWSplash");
        }
        this.immersionBar.init();
    }

    @Override
    protected void onStop() {
        super.onStop();
        if(null != this.immersionBar){
            this.immersionBar.destroy();
        }
    }

}
