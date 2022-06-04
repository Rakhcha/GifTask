package ru.rakhcheev.alphatask.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.rakhcheev.alphatask.client.RateClient;

import java.time.LocalDate;
import java.time.format.DateTimeFormatterBuilder;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class RateServiceTest {

    @Mock
    private RateClient rateClient;
    private RateService underTestRateService;

    @BeforeEach
    void setUp() {
        underTestRateService = new RateService(rateClient);
    }

    @Test
    void canGetLatestRate() {

        String rateCode = "RUB";

        underTestRateService.getLatestRate(rateCode);

        ArgumentCaptor<String> argumentCaptor = ArgumentCaptor.forClass(String.class);
        verify(rateClient).getLatestRate(any(), any(), argumentCaptor.capture());
        String capture = argumentCaptor.getValue();
        assertThat(capture).isEqualTo(rateCode);
    }

    @Test
    void getPreviousRate() {

        String rateCode = "RUB";
        String previousDate = LocalDate.now().minusDays(1)
                .format(new DateTimeFormatterBuilder().appendPattern("yyyy-MM-dd").toFormatter());

        underTestRateService.getPreviousRate(rateCode);

        ArgumentCaptor<String> argumentCaptor = ArgumentCaptor.forClass(String.class);
        verify(rateClient).getPreviousRate(argumentCaptor.capture(),any(),any(),argumentCaptor.capture());
        List<String> argumentList = argumentCaptor.getAllValues();
        assertThat(argumentList.get(0)).isEqualTo(previousDate);
        assertThat(argumentList.get(1)).isEqualTo(rateCode);

    }
}