package com.hk_tech.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.hk_tech.quizapp.databinding.ActivityScoreScreenBinding

class ScoreScreen : AppCompatActivity() {
    private lateinit var binding: ActivityScoreScreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityScoreScreenBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        val name = intent.getStringExtra(Constants.NAME)
        val score = intent.getStringExtra(Constants.SCORE)
        binding.tvName.text = name
        binding.tvScore.text = score
        binding.btnFinish.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}