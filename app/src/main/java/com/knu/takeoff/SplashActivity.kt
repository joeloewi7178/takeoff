package com.knu.takeoff

import android.app.Activity
import android.content.Intent
import android.os.Bundle

class SplashActivity: Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // TODO: 인터넷 연결이나 초기 세팅 설정하기
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }
}