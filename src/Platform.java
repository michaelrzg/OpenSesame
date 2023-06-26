public class Platform {
    public String platformName;
    private String platformUsername;
    private String encryptedPlatformPassword;
    private int encyrptkey;


    Platform(String platformName, String platformUsername,String encryptedPlatformPassword, int encyrptkey)
    {
        this.platformName=platformName;
        this.encryptedPlatformPassword = encryptedPlatformPassword;
        this.platformUsername=platformUsername;
        this.encyrptkey = encyrptkey;
    }
}
