public class Chapter {
    private String title;
    private int numberOfPages;

    public Chapter(String title, int numberOfPages) {
        this.title = title;
        this.numberOfPages = numberOfPages;
    }

    @Override
    public String toString() {
        return "Title: " + title + "Pages: " + numberOfPages;
    }
}