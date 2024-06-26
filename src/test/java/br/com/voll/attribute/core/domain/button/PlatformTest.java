package br.com.voll.attribute.core.domain.button;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PlatformTest {

    @Test
    void testPlatformValues() {
        Platform[] platforms = Platform.values();
        assertEquals(2, platforms.length);
        assertTrue(contains(platforms, Platform.windows));
        assertTrue(contains(platforms, Platform.mac));
    }

    @Test
    void testPlatformValueOf() {
        assertEquals(Platform.windows, Platform.valueOf("windows"));
        assertEquals(Platform.mac, Platform.valueOf("mac"));
    }

    private boolean contains(Platform[] platforms, Platform platform) {
        for (Platform p : platforms) {
            if (p == platform) {
                return true;
            }
        }
        return false;
    }
}
