package com.telegramBot.telegramBot.Repository;
import com.telegramBot.telegramBot.Entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "orders", path = "orders")
public interface ClientRepository extends JpaRepository<Client, Long> {

}
