import java.time.Year;

public class CarDemo {
    public static void main(String[] args) {
        Car[] cars = {
                new Car(1, "Toyota", "Camry", 2018, "Черный", 22000, "AB1234"),
                new Car(2, "BMW", "M5", 2018, "Белый", 55000, "BC5678"),
                new Car(3, "Toyota", "Corolla", 2015, "Серый", 15000, "CD9012"),
                new Car(4, "Audi", "A4", 2018, "Синий", 30000, "DE3456"),
                new Car(5, "Toyota", "Camry", 2012, "Красный", 12000, "EF7890")
        };

        String brandToFind = "Toyota";
        String modelToFind = "Camry";
        int nYears = 5;
        int yearToFind = 2018;
        double minPrice = 20000;

        System.out.println("a) Автомобили марки " + brandToFind + ":");
        printCarsHeader();
        for (Car car : cars) {
            if (car.getBrand().equalsIgnoreCase(brandToFind)) {
                System.out.println(car);
            }
        }

        System.out.println("\n---------------------------------------------\n");

        System.out.println("b) Автомобили модели " + modelToFind +
                ", которые эксплуатируются больше " + nYears + " лет:");
        printCarsHeader();
        int currentYear = Year.now().getValue();
        for (Car car : cars) {
            int age = currentYear - car.getYear();
            if (car.getModel().equalsIgnoreCase(modelToFind) && age > nYears) {
                System.out.println(car);
            }
        }

        System.out.println("\n---------------------------------------------\n");

        System.out.println("c) Автомобили года выпуска " + yearToFind +
                ", цена которых больше " + minPrice + ":");
        printCarsHeader();
        for (Car car : cars) {
            if (car.getYear() == yearToFind && car.getPrice() > minPrice) {
                System.out.println(car);
            }
        }
    }

    private static void printCarsHeader() {
        System.out.println(Car.header());
        System.out.println("---------------------------------------------------------------");
    }
}
