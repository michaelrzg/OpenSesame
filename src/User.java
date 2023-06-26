public class User {

    private String username;
    private String accountPass;
    private String signUpDate;
    public int friendCount;
    public int userID;
    public boolean activeUser;



    User(String username, String accountPass, int userID)
    {
        this.username = username;
       // this.accountPass = encrypt(accountPass)
        this.userID = userID;
        activeUser=true;

    }

    public void setAccountPass(String accountPass) {
       // this.accountPass = encrypt(accountPass);
    }


}
