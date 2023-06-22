public class GroupLeader extends User {
   public Group group;
   public boolean groupIsSet = false;

    GroupLeader(String username, String accountPass, int userID, Group group) {
        super(username, accountPass, userID);
        if(!groupIsSet) {
            this.group = group;
        }

    }





}
