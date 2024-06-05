package br.com.voll.attribute.core.applications.ports;

import br.com.voll.attribute.core.domain.button.Button;
import br.com.voll.attribute.core.domain.button.Type;

import java.util.List;

public interface ButtonRepository {
    public Button create(String label, Type type);
    public List<Button> getByType(Type type);
}