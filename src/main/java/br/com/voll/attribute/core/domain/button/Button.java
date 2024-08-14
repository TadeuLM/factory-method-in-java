package br.com.voll.attribute.core.domain.button;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Button {

    private Long id;
    private String label;
    private Platform platform;
}
