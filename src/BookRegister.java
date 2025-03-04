import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BookRegister {

    ArrayList<Book> books = new ArrayList<>();

    public void addBook(Book b) {books.add(b);}

    public void allRegisteredBooks() {

        for (Book b: books) {
            System.out.println(b);
        }
    }

    public List<Book> getBooksByGenre(Genre genre) {

        List<Book> result = new ArrayList<>();

        for (Book book : books) {
            if (book.getGenre() == genre) {
                result.add(book);
            }
        }
        return result;
    }

    public List<Book> getBooksByAuthor(String author) {

        List<Book> result = new ArrayList<>();

        for (Book book: books) {
            if (book.getAuthor().equalsIgnoreCase(author)) {
                result.add(book);
            }
        }
        return result;
    }

    public boolean removeBookByTitle(String title) {
        return books.removeIf(book -> book.getTitle().equalsIgnoreCase(title));
    }

    public List<Book> getBooksByReadingTime(int maxReadingTime) {
        List<Book> filteredBooks = new ArrayList<>();
        for (Book book : books) {
            int totalReadingTime = book.getNumberOfPages() * book.getMinutesPerPage();
            if (totalReadingTime <= maxReadingTime) {
                filteredBooks.add(book);
            }
        }
        return filteredBooks;
    }

    public void writeBookToFile(String filename) {
        try (FileWriter writer = new FileWriter(filename)) {
            for (Book book : books) {
                writer.write(book.getTitle() + ";"
                        + book.getAuthor() + ";"
                        + book.getNumberOfPages() + ";"
                        + book.getGenre() + ";"
                        + book.getMinutesPerPage() + "\n");
            }
            System.out.println("Books succesfully written to file: " + filename);
        } catch (IOException e) {
            System.out.println("Failed to write to file" + e.getMessage());
        }
    }

    public void readBooksFromFile(String filename) {
        books.clear();

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";");
                if (parts.length == 5) {
                    Book book = new Book(
                            parts[0],
                            parts[1],
                            Integer.parseInt(parts[2]),
                            Genre.valueOf(parts[3]),
                            Integer.parseInt(parts[4])
                    );
                    books.add(book);
                }
            }
            System.out.println("Books succesfully loaded from file: " + filename);
        } catch (IOException e) {
            System.out.println("Error reading from file: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("Error parsing file content " +e.getMessage());
        }
    }
}
