package br.com.voll.attribute.core.applications.factories;

import br.com.voll.attribute.adapter.driver.dto.ButtonDTO;
import br.com.voll.attribute.core.applications.factories.button.ButtonFactory;
import br.com.voll.attribute.core.domain.button.Button;
import br.com.voll.attribute.core.domain.button.Platform;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class ButtonFactoryTest {

    @Mock
    private ButtonFactory buttonFactory;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreateButton() {
        Button expectedButton = new Button();
        expectedButton.setLabel("Test Button");
        expectedButton.setPlatform(Platform.windows);
        when(buttonFactory.create(any(ButtonDTO.class))).thenReturn(expectedButton);

        ButtonDTO buttonDTO = new ButtonDTO();
        buttonDTO.setLabel("Test Button");
        buttonDTO.setPlatform(Platform.windows);

        Button createdButton = buttonFactory.create(buttonDTO);

        assertEquals("Test Button", createdButton.getLabel());
        assertEquals(Platform.windows, createdButton.getPlatform());

        verify(buttonFactory, times(1)).create(buttonDTO);
    }

    @Test
    void testGetButtonsByPlatform() {
        List<Button> expectedButtons = Collections.singletonList(new Button());
        when(buttonFactory.getByPlatform(any(Platform.class))).thenReturn(expectedButtons);

        List<Button> buttons = buttonFactory.getByPlatform(Platform.windows);

        assertEquals(1, buttons.size());

        verify(buttonFactory, times(1)).getByPlatform(Platform.windows);
    }

    @Test
    void testGetAllButtons() {
        List<Button> expectedButtons = Collections.singletonList(new Button());
        when(buttonFactory.getAll()).thenReturn(expectedButtons);

        List<Button> buttons = buttonFactory.getAll();

        assertEquals(1, buttons.size());

        verify(buttonFactory, times(1)).getAll();
    }
}
