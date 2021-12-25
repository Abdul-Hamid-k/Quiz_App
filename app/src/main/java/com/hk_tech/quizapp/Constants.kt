package com.hk_tech.quizapp

object Constants {
    const val NAME = "name"
    const val SCORE = "score"

    fun getQuestions(): ArrayList<QuestionsModel> {
        val questionList: ArrayList<QuestionsModel> = ArrayList()

        val que1 = QuestionsModel(
            1,
            "What country does this flag belongs to?",
            R.drawable.ic_flag_of_argentina,
            "Argentina",
            "Australia",
            "Armenia",
            "Austria",
            1
        )

        val que2 = QuestionsModel(
            2,
            "What country does this flag belongs to?",
            R.drawable.ic_flag_of_australia,
            "Argentina",
            "Australia",
            "Armenia",
            "Austria",
            2
        )

        val que3 = QuestionsModel(
            3,
            "What country does this flag belongs to?",
            R.drawable.ic_flag_of_belgium,
            "Bangladesh",
            "India",
            "Kuwait",
            "Belgium",
            4
        )

        val que4 = QuestionsModel(
            4,
            "What country does this flag belongs to?",
            R.drawable.ic_flag_of_brazil,
            "Israel",
            "Brazil",
            "America",
            "Austria",
            2
        )

        val que5 = QuestionsModel(
            5,
            "What country does this flag belongs to?",
            R.drawable.ic_flag_of_denmark,
            "Fiji",
            "India",
            "Armenia",
            "Denmark",
            4
        )

        val que6 = QuestionsModel(
            6,
            "What country does this flag belongs to?",
            R.drawable.ic_flag_of_fiji,
            "Nepal",
            "France",
            "Fiji",
            "Austria",
            3
        )

        val que7 = QuestionsModel(
            7,
            "What country does this flag belongs to?",
            R.drawable.ic_flag_of_germany,
            "Israel",
            "Atlantic",
            "India",
            "Germany",
            4
        )

        val que8 = QuestionsModel(
            8,
            "What country does this flag belongs to?",
            R.drawable.ic_flag_of_india,
            "Bangladesh",
            "Nepal",
            "India",
            "Pakistan",
            3
        )

        val que9 = QuestionsModel(
            9,
            "What country does this flag belongs to?",
            R.drawable.ic_flag_of_kuwait,
            "France",
            "Kuwait",
            "NewZealand",
            "Austria",
            2
        )

        val que10 = QuestionsModel(
            10,
            "What country does this flag belongs to?",
            R.drawable.ic_flag_of_new_zealand,
            "NewZealand",
            "Australia",
            "France",
            "Israel",
            1
        )

        questionList.add(que1)
        questionList.add(que2)
        questionList.add(que3)
        questionList.add(que4)
        questionList.add(que5)
        questionList.add(que6)
        questionList.add(que7)
        questionList.add(que8)
        questionList.add(que9)
        questionList.add(que10)

        return questionList
    }
}

