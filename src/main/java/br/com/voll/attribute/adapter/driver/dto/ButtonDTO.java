package br.com.voll.attribute.adapter.driver.dto;

import br.com.voll.attribute.core.domain.button.Platform;
import lombok.Data;

@Data
public class ButtonDTO {
    private String label;
    private Platform platform;
}