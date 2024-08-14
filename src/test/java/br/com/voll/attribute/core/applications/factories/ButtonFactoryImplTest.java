package br.com.voll.attribute.core.applications.factories;

import br.com.voll.attribute.adapter.driver.dto.ButtonDTO;
import br.com.voll.attribute.core.applications.factories.button.ButtonFactoryImpl;
import br.com.voll.attribute.core.applications.ports.ButtonRepository;
import br.com.voll.attribute.core.domain.button.Button;
import br.com.voll.attribute.core.domain.button.Platform;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import java.util.Collections;
import java.util.List;

public class ButtonFactoryImplTest {

    @Mock
    private ButtonRepository buttonRepository;

    private ButtonFactoryImpl buttonFactory;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        buttonFactory = new ButtonFactoryImpl(buttonRepository);
    }

    @Test
    public void testCreateButton() {
        Button mockButton = new Button();
        mockButton.setId(1L);
        mockButton.setLabel("Test Button");
        mockButton.setPlatform(Platform.windows);

        when(buttonRepository.save(any(Button.class))).thenReturn(mockButton);

        ButtonDTO buttonDTO = new ButtonDTO();
        buttonDTO.setLabel("Test Button");
        buttonDTO.setPlatform(Platform.windows);

        Button createdButton = buttonFactory.create(buttonDTO);

        verify(buttonRepository, times(1)).save(any(Button.class));

        assertEquals(1L, createdButton.getId());
        assertEquals("Test Button", createdButton.getLabel());
        assertEquals(Platform.windows, createdButton.getPlatform());
    }

    @Test
    public void testGetButtonsByPlatform() {
        Button mockButton = new Button();
        mockButton.setId(1L);
        mockButton.setLabel("Test Button");
        mockButton.setPlatform(Platform.windows);

        List<Button> expectedButtons = Collections.singletonList(mockButton);

        when(buttonRepository.findByPlatform(any(Platform.class))).thenReturn(expectedButtons);

        List<Button> buttons = buttonFactory.getByPlatform(Platform.windows);

        verify(buttonRepository, times(1)).findByPlatform(any(Platform.class));

        assertEquals(1, buttons.size());
        assertEquals(mockButton, buttons.get(0));
    }

    @Test
    public void testGetAllButtons() {
        Button mockButton = new Button();
        mockButton.setId(1L);
        mockButton.setLabel("Test Button");
        mockButton.setPlatform(Platform.windows);

        List<Button> expectedButtons = Collections.singletonList(mockButton);

        when(buttonRepository.findAll()).thenReturn(expectedButtons);

        List<Button> buttons = buttonFactory.getAll();

        verify(buttonRepository, times(1)).findAll();

        assertEquals(1, buttons.size());
        assertEquals(mockButton, buttons.get(0));
    }

    @Test
    public void testCreateButton_ExceptionHandling() {
        when(buttonRepository.save(any(Button.class))).thenThrow(RuntimeException.class);

        ButtonDTO buttonDTO = new ButtonDTO();
        buttonDTO.setLabel("Test Button");
        buttonDTO.setPlatform(Platform.windows);

        assertThrows(RuntimeException.class, () -> buttonFactory.create(buttonDTO));

        verify(buttonRepository, times(1)).save(any(Button.class));
    }

    @Test
    public void testGetButtonsByPlatform_EmptyList() {
        when(buttonRepository.findByPlatform(any(Platform.class))).thenReturn(Collections.emptyList());

        List<Button> buttons = buttonFactory.getByPlatform(Platform.mac);

        verify(buttonRepository, times(1)).findByPlatform(any(Platform.class));

        assertTrue(buttons.isEmpty());
    }
}
