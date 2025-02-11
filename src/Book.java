import java.time.LocalDate;
import java.util.ArrayList;

public class Book {
    private String title;
    private String author;
    private int numberOfPages;
    private Genre genre;
    private ArrayList<Chapter> chapters;
    private String isbn;
    private LocalDate published;
    private int minutesPerPage;

    public Book() {
        this.chapters = new ArrayList<>();
    }

    public String getTitle() {return title;}

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }


    public Genre getGenre() {
        return genre;
    }


    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public String toString() {
        return "Title " + title + ", Author: " + author + ", Genre: " + genre
                + ", Pages: " + numberOfPages + ", Minutes Per Page: " + minutesPerPage;
    }

    public void addChapter(Chapter chapter) {
        this.chapters.add(chapter);
    }

    public ArrayList<Chapter> getChapters() {
        return chapters;
    }

    public int getMinutesPerPage() {
        return minutesPerPage;
    }

    public void setMinutesPerPage(int minutesPerPage) {
        this.minutesPerPage = minutesPerPage;
    }
}
