package cn.edu.tju.wxy;

public class ExcelData {
    private String user;
    private String password;

    public String getPassword() {
        return password;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "name " + this.user + " password " + password;
    }
}
