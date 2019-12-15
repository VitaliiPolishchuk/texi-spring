package the.best.service;

import the.best.web.data.Location;

public interface TimeCalculationService {
    long calculateTime(Location origin, Location destination);
}
