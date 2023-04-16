package hello.ecommerce.admin.exception

class NotFoundCustomerException(
        override val message: String
) : ServerException(code = 404, message = message)