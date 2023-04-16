package hello.ecommerce.admin.exception

sealed class ServerException(
        val code: Int,
        override val message: String,
        ) : RuntimeException(message)
