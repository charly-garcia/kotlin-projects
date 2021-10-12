package com.example.imageslider

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.makeramen.roundedimageview.RoundedImageView

class SliderAdapter(sliderItems: ArrayList<SliderItem>, viewPager2: ViewPager2) : RecyclerView.Adapter<SliderAdapter.SliderViewHolder>() {

    var sliderItems : ArrayList<SliderItem>
    var viewPager2 : ViewPager2

    init {
        this.sliderItems = sliderItems
        this.viewPager2 = viewPager2
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SliderViewHolder {
        return SliderViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.slide_item_container,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: SliderViewHolder, position: Int) {
        holder.setImage(sliderItems[position])
    }

    override fun getItemCount(): Int {
        return sliderItems.size
    }

    class SliderViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {

        var imageView : RoundedImageView

        init {
            imageView = itemView.findViewById(R.id.imageSlide)
        }

        fun setImage(sliderItem: SliderItem) {
            imageView.setImageResource(sliderItem.image)
        }
    }
}