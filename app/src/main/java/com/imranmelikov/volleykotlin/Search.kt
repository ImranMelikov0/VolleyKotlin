package com.imranmelikov.volleykotlin

import android.content.Context
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import org.json.JSONException
import org.json.JSONObject

class Search(val context: Context) {
    fun personSearch(name:String) {

        val url = "http://kasimadalan.pe.hu/kisiler/tum_kisiler_arama.php"

        val request = object : StringRequest(Method.POST, url, Response.Listener {
            println("Success")
            try {
                val jsonObject=JSONObject(it)
                val personList=jsonObject.getJSONArray("kisiler")
                for (i in 0 until personList.length()){
                    val s=personList.getJSONObject(i)
                    val person_name=s.getString("kisi_ad")
                    val person_tel=s.getString("kisi_tel")
                    println("/////////")
                    println(person_name)
                    println(person_tel)
                    println("/////////")
                }
            }catch (e:JSONException){
                e.printStackTrace()
            }
        }, Response.ErrorListener {
            it.printStackTrace()
        }) {
            override fun getParams(): MutableMap<String, String>? {
                val params = HashMap<String, String>()
                params["kisi_ad"] = name
                return params
            }
        }
        Volley.newRequestQueue(context).add(request)
    }
}