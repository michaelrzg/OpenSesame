import java.util.concurrent.TimeUnit;

public class closeTaskbarAnimation implements Runnable{

    @Override
    public  void run()
    {

        testUI.taskbarIsClosing=true;
        for(int i=0;i<620;i++) {
            if (i % 2 == 0) {
                try {

                    TimeUnit.NANOSECONDS.sleep(1);

                    testUI.taskbar.setLocation(-5, 60 + i);
                    testUI.groupIcon.setLocation(60, 75 + i);
                    testUI.plusIcon.setLocation(165, 75 + i);
                    testUI.settingsIcon.setLocation(270, 75 + i);
                    testUI.addFriendsLabel.setLocation(125, 215 + i);
                    testUI.addFriendsFrame.setLocation(45,160+i);
                    testUI.comboBox.setLocation(85,210+i);
                    testUI.searchBarTemp.setLocation(75,290+i);
                    testUI.plusMenuOr.setLocation(110,380+i);
                    testUI.createNewGroupLabel.setLocation(128,460+i);
                    testUI.createNewGroupButton.setLocation(108,540+i);
                    testUI.allGroupsLabel.setLocation(148,185+i);
                    testUI.addOrDeleteGroups.setLocation(63,35+i);
                    testUI.filterBy.setLocation(201,35+i);

                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }


            }
            if(i==600)
            {
                testUI.groupPositionA.setVisible(true);
                testUI.groupPositionB.setVisible(true);
                testUI.groupPositionC.setVisible(true);
                testUI.groupPositionD.setVisible(true);
            }
        }
        testUI.taskbarIsClosing=false;
        testUI.taskbarIsOpen=false;

    }
}


