package com.example.samojlov_av_homework_module_15_number_3

import android.os.Bundle
import android.widget.TableLayout
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.viewpager2.widget.ViewPager2
import com.example.samojlov_av_homework_module_15_number_3.databinding.ActivityMainBinding
import com.example.samojlov_av_homework_module_15_number_3.models.Page
import com.example.samojlov_av_homework_module_15_number_3.utils.ViewPagerAdapter
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var tableLayoutTL: TabLayout
    private lateinit var viewPager: ViewPager2

    private val pagers = Page.pageList
    private lateinit var adapter: ViewPagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
//        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        init()
    }

    private fun init() {
        tableLayoutTL = binding.tableLayoutTL
        viewPager = binding.viewPager

        adapter = ViewPagerAdapter(this, pagers)
        viewPager.adapter = adapter

        TabLayoutMediator(tableLayoutTL, viewPager) { tab, positoon ->
            val name = pagers[positoon].name
            tab.text = name
        }.attach()
    }
}