public class OpenHomepageAnimation implements Runnable{
    @Override
    public void run() {
        try {

            Thread.sleep(450); //allows time for the CloseLoginAnimation or other animation to complete
            for(int i=0;i<150;i++) {

                //animated going up
                testUI.taskbar.setLocation(0,830-i);
                testUI.plusIcon.setLocation(165,845-i);

                //animated going down
               testUI.homeScreenIcon.setLocation(140,-155+i);

                Thread.sleep(1);


            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
