package com.example.android.browser

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.JsResult
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.annotation.RequiresApi
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
        webView.webChromeClient = CustomWebChromeClient()

        val url = arguments?.getString(URL_KEY) ?: return

        webView.loadUrl(url)
    }

    override fun onDestroyView() {
        viewBinding?.webView?.apply {
            destroy()
        }
        viewBinding = null
        super.onDestroyView()
    }

    inner class CustomWebChromeClient : WebChromeClient() {
        @RequiresApi(Build.VERSION_CODES.TIRAMISU)
        override fun onJsConfirm(
            view: WebView?,
            url: String?,
            message: String?,
            result: JsResult?
        ): Boolean {
            val container = viewBinding?.root ?: return false
            childFragmentManager.setFragmentResultListener(
                JsDialogFragment.REQUEST_KEY,
                this@BrowserFragment
            ) { _, bundle ->
                val dialogResult =
                    bundle.getSerializable(JsDialogFragment.RESULT_KEY, JsDialogResult::class.java)
                when (dialogResult) {
                    JsDialogResult.OK -> result?.confirm()
                    JsDialogResult.CANCEL -> result?.cancel()
                    else -> result?.cancel()
                }
                childFragmentManager.clearFragmentResult(JsDialogFragment.REQUEST_KEY)
                childFragmentManager.clearFragmentResultListener(JsDialogFragment.REQUEST_KEY)
            }
            childFragmentManager.beginTransaction()
                .add(container.id, JsDialogFragment(), DIALOG_TAG)
                .commit()
            return true
        }
    }

    companion object {
        private const val URL_KEY = "url"
        private const val DIALOG_TAG = "js_dialog"

        fun create(url: String?): BrowserFragment = BrowserFragment().apply {
            arguments = bundleOf(URL_KEY to url)
        }
    }
}
