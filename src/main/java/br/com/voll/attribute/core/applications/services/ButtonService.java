package br.com.voll.attribute.core.applications.services;

import br.com.voll.attribute.core.applications.factories.button.ButtonFactory;
import br.com.voll.attribute.core.domain.button.Button;
import br.com.voll.attribute.core.domain.button.Type;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ButtonService {
    private final ButtonFactory buttonFactory;

    public ButtonService(ButtonFactory buttonFactory) {
        this.buttonFactory = buttonFactory;
    }

    public Button initialize(String label, Type type) {
        return this.buttonFactory.createButton(label, type);
    }

    public List<Button> getByType(Type type) {
        return this.buttonFactory.getByType(type);
    }
}
