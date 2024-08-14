package br.com.voll.attribute.core.applications.ports;

import br.com.voll.attribute.core.domain.button.Button;
import br.com.voll.attribute.core.domain.button.Platform;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class IButtonRepositoryTest {

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

        assertEquals("Test Button", savedButton.getLabel());
        assertEquals(Platform.windows, savedButton.getPlatform());
    }

    @Test
    void testFindByPlatform() {
        Button button = new Button();
        button.setLabel("Button 1");
        button.setPlatform(Platform.windows);

        Button button2 = new Button();
        button2.setLabel("Button 2");
        button2.setPlatform(Platform.mac);

        when(buttonRepository.findByPlatform(Platform.windows)).thenReturn(List.of(button));
        when(buttonRepository.findByPlatform(Platform.mac)).thenReturn(List.of(button2));

        List<Button> windowsButtons = buttonRepository.findByPlatform(Platform.windows);
        assertEquals(1, windowsButtons.size());
        assertEquals("Button 1", windowsButtons.get(0).getLabel());

        List<Button> macButtons = buttonRepository.findByPlatform(Platform.mac);
        assertEquals(1, macButtons.size());
        assertEquals("Button 2", macButtons.get(0).getLabel());
    }

    @Test
    void testGetAll() {
        Button button = new Button();
        button.setLabel("Button 1");
        button.setPlatform(Platform.windows);

        Button button2 = new Button();
        button2.setLabel("Button 2");
        button2.setPlatform(Platform.mac);

        when(buttonRepository.findAll()).thenReturn(List.of(button, button2));

        List<Button> buttons = buttonRepository.findAll();
        assertEquals(2, buttons.size());
        assertEquals("Button 1", buttons.get(0).getLabel());
        assertEquals("Button 2", buttons.get(1).getLabel());
    }
}
