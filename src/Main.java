import java.util.List;

public class Main {
    public static void main(String[] args) {
        for (String s : args) {
            System.out.print(s + " ");
        }

        BookRegister br = new BookRegister();
        br.readBooksFromFile("books.txt");

        Program program = new Program();
        program.setBookRegister(br);
        program.run();

    }
}
