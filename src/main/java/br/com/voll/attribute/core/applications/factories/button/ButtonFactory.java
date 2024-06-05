package br.com.voll.attribute.core.applications.factories.button;

import br.com.voll.attribute.core.domain.button.Button;
import br.com.voll.attribute.core.domain.button.Type;

import java.util.List;

public interface ButtonFactory {
    Button createButton(String label, Type type);
    List<Button> getByType(Type type);
}