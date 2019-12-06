package the.best.algorithms;

import the.best.web.data.Location;

public interface TimeCalculationService {
    long calculateTime(Location origin, Location destination);
}
