import java.util.List;
import java.util.Scanner;

public class Program {
    private BookRegister bookRegister;
    private Scanner scanner;

    public Program() {
        this.bookRegister = new BookRegister();
        this.scanner = new Scanner(System.in);
    }

    public void setBookRegister(BookRegister bookRegister) {
        this.bookRegister = bookRegister;
    }

    public void run() {
        Boolean running = true;

        while (running) {
            System.out.println("\n--- Book Register Menu ---");
            System.out.println("1. Add book");
            System.out.println("2. All books");
            System.out.println("3. Books by Genre");
            System.out.println("4. Books by maximum reading time");
            System.out.println("5. Remove book");
            System.out.println("6. Books by author");
            System.out.println("7. Quit");

            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    addBook();
                    break;
                case 2:
                    displayAllBooks();
                    break;
                case 3:
                    displayBooksByGenre();
                    break;
                case 4:
                    displayBooksByReadingTime();
                    break;
                case 5:
                    removeBook();
                    break;
                case 6:
                    displayBooksByAuthor();
                    break;
                case 7:
                    running = false;
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

    }


    private void addBook() {
        System.out.println("Enter the title of the book:");
        String title = scanner.nextLine();

        System.out.println("Enter the author of the book:");
        String author = scanner.nextLine();

        System.out.println("Enter the number of pages in the book:");
        int numberOfPages = Integer.parseInt(scanner.nextLine());

        System.out.println("Enter minutes per page:");
        int minutesPerPage = Integer.parseInt(scanner.nextLine());

        Book book = new Book();
        book.setTitle(title);
        book.setAuthor(author);
        book.setNumberOfPages(numberOfPages);
        book.setMinutesPerPage(minutesPerPage);

        System.out.println("Select the genre of the book (FANTASY, ACTION, etc.:");
        String genreInput = scanner.nextLine().toUpperCase();

        try {
            Genre genre = Genre.valueOf(genreInput);
            book.setGenre(genre);
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid genre. Defaulting to 'UNKNOWN'.");
            book.setGenre(Genre.UNKNOWN);
        }

        bookRegister.addBook(book);
        System.out.println("Book added successfully: " + book);

        bookRegister.writeBookToFile("books.txt");

    }

    private void displayAllBooks() {
        System.out.println("All registered books: ");
        bookRegister.allRegisteredBooks();
    }

    private void displayBooksByGenre() {
        System.out.println("Enter the genre you want to filter by.");
        String genreInput = scanner.nextLine().toUpperCase();

        try {
            Genre genre = Genre.valueOf(genreInput);
            List<Book> booksByGenre = bookRegister.getBooksByGenre(genre);

            if (booksByGenre.isEmpty()) {
                System.out.println("No books found for this genre: " + genre);
            } else {
                System.out.println("Books in genre " + genre + ":");
                for (Book book : booksByGenre) {
                    System.out.println(book);
                }
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid genre. Please try again.");
        }
    }

    private void displayBooksByReadingTime() {
        System.out.println("Enter the maximum reading time in minutes:");
        int maxReadingTime = Integer.parseInt(scanner.nextLine());

        List<Book> booksByTime = bookRegister.getBooksByReadingTime(maxReadingTime);
        if (booksByTime.isEmpty()) {
            System.out.println("No books can be read within " + maxReadingTime + " minutes.");
        } else {
            System.out.println("Books that can be read within " + maxReadingTime + " minutes.");
            for (Book book : booksByTime) {
                System.out.println(book);
            }
        }
    }

    private void removeBook() {
        System.out.println("Enter the title of the book you want to remove: ");
        String title = scanner.nextLine();

        if (bookRegister.removeBookByTitle(title)) {
            System.out.println("Book removed successfully.");
        } else {
            System.out.println("Book not found.");
        }

    }

    private void displayBooksByAuthor() {
        System.out.println("Enter the name of author you want to filter by.");
        String name = scanner.nextLine();

        try {
            List<Book> booksByAuthor = bookRegister.getBooksByAuthor(name);

            if (booksByAuthor.isEmpty()) {
                System.out.println("No books by this author was found.");
            } else {
                System.out.println("Books by author " + name + ":");
                for (Book book : booksByAuthor) {
                    System.out.println(book);
                }
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid author. Please try again.");
        }
    }
}

