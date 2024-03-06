package engine.service

import engine.data.AnswerResult
import engine.data.Quiz
import org.springframework.stereotype.Service


@Service
class WebQuizService {

    private val quiz = Quiz(
        title = "The Java Logo",
        text = "What is depicted on the Java logo?",
        options = listOf("Robot", "Tea leaf", "Cup of coffee", "Bug")
    )

    fun getQuiz(): Quiz {
        return quiz
    }

    fun getAnswerResult(answer: Int): AnswerResult {
        return if (answer == 2) {
            AnswerResult.SUCCESS
        } else {
            AnswerResult.FAILURE
        }
    }
}