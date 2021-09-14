package com.aa.we201820367

import android.content.Intent
import android.content.pm.PackageManager
import android.nfc.Tag
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Base64
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast
import androidx.annotation.RequiresApi
import com.kakao.sdk.auth.model.OAuthToken
import com.kakao.sdk.common.model.AuthErrorCause
import com.kakao.sdk.common.util.Utility
import com.kakao.sdk.user.UserApiClient
import java.security.MessageDigest

class StartActivity : AppCompatActivity() {

    lateinit var welogin_Bt: Button

    @RequiresApi(Build.VERSION_CODES.P)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)

        welogin_Bt = findViewById(R.id.welogin_Bt)

        welogin_Bt.setOnClickListener {
            startActivity(Intent(this, weloginActivity::class.java))

            setContentView(R.layout.activity_main)

        }


    }
}
