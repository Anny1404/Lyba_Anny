package com.telegramBot.telegramBot.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class Client {
    @Id
    @GeneratedValue
    Long id;
    @Column(nullable = false)
    Long external_id;
    @Column(nullable = false)
    String full_name;
    @Column(nullable = false, length = 15)
    String phone_number;
    @Column(nullable = false, length = 400)
    String address;

    public Long getExternal_id() {
        return external_id;
    }

    public void setExternal_id(Long external_id) {
        this.external_id = external_id;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
