package com.example.books_app

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley

@Suppress("DEPRECATION")
class QtyFragment:android.app.DialogFragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var v= inflater.inflate(R.layout.blankfrag, container, false)

        var et=v.findViewById<EditText>(R.id.etqty)
        var btn=v.findViewById<Button>(R.id.btnqty)

        btn.setOnClickListener {


            var ip=BookInfo.ip
            var url=ip+"bookselling/get_order.php?uname="+BookInfo.name+"&bookname="+BookInfo.book

            var rq: RequestQueue = Volley.newRequestQueue(activity)
            var sr= StringRequest(
                Request.Method.GET,url,

                Response.Listener{ response ->




                    var i= Intent(activity, Home_Page::class.java)
                    startActivity(i)



                },
                Response.ErrorListener { error->
                    Toast.makeText(activity ,error.message, Toast.LENGTH_SHORT).show()

                })
            rq.add(sr)

        }
        return v
    }


}

