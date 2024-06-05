package br.com.voll.attribute.adapter.driven.infra;

import br.com.voll.attribute.core.applications.ports.ButtonRepository;
import br.com.voll.attribute.core.domain.button.Button;
import br.com.voll.attribute.core.domain.button.Type;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MacButtonRepository implements ButtonRepository {

    private List<Button> buttons = new ArrayList<>();

    @Override
    public Button create(String label, Type type) {
        Button button = new Button(label, type);
        buttons.add(button);
        return button;
    }

    @Override
    public List<Button> getByType(Type type) {
        return buttons;
    }
}