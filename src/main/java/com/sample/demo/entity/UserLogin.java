package com.sample.demo.entity;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class UserLogin {

    @Column
    @NotBlank(message = "Email is mandatory")
    @Pattern(regexp ="^.*(?=.{8,})(?=..*[0-9])(?=.*[a-z])(?=.*[@#$%^&+=]).*$")
    public String Email;
    @NotBlank(message = "Password is mandatory")
    @Pattern(regexp="^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{4,8}$")
    @Column
    public String password;

    public UserLogin() {

    }

    public String getEmail() {
        return Email;
    }



    public void setEmail(String email) {
        Email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserLogin(String email, String password) {
        Email = email;
        this.password = password;
    }


    @Override
    public String toString() {
        return "UserLogin{" +
                "Email='" + Email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
