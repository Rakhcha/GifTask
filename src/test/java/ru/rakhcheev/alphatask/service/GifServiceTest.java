package ru.rakhcheev.alphatask.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.rakhcheev.alphatask.client.GifClient;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class GifServiceTest {

    @Mock
    private GifClient client;
    private GifService underTestGifService;

    @BeforeEach
    void setUp() {
        underTestGifService = new GifService(client);
    }

    @Test
    void getRandomGifById() {

        String rateCode = "rich";

        underTestGifService.getRandomGifByTag(rateCode);

        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
        verify(client).getRandomGifByTag(any(),captor.capture(),any());
        String captorCode = captor.getValue();
        assertThat(captorCode).isEqualTo(rateCode);

    }
}