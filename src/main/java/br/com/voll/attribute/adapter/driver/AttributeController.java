package br.com.voll.attribute.adapter.driver;

import br.com.voll.attribute.core.applications.services.ButtonService;
import br.com.voll.attribute.core.domain.button.Button;
import br.com.voll.attribute.core.domain.button.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/button")
public class AttributeController {

    private final ButtonService buttonService;

    @Autowired
    public AttributeController(ButtonService buttonService)
    {
        this.buttonService = buttonService;
    }

    @PostMapping
    public ResponseEntity<Button> create(@RequestBody Button button) {
        try {
            Button novoButton = buttonService.initialize(button.label, button.type);
            return ResponseEntity.ok(novoButton);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/{type}")
    public ResponseEntity<List<Button>> index(@PathVariable Type type) {
        try {
            List<Button> button = buttonService.getByType(type);
            return ResponseEntity.ok(button);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
