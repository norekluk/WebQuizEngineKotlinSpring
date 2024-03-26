package engine.controller

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.context.request.ServletWebRequest
import java.time.LocalDateTime

@ControllerAdvice
class WebQuizControllerExceptionHandler {

    @ExceptionHandler(QuizNotFoundException::class)
    fun handleQuizNotFound(exception: QuizNotFoundException, request: ServletWebRequest): ResponseEntity<CustomErrorMessage> {
        return ResponseEntity<CustomErrorMessage>(
            CustomErrorMessage(
                LocalDateTime.now(),
                HttpStatus.NOT_FOUND.value(),
                exception.message,
                request.request.requestURI
            ), HttpStatus.NOT_FOUND
        )
    }

}

@ResponseStatus(code = HttpStatus.NOT_FOUND)
class QuizNotFoundException(message: String) : RuntimeException(message) {
    constructor(idOfQuiz: Int) : this("Quiz with id: $idOfQuiz not found")
}

data class CustomErrorMessage(
    val timestamp: LocalDateTime,
    val status: Int,
    val error: String?,
    val path: String
)

