import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Create libraries
        Library lib1 = new Library("Central Library");
        Library lib2 = new Library("Science Library");
        
        // Add books to first library
        lib1.addBook(new Book("War and Peace", "Leo Tolstoy", 1869));
        lib1.addBook(new Book("Anna Karenina", "Leo Tolstoy", 1877));
        lib1.addBook(new Book("Crime and Punishment", "Fyodor Dostoevsky", 1866));
        lib1.addBook(new Book("The Master and Margarita", "Mikhail Bulgakov", 1967));
        
        // Add books to second library
        lib2.addBook(new Book("Physics Fundamentals", "Stephen Hawking", 2004));
        lib2.addBook(new Book("Brief History of Time", "Stephen Hawking", 1988));
        lib2.addBook(new Book("Clean Code", "Robert Martin", 2008));
        lib2.addBook(new Book("The Great Gatsby", "F. Scott Fitzgerald", 1925));
        
        // Menu
        while (true) {
            System.out.println("\n=== LIBRARY MANAGEMENT SYSTEM ===");
            System.out.println("1. Show all books");
            System.out.println("2. Find books by author");
            System.out.println("3. Add book");
            System.out.println("0. Exit");
            System.out.print("Choose: ");
            
            String choice = scanner.nextLine();
            
            if (choice.equals("1")) {
                lib1.showAllBooks();
                lib2.showAllBooks();
                
            } else if (choice.equals("2")) {
                System.out.print("Enter author name: ");
                String author = scanner.nextLine();
                lib1.showBooksByAuthor(author);
                lib2.showBooksByAuthor(author);
                
            } else if (choice.equals("3")) {
                System.out.print("Which library? (1-Central, 2-Science): ");
                String libChoice = scanner.nextLine();
                System.out.print("Book title: ");
                String title = scanner.nextLine();
                System.out.print("Author: ");
                String author = scanner.nextLine();
                System.out.print("Year: ");
                int year = Integer.parseInt(scanner.nextLine());
                
                Book newBook = new Book(title, author, year);
                if (libChoice.equals("1")) {
                    lib1.addBook(newBook);
                } else {
                    lib2.addBook(newBook);
                }
                
            } else if (choice.equals("0")) {
                System.out.println("Goodbye!");
                break;
            } else {
                System.out.println("Invalid choice!");
            }
        }
        
        scanner.close();
    }
}