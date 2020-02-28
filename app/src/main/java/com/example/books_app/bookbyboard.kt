package com.example.books_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.Volley
import com.example.books_app.BookList.BaordAct
import com.example.books_app.bookbycity
import kotlinx.android.synthetic.main.activity_bookbyboard.*
import kotlinx.android.synthetic.main.activity_bookbycity.*

class bookbyboard : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bookbyboard)

        var ip = BookInfo.ip
        val url = ip + "bookselling/getboardlist.php"
        var list = ArrayList<String>()
        var rq = Volley.newRequestQueue(this)
        var jar = JsonArrayRequest(Request.Method.GET, url, null,
            Response.Listener { response ->
                for (x in 0..response.length() - 1) {
                    list.add(response.getJSONObject(x).getString("board"))

                    var adp = ArrayAdapter(this, R.layout.baordcardview, list)
                    bookbybaord.adapter = adp
                }


            }
            , Response.ErrorListener { error ->
                Toast.makeText(this, error.message, Toast.LENGTH_SHORT).show()

            })

        rq.add(jar)

        bookbybaord.setOnItemClickListener { adapterView, view, i, I ->

            var baord: String = list[i]
            var obj = Intent(this, BaordAct::class.java)
            obj.putExtra("board",baord)
            startActivity(obj)
        }


    }
}
