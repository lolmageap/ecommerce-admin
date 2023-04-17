package hello.ecommerce.admin.web.controller

import hello.ecommerce.admin.domain.user.dto.AdminUserFormDto
import hello.ecommerce.admin.domain.user.entity.AdminUser
import hello.ecommerce.admin.domain.user.service.AdminUserDetailService
import mu.KotlinLogging
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam


@Controller
class AdminUserController(val adminUserDetailService: AdminUserDetailService, val passwordEncoder: PasswordEncoder) {

    private val log = KotlinLogging.logger {}

    @GetMapping
    fun index() : String = "/index"

    @GetMapping("/users/sign-up")
    fun adminUserForm(model: Model): String {
        log.info(">>> 회원 가입 폼")
        return "/users/sign-up"
    }

    @PostMapping("/users/register")
    fun create(adminUserFormDTO: AdminUserFormDto): String {
        log.info(">>> 회원 가입 진행, {}", adminUserFormDTO)
        val newAdminUser: AdminUser = AdminUser.createAdminUser(adminUserFormDTO, passwordEncoder)
        adminUserDetailService.save(newAdminUser)
        return "redirect:/"
    }

    @GetMapping("/users/login")
    fun loginForm(@RequestParam(value = "error", defaultValue = "false") error: Boolean, model: Model): String? {
        if (error) {
            model.addAttribute("loginFailure", true)
            model.addAttribute("loginFailureMessage", "아이디와 패스워드를 확인하시고 다시 로그인해주세요.")
        }
        return "/users/login"
    }

}