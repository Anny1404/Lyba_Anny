package com.telegramBot.telegramBot.Entity;
import javax.persistence.*;


@Entity
public class ClientOrder {
    @Id
    @GeneratedValue
    Long id;
    @ManyToOne
    Client client_id;
    @Column(nullable = false)
    Integer status;
    @Column(nullable = false, length = 15, precision = 2)
    Double total;


}
