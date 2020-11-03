package id.tsabit.quiz

object Constant {

    const val USER_NAME: String = "user_name"
    const val TOTAL_QUESTIONS: String = "total_questions"
    const val CORRECT_ANSWERS: String = "correct_answers"

    fun getQuestion(): ArrayList<Question> {
        val questionList = ArrayList<Question>()

        val q1 = Question(
            1,
            "Bendera dari Negara manakah ini?",
            R.drawable.argentina,
            "Argentina",
            "India",
            "Korea Selatan",
            "Singapore",
            1
        )
        questionList.add(q1)

        val q2 = Question(
            2,
            "Bendera dari Negara manakah ini?",
            R.drawable.india,
            "Argentina",
            "India",
            "Korea Selatan",
            "Malaysia",
            2
        )
        questionList.add(q2)

        val q3 = Question(
            3,
            "Bendera dari Negara manakah ini?",
            R.drawable.germany,
            "Indonesia",
            "Amerika",
            "Jerman",
            "Jepang",
            3
        )
        questionList.add(q3)

        val q4 = Question(
            4,
            "Bendera dari Negara manakah ini?",
            R.drawable.japan,
            "Jerman",
            "India",
            "Korea Selatan",
            "Jepang",
            4
        )
        questionList.add(q4)

        val q5 = Question(
            5,
            "Bendera dari Negara manakah ini?",
            R.drawable.indonesia,
            "Malaysia",
            "Indonesia",
            "Korea Selatan",
            "Singapore",
            2
        )
        questionList.add(q5)

        val q6 = Question(
            6,
            "Bendera dari Negara manakah ini?",
            R.drawable.malaysia,
            "Amerika",
            "India",
            "Malaysia",
            "Jerman",
            3
        )
        questionList.add(q6)

        val q7 = Question(
            7,
            "Bendera dari Negara manakah ini?",
            R.drawable.japan,
            "Argentina",
            "India",
            "Malaysia",
            "Jepang",
            4
        )
        questionList.add(q7)

        val q8 = Question(
            8,
            "Bendera dari Negara manakah ini?",
            R.drawable.singapore,
            "Malaysia",
            "Indonesia",
            "Korea Selatan",
            "Singapore",
            4
        )
        questionList.add(q8)

        val q9 = Question(
            9,
            "Bendera dari Negara manakah ini?",
            R.drawable.southkorea,
            "Korea Selatan",
            "India",
            "Amerika",
            "Jerman",
            1
        )
        questionList.add(q9)

        val q10 = Question(
            10,
            "Bendera dari Negara manakah ini?",
            R.drawable.unitedstates,
            "Indonesia",
            "Jepang",
            "Amerika",
            "Singapore",
            3
        )
        questionList.add(q10)


        return questionList
    }
}