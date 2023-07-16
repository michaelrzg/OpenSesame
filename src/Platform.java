public class Platform {
    public String platformName;
    public String platformUsername;
    public Password encryptedPlatformPassword;
    public int encyrptkey;


    Platform(String platformName, String platformUsername,Password encryptedPlatformPassword)
    {
        this.platformName=platformName;
        this.encryptedPlatformPassword = encryptedPlatformPassword;
        this.platformUsername=platformUsername;
        this.encryptedPlatformPassword.encryptMethodID = encyrptkey;
    }
}
