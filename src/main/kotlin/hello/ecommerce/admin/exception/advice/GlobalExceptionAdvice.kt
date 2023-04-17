package hello.ecommerce.admin.exception.advice

import hello.ecommerce.admin.exception.ErrorResponse
import hello.ecommerce.admin.exception.ServerException
import mu.KotlinLogging
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class GlobalExceptionAdvice {

    private val logger = KotlinLogging.logger {}

    @ExceptionHandler(ServerException::class)
    fun handleServerException(exception: ServerException) : ErrorResponse {
        logger.error { exception.message }
        return ErrorResponse(code = exception.code, message = exception.message)
    }
}