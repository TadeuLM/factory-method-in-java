package br.com.voll.attribute.adapter.driven.infra;

import br.com.voll.attribute.core.applications.ports.ButtonRepository;
import br.com.voll.attribute.core.domain.button.Button;
import br.com.voll.attribute.core.domain.button.Platform;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class ButtonRepositoryTest {

    @Mock
    private ButtonRepository buttonRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testSaveButton() {
        Button button = new Button();
        button.setLabel("Test Button");
        button.setPlatform(Platform.windows);

        when(buttonRepository.save(any(Button.class))).thenReturn(button);

        Button savedButton = buttonRepository.save(button);

        assertEquals(button.getLabel(), savedButton.getLabel());
        assertEquals(button.getPlatform(), savedButton.getPlatform());
    }

    @Test
    void testFindByPlatform() {
        Button button = new Button();
        button.setLabel("Button 1");
        button.setPlatform(Platform.windows);

        Button button2 = new Button();
        button2.setLabel("Button 2");
        button2.setPlatform(Platform.windows);

        List<Button> expectedButtons = Arrays.asList(button, button2);

        when(buttonRepository.findByPlatform(any(Platform.class))).thenReturn(expectedButtons);

        List<Button> buttons = buttonRepository.findByPlatform(Platform.windows);

        assertEquals(expectedButtons.size(), buttons.size());
        assertEquals(expectedButtons.get(0).getLabel(), buttons.get(0).getLabel());
        assertEquals(expectedButtons.get(1).getLabel(), buttons.get(1).getLabel());
    }

    @Test
    void testGetAll() {
        Button button = new Button();
        button.setLabel("Button 1");
        button.setPlatform(Platform.windows);

        Button button2 = new Button();
        button2.setLabel("Button 2");
        button2.setPlatform(Platform.windows);

        List<Button> expectedButtons = Arrays.asList(button, button2);

        when(buttonRepository.findAll()).thenReturn(expectedButtons);

        List<Button> buttons = buttonRepository.findAll();

        assertEquals(expectedButtons.size(), buttons.size());
        assertEquals(expectedButtons.get(0).getLabel(), buttons.get(0).getLabel());
        assertEquals(expectedButtons.get(1).getLabel(), buttons.get(1).getLabel());
    }
}
