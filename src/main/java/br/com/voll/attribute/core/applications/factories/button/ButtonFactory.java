package br.com.voll.attribute.core.applications.factories.button;

import br.com.voll.attribute.adapter.driver.dto.ButtonDTO;
import br.com.voll.attribute.core.domain.button.Button;
import br.com.voll.attribute.core.domain.button.Platform;

import java.util.List;

public interface ButtonFactory {
    Button create(ButtonDTO buttonDTO);
    List<Button> getByPlatform(Platform platform);
    List<Button> getAll();
}