package com.aa.we201820367

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.aa.we201820367.databinding.ActivityMainBinding
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.kakao.sdk.common.util.Utility
import org.json.JSONObject

class MainActivity : AppCompatActivity(), View.OnClickListener {
    lateinit var binding :ActivityMainBinding

    lateinit var Btn_mk_hobby : Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



        Btn_mk_hobby = findViewById(R.id.Btn_mk_hobby)
        Btn_mk_hobby.setOnClickListener (this)


        binding.btn1.setOnClickListener(this)
        binding.btn2.setOnClickListener(this)
    }


    override fun onClick(v: View?) {
        var transaction = supportFragmentManager.beginTransaction()
        when (v!!.id) {
            R.id.btn1 -> {
                transaction.replace(R.id.bodyLayout,Btn1Fragment ())
            }
            R.id.btn2 -> {
                transaction.replace(R.id.bodyLayout,Btn2Fragment ())
            }
            R.id.Btn_mk_hobby -> {
                startActivity(Intent(this, com.aa.we201820367.Mk_hobbyActivity::class.java))
            }
            else -> {

            }
        }
        transaction.commit()
    }



    }


