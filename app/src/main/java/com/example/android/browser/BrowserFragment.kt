package com.example.android.browser

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebChromeClient
import android.webkit.WebViewClient
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import com.example.android.databinding.BrowserFragmentLayoutBinding

class BrowserFragment : Fragment() {
    private var viewBinding: BrowserFragmentLayoutBinding? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = BrowserFragmentLayoutBinding.inflate(inflater)
        return viewBinding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val viewBinding = viewBinding ?: return

        val webView = viewBinding.webView

        webView.settings.apply {
            javaScriptEnabled = true
            domStorageEnabled = true
        }
        webView.webViewClient = WebViewClient()
        webView.webChromeClient = WebChromeClient()

        val url = arguments?.getString(URL_KEY) ?: return

        webView.loadUrl(url)
    }

    override fun onDestroyView() {
        viewBinding?.webView?.destroy()
        viewBinding = null
        super.onDestroyView()
    }

    companion object {
        private const val URL_KEY = "url"
        fun create(url: String?): BrowserFragment = BrowserFragment().apply {
            arguments = bundleOf(URL_KEY to url)
        }
    }
}
