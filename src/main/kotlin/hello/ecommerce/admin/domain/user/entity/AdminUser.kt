package hello.ecommerce.admin.domain.user.entity

import hello.ecommerce.admin.domain.user.dto.AdminUserFormDto
import hello.ecommerce.admin.domain.user.enums.AdminUserPermission
import hello.ecommerce.admin.domain.user.enums.AdminUserRole
import hello.ecommerce.admin.util.BaseTimeEntity
import org.springframework.security.crypto.password.PasswordEncoder
import javax.persistence.*

@Entity
@Table(name = "users", schema = "ecommerce")
class AdminUser (

    @Column(name = "username")
    val username: String,

    @Column(name = "email")
    val email: String,

    @Column(name = "password")
    val password: String,

//    @Column(name = "phone")
//    val phone: String,

    @Column(name = "role")
    @Enumerated(value = EnumType.STRING)
    val role: AdminUserRole,

    @Column(name = "permission")
    @Enumerated(value = EnumType.STRING)
    val permission: AdminUserPermission,

) : BaseTimeEntity() {

    companion object{
        fun createAdminUser(adminUserDTO: AdminUserFormDto, passwordEncoder: PasswordEncoder): AdminUser {
            return AdminUser(
                    username = adminUserDTO.username,
                    password = passwordEncoder.encode(adminUserDTO.password1),
                    email = adminUserDTO.email,
                    role = AdminUserRole.USER,
                    permission = AdminUserPermission.ALL,
//                    phone = adminUserDTO.phone,
            )
        }
    }

}