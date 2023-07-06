import java.awt.*;
import java.util.concurrent.TimeUnit;
import java.util.logging.Handler;

public class OpenPlusMenuAnimation implements Runnable {

    @Override
    public void run(){

    for(int i=0;i<620;i++) {
        if (i % 2 == 0) {
            try {

                TimeUnit.NANOSECONDS.sleep(1);

                testUI.taskbar.setLocation(-5, 680 - i);
                testUI.groupIcon.setLocation(60, 695 - i);
                testUI.plusIcon.setLocation(165, 695 - i);
                testUI.settingsIcon.setLocation(270, 695 - i);
                testUI.addFriendsLabel.setLocation(138, 770 - i);
                testUI.addFriendsFrame.setLocation(45,780-i);
                testUI.comboBox.setLocation(85,830-i);
                testUI.searchBarTemp.setLocation(75,840-i);

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



    }
}
