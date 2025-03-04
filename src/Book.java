public class Book {
    private String title;
    private String author;
    private int numberOfPages;
    private Genre genre;
    private int minutesPerPage;


    public Book(String title, String author, int numberOfPages, Genre genre, int minutesPerPage) {
        this.title = title;
        this.author = author;
        this.numberOfPages = numberOfPages;
        this.genre = genre;
        this.minutesPerPage = minutesPerPage;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public Genre getGenre() {
        return genre;
    }


    public String toString() {
        return "Title " + title + ", Author: " + author + ", Genre: " + genre
                + ", Pages: " + numberOfPages + ", Minutes Per Page: " + minutesPerPage;
    }

    public int getMinutesPerPage() {
        return minutesPerPage;
    }
}

