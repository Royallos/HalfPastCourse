package app.entity;

public class User {

    String login;
    String pass;

    public User() {
    };
    public User(String name, String pass) {

        this.login = name;
        this.pass = pass;
    };

    public String getLogin() {
        return login;
    }

    public void setLogin(String name) {
        this.login = name;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
