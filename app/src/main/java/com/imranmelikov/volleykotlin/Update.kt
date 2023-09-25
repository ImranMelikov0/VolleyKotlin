package com.imranmelikov.volleykotlin

import android.content.Context
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley

class Update(val context: Context) {
    fun personUpdate(){
        val url="http://kasimadalan.pe.hu/kisiler/update_kisiler.php"

        val request=object :StringRequest(Method.POST,url,Response.Listener {response ->
            println(response)
        },Response.ErrorListener {
            it.printStackTrace()
        }){
            override fun getParams(): MutableMap<String, String>? {
                val params=HashMap<String,String>()
                params["kisi_id"]="15480"
                params["kisi_ad"]="test"
                params["kisi_tel"]="123"
                return params
            }
        }
        Volley.newRequestQueue(context).add(request)
    }
}