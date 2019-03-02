package sdi.training.config;

public class MySQLConfiguration {

    private String url = "jdbc:mysql://localhost:3306/sdi_training";
    private String user = "root";
    private String pass = "root";

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
