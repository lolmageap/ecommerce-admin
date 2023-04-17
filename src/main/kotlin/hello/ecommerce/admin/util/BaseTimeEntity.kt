package hello.ecommerce.admin.util

import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.time.LocalDateTime
import javax.persistence.*

@MappedSuperclass
@EntityListeners(AuditingEntityListener::class)
open class BaseTimeEntity(

        @Id @Column(name = "id") @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long? = null,

        @CreatedDate @Column(updatable = false)
        var createdAt: LocalDateTime? = null,

        @LastModifiedDate
        val updatedAt: LocalDateTime? = null,

        @Column(name = "is_deleted")
        val isDeleted: Boolean = false,

        @Column(name = "is_activated")
        val isActivated: Boolean = true,

        )