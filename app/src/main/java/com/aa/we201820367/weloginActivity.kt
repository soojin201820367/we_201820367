package com.aa.we201820367

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.Toast
import com.aa.we201820367.databinding.ActivityWeloginBinding
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.kakao.sdk.common.util.Utility
import org.json.JSONObject

class weloginActivity : AppCompatActivity(), View.OnClickListener {
    lateinit var binding: ActivityWeloginBinding

    companion object{
        var token :String = ""
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWeloginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var keyHash = Utility.getKeyHash(this)
        Log.d("KEY_HASH", keyHash)


        binding.joinTv.setOnClickListener(this)
        binding.loginBt.setOnClickListener(View.OnClickListener {
            if (binding.userIdEt.text.toString().trim().length < 1) {
                Toast.makeText(this, "아이디를 입력해 주세요.", Toast.LENGTH_SHORT).show()

            } else if (binding.passEt.text.toString().trim().length < 1) {
                Toast.makeText(this, "패스워드를 입력해 주세요.", Toast.LENGTH_SHORT).show()

            } else {
                val queue = Volley.newRequestQueue(this)
                var url1 : String =
                    "https://apple2873.cafe24.com/study/login.php"

                val request: StringRequest = object : StringRequest(
                    Method.POST, url1,
                    Response.Listener { response ->
                        var jsonObject : JSONObject = JSONObject(response)
                        var result = jsonObject.getString("result")

                        if(result == "OK"){
                            Storage.token = jsonObject.getString("token")
                            startActivity(Intent(this, com.aa.we201820367.MainActivity::class.java))
                            finish()
                        }else{
                            Toast.makeText(this, "로그인을 실패했습니다.", Toast.LENGTH_SHORT).show()
                        }
                    },
                    Response.ErrorListener { error ->
                        Toast.makeText(this, error.toString(), Toast.LENGTH_LONG).show()
                    }
                ) {
                    override fun getParams(): MutableMap<String, String> {
                        val params:MutableMap<String,String> =HashMap()
                        params["user_id"] =binding.userIdEt.text.toString().trim()
                        params["password"] =binding.passEt.text.toString().trim()
                        return params
                    }
                }
                queue.add(request)
            }
        })

    }

    override fun onClick(v: View?) {
       startActivityForResult(Intent(this,com.aa.we201820367.weJoinActivity::class.java),1000)

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        when(resultCode){
            RESULT_OK -> {
                startActivity(Intent(this, com.aa.we201820367.MainActivity::class.java))
                finish()

            }else -> {

        }
    }


    }

}