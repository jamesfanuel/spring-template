package com.restful.entity;

import com.restful.model.RegisterUserRequest;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
//@SQLDelete(sql = "UPDATE x1_user SET deleted_at = CURRENT_TIMESTAMP WHERE id = ?")
//@Where(clause = "deleted_at IS NULL")
@Table(name = "x1_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Integer memberId;

    @Column(name = "member_username")
    private String memberUsername;

    @Column(name = "member_fullname")
    private String memberFullname;

    @Column(name = "member_level")
    private Integer memberLevel;

    @Column(name = "member_password")
    private String memberPassword;

    @Column(name = "member_active_status")
    private Integer memberActiveStatus;

    @Column(name = "member_email")
    private String memberEmail;

    @Column(name = "token")
    private String token;
}
