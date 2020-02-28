package com.example.books_app.Adapters

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.books_app.QtyFragment
import com.example.books_app.R
import com.example.books_app.Models.books
import kotlinx.android.synthetic.main.baord_row.view.*
import kotlinx.android.synthetic.main.item_row.view.*

class itemAdapter (var context: Context, var list:ArrayList<books> ): RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        var v: View = LayoutInflater.from(context).inflate(R.layout.item_row,parent,false)
        return ItemHolder(v)
    }
    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        (holder as ItemHolder).bind(list[position].book,list[position].mrp,list[position].author,list[position].category,list[position].grade,list[position].baord)
    }

    @Suppress("DEPRECATION")
    class ItemHolder(itemView:View):RecyclerView.ViewHolder(itemView)
    {

        fun bind(n:String, p:String,a:String,c:String,g:String,b:String)
        {
            itemView.item_name.text=n
            itemView.item_author.text=a
            itemView.item_price.text=p.toString()
            itemView.item_category.text=c
            itemView.item_grade.text=g
            itemView.item_baord.text=b

            itemView.item_add_photo.setOnClickListener {


                var obj= QtyFragment()
                var manager=(itemView.context as Activity).fragmentManager
                obj.show(manager,"Qty")
            }
        }
    }


}