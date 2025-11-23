import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

// ДОБАВЛЕН: Класс-репозиторий для управления коллекцией автомобилей
public class CarRepository {
    private List<Car> cars;
    private int nextId;

    // ДОБАВЛЕН: Конструктор по умолчанию
    public CarRepository() {
        this.cars = new ArrayList<>();
        this.nextId = 1;
    }

    // ДОБАВЛЕН: Конструктор с начальной коллекцией
    public CarRepository(List<Car> initialCars) {
        this.cars = new ArrayList<>(initialCars);
        this.nextId = findMaxId() + 1;
    }

    // ДОБАВЛЕН: Вспомогательный метод для поиска максимального ID
    private int findMaxId() {
        return cars.stream()
                .mapToInt(Car::getId)
                .max()
                .orElse(0);
    }

    // === МЕТОДЫ ДОБАВЛЕНИЯ ===

    // ДОБАВЛЕН: Добавление существующего автомобиля с автоматическим назначением ID
    public void addCar(Car car) {
        car.setId(nextId++);
        cars.add(car);
    }

    // ДОБАВЛЕН: Создание и добавление нового автомобиля по параметрам
    public void addCar(String brand, String model, int year, String color, double price, String regNumber) {
        Car car = new Car(nextId++, brand, model, year, color, price, regNumber);
        cars.add(car);
    }

    // === МЕТОДЫ УДАЛЕНИЯ ===

    // ДОБАВЛЕН: Удаление автомобиля по ID
    public boolean removeCarById(int id) {
        return cars.removeIf(car -> car.getId() == id);
    }

    // ДОБАВЛЕН: Удаление автомобиля по регистрационному номеру
    public boolean removeCarByRegNumber(String regNumber) {
        return cars.removeIf(car -> car.getRegNumber().equalsIgnoreCase(regNumber));
    }

    // === МЕТОДЫ ИЗМЕНЕНИЯ ===

    // ДОБАВЛЕН: Обновление марки автомобиля
    public boolean updateCarBrand(int id, String newBrand) {
        Car car = findCarById(id);
        if (car != null) {
            car.setBrand(newBrand);
            return true;
        }
        return false;
    }

    // ДОБАВЛЕН: Обновление модели автомобиля
    public boolean updateCarModel(int id, String newModel) {
        Car car = findCarById(id);
        if (car != null) {
            car.setModel(newModel);
            return true;
        }
        return false;
    }

    // ДОБАВЛЕН: Обновление года выпуска автомобиля
    public boolean updateCarYear(int id, int newYear) {
        Car car = findCarById(id);
        if (car != null) {
            car.setYear(newYear);
            return true;
        }
        return false;
    }

    // ДОБАВЛЕН: Обновление цвета автомобиля
    public boolean updateCarColor(int id, String newColor) {
        Car car = findCarById(id);
        if (car != null) {
            car.setColor(newColor);
            return true;
        }
        return false;
    }

    // ДОБАВЛЕН: Обновление цены автомобиля
    public boolean updateCarPrice(int id, double newPrice) {
        Car car = findCarById(id);
        if (car != null) {
            car.setPrice(newPrice);
            return true;
        }
        return false;
    }

    // ДОБАВЛЕН: Обновление регистрационного номера автомобиля
    public boolean updateCarRegNumber(int id, String newRegNumber) {
        Car car = findCarById(id);
        if (car != null) {
            car.setRegNumber(newRegNumber);
            return true;
        }
        return false;
    }

    // ДОБАВЛЕН: Полное обновление автомобиля
    public boolean updateCar(int id, Car updatedCar) {
        for (int i = 0; i < cars.size(); i++) {
            if (cars.get(i).getId() == id) {
                updatedCar.setId(id); // ИЗМЕНЕНО: Сохраняем оригинальный ID
                cars.set(i, updatedCar);
                return true;
            }
        }
        return false;
    }

    // === МЕТОДЫ ПОИСКА ===

    // ДОБАВЛЕН: Поиск автомобиля по ID
    public Car findCarById(int id) {
        return cars.stream()
                .filter(car -> car.getId() == id)
                .findFirst()
                .orElse(null);
    }

    // ДОБАВЛЕН: Поиск автомобилей по марке
    public List<Car> findCarsByBrand(String brand) {
        return cars.stream()
                .filter(car -> car.getBrand().equalsIgnoreCase(brand))
                .collect(Collectors.toList());
    }

    // ДОБАВЛЕН: Поиск автомобилей по модели
    public List<Car> findCarsByModel(String model) {
        return cars.stream()
                .filter(car -> car.getModel().equalsIgnoreCase(model))
                .collect(Collectors.toList());
    }

    // ДОБАВЛЕН: Поиск автомобилей по году выпуска
    public List<Car> findCarsByYear(int year) {
        return cars.stream()
                .filter(car -> car.getYear() == year)
                .collect(Collectors.toList());
    }

    // ДОБАВЛЕН: Поиск автомобилей по цвету
    public List<Car> findCarsByColor(String color) {
        return cars.stream()
                .filter(car -> car.getColor().equalsIgnoreCase(color))
                .collect(Collectors.toList());
    }

    // ДОБАВЛЕН: Поиск автомобилей по диапазону цен
    public List<Car> findCarsByPriceRange(double minPrice, double maxPrice) {
        return cars.stream()
                .filter(car -> car.getPrice() >= minPrice && car.getPrice() <= maxPrice)
                .collect(Collectors.toList());
    }

    // ДОБАВЛЕН: Получение всех автомобилей
    public List<Car> getAllCars() {
        return new ArrayList<>(cars);
    }

    // ДОБАВЛЕН: Получение количества автомобилей в репозитории
    public int getCarCount() {
        return cars.size();
    }

    // ДОБАВЛЕН: Очистка репозитория
    public void clear() {
        cars.clear();
        nextId = 1;
    }

    // ДОБАВЛЕН: Проверка наличия автомобиля по ID
    public boolean containsCar(int id) {
        return cars.stream().anyMatch(car -> car.getId() == id);
    }
}