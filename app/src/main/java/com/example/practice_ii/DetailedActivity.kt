package com.example.practice_ii

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetailActivity : AppCompatActivity() {
    private lateinit var titleTextView: TextView
    private lateinit var subtitleTextView: TextView
    private lateinit var descriptionTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        titleTextView = findViewById(R.id.titleTextView)
        subtitleTextView = findViewById(R.id.subtitleTextView)
        descriptionTextView = findViewById(R.id.descriptionTextView)

        val title = intent.getStringExtra("title") ?: ""
        val subtitle = intent.getStringExtra("subtitle") ?: ""
        val description = intent.getStringExtra("description") ?: ""

        titleTextView.text = title
        subtitleTextView.text = subtitle
        descriptionTextView.text = description
    }
}
