package database;

import model.Book;
import model.Curriculum;
import model.User;

import java.util.ArrayList;

/**
 * Created by mortenlaursen on 17/10/2016.
 */
public class DBConnector {

    /*5 user methods*/
    public static ArrayList<User> getUsers() {
        return new ArrayList<User>();
    }

    public static User getUser(int id) {
        return new User();
    }

    public static boolean editUser(int id) {
        return true;
    }

    public static boolean addUser(User u) {
        return true;
    }

    public static boolean deleteUser(int id) {
        return true;
    }
    
    /*Curriculum methods*/
    public static ArrayList<Curriculum> getCurriculums() {
        return new ArrayList<Curriculum>();
    }

    public static Curriculum getCurriculum(int id) {
        return new Curriculum();
    }

    public static boolean editCurriculum(int id) {
        return true;
    }

    public static boolean addCurriculum(Curriculum c) {
        return true;
    }

    public static boolean deleteCurriculum(int id) {
        return true;
    }
    
    /*books methods*/
    public static ArrayList<Book> getBooks() {
        return new ArrayList<Book>();
    }

    public static Book getBook(int id) {
        return new Book();
    }

    public static boolean editBook(int id) {
        return true;
    }

    public static boolean addBook(Book b) {
        return true;
    }

    public static boolean deleteBook(int id) {
        return true;
    }
}
