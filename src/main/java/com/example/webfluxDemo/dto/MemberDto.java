package com.example.webfluxDemo.dto;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.PositiveOrZero;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
//@Builder
public class MemberDto {

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
