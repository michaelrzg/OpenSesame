import java.io.*;
import java.util.Random;

public class Password {
    public String encryptedPass;
    public int encryptMethodID;
    protected int pointer = 3;
    static int counter =0;

    PrintWriter pw = new PrintWriter(new FileWriter("src/UserData.Txt",true));

    //PASSWORDS CAN NOT INCLUDE '#' ',' or '&' symbols in sequence.
    Password(String originalPass) throws IOException {   Random rand = new Random();

        encryptMethodID  = rand.nextInt(3);


        switch (pointer)
        {
            case 0:
                encryptedPass = encryptMethod0(originalPass);
                break;
            case 1:
                encryptedPass = encryptMethod1(originalPass);
                break;
            case 2: encryptedPass = encryptMethod2(originalPass);
                break;
            case 3: encryptedPass = encryptMethod4(originalPass);
                break;
        }
        pw.append(counter+"," + encryptMethod2(encryptedPass) + "\n");
        pw.flush();
        counter++;
         

    }

    Password() throws IOException {};

    private String encryptMethod0(String originalPass)
    {  int index;
        String encryptedPass = "";
        for (int j = 0; j < originalPass.length(); j++) {
            index = Math.round((float) Math.random()*8+1);

            encryptedPass += index + Integer.toHexString( ((int) originalPass.charAt(j) ) ^ index )+"-";
            //converts into a line of 3 char for each char by using hexString value; adds a '-' symbol between each set of 3
            //System.out.println("[debug in Passowrd line 36] current epass text is " + encryptedPass);
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

    private String encryptMethod1(String originalPass)
    {   //WHEN
        Random rand = new Random();
        int key = rand.nextInt(10);
        //creates random single digit key variable which will be necessary to decode the password
        String [] array = originalPass.split("");
        //splits string into array
        String encryptedPass = "" + (key+54);
        for(int i=7;i<array.length+7;i++)
        {
          encryptedPass+="#@";
            //adds delimiting characters
            encryptedPass+= (i + array[i-7].charAt(0) + key );
            //changes char value of each character by current i value (7+) and a randomized key variable, which is hidden within in the encrypted password;
            //System.out.println("[debug line 72] current password in run " + i +  " is " + encryptedPass);

        }
        return encryptedPass;
    }
    private String decryptMethod1(String encryptedPass)
    {
        String decryptedPass= "";

        int key = Integer.parseInt(encryptedPass.substring(0,2)) - 54;
        //retreives the key value from the encrypted pass by taking the first term before delimiter and subtracting 54
        //System.out.println("[debug]derived key is "+key);

        String [] array = encryptedPass.substring(4).split("#@");
        //creates array of each char value excluding the 2 digit key(which is randomized single digit key from line 64 plus the arbitrary int 54) and first delimiter
        //System.out.println("[debug line 82, passed password is " + encryptedPass);

        for(int i=7;i<array.length+7;i++)
        {    array[i-7]= array[i-7].replace("#@","");
            //removing delimiters
            char a = (char)(Integer.parseInt(array[i-7])-i - key);
            //converts back into letters
            decryptedPass+=a;
            //rebuilds the string

        }
        return decryptedPass;

    }

    private String encryptMethod2 (String originalPass){
    char [] array = originalPass.toCharArray();
    String result = "";
    for (int i=0;i<array.length;i++){
        array[i] += i;
    }
    for(int i=0;i<array.length;i++)
    {
        result+= "-" + array[i] + ",";
    }

    return result;
    }
    private String decryptMethod2(String encryptedPass){
        String result = encryptedPass.replace("-","");
        result = result.replace(",","");
        String returnable = "";
        char [] array = result.toCharArray();
        for (int i=0;i<array.length;i++){
            array[i] -= i;
        }
        for(int i=0;i<array.length;i++)
        {
            returnable += array[i];
        }


        return returnable;
    }
    private String encryptMethod4(String pass)
    {
        return pass;

    }
    private String decryptMethod4(String pass)
    {
        return pass;
    }

    public String decryptPassword(String encryptedPass)
    {
        switch(pointer)
        {
            case 0: return decryptMethod0(encryptedPass);
            case 1: return decryptMethod1(encryptedPass);
            case 2 : return decryptMethod2(encryptedPass);
            case 3 : return decryptMethod4(encryptedPass);
        }
        return null;
    }
    public String decryptPassword()
    {
        switch(pointer)
        {
            case 0: return decryptMethod0(encryptedPass);
            case 1: return decryptMethod1(encryptedPass);
            case 2 : return decryptMethod2(encryptedPass);
            case 3 : return decryptMethod4(encryptedPass);
        }
        return null;
    }

    public void setPassword(String encryptedPass, int encryptMethodID)
    {
        this.encryptMethodID = encryptMethodID;
        this.encryptedPass=encryptedPass;
    }

}
