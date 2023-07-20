public class CreateNewGroupAnimation implements Runnable{
    @Override
    public void run() {
        for(int i=0;i<260;i++){
        OpenSesameUI.createNewGroupContainer.setLocation(1280-i,103);
        OpenSesameUI.createAGroupLabel.setLocation(1335-i,OpenSesameUI.createAGroupLabel.getY());
        OpenSesameUI.DataLabel.setLocation(1300-i,OpenSesameUI.DataLabel.getY());

        OpenSesameUI.newGroupNameImage.setLocation(1304-i,OpenSesameUI.newGroupNameImage.getY());
        OpenSesameUI.newGroupNameTextField.setLocation(1320-i,OpenSesameUI.newGroupNameTextField.getY());

        OpenSesameUI.Platform1Image.setLocation(1304-i,OpenSesameUI.Platform1Image.getY());
        OpenSesameUI.Platform1TextField.setLocation(1320-i,OpenSesameUI.Platform1TextField.getY());

        OpenSesameUI.Platform2Image.setLocation(1304-i,OpenSesameUI.Platform2Image.getY());
        OpenSesameUI.Platform2TextField.setLocation(1320-i,OpenSesameUI.Platform2TextField.getY());

        OpenSesameUI.Username1TextField.setLocation(1320-i,OpenSesameUI.Username1TextField.getY());
        OpenSesameUI.Username1Image.setLocation(1304-i,OpenSesameUI.Username1Image.getY());

        OpenSesameUI.Username2TextField.setLocation(1320-i,OpenSesameUI.Username2TextField.getY());
        OpenSesameUI.Username2Image.setLocation(1304-i,OpenSesameUI.Username2Image.getY());


        OpenSesameUI.password1TextField.setLocation(1320-i,OpenSesameUI.password1TextField.getY());
        OpenSesameUI.Password1Image.setLocation(1304-i,OpenSesameUI.Password1Image.getY());

        OpenSesameUI.password2TextField.setLocation(1320-i,OpenSesameUI.password2TextField.getY());
        OpenSesameUI.Password2Image.setLocation(1304-i,OpenSesameUI.Password2Image.getY());

        OpenSesameUI.createGroup.setLocation(1300-i,OpenSesameUI.createGroup.getY());
        OpenSesameUI.createGroupLabel.setLocation(1300-i,OpenSesameUI.createGroupLabel.getY());




            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
