package com.example.acidbasequiz

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.acidbasequiz.databinding.ActivityResultsBinding

class ResultsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityResultsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val score = intent.getIntExtra("score", 0)
        val total = intent.getIntExtra("total", 10)
        val percentage = (score * 100) / total

        binding.scoreTv.text = "Score: $score/$total"
        binding.percentageTv.text = "$percentage%"
        binding.messageTv.text = getResultMessage(percentage)

        binding.retakeBtn.setOnClickListener {
            val intent = Intent(this, QuizActivity::class.java)
            startActivity(intent)
            finish()
        }

        binding.homeBtn.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    private fun getResultMessage(percentage: Int): String {
        return when {
            percentage >= 80 -> "Excellent! You have a great understanding of acid-base reactions! 🎉"
            percentage >= 60 -> "Good job! You have a solid understanding of the concepts. 👍"
            percentage >= 40 -> "Fair attempt! Review the concepts and try again. 📚"
            else -> "Keep learning! Practice more and retake the quiz. 💪"
        }
    }
}
