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
import kotlinx.android.synthetic.main.activity_bookbyboard.*
import kotlinx.android.synthetic.main.activity_buy__book.*

class Buy_Book : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_buy__book)


        search_city.setOnClickListener {

            startActivity(Intent(this,bookbycity::class.java))


        }

        search_board.setOnClickListener {

         var i=Intent(this,bookbyboard::class.java)
            startActivity(i)


        }






////        var ip = BookInfo.ip
////        val url = ip + "bookselling/getbookstobuy.php"
////        var list = ArrayList<String>()
////        var rq = Volley.newRequestQueue(this)
////        var jar = JsonArrayRequest(Request.Method.GET, url, null,
////            Response.Listener { response ->
////                for (x in 0..response.length() - 1) {
////                    list.add(response.getJSONObject(x).getString("city"))
////
////                    var adp = ArrayAdapter(this, R.layout.mycardview, list)
////                    cate_h.adapter = adp
////                }
////
////
////            }
////            , Response.ErrorListener { error ->
////                Toast.makeText(this, error.message, Toast.LENGTH_SHORT).show()
////
////            })
//
//        rq.add(jar)
//
//        cate_h.setOnItemClickListener { adapterView, view, i, I ->
//
//            var cit: String = list[i]
//            var obj = Intent(this, ItemAct::class.java)
//            obj.putExtra("cit", cit)
//            startActivity(obj)
//        }
//
//
//        var ipb = BookInfo.ip
//        val urlb = ipb + "bookselling/get_board.php"
//        var listb = ArrayList<String>()
//        var rqb = Volley.newRequestQueue(this)
//        var jarb = JsonArrayRequest(Request.Method.GET, urlb, null,
//            Response.Listener { response ->
//                for (x in 0..response.length() - 1) {
//                    listb.add(response.getJSONObject(x).getString("board"))
//
//                    var adp = ArrayAdapter(this, R.layout.mycardview, listb)
//                    cate_h.adapter = adp
//                }
//
//
//            }
//            , Response.ErrorListener { error ->
//                Toast.makeText(this, error.message, Toast.LENGTH_SHORT).show()
//
//            })
//
//        rqb.add(jarb)
//
//
//        board_h.setOnItemClickListener { adapterView, view, i, I ->
//
//            var board: String = list[i]
//            var obj = Intent(this, ItemAct::class.java)
//            obj.putExtra("board", board)
//            startActivity(obj)
//        }
//

    }

}
