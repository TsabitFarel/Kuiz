package id.tsabit.quiz

import android.content.Intent
import android.graphics.BitmapFactory
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_quiz_question.*

class QuizQuestionActivity : AppCompatActivity(), View.OnClickListener {

    // mCurrentPosition untuk mengetahui posisi start quiz
    private var mCurrentPosition: Int = 1
    // mQuestionList untuk mengambil data dari data class Question
    private var mQuestionList: ArrayList<Question>? = null
    private var mSelectedOptionPosition: Int = 0
    // mCorrectAnswers untuk mengetahui kita benar berapa
    private var mCorrectAnswers: Int = 0
    // mUsername untuk menyimpan username kita
    private var mUsername: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_question)

        // Mengambil Username yang dimasukkan ke dalam editText username
        mUsername = intent.getStringExtra(Constant.USER_NAME)

        mQuestionList = Constant.getQuestion()

        setQuestion()

        txt_option_one.setOnClickListener(this)
        txt_option_two.setOnClickListener(this)
        txt_option_three.setOnClickListener(this)
        txt_option_four.setOnClickListener(this)
        btn_submit.setOnClickListener(this)
    }

    private fun setQuestion() {
        val question = mQuestionList!![mCurrentPosition-1]

        defaultOptionsView()

        if (mCurrentPosition == mQuestionList!!.size){
            btn_submit.text = "SELESAI"
        } else {
            btn_submit.text = "JAWAB"
        }

        progress_bar.progress = mCurrentPosition
        txt_progress.text = "$mCurrentPosition" + "/" + progress_bar.max

        txt_question.text = question.question
        country_image.setImageResource(question.image)
        txt_option_one.text = question.optionOne
        txt_option_two.text = question.optionTwo
        txt_option_three.text = question.optionThree
        txt_option_four.text = question.optionFour
    }

    private fun defaultOptionsView() {
        val options = ArrayList<TextView>()
        options.add(0, txt_option_one)
        options.add(1, txt_option_two)
        options.add(2, txt_option_three)
        options.add(3, txt_option_four)

        for (option in options) {
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(
                    this,
                    R.drawable.default_option_border_bg
            )
        }
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.txt_option_one -> {
                selectedOptionView(txt_option_one, 1)
            }
            R.id.txt_option_two -> {
                selectedOptionView(txt_option_two, 2)
            }
            R.id.txt_option_three -> {
                selectedOptionView(txt_option_three, 3)
            }
            R.id.txt_option_four -> {
                selectedOptionView(txt_option_four, 4)
            }
            R.id.btn_submit -> {
                // Jika selesai submit jawaban maka akan ke Pertanyaan selanjutnya
                if (mSelectedOptionPosition == 0) {
                    mCurrentPosition ++

                    // Jika posisi user masih di pertanyaan maka tampilkan pertanyaan lainnya
                    when {
                        mCurrentPosition <= mQuestionList!!.size -> {
                            setQuestion()
                        }
                        // Dan jika user melebihi batas soal maka akan ada Toast selesai quiz
                        else -> {
                            val intent = Intent(this, ResultActivity::class.java)
                            intent.putExtra(Constant.USER_NAME, mUsername)
                            intent.putExtra(Constant.CORRECT_ANSWERS, mCorrectAnswers)
                            intent.putExtra(Constant.TOTAL_QUESTIONS, mQuestionList!!.size)
                            startActivity(intent)
                            finish()
                        }
                    }
                } else {
                    // Jika User salah maka akan muncul drawable dari wrong_option_border_bg
                    val question = mQuestionList?.get(mCurrentPosition -1)
                    if (question!!.correctAnswer != mSelectedOptionPosition){
                        answerView(mSelectedOptionPosition, R.drawable.wrong_option_border_bg)
                    } else {
                        mCorrectAnswers++
                    }
                    // Jika User benar akan muncul drawable dari correct_option_border_bg
                    // correctAnswer yang benar ini di luar if karena jika pertanyaan benar
                    // maka tidak perlu memberi tahu kalau ini salah artinya kalau keluar warna
                    // hijau maka tidak perlu lagi keluar warna merah
                    answerView(question.correctAnswer, R.drawable.correct_option_border_bg)

                    // Mengubah btn_submit kalau sudah selesai menjawab pertanyaan menjadi "FINISH"
                    // atau "GO TO NEXT QUESTION"
                    if (mCurrentPosition == mQuestionList!!.size) {
                        btn_submit.text = "SELESAI"
                    } else {
                        btn_submit.text = "KE PERTANYAAN SELANJUTNYA"
                    }
                    mSelectedOptionPosition = 0
                }
            }
        }
    }

    private fun answerView(answer: Int, drawableView: Int) {
        when(answer) {
            1 -> {
                txt_option_one.background = ContextCompat.getDrawable(this, drawableView)
            }
            2 -> {
                txt_option_two.background = ContextCompat.getDrawable(this, drawableView)
            }
            3 -> {
                txt_option_three.background = ContextCompat.getDrawable(this, drawableView)
            }
            4 -> {
                txt_option_four.background = ContextCompat.getDrawable(this, drawableView)
            }
        }
    }


    private fun selectedOptionView(tv: TextView, selectedOptionNum: Int){

        defaultOptionsView()
        mSelectedOptionPosition = selectedOptionNum

        tv.setTextColor(Color.parseColor("#363A43"))
        tv.setTypeface(tv.typeface, Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(
                this,
                R.drawable.selected_option_border_bg
        )
    }
}