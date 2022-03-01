package com.example.a20_coroutine

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.a20_coroutine.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding
    var count = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnDownload.setOnClickListener {
            CoroutineScope(Dispatchers.Default).launch {
                downloadData()
            }
        }

        binding.btnCount.setOnClickListener {
            count ++
            binding.txtCount.text = count.toString()
        }

    }

    private suspend fun downloadData() {
        for(i in 1..500000) {
            //Log.i("Mylog",i.toString())
            withContext(Dispatchers.Main){
                binding.txtDownload.text = i.toString()
            }

        }
    }
}