package engine.service

import engine.data.Quiz
import engine.repository.WebQuizRepository
import org.springframework.stereotype.Service


@Service
class WebQuizService(val repository: WebQuizRepository) {

    fun createQuiz(quiz: Quiz): Int {
        return repository.addQuiz(quiz)
    }
    fun getQuizById(id: Int): Quiz {
        return repository.getQuiz(id)
    }

    fun getQuizzes(): List<Quiz> {
        return repository.getQuizzes()
    }

    fun solveQuiz(quizId: Int, answer: Int): Boolean {
        return repository.getQuiz(quizId).answer == answer
    }
}