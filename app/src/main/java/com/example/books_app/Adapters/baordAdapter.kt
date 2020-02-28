package com.example.books_app.Adapters

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.books_app.Models.books
import com.example.books_app.Models.booksBaordModel
import com.example.books_app.QtyFragment
import com.example.books_app.R
import kotlinx.android.synthetic.main.baord_row.view.*
import kotlinx.android.synthetic.main.item_row.view.*

class baordAdapter(var context: Context, var list:ArrayList<booksBaordModel> ): RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        var v: View = LayoutInflater.from(context).inflate(R.layout.baord_row,parent,false)
        return ItemHolder(v)
    }
    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        (holder as ItemHolder).bind(list[position].books,list[position].mrps,list[position].authors,list[position].categorys,list[position].citys,list[position].grades)
    }

    @Suppress("DEPRECATION")
    class ItemHolder(itemView: View): RecyclerView.ViewHolder(itemView)
    {

        fun bind(names:String, auth:String,price:String,cate:String,city:String,grade:String)
        {
            itemView.itemb_name.text=names
//          itemView.itemb_name.text=nb
            itemView.itemb_author.text=auth
            itemView.itemb_price.text=price.toString()
            itemView.itemb_category.text=cate
            itemView.itemb_city.text=city
            itemView.itemb_grade.text=grade

            itemView.itemb_add_photo.setOnClickListener {


                var obj= QtyFragment()
                var manager=(itemView.context as Activity).fragmentManager
                obj.show(manager,"Qty")
            }
        }
    }

}