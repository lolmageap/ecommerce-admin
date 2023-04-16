package hello.ecommerce.admin.domain.user.repository

import hello.ecommerce.admin.domain.user.entity.AdminUser
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface AdminUserRepository : JpaRepository<AdminUser, Long> {
    fun findByEmailAndIsActivated(userEmail: String, isActivated: Boolean): AdminUser?

}