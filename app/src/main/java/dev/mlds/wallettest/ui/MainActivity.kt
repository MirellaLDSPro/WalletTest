package dev.mlds.wallettest.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import dev.mlds.wallettest.R
import dev.mlds.wallettest.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var viewBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)
    }
}