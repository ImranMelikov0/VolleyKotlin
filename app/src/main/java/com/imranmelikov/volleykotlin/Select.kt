package com.imranmelikov.volleykotlin

import android.content.Context
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import org.json.JSONException
import org.json.JSONObject

class Select(val context: Context) {
    fun select(){
        val url="http://kasimadalan.pe.hu/kisiler/tum_kisiler.php"

        val request=StringRequest(Request.Method.GET,url, { response->
            println("Success")
            try {
                val jsonObject=JSONObject(response)
                val personList=jsonObject.getJSONArray("kisiler")
                for (i in 0 until personList.length()){
                    val s=personList.getJSONObject(i)
                    val personName=s.getString("kisi_ad")
                    val personTel=s.getString("kisi_tel")

                    println("*******")
                    println(personName)
                    println(personTel)
                }

            }catch (e:JSONException){
                e.printStackTrace()
            }
        }, {
            it.printStackTrace()
        })
        Volley.newRequestQueue(context).add(request)
        }
    }