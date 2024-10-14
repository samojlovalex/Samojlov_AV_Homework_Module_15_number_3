package com.example.samojlov_av_homework_module_15_number_3.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import com.example.samojlov_av_homework_module_15_number_3.databinding.FragmentWebVieWBinding
import com.example.samojlov_av_homework_module_15_number_3.models.Page

class ViewPagerFragment : Fragment() {

    private lateinit var binding: FragmentWebVieWBinding
    private lateinit var webViewWV: WebView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentWebVieWBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        webViewWV = binding.webViewWV
        webViewWV.webViewClient = WebViewClient()
        val viewPagerItem = arguments?.getSerializable("vp") as Page
        webViewWV.loadUrl(viewPagerItem.url)
    }
}