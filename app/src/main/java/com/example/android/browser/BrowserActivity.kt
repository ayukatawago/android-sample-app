package com.example.android.browser

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.android.databinding.BrowserActivityLayoutBinding

class BrowserActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val viewBinding = BrowserActivityLayoutBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)
    }

    companion object {
        private const val URL_KEY = "url"

        fun createIntent(context: Context, url: String): Intent =
            Intent(context, BrowserActivity::class.java).apply {
                putExtra(URL_KEY, url)
            }
    }
}
