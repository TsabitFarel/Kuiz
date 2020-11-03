package id.tsabit.quiz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_result.*

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val username = intent.getStringExtra(Constant.USER_NAME)
        txt_username.text = username

        val totalQuestion = intent.getIntExtra(Constant.TOTAL_QUESTIONS, 0)
        val correctAnswer = intent.getIntExtra(Constant.CORRECT_ANSWERS, 0)

        txt_score.text = "Skormu $correctAnswer dari $totalQuestion"

        btn_finish.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
    }
}