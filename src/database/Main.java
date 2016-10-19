package database;

/**
 * Created by aleksanderkristiansen on 19/10/2016.
 */
public class Main {

    public static void main(String[] args) throws Exception {

        DBConnector db = new DBConnector();

        System.out.print(db.getBooks().get(1));








    }
}
