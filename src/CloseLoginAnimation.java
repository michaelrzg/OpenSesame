

public class CloseLoginAnimation implements Runnable{

    @Override
    public void run() {
        try {
        for(int i=0;i<500;i++) {

            //animated going left
            testUI.loginButton.setLocation(95- i, 440 );
            testUI.username.setLocation(95- i, 300 );
            testUI.password.setLocation(95 - i, 370);
            testUI.login.setLocation(90- i, 210 );
            testUI.loginFrame.setLocation(45- i, 200 );

            //animated going down
            testUI.or.setLocation(114 + i, 580);
            testUI.createNewAccountButton.setLocation(90+ i, 640 );
            testUI.title.setLocation(90+ i, 80 );

            //delayy to control animation speed
            Thread.sleep(1);


        }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
