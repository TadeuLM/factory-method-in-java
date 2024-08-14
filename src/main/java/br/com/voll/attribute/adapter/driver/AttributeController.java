package br.com.voll.attribute.adapter.driver;

import br.com.voll.attribute.adapter.driver.dto.ButtonDTO;
import br.com.voll.attribute.core.applications.services.ButtonService;
import br.com.voll.attribute.core.domain.button.Button;
import br.com.voll.attribute.core.domain.button.Platform;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/button")
public class AttributeController {

    private final ButtonService buttonService;

    public AttributeController(ButtonService buttonService) {
        this.buttonService = buttonService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Button create(@Valid @RequestBody ButtonDTO buttonDTO) {
        return buttonService.create(buttonDTO);
    }

    @GetMapping("/{platform}")
    @ResponseStatus(HttpStatus.OK)
    public List<Button> index(@PathVariable Platform platform) {
        return buttonService.getPlatform(platform);
    }

    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public List<Button> findAll() {
        return buttonService.findAll();
    }
}