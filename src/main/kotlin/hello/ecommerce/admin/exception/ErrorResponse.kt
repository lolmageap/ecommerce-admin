package hello.ecommerce.admin.exception

data class ErrorResponse(
        val code: Int,
        val message: String,
)