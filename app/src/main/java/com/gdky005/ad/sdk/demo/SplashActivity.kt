package com.gdky005.ad.sdk.demo

import android.app.Activity
import android.os.Bundle
import android.view.View
import com.bytedance.sdk.openadsdk.*
import kotlinx.android.synthetic.main.content_main.*
import org.jetbrains.anko.toast


class SplashActivity : Activity() {

    lateinit var ttAdManager: TTAdManager
    lateinit var mTTAdNative: TTAdNative

    @Override
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.content_main)

        ttAdManager = TTAdSdk.getAdManager()
        mTTAdNative = TTAdSdk.getAdManager().createAdNative(baseContext)  //baseContext建议为activity


        val adSlot = AdSlot.Builder()
            .setAdCount(10)
            .setCodeId("818527689")
            .setImageAcceptedSize(640, 320)
            .build()

//            // 注：如果您在头条广告平台选择了原生广告，返回的图片尺寸可能会与您期望的尺寸有较大差异
//            .setImageAcceptedSize(640, 320)
//            // 可选参数 设置是否支持deeplink
//            .setSupportDeepLink(true)
//            // 可选参数，针对信息流广告设置每次请求的广告返回个数，最多支持3个
//            .setAdCount(2)
//            //请求原生广告时候需要设置，参数为TYPE_BANNER或TYPE_INTERACTION_AD
//            .setNativeAdType(AdSlot.TYPE_BANNER)
//            //激励视频奖励的名称，针对激励视频参数
//            .setRewardName("金币")
//            //激励视频奖励个数
//            .setRewardAmount(3)
//            //用户ID,使用激励视频必传参数
//            //表来标识应用侧唯一用户；若非服务器回调模式或不需sdk透传，可设置为空字符串
//            .setUserID("user123")
//            //设置期望视频播放的方向，为TTAdConstant.HORIZONTAL或TTAdConstant.VERTICAL
//            .setOrientation(orientation)
//            //激励视频奖励透传参数，字符串，如果用json对象，必须使用序列化为String类型,可为空
//            .setMediaExtra("media_extra")
//            .build();


        mTTAdNative.loadSplashAd(adSlot, object : TTAdNative.SplashAdListener {
            override fun onSplashAdLoad(ad: TTSplashAd) {
                toast("开屏广告请求成功")

                var view = ad.splashView

                var mSplashContainer = rl

                mSplashContainer.removeAllViews()
                //把SplashView 添加到ViewGroup中
                mSplashContainer.addView(view)
                //设置SplashView的交互监听器
                ad.setSplashInteractionListener(object : TTSplashAd.AdInteractionListener {
                    override fun onAdClicked(p0: View?, p1: Int) {
                        toast("开屏广告点击")
                    }

                    override fun onAdSkip() {
                        toast("开屏广告展示")
                    }

                    override fun onAdShow(p0: View?, p1: Int) {
                        toast("开屏广告跳过")
                    }

                    override fun onAdTimeOver() {
                        toast("开屏广告倒计时结束")
                    }
                })

            }

            override fun onTimeout() {
                toast("onTimeout")
            }

            override fun onError(code: Int, message: String) {
                toast("onError: message")
            }
        })

    }
}