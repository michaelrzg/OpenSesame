import java.util.Random;

public class Password {
    private String encryptedPass;
    private int encryptMethodID;
    Password(String originalPass)
    {   Random rand = new Random();
        encryptMethodID = rand.nextInt(4);
        System.out.println("[debug in password line 10] rand variable is " + rand.nextInt(4) );
        String a = encryptMethod0(originalPass);
        System.out.println(a);
        System.out.println(decryptMethod0(a));
        switch (encryptMethodID)
        {
            case 0:
                encryptedPass = encryptMethod0(originalPass);
                encryptMethodID = 0;
                break;
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
        }

    }

    private String encryptMethod0(String originalPass)
    {  int index;
        String encryptedPass = "";
        for (int j = 0; j < originalPass.length(); j++) {
            index = Math.round((float) Math.random()*8+1);

            encryptedPass += index + Integer.toHexString( ((int) originalPass.charAt(j) ) ^ index )+"-";
            //converts into a line of 3 digits for each char by using hexStrings; adds a '-' symbol between each set of 3
            System.out.println("[debug in Passowrd line 36] current epass text is " + encryptedPass);
        }
        return encryptedPass.substring(0, encryptedPass.lastIndexOf("-"));
    }
    private String decryptMethod0(String encryptedPass)
    {
        encryptedPass = encryptedPass.replace("-", "");
        //step 1 , remove '-' symbols previously added
        String decryptedPass = "";

        for (int i = 0; i < encryptedPass.length(); i+=3) {

            String index =  encryptedPass.substring(i+1, i+3);
            //iterates through the string of numbers, grabs 3

            decryptedPass += (char) (Integer.parseInt(index, 16) ^ (Integer.parseInt(String.valueOf(encryptedPass.charAt(i)))));
            //reverses encryption of prev method, returns decrypted pass
        }
        return decryptedPass;
    }

}
