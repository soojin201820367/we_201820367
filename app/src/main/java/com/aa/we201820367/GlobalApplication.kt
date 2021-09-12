package com.aa.we201820367

import android.app.Application
import com.kakao.sdk.common.KakaoSdk

class GlobalApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        KakaoSdk.init(this, "{17218dafa0f973f195498be804676cd5}")
    }

}