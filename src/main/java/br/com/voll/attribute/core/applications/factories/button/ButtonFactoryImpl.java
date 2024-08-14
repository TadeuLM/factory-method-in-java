package br.com.voll.attribute.core.applications.factories.button;

import br.com.voll.attribute.adapter.driver.dto.ButtonDTO;
import br.com.voll.attribute.core.applications.ports.ButtonRepository;
import br.com.voll.attribute.core.domain.button.Button;
import br.com.voll.attribute.core.domain.button.Platform;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ButtonFactoryImpl implements ButtonFactory {

    private final ButtonRepository buttonRepository;

    @Autowired
    public ButtonFactoryImpl(ButtonRepository buttonRepository) {
        this.buttonRepository = buttonRepository;
    }

    @Override
    public Button create(ButtonDTO buttonDTO) {
        Button button = new Button();
        button.setLabel(buttonDTO.getLabel());
        button.setPlatform(buttonDTO.getPlatform());
        return buttonRepository.save(button);
    }

    @Override
    public List<Button> getByPlatform(Platform platform) {
        return buttonRepository.findByPlatform(platform);
    }

    @Override
    public List<Button> getAll() {
        return buttonRepository.findAll();
    }
}