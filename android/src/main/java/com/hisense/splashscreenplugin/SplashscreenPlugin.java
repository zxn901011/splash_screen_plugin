package com.hisense.splashscreenplugin;

import android.app.Activity;

import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.MethodChannel.MethodCallHandler;
import io.flutter.plugin.common.MethodChannel.Result;
import io.flutter.plugin.common.PluginRegistry.Registrar;

public class SplashscreenPlugin implements MethodCallHandler {

    private final Activity activity;

    private SplashscreenPlugin(Activity activity) {
        this.activity = activity;
    }

    public static void registerWith(Registrar registrar) {
        final MethodChannel channel = new MethodChannel(registrar.messenger(), "splash_screen_plugin");
        channel.setMethodCallHandler(new FlutterSplashScreenPlugin(registrar.activity()));
    }

    @Override
    public void onMethodCall(MethodCall methodCall, Result result) {
        switch (methodCall.method) {
            case "show":
                show();
                break;
            case "hide":
                hide();
                break;
            default:
                result.notImplemented();
        }
    }

    /**
     * 打开启动屏
     */
    private void show() {
        SplashScreen.show(activity);
    }

    /**
     * 关闭启动屏
     */
    private void hide() {
        SplashScreen.hide(activity);
    }


}
