package com.sample.demo.entity;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class getUserDetails {

    @NotBlank(message = "Email is mandatory")
    @Pattern(regexp ="^.*(?=.{8,})(?=..*[0-9])(?=.*[a-z])(?=.*[@#$%^&+=]).*$")
    public String userEmail;

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }
}
