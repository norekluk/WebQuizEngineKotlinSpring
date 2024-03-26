package engine.controller

import engine.data.AnswerResult
import engine.data.Quiz
import engine.data.QuizResponse
import engine.service.WebQuizService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class WebQuizController(val service: WebQuizService) {

    @PostMapping("/quizzes")
    fun createQuiz(@RequestBody quiz: Quiz): ResponseEntity<QuizResponse> {
        val id = service.createQuiz(quiz)

        val responseBody = QuizResponse(id, quiz.title, quiz.text, quiz.options)

        return ResponseEntity.ok(responseBody)
    }

    @GetMapping("/quizzes/{id}")
    fun getQuiz(@PathVariable id: Int): ResponseEntity<QuizResponse> {
        val quiz = service.getQuizById(id)

        return ResponseEntity.ok(QuizResponse(id, quiz.title, quiz.text, quiz.options))
    }

    @GetMapping("/quizzes")
    fun getQuizzes(): ResponseEntity<List<QuizResponse>> {
        return ResponseEntity.ok(
            service.getQuizzes().mapIndexed { index, quiz -> QuizResponse(index, quiz.title, quiz.text, quiz.options) }
        )
    }

    @PostMapping("/quizzes/{id}/solve")
    fun solveQuiz(@PathVariable id: Int, @RequestParam answer: Int): ResponseEntity<AnswerResult> {
        return ResponseEntity.ok(
            when (service.solveQuiz(id, answer)) {
                true -> AnswerResult.SUCCESS
                false -> AnswerResult.FAILURE
            }
        )
    }

}