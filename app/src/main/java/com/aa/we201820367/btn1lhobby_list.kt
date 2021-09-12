package com.aa.we201820367

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.PixelCopy.request
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.aa.we201820367.databinding.ActivityBtn1lhobbyListBinding
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import org.json.JSONObject

class btn1lhobby_list : AppCompatActivity() {
    lateinit var binding: ActivityBtn1lhobbyListBinding
    lateinit var list: RecyclerView
    var hobbyarr: ArrayList<hobbyData> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBtn1lhobbyListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        list = findViewById(R.id.list)

        request()
    }

    fun request() {
        val queue = Volley.newRequestQueue(this)
        var url1: String =
            "https://apple2873.cafe24.com/study/hobbybtn1_select.php"

        val request: StringRequest = object : StringRequest(
            Method.POST, url1,
            Response.Listener { response ->
                var jsonObject: JSONObject = JSONObject(response)
                var result = jsonObject.getString("result")
                if (result == "OK") {
                    var jsonArray = jsonObject.getJSONArray("hobbybtn1")
                    hobbyarr.clear()
                    for (i in 0 until jsonArray.length() step 1) {
                        var hobbyObj = jsonArray.getJSONObject(i)
                        var temphobby: hobbyData = hobbyData(
                            hobbyObj.getString("ch_name"),
                            hobbyObj.getString("ch_info"),
                            hobbyObj.getString("hash")
                        )
                        hobbyarr.add(temphobby)

                    }
                    (binding.list.adapter as DataAdapter).notifyDataSetChanged()


                } else {
                    Toast.makeText(this, "데이터 가져오기 실패", Toast.LENGTH_SHORT).show()
                }
            },
            Response.ErrorListener { error ->
                Toast.makeText(this, error.toString(), Toast.LENGTH_LONG).show()
            }
        ) {
            override fun getParams(): MutableMap<String, String> {
                val params: MutableMap<String, String> = HashMap()
                params["token"] = Storage.token

                return params
            }
        }
        queue.add(request)

    }
}
