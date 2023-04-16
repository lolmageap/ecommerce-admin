package hello.ecommerce.admin.exception

class DuplicatedAdminUserException(
        override val message: String,
        ) : ServerException(code = 404, message = message)