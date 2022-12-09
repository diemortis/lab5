package com.creyc.test

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.recyclerview_item.view.*


class PhonesAdapter: RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var mPhonesList: ArrayList<PhoneModel> = ArrayList()

    fun setupPhones(phoneList: Array<PhoneModel>){
        mPhonesList.clear()
        mPhonesList.addAll(phoneList)
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val itemView = layoutInflater.inflate(R.layout.recyclerview_item, parent, false)
        return PhonesViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is PhonesViewHolder){
            holder.bind(mPhones = mPhonesList[position])
        }
    }

    override fun getItemCount(): Int {
        return mPhonesList.count()
    }

    class PhonesViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        fun bind(mPhones: PhoneModel){
            itemView.PhoneModelValueText.text = mPhones.name
            itemView.PriceValueText.text = mPhones.price
            itemView.DateValueText.text = mPhones.date
            itemView.ScoreValueText.text = mPhones.score
        }
    }

}