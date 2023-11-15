package com.aop.demo.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "merchant")
@NoArgsConstructor
public class MerchantEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "merchant_id", nullable = false,unique = true)
    private String merchantId;
    @Column(name = "created_on", insertable = false)
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdOn;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_on")
    @UpdateTimestamp
    private Date updatedOn;

    /**
     *
     * @param name
     * @param merchantId
     */
    public MerchantEntity(final String name, final String merchantId) {
        this.name = name;
        this.merchantId = merchantId;
    }
}
