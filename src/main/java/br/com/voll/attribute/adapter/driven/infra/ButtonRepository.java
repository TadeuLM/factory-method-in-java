package br.com.voll.attribute.adapter.driven.infra;

import br.com.voll.attribute.core.applications.ports.IButtonRepository;
import br.com.voll.attribute.core.domain.button.Button;
import br.com.voll.attribute.core.domain.button.Platform;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ButtonRepository extends IButtonRepository, JpaRepository<Button, Long> {
    List<Button> findByPlatform(Platform platform);
}