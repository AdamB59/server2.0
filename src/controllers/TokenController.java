package controllers;

import Encrypters.*;
import database.DBConnector;
import model.User;

import java.sql.SQLException;

/**
 * Opretter en instans af DBConnector og kalder alle metoder til AccesTokens.
 * Hver metode er forklaret med kommentarer i DBConnector.
 */

public class TokenController {

    DBConnector db = new DBConnector();

    public String authenticate(String username, String password) throws SQLException {
        // Authenticate the user using the credentials provided

        String token;

        User foundUser = db.authenticate(username, password);
        System.out.print("user:" + foundUser);
        if (foundUser != null) {

            // nedenstående tal bestemmer hvor lang token skal være.
            token = Crypter.buildToken("abcdefghijklmnopqrstuvxyz1234567890@&%!?", 50);
            db.addToken(token, foundUser.getUserID());
            // Fra det brugernavn og adgangskode der bliver indtastet hos klienten,
            // der regner den ud hvilket ID brugeren har, og så genereres der en token til den tilhørende brugerID.

        } else {
            token = null;
        }
        //Retunerer en access token til klienten.
        return token;


    }

    public User getUserFromTokens(String token) throws SQLException {
        DBConnector db = new DBConnector();
        User user = db.getUserFromToken(token);
        db.close();
        return user;

    }

    public boolean deleteToken(String token) throws SQLException{
        DBConnector db = new DBConnector();
        boolean deleteToken = db.deleteToken(token);
        db.close();
        return deleteToken;

    }
}
