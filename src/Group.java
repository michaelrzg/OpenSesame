import java.util.ArrayList;

public class Group {
    private String groupName;
    private String encryptedGroupPass;
    private GroupLeader leader;
    private int groupId;
    private ArrayList<User> members;
    protected int memberCount;

    private PasswordManager passwordManager;

    private boolean groupIsOpen;

    Group(String groupName, User leader, int groupId, String groupPAss)
    {
        this.groupName = groupName;
        this.leader = (GroupLeader) leader;
        this.groupId = groupId;
        //this.encryptedGroupPass = encrypt(groupPass);
        members = new ArrayList<User>();
        memberCount=0;
        this.groupIsOpen=true;
        passwordManager = new PasswordManager();
    }

    public void addUserToGroup(User methodCaller, User personToBeAdded) throws NotLeaderException
    {   System.out.println("[debug in group line 27] addUserToGroup");
        if(methodCaller == leader && groupIsOpen)
        {
            members.add(personToBeAdded);
            memberCount = members.size();

        }
        else throw new NotLeaderException("Error: Users can only be added by the Group leader");
    }
    public void removeUserFromGroup(User methodCaller, User personToBeRemoved) throws NotLeaderException {
        if(methodCaller == leader && groupIsOpen)
        {
            members.remove(personToBeRemoved);
            memberCount = members.size();
            System.out.println("[debug in group line 41] removeUserToGroup");
        }
        else throw new NotLeaderException("Error: Users can only be added by the Group leader");
    }
    public void closeGroup(User methodCaller) throws Exception {
        if (methodCaller == leader && groupIsOpen)
        {
            groupIsOpen=false;
        }
        else if (!groupIsOpen)
        {
            throw new GroupIsClosedException("Group is already closed");
        }
        else throw new Exception("Something went wrong, please try again");
    }





}
