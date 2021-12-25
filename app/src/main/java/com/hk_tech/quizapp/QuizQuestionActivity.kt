package com.hk_tech.quizapp

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.hk_tech.quizapp.databinding.ActivityQuizQuestionBinding

class QuizQuestionActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityQuizQuestionBinding
    private var mSelectedOption: Int = 0
    private var mCurrentPosition: Int = 1
    private val mQuestionList: ArrayList<QuestionsModel> = Constants.getQuestions()

    private lateinit var progressBar: ProgressBar
    private lateinit var tvProgressBar: TextView
    private lateinit var tvQuestion: TextView
    private lateinit var flag: ImageView
    private lateinit var optionOne: TextView
    private lateinit var optionTwo: TextView
    private lateinit var optionThree: TextView
    private lateinit var optionFour: TextView
    private var score: Int = 0

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuizQuestionBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        progressBar = binding.progressBar
        tvProgressBar = binding.tvProgressBar
        tvQuestion = binding.tvQuestion
        flag = binding.ivFlag
        optionOne = binding.tvOptionOne
        optionTwo = binding.tvOptionTwo
        optionThree = binding.tvOptionThree
        optionFour = binding.tvOptionFour

        setQuestion()
        binding.btnSubmit.setOnClickListener(this)
    }

    @SuppressLint("SetTextI18n")
    private fun setQuestion() {
        defaultOptionsView()
        val question: QuestionsModel = mQuestionList[mCurrentPosition - 1]
        flag.setImageResource(question.image)
        progressBar.progress = mCurrentPosition
        tvProgressBar.text = "${mCurrentPosition}/${progressBar.max}"
        tvQuestion.text = question.question
        optionOne.text = question.optionsOne
        optionTwo.text = question.optionsTwo
        optionThree.text = question.optionsThree
        optionFour.text = question.optionsFour

        if (mCurrentPosition == mQuestionList.size) {
            binding.btnSubmit.text = "FINISH"
        } else {
            binding.btnSubmit.text = "SUBMIT"
        }

    }

    private fun defaultOptionsView() {
        val options = ArrayList<TextView>()
        options.add(optionOne)
        options.add(optionTwo)
        options.add(optionThree)
        options.add(optionFour)

        for (option in options) {
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(
                this,
                R.drawable.default_option_border_bg
            )
        }
    }

    private fun selectedOptionView(tv: TextView, selectedOptionNumber: Int) {
        defaultOptionsView()
        mSelectedOption = selectedOptionNumber

        tv.setTextColor(Color.parseColor("#363A43"))
        tv.setTypeface(tv.typeface, Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(
            this,
            R.drawable.select_option_border_bg
        )
    }

    @SuppressLint("SetTextI18n")
    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.tvOptionOne -> {
                selectedOptionView(optionOne, 1)
            }

            R.id.tvOptionTwo -> {
                selectedOptionView(optionTwo, 2)
            }

            R.id.tvOptionThree -> {
                selectedOptionView(optionThree, 3)
            }

            R.id.tvOptionFour -> {
                selectedOptionView(optionFour, 4)
            }
            R.id.btnSubmit -> {
                if (mSelectedOption == 0) {
                    mCurrentPosition++

                    when {
                        mCurrentPosition <= mQuestionList.size -> {
                            setQuestion()
                        }
                        else -> {
                            val name = intent.getStringExtra(Constants.NAME)
                            val intent = Intent(this, ScoreScreen::class.java)
                            intent.putExtra(Constants.SCORE, score.toString())
                            intent.putExtra(Constants.NAME, name)
                            startActivity(intent)
                            finish()
                        }
                    }
                } else {
                    val question = mQuestionList[mCurrentPosition - 1]
                    if (question.answer != mSelectedOption) {
                        answerView(mSelectedOption, R.drawable.wrong_option_border_bg)
                    } else {
                        score++
                    }
                    answerView(question.answer, R.drawable.correct_option_border_bg)


                    if (mCurrentPosition == mQuestionList.size) {
                        binding.btnSubmit.text = "FINISH"
                    } else {
                        binding.btnSubmit.text = "GO TO NEXT QUESTION"
                    }

                    mSelectedOption = 0
                }
            }
        }
    }

    private fun answerView(answer: Int, drawableView: Int) {
        when (answer) {
            1 -> {
                optionOne.background = ContextCompat.getDrawable(
                    this,
                    drawableView
                )
            }
            2 -> {
                optionTwo.background = ContextCompat.getDrawable(
                    this,
                    drawableView
                )
            }
            3 -> {
                optionThree.background = ContextCompat.getDrawable(
                    this,
                    drawableView
                )
            }
            4 -> {
                optionFour.background = ContextCompat.getDrawable(
                    this,
                    drawableView
                )
            }
        }
    }
}