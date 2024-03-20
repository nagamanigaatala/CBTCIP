import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

// Book class to represent a book object
class Book {
    private int id;
    private String title;
    private String author;
    private boolean available;

    public Book(int id, String title, String author, boolean available) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.available = available;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Title: " + title + ", Author: " + author + ", Available: " + available;
    }
}

// Library class to manage books and users
class Library {
    private Map<Integer, Book> books;
    private List<String> users;

    public Library() {
        books = new HashMap<>();
        users = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.put(book.getId(), book);
    }

    public void addUser(String username) {
        users.add(username);
    }

    public void displayBooks() {
        System.out.println("Available Books:");
        for (Book book : books.values()) {
            if (book.isAvailable()) {
                System.out.println(book);
            }
        }
    }

    public void issueBook(int bookId, String username) {
        Book book = books.get(bookId);
        if (book != null && book.isAvailable()) {
            book.setAvailable(false);
            System.out.println("Book issued successfully to " + username);
        } else {
            System.out.println("Book not available or invalid ID");
        }
    }

    public void returnBook(int bookId) {
        Book book = books.get(bookId);
        if (book != null && !book.isAvailable()) {
            book.setAvailable(true);
            System.out.println("Book returned successfully");
        } else {
            System.out.println("Book not issued or invalid ID");
        }
    }
}

// Main class to run the library system
public class Main {
    public static void main(String[] args) {
        Library library = new Library();

        // Adding some books to the library
        library.addBook(new Book(1, "Java Programming", "John Doe", true));
        library.addBook(new Book(2, "Data Structures", "Jane Smith", true));
        library.addBook(new Book(3, "Algorithm Design", "Alice Johnson", false));

        // Adding some users
        library.addUser("user1");
        library.addUser("user2");

        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("1. Display Available Books");
            System.out.println("2. Issue a Book");
            System.out.println("3. Return a Book");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    library.displayBooks();
                    break;
                case 2:
                    System.out.print("Enter Book ID to issue: ");
                    int bookId = scanner.nextInt();
                    System.out.print("Enter Username: ");
                    String username = scanner.next();
                    library.issueBook(bookId, username);
                    break;
                case 3:
                    System.out.print("Enter Book ID to return: ");
                    int returnBookId = scanner.nextInt();
                    library.returnBook(returnBookId);
                    break;
                case 4:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        } while (choice != 4);

        scanner.close();
    }
}
