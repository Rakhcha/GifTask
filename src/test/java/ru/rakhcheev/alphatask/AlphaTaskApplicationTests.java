package ru.rakhcheev.alphatask;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class AlphaTaskApplicationTests {

    @Test
    void contextLoads() {
        assertEquals(2, 1+1);
    }

}
