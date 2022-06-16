package com.sample.demo.entity;

import org.springframework.validation.annotation.Validated;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Validated
public class UserEntity {
    @Id
    @Column
    @Size(min=2,max=4)
    public String userId;
    @Column
    @Size(min=2, max=24)
    public String userName;

    @Column
    @NotBlank(message = "Email is mandatory")
    @Pattern(regexp ="^.*(?=.{8,})(?=..*[0-9])(?=.*[a-z])(?=.*[@#$%^&+=]).*$")
    public String userEmail;
    @NotBlank(message = "Password is mandatory")
    @Pattern(regexp="^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{4,8}$")
    @Column
    public String password;

    public UserEntity() {
        this.userId = userId;
        this.userName = userName;
        this.userEmail = userEmail;
        this.password = password;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
