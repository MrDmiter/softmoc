package utils;

public class YamlFile {
    private String url;
    private String email;
    private String password;
    private String wrongEmail;
    private String wrongPassword;

    YamlFile(){

    }
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getWrongEmail() {
        return wrongEmail;
    }

    public void setWrongEmail(String wrongEmail) {
        this.wrongEmail = wrongEmail;
    }

    public String getWrongPassword() {
        return wrongPassword;
    }

    public void setWrongPassword(String wrongPassword) {
        this.wrongPassword = wrongPassword;
    }
}
