public class Platform {
    public String platformName;
    private String platformUsername;
    public Password encryptedPlatformPassword;
    private int encyrptkey;


    Platform(String platformName, String platformUsername,Password encryptedPlatformPassword, int encyrptkey)
    {
        this.platformName=platformName;
        this.encryptedPlatformPassword = encryptedPlatformPassword;
        this.platformUsername=platformUsername;
        this.encryptedPlatformPassword.encryptMethodID = encyrptkey;
    }
}
