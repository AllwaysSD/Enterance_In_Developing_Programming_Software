public class Car {
    private int id;
    private String brand;
    private String model;
    private int year;
    private String color;
    private double price;
    private String regNumber;

    public Car(int id, String brand, String model, int year, String color, double price, String regNumber) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.color = color;
        this.price = price;
        this.regNumber = regNumber;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getBrand() { return brand; }
    public void setBrand(String brand) { this.brand = brand; }

    public String getModel() { return model; }
    public void setModel(String model) { this.model = model; }

    public int getYear() { return year; }
    public void setYear(int year) { this.year = year; }

    public String getColor() { return color; }
    public void setColor(String color) { this.color = color; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    public String getRegNumber() { return regNumber; }
    public void setRegNumber(String regNumber) { this.regNumber = regNumber; }

    @Override
    public String toString() {
        return String.format("%-3d | %-8s | %-8s | %-4d | %-8s | %10.2f | %-8s",
                id, brand, model, year, color, price, regNumber);
    }

    public static String header() {
        return String.format("%-3s | %-8s | %-8s | %-4s | %-8s | %-10s | %-8s",
                "ID", "Марка", "Модель", "Год", "Цвет", "Цена", "Рег.№");
    }
}