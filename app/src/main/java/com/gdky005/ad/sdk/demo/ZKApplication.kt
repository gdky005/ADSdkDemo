package com.gdky005.ad.sdk.demo

import android.app.Application
import com.bytedance.sdk.openadsdk.TTAdConfig
import com.bytedance.sdk.openadsdk.TTAdConstant
import com.bytedance.sdk.openadsdk.TTAdSdk



class ZKApplication : Application() {

    override fun onCreate() {
        super.onCreate()

//        ZKManager.getInstance().init(this)  //必须
//        ZKManager.getInstance().initStethoForApplicaiton(this) //可选 手机 USB 连接电脑，可以通过 Chrome 中输入：chrome://inspect,查看网络，资源，数据库，SP 文件
//        ZKManager.getInstance().initTakePhotoForApplication()  //推荐添加 兼容7.0以上无法拍照问题
//
//        ZKManager.getInstance().setBaseUrl("http://www.gdky005.com") //必选，设置当前 app 请求域名的 Url


        //强烈建议在应用对应的Application#onCreate()方法中调用，避免出现content为null的异常
        TTAdSdk.init(
            this,
            TTAdConfig.Builder()
                .appId("5018527")
                .useTextureView(false) //使用TextureView控件播放视频,默认为SurfaceView,当有SurfaceView冲突的场景，可以使用TextureView
                .appName("com.gdky005.ad.sdk.demo")
                .titleBarTheme(TTAdConstant.TITLE_BAR_THEME_DARK)
                .allowShowNotify(true) //是否允许sdk展示通知栏提示
                .allowShowPageWhenScreenLock(true) //是否在锁屏场景支持展示广告落地页
                .debug(true) //测试阶段打开，可以通过日志排查问题，上线时去除该调用
                .directDownloadNetworkType(
                    TTAdConstant.NETWORK_STATE_WIFI,
                    TTAdConstant.NETWORK_STATE_3G
                ) //允许直接下载的网络状态集合
                .supportMultiProcess(false) //是否支持多进程，true支持
                .build()
        )

    }

}