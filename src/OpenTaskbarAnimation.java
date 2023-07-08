import java.util.concurrent.TimeUnit;

public class OpenTaskbarAnimation implements Runnable {

    @Override
    public void run(){

        testUI.taskbarIsOpen=true;
    for(int i=0;i<620;i++) {
        if (i % 2 == 0) {
            try {

                TimeUnit.NANOSECONDS.sleep(1);

                testUI.taskbar.setLocation(-5, 680 - i);
                testUI.groupIcon.setLocation(60, 695 - i);
                testUI.plusIcon.setLocation(165, 695 - i);
                testUI.settingsIcon.setLocation(270, 695 - i);
                testUI.addFriendsLabel.setLocation(125, 835 - i);
                testUI.addFriendsFrame.setLocation(45,780-i);
                testUI.comboBox.setLocation(85,830-i);
                testUI.searchBarTemp.setLocation(75,910-i);
                testUI.plusMenuOr.setLocation(110,1000-i);
                testUI.createNewGroupLabel.setLocation(128,1080-i);
                testUI.createNewGroupButton.setLocation(108,1160-i);
                testUI.allGroupsLabel.setLocation(148,805-i);
                testUI.addOrDeleteGroups.setLocation(63,1275-i);
                testUI.filterBy.setLocation(201,1275-i);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }


        }
        if(i==600)
        {
            testUI.groupPositionA.setVisible(false);
            testUI.groupPositionB.setVisible(false);
            testUI.groupPositionC.setVisible(false);
            testUI.groupPositionD.setVisible(false);
        }
    }
    testUI.taskbarIsOpening=false;


    }
}
