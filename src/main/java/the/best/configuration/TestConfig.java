package the.best.configuration;

import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import the.best.service.TimeCalculationService;
import the.best.service.TimeCalculationServiceImpl;

@Profile("test")
@Configuration
public class TestConfig {
    @Bean
    @Primary
    public TimeCalculationService nameService() {
        return Mockito.mock(TimeCalculationServiceImpl.class);
    }
}
