package com.example.books_app.BookList

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.Volley
import com.example.books_app.Adapters.itemAdapter
import com.example.books_app.BookInfo
import com.example.books_app.R
import com.example.books_app.Models.books
import kotlinx.android.synthetic.main.activity_item.*

class ItemAct : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item)

        var cit = intent.getStringExtra("cit")
        var ip= BookInfo.ip
        var url=ip+"/bookselling/get_books_by_city.php?city="+cit


//        var baord = intent.getStringExtra("board")
//        var url1=ip+"/bookselling/get_books_by_city.php?baord="+baord

        var list=ArrayList<books>()

        var rq: RequestQueue = Volley.newRequestQueue(this)
        var jar= JsonArrayRequest(
            Request.Method.GET,url,null,
            Response.Listener{response->
                for(x in 0..response.length()-1)
                { list.add(
                    books(
                        response.getJSONObject(x).getString("book"),
                        response.getJSONObject(x).getString("author"),
                        response.getJSONObject(x).getString("mrp"),
                        response.getJSONObject(x).getString("category"),
                        response.getJSONObject(x).getString("grade"),
                        response.getJSONObject(x).getString("board")
                    )
                )

                    var adp=itemAdapter(this, list)
                    rec_itm.layoutManager= LinearLayoutManager(this)
                    rec_itm.adapter=adp
                }
            }, Response.ErrorListener { error->

                Toast.makeText(this ,error.message.toString(), Toast.LENGTH_SHORT).show()

            })

        rq.add(jar)

    }


}
