/**
 * Created by mortenlaursen on 12/10/2016.
 */
public class Book {
    String name;
    int ISBN;
    String author;
    String hej; 

    public Book(String name, int ISBN) {
        this.name = name;
        this.ISBN = ISBN;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getISBN() {
        return ISBN;
    }

    public void setISBN(int ISBN) {
        this.ISBN = ISBN;
    }
}
