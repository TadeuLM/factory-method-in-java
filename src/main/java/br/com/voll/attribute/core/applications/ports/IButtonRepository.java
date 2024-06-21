package br.com.voll.attribute.core.applications.ports;

import br.com.voll.attribute.core.domain.button.Button;
import br.com.voll.attribute.core.domain.button.Platform;

import java.util.List;

public interface IButtonRepository {
    Button save(Button button);
    List<Button> findByPlatform(Platform platform);
}