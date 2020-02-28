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
import com.example.books_app.BookList.ItemAct
import kotlinx.android.synthetic.main.activity_bookbycity.*

class bookbycity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bookbycity)

        var ip = BookInfo.ip
        val url = ip + "bookselling/getbookstobuy.php"
        var list = ArrayList<String>()
        var rq = Volley.newRequestQueue(this)
        var jar = JsonArrayRequest(Request.Method.GET, url, null,
            Response.Listener { response ->
                for (x in 0..response.length() - 1) {
                    list.add(response.getJSONObject(x).getString("city"))

                    var adp = ArrayAdapter(this, R.layout.mycardview, list)
                    bookbycity.adapter = adp
                }


            }
            , Response.ErrorListener { error ->
                Toast.makeText(this, error.message, Toast.LENGTH_SHORT).show()

            })

        rq.add(jar)

        bookbycity.setOnItemClickListener { adapterView, view, i, I ->

            var cit: String = list[i]
            var obj = Intent(this, ItemAct::class.java)
            obj.putExtra("cit", cit)
            startActivity(obj)
        }

    }
}
