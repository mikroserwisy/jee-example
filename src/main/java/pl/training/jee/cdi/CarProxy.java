package pl.training.jee.cdi;

import lombok.extern.java.Log;

@Log
public class CarProxy implements Vehicle {

    private final Vehicle vehicle;
    private final VehicleLogger vehicleLogger;

    public CarProxy(Vehicle vehicle, VehicleLogger vehicleLogger) {
        this.vehicle = vehicle;
        this.vehicleLogger = vehicleLogger;
    }

    @Override
    public void go() {
        vehicleLogger.logBeforeGo();
        vehicle.go();
        vehicleLogger.logAfterGo();
    }

}
