package the.best.pattern;

import org.springframework.stereotype.Service;

import the.best.pattern.PriceCalculationService;

@Service
public class PriceCalculationChainBuilderImpl implements PriceCalculationChainBuilder {
    @Override
    public PriceCalculationService buildStandart() {
        BookingPriceCalculationService bookingPriceCalculationService = new BookingPriceCalculationService();
        KmPriceCalculationService kmPriceCalculationService = new KmPriceCalculationService();
        DiscountPriceCalculationService discountPriceCalculationService = new DiscountPriceCalculationService();
        UserPointsPriceCalculationService userPointsPriceCalculationService = new UserPointsPriceCalculationService();

        bookingPriceCalculationService.setNext(kmPriceCalculationService);
        kmPriceCalculationService.setNext(discountPriceCalculationService);
        discountPriceCalculationService.setNext(userPointsPriceCalculationService);

        return bookingPriceCalculationService;
    }
}
