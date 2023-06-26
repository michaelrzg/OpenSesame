import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class PasswordManager
{

    private File dataStorage;
    //file is a csv, each line is platform,user,password,encryptkey(0-2)
    private ArrayList<Platform> platforms;
    PasswordManager()
    {
        try
        {
        dataStorage = new File("data.txt");
        Scanner sc = new Scanner(dataStorage);
        while(sc.hasNextLine())
        {
            String [] line = sc.nextLine().split(",");
            platforms.add(new Platform(line[0],line[1],line[2],Integer.parseInt(line[3])));

        }
        }
     catch (FileNotFoundException e)
        {
        e.printStackTrace();
        }
    }
}
