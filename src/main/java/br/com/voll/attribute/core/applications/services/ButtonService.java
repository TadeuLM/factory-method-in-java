package br.com.voll.attribute.core.applications.services;

import br.com.voll.attribute.core.applications.factories.button.ButtonFactory;
import br.com.voll.attribute.core.domain.button.Button;
import br.com.voll.attribute.core.domain.button.Platform;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ButtonService {
    private final ButtonFactory buttonFactory;

    public ButtonService(ButtonFactory buttonFactory) {
        this.buttonFactory = buttonFactory;
    }

    public Button create(String label, Platform platform) {
        return this.buttonFactory.create(label, platform);
    }

    public List<Button> getPlatform(Platform platform) {
        return this.buttonFactory.getByPlatform(platform);
    }
}