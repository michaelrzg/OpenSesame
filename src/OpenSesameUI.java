import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

public class OpenSesameUI {

    static JFrame frame = new JFrame();
    static JPanel panel = new JPanel();
    static JLabel mainUiFrame = new JLabel();
    Border blackline = new RoundedBorder(new Color(217,217,217),20);
    static JLabel OpenSesameIcon = new JLabel();
     static ImageIcon openSesameLogo = new ImageIcon("res/OpenSesameIcon2.png");
     JLabel groupsBackground = new JLabel();
     static ImageIcon groupsBacking = new ImageIcon("res/GroupsBackground.png");

     static JLabel todos = new JLabel();
     static JLabel login = new JLabel();
     static ImageIcon todosicon = new ImageIcon("res/Group_7.png");
     static ImageIcon loginIcon = new ImageIcon("res/Login_Screen_1.png");
     static JButton loginButton = new JButton();
     static JTextField usernameField = new JTextField("            Username",SwingConstants.CENTER);
     static JPasswordField passwordField = new JPasswordField("            Password");

     static JButton group1Button = new JButton();
     static String group1Name =  "The Boys";
     static String group2Name = "The Belligerents";
     static String group3Name = "Casamigos";
     static String group4Name = "The Dynasty";
     static JLabel group1Label = new JLabel(group1Name,SwingConstants.CENTER);
      static JButton gruop2Button = new JButton();
     static JLabel group2Label = new JLabel(group2Name,SwingConstants.CENTER);
     static JButton group3Button = new JButton();
     static JLabel group3JLabel = new JLabel(group3Name,SwingConstants.CENTER);
     static JButton group4Button = new JButton();
     static JLabel group4JLabel = new JLabel(group4Name,SwingConstants.CENTER);
     static JLabel pleaseSelectGrooup = new JLabel("Select a Group to see its contents");
     static JLabel currentGroupLabel = new JLabel("",SwingConstants.CENTER);
    Font openSansBold = Font.createFont( Font.TRUETYPE_FONT,
            new FileInputStream("res/OpenSans-Bold.ttf") );
    Font openSans = Font.createFont( Font.TRUETYPE_FONT,
            new FileInputStream("res/OpenSans-Light.ttf") );
    Font derivedOpenSansFontBold = openSansBold.deriveFont(Font.BOLD,15);
    Font derivedOpenSansFont = openSans.deriveFont(Font.BOLD,15);

    ImageIcon AddGroups = new ImageIcon("res/groupIcon.png");
    JButton AddGroupsButton = new JButton();

    static JLabel createNewGroupContainer = new JLabel();
    static JLabel createAGroupLabel = new JLabel("Create a Group");
    static JLabel DataLabel = new JLabel("", SwingConstants.CENTER);
    static JLabel newGroupNameImage = new JLabel();
    static JTextField newGroupNameTextField = new JTextField();
    static JTextField Platform1TextField = new JTextField();
    static JLabel Platform1Image = new JLabel();

    static JTextField Username1TextField = new JTextField();
    static JLabel Username1Image = new JLabel();
    static JPasswordField password1TextField = new JPasswordField();
    static JLabel Password1Image = new JLabel();

    static JTextField Platform2TextField = new JTextField();
    static JLabel Platform2Image = new JLabel();

    static JTextField Username2TextField = new JTextField();
    static JLabel Username2Image = new JLabel();
    static JPasswordField password2TextField = new JPasswordField();
    static JLabel Password2Image = new JLabel();
    static JButton createGroup = new JButton();
    static JLabel createGroupLabel =new JLabel("Create", SwingConstants.CENTER);



    Platform [] group1Platforms = {new Platform("Netflix","timmy2001", new Password("password123"))
            ,new Platform("Hulu","EddyRichtofen",new Password("password123")),
             new Platform("Spotify", "TankDempsey",new Password("password123"))};

    Platform [] group2Platforms = {new Platform("Apple Music", "TakeoMasaki",new Password("password123")),
            new Platform("HBO Max", "NiclolaiBelinski",new Password("password123")),
            new Platform("SoundCloud", "DrGroph123",new Password("password123")),
            new Platform("Youtube Music", "LudwigMaxis", new Password("password123"))};
    Platform [] group3Platforms = {new Platform("Instagram", "SamanthaMaxis", new Password("password123")),
            new Platform("Snapchat", "PeteMccain", new Password("password123")),
            new Platform("Twitter", "theShadowMan",new Password("password123"))};

    Platform [] group4Platforms = {new Platform("Walmart+", "SaveMore", new Password("password123")),
            new Platform("ChickFilA", "BiscuitLover123", new Password("password123")),
            new Platform("McDonalds", "BigMacMan",new Password("password123"))};
    JLabel [][] slots = {
            {new JLabel(),new JLabel(), new JLabel(),new JLabel()},
            {new JLabel(),new JLabel(), new JLabel(),new JLabel()},
            {new JLabel(),new JLabel(), new JLabel(),new JLabel()},
            {new JLabel(),new JLabel(), new JLabel(),new JLabel()}};




     JScrollBar bar = new JScrollBar();


    OpenSesameUI() throws IOException, FontFormatException, InterruptedException {

        initializePanel();
        Thread.sleep(5);
        initializeObjects();
        login();

    }
    boolean checkCredentials(String user, char [] pass)
    {
        char [] p = {'d','e','v'};
        boolean passmatch = true;
        for(int i=0;i<3;i++)
        {
            if (p[i] != pass[i]) {
                passmatch = false;
                break;
            }
        }
        return user.equals("dev") && passmatch;
    }
    public void login()
    {
        login.setLocation(0,0);
        login.setSize(1280,720);
        login.setIcon(loginIcon);
        login.setVisible(true);



        loginButton.setBounds(540,428,200,42);
        loginButton.setContentAreaFilled(false);
        loginButton.setBorderPainted(false);
        loginButton.setFocusPainted(false);
        loginButton.addActionListener(e->
        {
            System.out.println("Login Button Pressed");
            //System.out.println(checkCredentials(usernameField.getText(),passwordField.getPassword()));
           // System.out.println(usernameField.getText());
           // System.out.println(Arrays.toString(passwordField.getPassword()));

            if(checkCredentials(usernameField.getText(),passwordField.getPassword()))
            {
                homepage();
            }

        });

        usernameField.setBounds(555,321,180,37);

        usernameField.setOpaque(false);
        usernameField.setFont(derivedOpenSansFont);
       usernameField.setBorder(BorderFactory.createEmptyBorder());
        usernameField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
               if(usernameField.getText().equals("            Username")){
                usernameField.setText("");
            }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if(usernameField.getText().equals(""))
                {
                    usernameField.setText("            Username");
                }
            }
        });
        usernameField.setVisible(true);

        passwordField.setBounds(555,362,180,38);
        char c =0;
        char [] empty = {};
        char [] defaultSet = {' ',' '  ,' '  ,' '  ,' '  ,' '  ,' '  ,' '  ,' '  ,' '  ,' '  ,' '  ,'P','a','s','s','w','o','r','d'};
        passwordField.setEchoChar(c);
        passwordField.setOpaque(false);
        passwordField.setFont(derivedOpenSansFont);
        passwordField.setBorder(BorderFactory.createEmptyBorder());
        passwordField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                //System.out.println(Arrays.toString(defaultSet));

                if(Arrays.equals(passwordField.getPassword(), defaultSet)) {
                    passwordField.setText("");
                    passwordField.setEchoChar('*');
                }
            }

            @Override
            public void focusLost(FocusEvent e) {

                if(passwordField.getPassword().length==0)
                {
                    passwordField.setEchoChar(c);
                    passwordField.setText("            Password");
                }
            }
        });
        passwordField.setVisible(true);


        loginButton.setVisible(true);




    }
    public void homepage()
    {
        login.setVisible(false);
        loginButton.setVisible(false);
        usernameField.setVisible(false);
        passwordField.setVisible(false);


        OpenSesameIcon.setVisible(true);
        groupsBackground.setVisible(true);
        todos.setVisible(true);
        group1Button.setVisible(true);
        group1Label.setVisible(true);
        gruop2Button.setVisible(true);
        group2Label.setVisible(true);
        group3Button.setVisible(true);
        group3JLabel.setVisible(true);
        group4Button.setVisible(true);
        group4JLabel.setVisible(true);
        pleaseSelectGrooup.setVisible(true);
        currentGroupLabel.setVisible(true);
        AddGroupsButton.setVisible(true);
        createNewGroupContainer.setVisible(true);
        createAGroupLabel.setVisible(true);
        newGroupNameImage.setVisible(true);
        DataLabel.setVisible(true);
        newGroupNameTextField.setVisible(true);
        Platform1TextField.setVisible(true);
        Platform1Image.setVisible(true);
        Username1Image.setVisible(true);
        Username1TextField.setVisible(true);
        Password1Image.setVisible(true);
        password1TextField.setVisible(true);
        createGroup.setVisible(true);
        createGroupLabel.setVisible(true);

    }

     void initializeObjects() throws IOException, FontFormatException {

        frame.setSize(1280,760);
        frame.setLocationRelativeTo(null);
        frame.add(panel);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setIconImage(testUI.openSesameLogo.getImage());
        //panel.setBackground(new Color(229,174,174));
        //panel.setBackground(new Color(222,222,222));
         frame.setVisible(true);
        panel.setLayout(null);
        login.setIcon(loginIcon);

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        OpenSesameIcon.setBounds(56,8,192,73);
        OpenSesameIcon.setIcon(openSesameLogo);

         OpenSesameIcon.setVisible(false);
         groupsBackground.setVisible(false);
         todos.setVisible(false);
         group1Button.setVisible(false);
         group1Label.setVisible(false);
         gruop2Button.setVisible(false);
         group2Label.setVisible(false);
         group3Button.setVisible(false);
         group3JLabel.setVisible(false);
         group4Button.setVisible(false);
         group4JLabel.setVisible(false);
         pleaseSelectGrooup.setVisible(false);
         currentGroupLabel.setVisible(false);
         AddGroupsButton.setVisible(false);
       // groupsBackground.setIcon(groupsBacking);

        groupsBackground.setBounds(60,105,240,559);
        groupsBackground.setText("hello");
        groupsBackground.setFont(openSansBold);

        AddGroupsButton.setBounds(1170,50,40,40);
        AddGroupsButton.setIcon(AddGroups);
        AddGroupsButton.setFocusPainted(false);
        AddGroupsButton.setOpaque(false);
        AddGroupsButton.setContentAreaFilled(false);
        AddGroupsButton.setBorderPainted(false);
        AddGroupsButton.addActionListener(e->
        {
            System.out.println("addGroups Pressed");
            CreateNewGroupOpenAnimation();
        });

        todos.setLocation(0,0);
        todos.setSize(1280,720);
        todos.setIcon(todosicon);


         group1Button.setIcon(new ImageIcon("res/groupButton.png"));
        group1Button.setFont(derivedOpenSansFontBold);
        group1Button.setBounds(72,192,200,42);

        group1Button.setOpaque(true);
        group1Button.setContentAreaFilled(false);
         group1Button.setBorderPainted(false);
         group1Button.setFocusPainted(false);
         group1Button.addActionListener(e -> {

             pleaseSelectGrooup.setVisible(false);
             drawData(group1Platforms);
             currentGroupLabel.setText(group1Name);
         });

         group1Label.setBounds(72,192,200,42);
         group1Label.setOpaque(false);
         group1Label.setFont(derivedOpenSansFontBold);


           gruop2Button.setIcon(new ImageIcon("res/groupButton.png"));
        gruop2Button.setFont(derivedOpenSansFontBold);
        gruop2Button.setBounds(72,258,200,42);
        gruop2Button.setOpaque(true);
        gruop2Button.setContentAreaFilled(false);
         gruop2Button.setBorderPainted(false);
         gruop2Button.setFocusPainted(false);
         gruop2Button.addActionListener(e -> {
             pleaseSelectGrooup.setVisible(false);
             drawData(group2Platforms);
             currentGroupLabel.setText(group2Name);
         });

          group2Label.setBounds(72,258,200,42);
         group2Label.setOpaque(false);
         group2Label.setFont(derivedOpenSansFontBold);

        group3Button.setFont(derivedOpenSansFontBold);
        group3Button.setBounds(72,324,200,42);
        group3Button.setOpaque(true);
        group3Button.setContentAreaFilled(false);
         group3Button.setBorderPainted(false);
         group3Button.setFocusPainted(false);
        group3Button.setIcon(new ImageIcon("res/groupButton.png"));
         group3Button.addActionListener(e -> {

             pleaseSelectGrooup.setVisible(false);
             drawData(group3Platforms);
             currentGroupLabel.setText(group3Name);
         });
      
          group3JLabel.setBounds(72,324,200,42);
         group3JLabel.setOpaque(false);
         group3JLabel.setFont(derivedOpenSansFontBold);

        group4Button.setFont(derivedOpenSansFontBold);
        group4Button.setBounds(72,390,200,42);
        group4Button.setOpaque(true);
        group4Button.setContentAreaFilled(false);
         group4Button.setBorderPainted(false);
         group4Button.setFocusPainted(false);
        group4Button.setIcon(new ImageIcon("res/groupButton.png"));
         group4Button.addActionListener(e -> {

             pleaseSelectGrooup.setVisible(false);
             drawData(group4Platforms);
             currentGroupLabel.setText(group4Name);
         });
      
          group4JLabel.setBounds(72,390,200,42);
         group4JLabel.setOpaque(false);
         group4JLabel.setFont(derivedOpenSansFontBold);

         slots[0][0].setBounds(400,192,200,42);
         slots[0][0].setVisible(true);
         slots[0][0].setFont(derivedOpenSansFontBold);
         //slots[0][0].setText("Test");

         slots[0][1].setBounds(700,192,200,42);
         slots[0][1].setVisible(true);
         slots[0][1].setFont(derivedOpenSansFontBold);
        // slots[0][1].setText("Test");

         slots[0][2].setBounds(975,192,200,42);
         slots[0][2].setVisible(true);
         slots[0][2].setFont(derivedOpenSansFontBold);
        // slots[0][2].setText("Test");

         slots[1][0].setBounds(400,258,200,42);
         slots[1][0].setVisible(true);
         slots[1][0].setFont(derivedOpenSansFontBold);
        // slots[1][0].setText("Test");

         slots[1][1].setBounds(700,258,200,42);
         slots[1][1].setVisible(true);
         slots[1][1].setFont(derivedOpenSansFontBold);
      //   slots[1][1].setText("Test");

         slots[1][2].setBounds(975,258,200,42);
         slots[1][2].setVisible(true);
         slots[1][2].setFont(derivedOpenSansFontBold);
       //  slots[1][2].setText("Test");

         slots[2][0].setBounds(400,324,200,42);
         slots[2][0].setVisible(true);
         slots[2][0].setFont(derivedOpenSansFontBold);
       //  slots[2][0].setText("Test");

         slots[2][1].setBounds(700,324,200,42);
         slots[2][1].setVisible(true);
         slots[2][1].setFont(derivedOpenSansFontBold);
        // slots[2][1].setText("Test");

         slots[2][2].setBounds(975,324,200,42);
         slots[2][2].setVisible(true);
         slots[2][2].setFont(derivedOpenSansFontBold);
       //  slots[2][2].setText("Test");

         slots[3][0].setBounds(400,390,200,42);
         slots[3][0].setVisible(true);
         slots[3][0].setFont(derivedOpenSansFontBold);
       //  slots[3][0].setText("Test");

         slots[3][1].setBounds(700,390,200,42);
         slots[3][1].setVisible(true);
         slots[3][1].setFont(derivedOpenSansFontBold);
      //   slots[3][1].setText("Test");

         slots[3][2].setBounds(975,390,200,42);
         slots[3][2].setVisible(true);
         slots[3][2].setFont(derivedOpenSansFontBold);
       //  slots[3][2].setText("Test");

         pleaseSelectGrooup.setBounds(650,350,300,42);
         pleaseSelectGrooup.setFont(derivedOpenSansFontBold);

         currentGroupLabel.setBounds(650,45,200,42);
         currentGroupLabel.setFont(new Font("OpenSans", Font.BOLD,30));

         createNewGroupContainer.setBounds(1280,103,400,620);
         createNewGroupContainer.setIcon(new ImageIcon("res/GroupsBackground.png"));

         createAGroupLabel.setFont(new Font("OpenSans", Font.PLAIN, 20));
         createAGroupLabel.setBounds(1350,125,200,50);




        frame.getRootPane().setDefaultButton(loginButton);

        DataLabel.setFont(new Font("OpenSans", Font.PLAIN, 15));
        DataLabel.setBounds(1350,160,200,50);
        DataLabel.setText("Name:");

        newGroupNameImage.setIcon(new ImageIcon("res/TextBox.png"));
        newGroupNameImage.setBounds(1350,190,200,50);

        newGroupNameTextField.setFont(new Font("OpenSans", Font.PLAIN,10));
        newGroupNameTextField.setText("Enter Group Name");
        newGroupNameTextField.setBounds(1355,196,200,40);

         newGroupNameTextField.setOpaque(false);
         newGroupNameTextField.setFont(derivedOpenSansFont);
         newGroupNameTextField.setBorder(BorderFactory.createEmptyBorder());
         newGroupNameTextField.addFocusListener(new FocusListener() {
             @Override
             public void focusGained(FocusEvent e) {
                 if(newGroupNameTextField.getText().equals("    Enter Group Name")){
                     newGroupNameTextField.setText("");
                 }
             }

             @Override
             public void focusLost(FocusEvent e) {
                 if(newGroupNameImage.getText().equals(""))
                 {
                     newGroupNameTextField.setText("    Enter Group Name");
                 }
             }
         });

         Platform1Image.setIcon(new ImageIcon("res/TextBox.png"));
        Platform1Image.setBounds(1350,250,200,50);

        Platform1TextField.setFont(new Font("OpenSans", Font.PLAIN,10));
        Platform1TextField.setText("           Platform 1");
        Platform1TextField.setBounds(1355,256,200,40);

         Platform1TextField.setOpaque(false);
         Platform1TextField.setFont(derivedOpenSansFont);
         Platform1TextField.setBorder(BorderFactory.createEmptyBorder());
         Platform1TextField.addFocusListener(new FocusListener() {
             @Override
             public void focusGained(FocusEvent e) {
                 if(Platform1TextField.getText().equals("           Platform 1")){
                     Platform1TextField.setText("");
                 }
             }

             @Override
             public void focusLost(FocusEvent e) {
                 if(Platform1TextField.getText().equals(""))
                 {
                     Platform1TextField.setText("           Platform 1");
                 }
             }
         });

        Username1Image.setIcon(new ImageIcon("res/TextBox.png"));
        Username1Image.setBounds(1350,285,200,50);

        Username1TextField.setFont(new Font("OpenSans", Font.PLAIN,10));
        Username1TextField.setText("          Username 1");
        Username1TextField.setBounds(1355,291,200,40);

         Username1TextField.setOpaque(false);
         Username1TextField.setFont(derivedOpenSansFont);
         Username1TextField.setBorder(BorderFactory.createEmptyBorder());
         Username1TextField.addFocusListener(new FocusListener() {
             @Override
             public void focusGained(FocusEvent e) {
                 if(Username1TextField.getText().equals("          Username 1")){
                     Username1TextField.setText("");
                 }
             }

             @Override
             public void focusLost(FocusEvent e) {
                 if(Username1TextField.getText().equals(""))
                 {
                     Username1TextField.setText("          Username 1");
                 }
             }
         });

         Password1Image.setIcon(new ImageIcon("res/TextBox.png"));
         Password1Image.setBounds(1350,320,200,50);
         char zero = 0;
         password1TextField.setFont(new Font("OpenSans", Font.PLAIN,10));
         password1TextField.setText("          Password 1");
         password1TextField.setBounds(1355,326,200,40);

         password1TextField.setOpaque(false);
         password1TextField.setFont(derivedOpenSansFont);
         password1TextField.setBorder(BorderFactory.createEmptyBorder());
         password1TextField.setEchoChar(zero);
         password1TextField.addFocusListener(new FocusListener() {
             @Override
             public void focusGained(FocusEvent e) {

                 password1TextField.setText("");
                 password1TextField.setEchoChar('*');
             }

             @Override
             public void focusLost(FocusEvent e) {

             }
         });

         createGroup.setIcon(new ImageIcon("res/groupButton.png"));
         createGroup.setBounds(1350,600,200,50);
         createGroup.setOpaque(false);
         createGroup.setBorder(BorderFactory.createEmptyBorder());
         createGroup.setContentAreaFilled(false);
         createGroup.setFocusPainted(false);

         createGroupLabel.setBounds(1350,600,200,50);
         createGroupLabel.setFont(new Font("OpenSans", Font.PLAIN, 18));



         Platform2Image.setIcon(new ImageIcon("res/TextBox.png"));
         Platform2Image.setBounds(1350,376,200,50);

         Platform2TextField.setFont(new Font("OpenSans", Font.PLAIN,10));
         Platform2TextField.setText("           Platform 1");
         Platform2TextField.setBounds(1355,382,200,40);

         Platform2TextField.setOpaque(false);
         Platform2TextField.setFont(derivedOpenSansFont);
         Platform2TextField.setBorder(BorderFactory.createEmptyBorder());
         Platform2TextField.addFocusListener(new FocusListener() {
             @Override
             public void focusGained(FocusEvent e) {
                 if(Platform2TextField.getText().equals("           Platform 1")){
                     Platform2TextField.setText("");
                 }
             }

             @Override
             public void focusLost(FocusEvent e) {
                 if(Platform2TextField.getText().equals(""))
                 {
                     Platform2TextField.setText("           Platform 1");
                 }
             }
         });

         Username2Image.setIcon(new ImageIcon("res/TextBox.png"));
         Username2Image.setBounds(1350,411,200,50);

         Username2TextField.setFont(new Font("OpenSans", Font.PLAIN,10));
         Username2TextField.setText("          Username 1");
         Username2TextField.setBounds(1355,417,200,40);

         Username2TextField.setOpaque(false);
         Username2TextField.setFont(derivedOpenSansFont);
         Username2TextField.setBorder(BorderFactory.createEmptyBorder());
         Username2TextField.addFocusListener(new FocusListener() {
             @Override
             public void focusGained(FocusEvent e) {
                 if(Username2TextField.getText().equals("          Username 1")){
                     Username2TextField.setText("");
                 }
             }

             @Override
             public void focusLost(FocusEvent e) {
                 if(Username2TextField.getText().equals(""))
                 {
                     Username2TextField.setText("          Username 1");
                 }
             }
         });

         Password2Image.setIcon(new ImageIcon("res/TextBox.png"));
         Password2Image.setBounds(1350,446,200,50);

         password2TextField.setFont(new Font("OpenSans", Font.PLAIN,10));
         password2TextField.setText("          Password 1");
         password2TextField.setBounds(1355,452,200,40);

         password2TextField.setOpaque(false);
         password2TextField.setFont(derivedOpenSansFont);
         password2TextField.setBorder(BorderFactory.createEmptyBorder());
         password2TextField.setEchoChar(zero);
         password2TextField.addFocusListener(new FocusListener() {
             @Override
             public void focusGained(FocusEvent e) {

                 password2TextField.setText("");
                 password2TextField.setEchoChar('*');
             }

             @Override
             public void focusLost(FocusEvent e) {

             }
         });















    }
    void initializePanel() throws InterruptedException {

        panel.add(createGroupLabel);
        panel.add(createGroup);
        panel.add(Platform1TextField);
        panel.add(Platform2TextField);
        panel.add(Platform2Image);
        panel.add(Platform1Image);
        panel.add(password1TextField);
        panel.add(password2TextField);
        panel.add(Password1Image);
        panel.add(Password2Image);
        panel.add(Username1TextField);
        panel.add(Username2TextField);
        panel.add(Username1Image);
        panel.add(Username2Image);
        panel.add(newGroupNameTextField);
        panel.add(createAGroupLabel);
        panel.add(newGroupNameImage);
        panel.add(DataLabel);

        panel.add(loginButton);
        panel.add(createNewGroupContainer);
        panel.add(usernameField);
        panel.add(passwordField);
        panel.add(login);
        panel.add(AddGroupsButton);
        panel.add(group1Button);
        panel.add(group1Label);
        panel.add(gruop2Button);
        panel.add(group2Label);
        panel.add(group3Button);
        panel.add(group3JLabel);
        panel.add(group4Button);
        panel.add(group4JLabel);
        panel.add(currentGroupLabel);

        for(JLabel[] i : slots)
        {
            for(JLabel j : i)
            {
                panel.add(j);
            }

        }
        panel.add(pleaseSelectGrooup);
        //panel.add(OpenSesameIcon);
        //panel.add(groupsBackground);
       // panel.add(bar);
        panel.add(todos);

    }
    void drawData(Platform [] platforms)
    {
        for(JLabel[] i : slots)
        {
            for(JLabel j : i)
            {
                j.setText("");
            }
        }
        for (int i=0;i<platforms.length;i++)
        {
            slots[i][0].setText(platforms[i].platformName);
            slots[i][1].setText(platforms[i].platformUsername);
            slots[i][2].setText(platforms[i].encryptedPlatformPassword.decryptPassword());

        }
    }
    void CreateNewGroupOpenAnimation ()
    {
        CreateNewGroupAnimation animation = new CreateNewGroupAnimation();
        Thread thread = new Thread(animation);
        thread.start();
    }
















}
