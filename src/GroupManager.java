import java.util.ArrayList;

public class GroupManager
{
    public ArrayList<Group> groups;


    GroupManager()
    {
        groups = new ArrayList<>();

    }

    public void addGroup(Group group)
    {
        groups.add(group);
    }
}
