import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class PasswordManager
{

    private File dataStorage;
    //file is a csv, each line is platform,user,password,encryptkey(0-2)
    private ArrayList<Platform> passwords;
    PasswordManager()
    {
        passwords=new ArrayList<>();

        try
        {
        dataStorage = new File("src/PlatformsData.txt");
        Scanner sc = new Scanner(dataStorage);
        while(sc.hasNextLine())
        {
            Password temp = new Password();
            String [] line = sc.nextLine().split(",");
            temp.setPassword(line[2], Integer.parseInt(line[3]));
            passwords.add(new Platform(line[0],line[1],temp));
            // 0 : platformName 1: username for platform 2: encryptedPassword 3: encryptionID
            //example data : netflix,username,encryptedpass,1


        }
        }
     catch (IOException e)
        {
        e.printStackTrace();
        }
    }

    public String  retrievePassword(String platform)
    {
        for (Platform s : passwords)
        {
            if(s.platformName.equals(platform))
            {
                return s.encryptedPlatformPassword.decryptPassword(s.encryptedPlatformPassword.encryptedPass);
            }
        }
        return null;
    }
}
