package hello.ecommerce.admin.util

import org.springframework.data.annotation.CreatedBy
import org.springframework.data.annotation.LastModifiedBy
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import javax.persistence.Column
import javax.persistence.EntityListeners
import javax.persistence.MappedSuperclass

@MappedSuperclass
@EntityListeners(AuditingEntityListener::class)
open class BaseEntity(
        @CreatedBy @Column(updatable = false)
        private var createdBy: String? = null,

        @LastModifiedBy
        @Column(updatable = false)
        private var lastModifiedBy: String? = null,

)