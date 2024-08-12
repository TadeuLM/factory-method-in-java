package br.com.voll.attribute.adapter.driven.infra;

import br.com.voll.attribute.core.applications.ports.IButtonRepository;
import br.com.voll.attribute.core.domain.button.Button;
import br.com.voll.attribute.core.domain.button.Platform;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
//FIXME: [clean arch] - aqui eu criaria uma classe concreta que implementasse "IButtonRepository" e 
//essa classe faria o uso de uma interface extendendo de "JpaRepository". 
//O motivo principal é a separação da classes representativas de database (@Entity) das de dominio
//Assim a classe "Button" não estaria com anotações do JPA 
public interface ButtonRepository extends IButtonRepository, JpaRepository<Button, Long> { 
    List<Button> findByPlatform(Platform platform);
}