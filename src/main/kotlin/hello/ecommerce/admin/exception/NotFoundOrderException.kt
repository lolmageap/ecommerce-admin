package hello.ecommerce.admin.exception

class NotFoundOrderException(
        override val message: String
) : ServerException(code = 404, message = message)