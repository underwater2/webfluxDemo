package com.example.webfluxDemo.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.PositiveOrZero;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(value = "member")
public class Member {

    @Id
    private String id;

    @NotBlank
    private String LoginId;

    @NotBlank
    private String password;

    @PositiveOrZero
    private int age;

    @PastOrPresent
    @CreatedDate
    private Date createdAt;

    @PastOrPresent
    @LastModifiedDate
    private Date updatedAt;
}
