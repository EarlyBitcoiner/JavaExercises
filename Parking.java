import java.util.ArrayList;

public class Parking {

    public static class Car {

        private final String manufacturer;
        private final String model;
        private final int year;

        Car(String m, String model_, int y) {
            manufacturer = m;
            model = model_;
            year = y;
        }

        public int getYear() {
            return year;
        }

        public String getModel() {
            return model;
        }

        public String getManufacturer() {
            return manufacturer;
        }

        @Override
        public String toString() {
            StringBuilder str = new StringBuilder();
            str.append(manufacturer);
            str.append(" ");
            str.append(model);
            str.append(" (");
            str.append(year);
            str.append(")");
            return str.toString();
        }
    }

    public static class parking {

        private final String type;
        private final int capacity;
        private int carsIn = 0;
        private ArrayList<Car> cars;

        parking(String type_, int capacity_) {
            type = type_;
            capacity = capacity_;
            cars = new ArrayList<>();
        }

        public void add(Car car) {
            if(carsIn!=capacity){
                cars.add(car);
                carsIn++;
            }
        }

        public boolean remove(String ma, String mo) {
            for (int i = 0; i < carsIn; i++) {
                if (cars.get(i).getManufacturer().equals(ma) && cars.get(i).getModel().equals(mo)) {
                    cars.remove(i);
                    carsIn--;
                    return true;
                }
            }
            return false;
        }

        public Car getLatestCar() {
            Car LatestCar = null;
            int LatestYear = 0;

            for (Car car : cars) {
                if (car.getYear() > LatestYear) {
                    LatestYear = car.getYear();
                    LatestCar = car;
                }
            }

            return LatestCar;
        }

        public Car getCar(String ma, String mo) {
            Car WantedCar;

            for (Car car : cars) {
                if (car.getManufacturer().equals(ma) && car.getModel().equals(mo)) {
                    WantedCar = car;
                    return WantedCar;
                }
            }
            return null;
        }

        public int getCount() {
            return carsIn;
        }

        public String getStatistics() {
            StringBuilder output = new StringBuilder();

            output.append("The cars are parked in ");
            output.append(type);
            for (int i = 0; i < carsIn; i++) {
                output.append("\n" + cars.get(i).toString());
            }
            return output.toString();
        }

    }

    public static void main(String[] args) {

// Initialize the repository
        parking parking = new parking("Underground parking garage", 5);

// Initialize entity
        Car volvo = new Car("Volvo", "XC70", 2010);

// Print Car
        System.out.println(volvo); // Volvo XC70 (2010)

// Add Car
        parking.add(volvo);

// Remove Car
        System.out.println(parking.remove("Volvo", "XC90")); // false
        System.out.println(parking.remove("Volvo", "XC70")); // true

        Car peugeot = new Car("Peugeot", "307", 2011);
        Car audi = new Car("Audi", "S4", 2005);

        parking.add(peugeot);
        parking.add(audi);

// Get Latest Car
        Car latestCar = parking.getLatestCar();
        System.out.println(latestCar); // Peugeot 307 (2011)

// Get Car
        Car audiS4 = parking.getCar("Audi", "S4");
        System.out.println(audiS4); // Audi S4 (2005)

// Count
        System.out.println(parking.getCount()); // 2

// Get Statistics
        System.out.println(parking.getStatistics());
// The cars are parked in Underground parking garage:
// Peugeot 307 (2011)
// Audi S4 (2005)

    }

}
