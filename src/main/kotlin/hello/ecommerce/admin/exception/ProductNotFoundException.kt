package hello.ecommerce.admin.exception

class ProductNotFoundException (
        override val message: String
) : ServerException(code = 404, message = message)