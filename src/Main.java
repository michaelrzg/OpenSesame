public class Main
{
    public static void main(String[]args)
    {
        Password one = new Password("password\\4845");
        GroupManager groupManager = new GroupManager();

        testUI ui = new testUI(groupManager);

    }
}
