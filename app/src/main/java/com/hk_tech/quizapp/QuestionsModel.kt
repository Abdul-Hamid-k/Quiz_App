package com.hk_tech.quizapp

data class QuestionsModel(
    val questionId: Int,
    val question: String,
    val image: Int,
    val optionsOne: String,
    val optionsTwo: String,
    val optionsThree: String,
    val optionsFour: String,
    val answer: Int,
)
