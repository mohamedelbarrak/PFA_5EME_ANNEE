package com.myweb.smartshoppingapp.data.model;

public class Login {

    private int id;

    private String username;

    private String password;

    private String email;

    private String mobile;

    private int resetCount;

    private int role = 1;

    private boolean isRest = Boolean.FALSE;

    private long x;

    private long y;

    private String adresse;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public int getResetCount() {
        return resetCount;
    }

    public void setResetCount(int resetCount) {
        this.resetCount = resetCount;
    }

    public boolean isRest() {
        return isRest;
    }

    public void setRest(boolean isRest) {
        this.isRest = isRest;
    }



    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }


    public long getX() {
        return x;
    }

    public void setX(long x) {
        this.x = x;
    }

    public long getY() {
        return y;
    }

    public void setY(long y) {
        this.y = y;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    @Override
    public String toString() {
        return "Login{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", mobile='" + mobile + '\'' +
                ", resetCount=" + resetCount +
                ", role=" + role +
                ", isRest=" + isRest +
                ", x=" + x +
                ", y=" + y +
                ", adresse='" + adresse + '\'' +
                '}';
    }
}
