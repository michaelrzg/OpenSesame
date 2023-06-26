public class Platform {
    public String platformName;
    private String platformUsername;
    private Password platformPassword;


    Platform(String platformName, String platformUsername, Password platformPassword)
    {
        this.platformName=platformName;
        this.platformPassword=platformPassword;
        this.platformUsername=platformUsername;
    }
}
