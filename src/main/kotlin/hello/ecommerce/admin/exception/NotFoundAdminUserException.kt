package hello.ecommerce.admin.exception

class NotFoundAdminUserException(
        override val message: String
) : ServerException(code = 404, message = message)