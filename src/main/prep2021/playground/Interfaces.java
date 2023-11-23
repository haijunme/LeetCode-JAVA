package main.prep2021.playground;

public class Interfaces {
    private interface CompactCompatibleVehicle {

    }

    private interface RegularCompatibleVehicle {

    }

    private interface LargeCompatibleVehicle {

    }

    private static class Motorcycle implements CompactCompatibleVehicle {

    }

    private static class Car implements CompactCompatibleVehicle, RegularCompatibleVehicle {

    }

    private static class Van implements LargeCompatibleVehicle, RegularCompatibleVehicle {

    }

    public static void main(String[] args) {
        CompactCompatibleVehicle[] motorcycleSpots = new CompactCompatibleVehicle[10];
        RegularCompatibleVehicle[] carSpots = new RegularCompatibleVehicle[10];
        LargeCompatibleVehicle[] largeSpots = new LargeCompatibleVehicle[10];

        motorcycleSpots[2] = new Car();
        motorcycleSpots[1] = new Motorcycle();
    }
}
