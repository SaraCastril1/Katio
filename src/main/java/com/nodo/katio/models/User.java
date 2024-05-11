package com.nodo.katio.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private String lastname;
    private String email;
    private String phone;
    private String identification;
    private String passhash;

    public void stringValidator(String expression) {
        if (!expression.matches("[a-zA-ZÁÉÍÓÚáéíóúÜüÑñ ]+")) {
            throw new IllegalArgumentException("Expression must contain only alphabets and spaces");
        }
    }

    public void integerValidator(String expression) {
        if (!expression.matches("[0-9]+")) {
            throw new IllegalArgumentException("Expression must contain only numbers");
        }
    }

    public Integer getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.stringValidator(name);
        this.name = name;
    }

    public String getLastname() {
        return this.lastname;
    }

    public void setLastname(String lastname) {
        this.stringValidator(lastname);
        this.lastname = lastname;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);

        if (matcher.matches()) {
            this.email = email;
        } else {
            throw new IllegalArgumentException("Invalid email: " + email);
        }
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.integerValidator(phone);
        this.phone = phone;
    }

    public String getIdentification() {
        return this.identification;
    }

    public void setIdentification(String identification) {
        // integerValidator(identification);
        this.identification = identification;
    }

    public String getPasshash() {
        return this.passhash;
    }

    public void setPasshash(String passhash) {
        this.passhash = passhash;
    }

}
