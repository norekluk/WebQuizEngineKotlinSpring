package engine.controller

import engine.data.AnswerResult
import engine.data.Quiz
import engine.service.WebQuizService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class WebQuizController(val service: WebQuizService) {


    @GetMapping("/quiz")
    fun getQuiz(): ResponseEntity<Quiz> {
        return ResponseEntity.ok(service.getQuiz())
    }

    @PostMapping("/quiz")
    fun answerQuiz(@RequestParam answer: Int): ResponseEntity<AnswerResult> {
        return ResponseEntity.ok(service.getAnswerResult(answer))
    }

}