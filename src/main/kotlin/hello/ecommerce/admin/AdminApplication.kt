package hello.ecommerce.admin

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaAuditing

@EnableJpaAuditing
@SpringBootApplication
class AdminApplication

fun main(args: Array<String>) {
	runApplication<AdminApplication>(*args)
}
