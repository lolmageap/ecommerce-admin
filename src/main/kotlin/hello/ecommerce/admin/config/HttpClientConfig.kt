package hello.ecommerce.admin.config

import org.springframework.boot.web.client.RestTemplateBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.client.RestTemplate
import java.time.Duration

@Configuration
class HttpClientConfig {

    val LIMIT_SECONDS = 3

    @Bean
    fun restTemplate(builder: RestTemplateBuilder): RestTemplate? {
        return builder
                .setConnectTimeout(Duration.ofSeconds(LIMIT_SECONDS.toLong()))
                .setReadTimeout(Duration.ofSeconds(LIMIT_SECONDS.toLong()))
                .build()
    }

}