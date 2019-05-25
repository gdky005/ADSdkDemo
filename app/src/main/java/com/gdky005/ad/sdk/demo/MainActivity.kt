package com.gdky005.ad.sdk.demo

import android.app.Activity
import android.os.Bundle
import com.bytedance.sdk.openadsdk.TTAdManager
import com.bytedance.sdk.openadsdk.TTAdNative
import com.bytedance.sdk.openadsdk.TTAdSdk


class MainActivity : Activity() {
    lateinit var ttAdManager: TTAdManager
    lateinit var mTTAdNative: TTAdNative

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ttAdManager = TTAdSdk.getAdManager()
        mTTAdNative = TTAdSdk.getAdManager().createAdNative(baseContext)  //baseContext建议为activity




    }
}
