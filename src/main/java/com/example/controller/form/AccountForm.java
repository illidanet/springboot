package com.example.controller.form;

import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * Created by illidanet on 2/20/17.
 */
public class AccountForm {
    private long id;

    @NotNull
    @NotBlank
    @Pattern(regexp = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$",message = "invalid email address")
    private String email;

    @NotNull
    @NotBlank
    @Size(min = 6,max = 30,message = "not strong enough")
    private String password;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString(){
        return id+" "+email+" "+password;
    }
}
