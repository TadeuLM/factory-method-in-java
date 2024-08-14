package br.com.voll.attribute.adapter.driven.infra;

import br.com.voll.attribute.adapter.driven.infra.model.ButtonModel;
import br.com.voll.attribute.core.applications.ports.ButtonRepository;
import br.com.voll.attribute.core.domain.button.Button;
import br.com.voll.attribute.core.domain.button.Platform;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ButtonRepositoryImp implements ButtonRepository {

    private final JpaButtonRepository jpaButtonRepository;

    @Autowired
    public ButtonRepositoryImp(JpaButtonRepository jpaButtonRepository) {
        this.jpaButtonRepository = jpaButtonRepository;
    }

    @Override
    public Button save(Button button) {
        ButtonModel buttonEntity = new ButtonModel();
        buttonEntity.setLabel(button.getLabel());
        buttonEntity.setPlatform(button.getPlatform());
        ButtonModel savedEntity = jpaButtonRepository.save(buttonEntity);
        button.setId(savedEntity.getId());
        return button;
    }

    @Override
    public List<Button> findByPlatform(Platform platform) {
        return jpaButtonRepository.findByPlatform(platform).stream()
                .map(entity -> new Button(entity.getId(), entity.getLabel(), entity.getPlatform()))
                .collect(Collectors.toList());
    }

    @Override
    public List<Button> findAll() {
        return jpaButtonRepository.findAll().stream()
                .map(entity -> new Button(entity.getId(), entity.getLabel(), entity.getPlatform()))
                .collect(Collectors.toList());
    }
}