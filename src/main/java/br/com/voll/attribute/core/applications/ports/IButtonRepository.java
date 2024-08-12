package br.com.voll.attribute.core.applications.ports;

import br.com.voll.attribute.core.domain.button.Button;
import br.com.voll.attribute.core.domain.button.Platform;

import java.util.List;

public interface IButtonRepository {//FIXME - Não prefixar as interfaces com "I" (Livro Clean Code - Robert C. Martin - pagina 24)
    Button save(Button button);
    List<Button> findByPlatform(Platform platform);
    List<Button> findAll();
}