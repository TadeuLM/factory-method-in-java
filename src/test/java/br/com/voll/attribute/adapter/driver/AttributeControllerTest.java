package br.com.voll.attribute.adapter.driver;

import br.com.voll.attribute.adapter.driver.dto.ButtonDTO;
import br.com.voll.attribute.core.applications.services.ButtonService;
import br.com.voll.attribute.core.domain.button.Button;
import br.com.voll.attribute.core.domain.button.Platform;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ActiveProfiles("test")
@SpringBootTest
@AutoConfigureMockMvc
class AttributeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ButtonService buttonService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(new AttributeController(buttonService)).build();
    }

    @Test
    void testCreateButton() throws Exception {
        ButtonDTO buttonDTO = new ButtonDTO();
        buttonDTO.setLabel("Test Button");
        buttonDTO.setPlatform(Platform.windows);

        Button button = new Button();
        button.setLabel("Test Button");
        button.setPlatform(Platform.windows);

        when(buttonService.create(any(ButtonDTO.class))).thenReturn(button);

        mockMvc.perform(post("/button")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"label\": \"Test Button\", \"platform\": \"windows\"}"))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.label").value("Test Button"))
                .andExpect(jsonPath("$.platform").value("windows"));

        verify(buttonService, times(1)).create(any(ButtonDTO.class));
    }

    @Test
    void testGetButtonsByPlatform() throws Exception {
        Button button1 = new Button();
        button1.setLabel("Button 1");
        button1.setPlatform(Platform.mac);

        Button button2 = new Button();
        button2.setLabel("Button 2");
        button2.setPlatform(Platform.mac);

        when(buttonService.getPlatform(Platform.mac)).thenReturn(Arrays.asList(button1, button2));

        mockMvc.perform(get("/button/mac")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].label").value("Button 1"))
                .andExpect(jsonPath("$[0].platform").value("mac"))
                .andExpect(jsonPath("$[1].label").value("Button 2"))
                .andExpect(jsonPath("$[1].platform").value("mac"));

        verify(buttonService, times(1)).getPlatform(Platform.mac);
    }

    @Test
    void testGetAllButtons() throws Exception {
        Button button1 = new Button();
        button1.setLabel("Button 1");
        button1.setPlatform(Platform.windows);

        Button button2 = new Button();
        button2.setLabel("Button 2");
        button2.setPlatform(Platform.mac);

        when(buttonService.findAll()).thenReturn(Arrays.asList(button1, button2));

        mockMvc.perform(get("/button/")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].label").value("Button 1"))
                .andExpect(jsonPath("$[0].platform").value("windows"))
                .andExpect(jsonPath("$[1].label").value("Button 2"))
                .andExpect(jsonPath("$[1].platform").value("mac"));

        verify(buttonService, times(1)).findAll();
    }


    @Test
    void testCreateButtonValidationError() throws Exception {
        mockMvc.perform(post("/button")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"label\": \"\", \"platform\": \"\"}"))
                .andExpect(status().isBadRequest());
    }

    @Test
    void testGetButtonsByNonExistentPlatform() throws Exception {
        when(buttonService.getPlatform(any(Platform.class))).thenReturn(List.of());

        mockMvc.perform(get("/button/NON_EXISTENT_PLATFORM")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }
}
