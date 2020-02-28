package com.example.books_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.textclassifier.TextSelection
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.activity_sell__book.*

class Sell_Book : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sell__book)



        sell_sellbtn.setOnClickListener {
            var ip=BookInfo.ip
            var url=ip+"bookselling/addbookforselling.php?book="+sell_book.text.toString()+
                    "&author="+sell_author.text.toString()+
                    "&mrp="+sell_mrp.text.toString()+"&category="+sell_cate.text.toString()+
                    "&city="+sell_city.text.toString()+"&grade="+sell_class.text.toString()+
                    "&board="+sell_board.text.toString()

            var rq= Volley.newRequestQueue(this)
            var str= StringRequest(
                Request.Method.GET,url,
                Response.Listener { response ->
                    if (response.equals("0"))
                    {
                        Toast.makeText(this, "No Book Added", Toast.LENGTH_SHORT).show()
                    } else
                    {

                        Toast.makeText(this, "Book Added Successfully", Toast.LENGTH_SHORT).show()

                  val sell=Intent(this,Home_Page::class.java)
                  startActivity(sell)
                     }

                },Response.ErrorListener {error ->
                    Toast.makeText(this ,error.message, Toast.LENGTH_SHORT).show()

                })
            rq.add(str)
        }


    }
}



