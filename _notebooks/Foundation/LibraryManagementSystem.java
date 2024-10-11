import java.util.ArrayList;
import java.util.Scanner;

public class LibraryManagementSystem {

    // Book class
    public static class Book {
        private String title;
        private boolean available;

        public Book(String title) {
            this.title = title;
            this.available = true;
        }

        public boolean isAvailable() {
            return available;
        }

        public void borrow() {
            available = false;
        }

        public void returnBook() {
            available = true;
        }

        public String getTitle() {
            return title;
        }
    }

    // User class
    public static class User {
        private String name;
        private ArrayList<Book> borrowedBooks;

        public User(String name) {
            this.name = name;
            borrowedBooks = new ArrayList<>();
        }

        public void borrowBook(Book book) {
            if (book.isAvailable()) {
                book.borrow();
                borrowedBooks.add(book);
                System.out.println("You borrowed: " + book.getTitle());
            } else {
                System.out.println("Book is not available.");
            }
        }

        public void returnBook(Book book) {
            if (borrowedBooks.contains(book)) {
                book.returnBook();
                borrowedBooks.remove(book);
                System.out.println("You returned: " + book.getTitle());
            } else {
                System.out.println("You haven't borrowed this book.");
            }
        }

        public void viewBorrowedBooks() {
            if (borrowedBooks.isEmpty()) {
                System.out.println("You haven't borrowed any books.");
            } else {
                System.out.println("Your borrowed books:");
                for (Book book : borrowedBooks) {
                    System.out.println("- " + book.getTitle());
                }
            }
        }
    }

    // Librarian class extends User
    public static class Librarian extends User {
        public Librarian(String name) {
            super(name);
        }

        public void addBook(Book[] library, Book newBook) {
            for (int i = 0; i < library.length; i++) {
                if (library[i] == null) {
                    library[i] = newBook;
                    System.out.println(newBook.getTitle() + " added to the library.");
                    return;
                }
            }
            System.out.println("Library is full, cannot add more books.");
        }

        public void removeBook(Book[] library, String title) {
            for (int i = 0; i < library.length; i++) {
                if (library[i] != null && library[i].getTitle().equals(title)) {
                    library[i] = null;
                    System.out.println(title + " removed from the library.");
                    return;
                }
            }
            System.out.println("Book not found in the library.");
        }
    }

    // Main program
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Initialize library with 5 slots for books
        Book[] library = new Book[5];
        library[0] = new Book("The Great Gatsby");
        library[1] = new Book("1984");
        library[2] = new Book("To Kill a Mockingbird");

        // Create users and librarian
        User user = new User("John Doe");
        Librarian librarian = new Librarian("Jane Doe");

        // Menu loop
        boolean running = true;
        while (running) {
            System.out.println("\n--- Library Menu ---");
            System.out.println("1. View available books");
            System.out.println("2. Borrow a book");
            System.out.println("3. Return a book");
            System.out.println("4. View borrowed books");
            System.out.println("5. Add a book (Librarian only)");
            System.out.println("6. Remove a book (Librarian only)");
            System.out.println("7. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    // View available books
                    System.out.println("\nAvailable books:");
                    for (Book book : library) {
                        if (book != null && book.isAvailable()) {
                            System.out.println("- " + book.getTitle());
                        }
                    }
                    break;

                case 2:
                    // Borrow a book
                    System.out.print("Enter the title of the book to borrow: ");
                    String titleToBorrow = scanner.nextLine();
                    Book bookToBorrow = findBook(library, titleToBorrow);
                    if (bookToBorrow != null) {
                        user.borrowBook(bookToBorrow);
                    } else {
                        System.out.println("Book not found.");
                    }
                    break;

                case 3:
                    // Return a book
                    System.out.print("Enter the title of the book to return: ");
                    String titleToReturn = scanner.nextLine();
                    Book bookToReturn = findBook(library, titleToReturn);
                    if (bookToReturn != null) {
                        user.returnBook(bookToReturn);
                    } else {
                        System.out.println("Book not found.");
                    }
                    break;

                case 4:
                    // View borrowed books
                    user.viewBorrowedBooks();
                    break;

                case 5:
                    // Add a book (Librarian)
                    System.out.print("Enter the title of the new book: ");
                    String newBookTitle = scanner.nextLine();
                    librarian.addBook(library, new Book(newBookTitle));
                    break;

                case 6:
                    // Remove a book (Librarian)
                    System.out.print("Enter the title of the book to remove: ");
                    String titleToRemove = scanner.nextLine();
                    librarian.removeBook(library, titleToRemove);
                    break;

                case 7:
                    // Exit
                    running = false;
                    break;

                default:
                    System.out.println("Invalid option, please choose again.");
            }
        }

        scanner.close();
        System.out.println("Exiting Library Management System.");
    }

    // Helper method to find a book in the library by title
    public static Book findBook(Book[] library, String title) {
        for (Book book : library) {
            if (book != null && book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }
}