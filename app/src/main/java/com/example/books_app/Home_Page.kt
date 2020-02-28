package com.example.books_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_home__page.*

class Home_Page : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home__page)

        home_sellbtn.setOnClickListener {
            val sell= Intent(this,Sell_Book::class.java)
            startActivity(sell)
        }

        home_buybtn.setOnClickListener {
            val buy= Intent(this,Buy_Book::class.java)
            startActivity(buy)
        }
    }
}
