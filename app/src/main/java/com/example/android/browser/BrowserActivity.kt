package com.example.android.browser

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.example.android.R
import com.example.android.databinding.BrowserActivityLayoutBinding

class BrowserActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val viewBinding = BrowserActivityLayoutBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        setSupportActionBar(viewBinding.toolbar)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.header_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.closeButton -> finish()
            else -> Unit
        }
        return super.onOptionsItemSelected(item)
    }

    companion object {
        private const val URL_KEY = "url"

        fun createIntent(context: Context, url: String): Intent =
            Intent(context, BrowserActivity::class.java).apply {
                putExtra(URL_KEY, url)
            }
    }
}
