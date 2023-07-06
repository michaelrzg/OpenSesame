import java.awt.*;
import java.util.concurrent.TimeUnit;

public class OpenHomepageAnimation implements Runnable{
    @Override
    public void run() {
        try {

            Thread.sleep(450); //allows time for the CloseLoginAnimation or other animation to complete
            int j=0;
            for(int i=0;i<255;i++) {
                if(i<151) {
                    //animated going up
                    testUI.taskbar.setLocation(-5, 830 - i);
                    testUI.plusIcon.setLocation(165, 845 - i);
                    testUI.groupIcon.setLocation(60, 845 - i);
                    testUI.settingsIcon.setLocation(270, 845 - i);

                    //animated going down
                    testUI.homeScreenIcon.setLocation(140, -155 + i);

                    //loop delay
                    TimeUnit.MICROSECONDS.sleep(1);
                }
                if(i>0 && i<84)
                {
                    testUI.homepageFrame.setBackground(new Color(255,172+i,172+i));
                }
                if(i==150)
                {
                    testUI.homepageFrame.setBorder(testUI.roundedTitledBorder);
                }
                if(i<173) {

                   j=i;
                }
                testUI.welcomeBack.setForeground(new Color(255 -i, 172 - j, 172 - j));



            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
