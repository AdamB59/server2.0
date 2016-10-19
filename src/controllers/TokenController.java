package controllers;

import Encrypters.Crypter;
import database.DBConnector;
import model.User;

import java.sql.SQLException;

/**
 * Created by Tastum on 19/10/2016.
 */
public class TokenController {

    DBConnector db = new DBConnector();

    public String authenticate(String username, String password) throws SQLException {
        // Authenticate the user using the credentials provided

        String token;

        User foundUser = db.authenticate(username, password);
        if (foundUser != null) {

            token = Crypter.buildToken("abcdefghijklmnopqrstuvxyz1234567890@&%!?", 25);

//            db.addToken(token, foundUser.getId());
            db.addToken(token, 12);

        } else {
            token = null;
        }
        //Retunerer en access token til klienten.
        return token;
    }
}
