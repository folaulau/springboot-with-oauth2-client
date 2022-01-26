package com.lovemesomecoding.oauth2.user;

import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.ResultCheckStyle;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.Where;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(value = Include.NON_NULL)
@DynamicUpdate
@Entity
@SQLDelete(sql = "UPDATE user SET deleted = 'T' WHERE id = ?", check = ResultCheckStyle.NONE)
@Where(clause = "deleted = 'F'")
@Table(name = "user", indexes = {@Index(columnList = "email"), @Index(columnList = "deleted")})
public class User implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false, unique = true)
    private Long              id;

    /**
     * full name
     */
    @Column(name = "name")
    private String            name;

    @NotEmpty
    @Column(name = "email", unique = true)
    private String            email;

    /**
     * This is for 3rd party client in case they don't have email visible.
     */
    @Column(name = "username", nullable = true)
    private String            username;

    @Enumerated(EnumType.STRING)
    @Column(name = "client_type", nullable = false)
    private Oauth2ClientType  clientType;

    @Type(type = "true_false")
    @Column(name = "deleted", nullable = false)
    private boolean           deleted;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime     createdAt;

    @UpdateTimestamp
    @Column(name = "last_updated_at", nullable = false)
    private LocalDateTime     lastUpdatedAt;

}
