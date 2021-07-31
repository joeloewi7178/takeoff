package com.knu.takeoff

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class TakeOffApplication: Application() {

    override fun onCreate() {
        super.onCreate()

        //보통은 이 곳에서 초기화를 하지만, jetpack에 startup이라는 라이브러리로도 가능함.
    }
}