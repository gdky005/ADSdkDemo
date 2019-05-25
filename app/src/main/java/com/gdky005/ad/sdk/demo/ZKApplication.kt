package com.gdky005.ad.sdk.demo

import android.app.Application
import team.zhuoke.sdk.ZKManager

class ZKApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        ZKManager.getInstance().init(this)  //必须
        ZKManager.getInstance().initStethoForApplicaiton(this) //可选 手机 USB 连接电脑，可以通过 Chrome 中输入：chrome://inspect,查看网络，资源，数据库，SP 文件
        ZKManager.getInstance().initTakePhotoForApplication()  //推荐添加 兼容7.0以上无法拍照问题

        ZKManager.getInstance().setBaseUrl("http://www.gdky005.com") //必选，设置当前 app 请求域名的 Url

    }

}