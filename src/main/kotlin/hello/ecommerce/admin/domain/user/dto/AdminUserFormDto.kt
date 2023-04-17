package hello.ecommerce.admin.domain.user.dto

data class AdminUserFormDto(
        val username: String,
        val password1: String,
        val password2: String,
        val email: String,
        val phone: String,
        ) {
}