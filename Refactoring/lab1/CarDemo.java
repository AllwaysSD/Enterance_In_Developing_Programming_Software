import java.time.Year;
import java.util.Arrays;
import java.util.List;

public class CarDemo {
    public static void main(String[] args) {
        // ИЗМЕНЕНО: Создание массива автомобилей через List для удобства передачи в репозиторий
        List<Car> carList = Arrays.asList(
            new Car(1, "Toyota", "Camry", 2018, "Черный", 22000, "AB1234"),
            new Car(2, "BMW", "M5", 2018, "Белый", 55000, "BC5678"),
            new Car(3, "Toyota", "Corolla", 2015, "Серый", 15000, "CD9012"),
            new Car(4, "Audi", "A4", 2018, "Синий", 30000, "DE3456"),
            new Car(5, "Toyota", "Camry", 2012, "Красный", 12000, "EF7890")
        );

        // ДОБАВЛЕНО: Создание репозитория с начальной коллекцией
        CarRepository carRepository = new CarRepository(carList);

        String brandToFind = "Toyota";
        String modelToFind = "Camry";
        int nYears = 5;
        int yearToFind = 2018;
        double minPrice = 20000;

        // ДОБАВЛЕНО: Демонстрация работы репозитория
        
        System.out.println("=== ДЕМОНСТРАЦИЯ РАБОТЫ РЕПОЗИТОРИЯ ===");
        
        System.out.println("\nИсходная коллекция автомобилей:");
        printCarsHeader();
        printCarList(carRepository.getAllCars());

        // ДОБАВЛЕНО: Добавление нового автомобиля
        System.out.println("\n--- Добавление нового автомобиля ---");
        carRepository.addCar("Mercedes", "E-Class", 2020, "Черный", 45000, "MG2020");
        System.out.println("Добавлен новый автомобиль Mercedes E-Class");
        printCarList(carRepository.getAllCars());

        // ДОБАВЛЕНО: Обновление автомобиля
        System.out.println("\n--- Обновление цены автомобиля с ID 1 ---");
        carRepository.updateCarPrice(1, 25000);
        System.out.println("Цена автомобиля с ID 1 обновлена до 25000");
        printCarList(carRepository.findCarsByBrand("Toyota"));

        // ДОБАВЛЕНО: Удаление автомобиля
        System.out.println("\n--- Удаление автомобиля с ID 3 ---");
        carRepository.removeCarById(3);
        System.out.println("Автомобиль с ID 3 удален");
        printCarList(carRepository.getAllCars());

        // ИСХОДНЫЕ ЗАДАЧИ (адаптированные для работы с репозиторием)
        
        System.out.println("\n=== ВЫПОЛНЕНИЕ ИСХОДНЫХ ЗАДАЧ ===");

        System.out.println("\na) Автомобили марки " + brandToFind + ":");
        printCarsHeader();
        printCarList(carRepository.findCarsByBrand(brandToFind));

        System.out.println("\n---------------------------------------------\n");

        System.out.println("b) Автомобили модели " + modelToFind +
                ", которые эксплуатируются больше " + nYears + " лет:");
        printCarsHeader();
        int currentYear = Year.now().getValue();
        List<Car> allCars = carRepository.getAllCars();
        for (Car car : allCars) {
            int age = currentYear - car.getYear();
            if (car.getModel().equalsIgnoreCase(modelToFind) && age > nYears) {
                System.out.println(car);
            }
        }

        System.out.println("\n---------------------------------------------\n");

        System.out.println("c) Автомобили года выпуска " + yearToFind +
                ", цена которых больше " + minPrice + ":");
        printCarsHeader();
        List<Car> carsByYear = carRepository.findCarsByYear(yearToFind);
        for (Car car : carsByYear) {
            if (car.getPrice() > minPrice) {
                System.out.println(car);
            }
        }

        // ДОБАВЛЕНО: Дополнительная демонстрация методов репозитория
        System.out.println("\n=== ДОПОЛНИТЕЛЬНЫЕ ВОЗМОЖНОСТИ РЕПОЗИТОРИЯ ===");
        
        System.out.println("\nПоиск автомобилей в ценовом диапазоне 10000-30000:");
        printCarsHeader();
        printCarList(carRepository.findCarsByPriceRange(10000, 30000));

        System.out.println("\nОбщее количество автомобилей в репозитории: " + carRepository.getCarCount());
    }

    // ИЗМЕНЕНО: Добавлен метод для печати списка автомобилей
    private static void printCarList(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car);
        }
    }

    private static void printCarsHeader() {
        System.out.println(Car.header());
        System.out.println("---------------------------------------------------------------");
    }
}