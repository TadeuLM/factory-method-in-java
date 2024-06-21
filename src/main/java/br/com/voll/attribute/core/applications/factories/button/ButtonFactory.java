package br.com.voll.attribute.core.applications.factories.button;

import br.com.voll.attribute.core.applications.ports.IButtonRepository;
import br.com.voll.attribute.core.domain.button.Button;
import br.com.voll.attribute.core.domain.button.Platform;

import java.util.List;

public interface ButtonFactory {
    Button create(String label, Platform platform);
    List<Button> getByPlatform(Platform platform);
}