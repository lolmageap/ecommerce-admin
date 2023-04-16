package hello.ecommerce.admin.domain.user.dto

import hello.ecommerce.admin.domain.user.entity.AdminUser
import hello.ecommerce.admin.domain.user.enums.AdminUserPermission
import hello.ecommerce.admin.domain.user.enums.AdminUserRole
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import java.util.stream.Collectors

data class AdminUserDetail(
        val adminUser: AdminUser,
        val roles: List<AdminUserRole>,
        val permissions: List<AdminUserPermission>) : UserDetails {
    override fun getAuthorities(): Collection<GrantedAuthority>? {
        val authorities: MutableList<GrantedAuthority> = ArrayList()

        // 권한 목록 - 실습용 권한은 1개
        val permissionAuthority: GrantedAuthority = SimpleGrantedAuthority(adminUser.permission.name)
        authorities.add(permissionAuthority)

        // 역할 목록 - 실습용 역할은 1개
        val roleAuthority: GrantedAuthority = SimpleGrantedAuthority("ROLE_" + adminUser.role.name)
        authorities.add(roleAuthority)
        return authorities
    }

    override fun getPassword(): String? {
        return adminUser.password
    }

    override fun getUsername(): String? {
        return adminUser.username
    }

    override fun isAccountNonExpired(): Boolean {
        return adminUser.isActivated
    }

    override fun isAccountNonLocked(): Boolean {
        return adminUser.isActivated
    }

    override fun isCredentialsNonExpired(): Boolean {
        return adminUser.isActivated
    }

    override fun isEnabled(): Boolean {
        return adminUser.isActivated
    }

    fun getPermissionList(): MutableList<Any>? {
        return roles.stream().map<Any> { r: AdminUserRole -> r.name }.collect(Collectors.toList())
    }

    fun getRoleList(): MutableList<Any>? {
        return permissions.stream().map<Any> { p: AdminUserPermission -> p.name }.collect(Collectors.toList())
    }

}