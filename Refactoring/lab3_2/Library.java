import java.util.ArrayList;
import java.util.List;

public class Library {
    private String name;
    private List<Book> books;
    
    public Library(String name) {
        this.name = name;
        this.books = new ArrayList<>();
    }
    
    public void addBook(Book book) {
        books.add(book);
        System.out.println("Book added: " + book.getTitle());
    }
    
    public void showAllBooks() {
        System.out.println("\nAll books in '" + name + "' library:");
        if (books.isEmpty()) {
            System.out.println("No books");
        } else {
            for (int i = 0; i < books.size(); i++) {
                System.out.print((i + 1) + ". ");
                books.get(i).printInfo();
            }
        }
    }
    
    public void showBooksByAuthor(String author) {
        System.out.println("\nBooks by author '" + author + "':");
        boolean found = false;
        for (Book book : books) {
            if (book.getAuthor().equalsIgnoreCase(author)) {
                book.printInfo();
                found = true;
            }
        }
        if (!found) {
            System.out.println("No books found");
        }
    }
    
    public String getName() {
        return name;
    }
}