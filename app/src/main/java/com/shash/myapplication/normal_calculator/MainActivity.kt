package com.shash.myapplication.normal_calculator

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.shash.myapplication.R

class MainActivity : AppCompatActivity() {
    lateinit var txtTitle: TextView
    var count: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        count = savedInstanceState?.getInt("Count", 0) ?: 0

        txtTitle = findViewById(R.id.txtCount)

        txtTitle.text = count.toString()



        findViewById<Button>(R.id.btnCount).setOnClickListener {
            count++
            txtTitle.text = count.toString()
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("Count", count)
    }

}