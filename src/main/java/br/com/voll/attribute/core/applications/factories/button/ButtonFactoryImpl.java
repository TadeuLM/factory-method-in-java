package br.com.voll.attribute.core.applications.factories.button;

import br.com.voll.attribute.core.applications.ports.ButtonRepository;
import br.com.voll.attribute.core.domain.button.Button;
import br.com.voll.attribute.core.domain.button.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ButtonFactoryImpl implements ButtonFactory {

    @Autowired
    @Qualifier("windowsButtonRepository")
    private ButtonRepository buttonWindowsRepository;

    @Autowired
    @Qualifier("macButtonRepository")
    private ButtonRepository buttonMacRepository;

    @Override
    public Button createButton(String label, Type type) {
        switch (type) {
            case windows:
                return buttonWindowsRepository.create(label, type);
            case mac:
                return buttonMacRepository.create(label, type);
            default:
                throw new IllegalArgumentException("Invalid button type: " + type);
        }
    }

    @Override
    public List<Button> getByType(Type type) {
        switch (type) {
            case windows:
                return buttonWindowsRepository.getByType(Type.windows);
            case mac:
                return buttonMacRepository.getByType(Type.mac);
            default:
                throw new IllegalArgumentException("Invalid button type: " + type);
        }
    }
}