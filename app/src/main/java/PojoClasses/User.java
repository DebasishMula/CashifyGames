package PojoClasses;

public class User {

   private String teamName,mobile,pin;

    public  User()
    {

    }
    public User(String teamName, String mobile, String pin) {
        this.teamName = teamName;
        this.mobile = mobile;
        this.pin = pin;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }
}
