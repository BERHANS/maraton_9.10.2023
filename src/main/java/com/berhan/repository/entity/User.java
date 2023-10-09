package com.berhan.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "tbl_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    private String name_surname;
    @Column(unique = true,updatable = true)
    private String email;
    @Column(unique = true,updatable = true)
    private String phoneNumber;
    @Column(unique = true,updatable = true)
    private String nickName;
    @Embedded
    BaseEntity baseEntity;
}
