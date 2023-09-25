package com.imranmelikov.volleykotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val insert=Insert(this)
        insert.personInsert()

        val delete=Delete(this)
        delete.personDelete()

        val update=Update(this)
        update.personUpdate()

        val select=Select(this)
        select.select()

        val search=Search(this)
        search.personSearch("test")
    }

}