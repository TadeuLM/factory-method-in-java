package br.com.voll.attribute.core.applications.services;

import br.com.voll.attribute.adapter.driver.dto.ButtonDTO;
import br.com.voll.attribute.core.applications.factories.button.ButtonFactory;
import br.com.voll.attribute.core.domain.button.Button;
import br.com.voll.attribute.core.domain.button.Platform;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class ButtonServiceTest {

    @Mock
    private ButtonFactory buttonFactory;

    @InjectMocks
    private ButtonService buttonService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreateButton() {
        Button button = new Button();
        button.setLabel("Test Button");
        button.setPlatform(Platform.mac);

        ButtonDTO buttonDTO = new ButtonDTO();
        buttonDTO.setLabel("Test Button");
        buttonDTO.setPlatform(Platform.mac);

        when(buttonFactory.create(buttonDTO)).thenReturn(button);

        Button createdButton = buttonService.create(buttonDTO);

        assertEquals(button, createdButton);
        verify(buttonFactory, times(1)).create(buttonDTO);
    }

    @Test
    void testGetButtonsByPlatform() {
        Button button = new Button();
        button.setLabel("label1");
        button.setPlatform(Platform.mac);

        Button button2 = new Button();
        button2.setLabel("label2");
        button2.setPlatform(Platform.mac);

        List<Button> buttons = Arrays.asList(button, button2);
        when(buttonFactory.getByPlatform(Platform.mac)).thenReturn(buttons);

        List<Button> retrievedButtons = buttonService.getPlatform(Platform.mac);

        assertEquals(buttons, retrievedButtons);
        verify(buttonFactory, times(1)).getByPlatform(Platform.mac);
    }

    @Test
    void testGetAllButtons() {
        Button button = new Button();
        button.setLabel("label1");
        button.setPlatform(Platform.mac);

        Button button2 = new Button();
        button2.setLabel("label2");
        button2.setPlatform(Platform.windows);

        List<Button> buttons = Arrays.asList(button, button2);
        when(buttonFactory.getAll()).thenReturn(buttons);

        List<Button> retrievedButtons = buttonService.findAll();

        assertEquals(buttons, retrievedButtons);
        verify(buttonFactory, times(1)).getAll();
    }
}
