public class Main
{
    public static void main(String[]args)
    {
        //Password one = new Password("password\\4845");

        GroupManager SampleGroupManager = new GroupManager();
        SampleGroupManager.addGroup(new Group("test group A"));
        SampleGroupManager.addGroup(new Group("test Group B"));
        SampleGroupManager.addGroup(new Group("test Group C"));
        SampleGroupManager.addGroup(new Group("test Group D"));


        testUI ui = new testUI(SampleGroupManager);

    }
}
