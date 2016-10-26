package model;

/**
 * Denne klasse er oprettet med formålet om at kunne modtage et Gson-objekt, og herefter dele det op i username og password,
 * så det kan læses af IntelliJ.
 */

public class UserLogin {

    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
