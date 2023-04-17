package hello.ecommerce.admin.domain.user.service

import hello.ecommerce.admin.domain.user.dto.AdminUserDetail
import hello.ecommerce.admin.domain.user.entity.AdminUser
import hello.ecommerce.admin.domain.user.repository.AdminUserRepository
import hello.ecommerce.admin.exception.DuplicatedAdminUserException
import hello.ecommerce.admin.exception.NotFoundAdminUserException
import mu.KotlinLogging
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class AdminUserDetailService(val adminUserRepository: AdminUserRepository) : UserDetailsService {

    private val logger = KotlinLogging.logger {}

    fun save(adminUser: AdminUser): AdminUser {
        val adminUser: AdminUser = adminUserRepository.findByEmailAndIsActivated(adminUser.email, true)
                ?: return adminUserRepository.save(adminUser)

        throw DuplicatedAdminUserException(message = "Already register admin user, ${adminUser.email}")
    }

    @Throws(UsernameNotFoundException::class)
    override fun loadUserByUsername(userEmail: String): UserDetails? {
        logger.info(">>> loadUserByUsername, {}", userEmail)

        val adminUser: AdminUser = adminUserRepository.findByEmailAndIsActivated(userEmail, true)
                ?: throw NotFoundAdminUserException(message = "Not found admin user with $userEmail")

        return AdminUserDetail(
                adminUser = adminUser,
                roles = adminUser.role?.let { listOf(it) },
                permissions = adminUser.permission?.let { listOf(it) },
        )
    }

}