package br.com.voll.attribute.adapter.driven.infra;

import br.com.voll.attribute.adapter.driven.infra.model.ButtonModel;
import br.com.voll.attribute.core.domain.button.Platform;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JpaButtonRepository extends JpaRepository<ButtonModel, Long> {
    List<ButtonModel> findByPlatform(Platform platform);
}