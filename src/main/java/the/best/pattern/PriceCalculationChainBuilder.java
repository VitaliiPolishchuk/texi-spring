package the.best.pattern;

import org.springframework.stereotype.Service;

@Service
public interface PriceCalculationChainBuilder {
    PriceCalculationService buildStandart();
}
