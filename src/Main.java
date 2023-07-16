import java.awt.*;
import java.io.IOException;

public class Main
{
    public static void main(String[]args) throws IOException, FontFormatException, InterruptedException {
        //PASSWORDS CAN NOT INCLUDE '#' ',' or '&' symbols in sequence.
        //see Passwords class for more details

        Password one = new Password("password");
        System.out.println(one.encryptedPass);
        System.out.println(one.decryptPassword(one.encryptedPass));


        GroupManager SampleGroupManager = new GroupManager();
        SampleGroupManager.addGroup(new Group("Test Group A"));
        SampleGroupManager.addGroup(new Group("Test Group B"));
        SampleGroupManager.addGroup(new Group("Test Group C"));
        SampleGroupManager.addGroup(new Group("Test Group D"));


       //testUI ui = new testUI(SampleGroupManager);
        OpenSesameUI ui = new OpenSesameUI();

    }
}
