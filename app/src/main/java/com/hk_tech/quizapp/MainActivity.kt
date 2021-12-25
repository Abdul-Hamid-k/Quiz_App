package com.hk_tech.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.hk_tech.quizapp.databinding.ActivityMainBinding
import java.util.*

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

//        binding.etName.requestFocus()
        binding.btnStart.setOnClickListener {
            var name = binding.etName.text.toString()
            if (name.isEmpty()) {
                Toast.makeText(this, "Please enter a name!", Toast.LENGTH_LONG).show()
            } else {
                val intent = Intent(this, QuizQuestionActivity::class.java)
                name =
                    name.replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() }
                intent.putExtra(Constants.NAME, name)
                startActivity(intent)
                finish()
            }
        }
    }
}