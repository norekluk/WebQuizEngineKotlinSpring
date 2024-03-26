package engine.data

data class AnswerResult(val success: Boolean, val feedback: String) {

    companion object {
        val SUCCESS: AnswerResult = AnswerResult(true, "Congratulations, you're right!")
        val FAILURE: AnswerResult = AnswerResult(false, "Wrong answer! Please, try again.")
    }
}