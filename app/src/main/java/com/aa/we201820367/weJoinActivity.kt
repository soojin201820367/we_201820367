package com.aa.we201820367

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.aa.we201820367.databinding.ActivityWeJoinBinding
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import org.json.JSONObject

class weJoinActivity : AppCompatActivity() {
    var isDup: Int = -1
    lateinit var binding: ActivityWeJoinBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWeJoinBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.chkBt.setOnClickListener{
            if (binding.userIdEt.text.toString().trim().length < 1) {
                Toast.makeText(this, "아이디를 입력해 주세요.", Toast.LENGTH_SHORT).show()

            } else if (binding.userIdEt.text.toString().trim().length < 3) {
                Toast.makeText(this, "아이디는 4글자 이상 입력해 주세요.", Toast.LENGTH_SHORT).show()

            }else{
                val queue = Volley.newRequestQueue(this)
                var url1 : String =
                    "https://apple2873.cafe24.com/study/duplicate_id.php"

                val request1: StringRequest = object : StringRequest(
                    Method.POST, url1,
                    Response.Listener { response ->
                        var jsonObject : JSONObject = JSONObject(response)
                        var result = jsonObject.getString("result")

                        when(result){
                            "OK" -> {
                                isDup = 1
                            }else->{
                                isDup = -1
                            }
                        }

                    },
                    Response.ErrorListener { error ->
                        Toast.makeText(this, error.toString(), Toast.LENGTH_LONG).show()
                    }
                ) {
                    override fun getParams(): MutableMap<String, String> {
                        val params:MutableMap<String,String> =HashMap()
                        params["user_id"] =binding.userIdEt.text.toString().trim()

                        return params
                    }
                }
                queue.add(request1)
            }
        }

        binding.joinBt.setOnClickListener {
            if (isDup == -1) {
                Toast.makeText(this, "아이디 중복 확인 해주세요.", Toast.LENGTH_SHORT).show()

            } else if (binding.userIdEt.text.toString().trim().length < 1) {
                Toast.makeText(this, "아이디를 입력해 주세요.", Toast.LENGTH_SHORT).show()

            } else if (binding.userIdEt.text.toString().trim().length < 3) {
                Toast.makeText(this, "아이디는 4글자 이상 입력해 주세요.", Toast.LENGTH_SHORT).show()

            } else if (binding.passEt1.text.toString().trim().length < 1) {
                Toast.makeText(this, "패스워드를 입력해 주세요.", Toast.LENGTH_SHORT).show()

            } else if (binding.passEt1.text.toString().trim() != binding.passEt2.text.toString().trim()) {
                Toast.makeText(this, "패스워드가 같지 않습니다 확인해 주세요.", Toast.LENGTH_SHORT).show()
            }else{
                val queue = Volley.newRequestQueue(this)
                var url1 : String =
                   "https://apple2873.cafe24.com/study/join.php"

                val request: StringRequest = object : StringRequest(
                    Method.POST, url1,
                    Response.Listener { response ->
                        var jsonObject : JSONObject = JSONObject(response)
                        var result = jsonObject.getString("result")

                        if(result == "OK"){
                            Storage.token = jsonObject.getString("token")
                            setResult(RESULT_OK)
                            finish()
                        }else{
                            Toast.makeText(this, "회원가입 실패 다시 시도해 주세요.", Toast.LENGTH_SHORT).show()
                        }
                    },
                    Response.ErrorListener { error ->
                        Toast.makeText(this, error.toString(), Toast.LENGTH_LONG).show()
                    }
                ) {
                    override fun getParams(): MutableMap<String, String> {
                        val params:MutableMap<String,String> =HashMap()
                        params["user_id"] =binding.userIdEt.text.toString().trim()
                        params["password"] =binding.passEt1.text.toString().trim()
                        return params
                    }
                }
                queue.add(request)

            }

        }
    }
}