package br.com.voll.attribute.core.domain.button;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class ButtonTest {

    private Validator validator;

    @BeforeEach
    void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    void testGettersAndSetters() {
        Button button = new Button();

        button.setId(1L);
        button.setLabel("Test Label");
        button.setPlatform(Platform.windows);

        assertEquals(1L, button.getId());
        assertEquals("Test Label", button.getLabel());
        assertEquals(Platform.windows, button.getPlatform());
    }

    @Test
    void testNotNullFields() {
        Button button = new Button(1L, "Test Button", Platform.windows);
        assertNotNull(button.getId());
        assertNotNull(button.getLabel());
        assertNotNull(button.getPlatform());
    }

    @Test
    void testDefaultConstructor() {
        Button button = new Button();

        assertNotNull(button);
    }
}
