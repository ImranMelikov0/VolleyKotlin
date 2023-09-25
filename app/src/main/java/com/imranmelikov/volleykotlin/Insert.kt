package com.imranmelikov.volleykotlin

import android.content.Context
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley

class Insert(val context: Context) {
    fun personInsert(){
        val url ="http://kasimadalan.pe.hu/kisiler/insert_kisiler.php"

        val request=object :StringRequest(Method.POST,url,Response.Listener {response->

           println(response)
        },Response.ErrorListener {
            it.printStackTrace()
        }){
            override fun getParams(): MutableMap<String, String>? {
                val params=HashMap<String,String>()
                params["kisi_ad"]="TestName"
                params["kisi_tel"]="555040tel"
                return params
            }
        }
        Volley.newRequestQueue(context).add(request)
    }
}