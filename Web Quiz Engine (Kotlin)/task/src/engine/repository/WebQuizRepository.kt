package engine.repository

import engine.controller.QuizNotFoundException
import engine.data.Quiz
import org.springframework.stereotype.Component

@Component
class WebQuizRepository {

    private val quizzes = mutableListOf<Quiz>()

    fun addQuiz(quiz: Quiz): Int {
        quizzes.add(quiz)
        return quizzes.lastIndex
    }

    fun getQuiz(id: Int): Quiz {
        if (id >= quizzes.size || id < 0) throw QuizNotFoundException(id)

        return quizzes[id]
    }

    fun getQuizzes(): List<Quiz> {
        return quizzes
    }
}