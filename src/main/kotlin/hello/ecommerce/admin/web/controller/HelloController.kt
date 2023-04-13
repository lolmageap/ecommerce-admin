package hello.ecommerce.admin.web.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable


@Controller
class HelloController {

    @GetMapping
    fun index() : String = "/index"

    @GetMapping("/delivery")
    fun delivery() : String = "/products/products"

    @GetMapping("/products/product-detail/{id}")
    fun productDetail(@PathVariable id : Long) : String = "/products/product-detail"

}