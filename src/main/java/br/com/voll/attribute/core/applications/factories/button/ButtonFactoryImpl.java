package br.com.voll.attribute.core.applications.factories.button;

import br.com.voll.attribute.core.applications.ports.IButtonRepository;
import br.com.voll.attribute.core.domain.button.Button;
import br.com.voll.attribute.core.domain.button.Platform;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ButtonFactoryImpl implements ButtonFactory {

    private final IButtonRepository buttonRepository;

    @Autowired
    public ButtonFactoryImpl(IButtonRepository buttonRepository) {
        this.buttonRepository = buttonRepository;
    }

    @Override
    public Button create(String label, Platform platform) {
        Button button = new Button();
        button.setLabel(label);
        button.setPlatform(platform);
        return buttonRepository.save(button);
    }

    @Override
    public List<Button> getByPlatform(Platform platform) {
        return buttonRepository.findByPlatform(platform);
    }
}