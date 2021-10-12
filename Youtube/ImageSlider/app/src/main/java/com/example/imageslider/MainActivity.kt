package com.example.imageslider

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import androidx.viewpager2.widget.ViewPager2

class MainActivity : AppCompatActivity() {

    private lateinit var viewPager2: ViewPager2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewPager2 = findViewById(R.id.viewPagerImageSlider)

        var sliderItems = ArrayList<SliderItem>()
        sliderItems.add(SliderItem(R.drawable.bugatti))
        sliderItems.add(SliderItem(R.drawable.ferrari))
        sliderItems.add(SliderItem(R.drawable.ferrari2))
        sliderItems.add(SliderItem(R.drawable.ford_mustang))
        sliderItems.add(SliderItem(R.drawable.lamborghini))

        viewPager2.adapter = SliderAdapter(sliderItems, viewPager2)

        viewPager2.clipToPadding = false
        viewPager2.clipChildren = false
        viewPager2.offscreenPageLimit = 3
        viewPager2.getChildAt(0).overScrollMode = RecyclerView.OVER_SCROLL_NEVER

        var compositePageTransformer = CompositePageTransformer()
        compositePageTransformer.addTransformer(MarginPageTransformer(40))
        compositePageTransformer.addTransformer { page, position ->
            val r : Float = 1 - Math.abs(position)
            page.setScaleY(0.85f + r * 0.15f)
        }

        viewPager2.setPageTransformer(compositePageTransformer)
    }
}