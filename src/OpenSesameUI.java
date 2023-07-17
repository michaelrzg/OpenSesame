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

    ImageIcon settingsIcon = new ImageIcon("res/settingsIcon.png");
    JButton settingsButton = new JButton();


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
        settingsButton.setVisible(true);

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
         settingsButton.setVisible(false);
       // groupsBackground.setIcon(groupsBacking);

        groupsBackground.setBounds(60,105,240,559);
        groupsBackground.setText("hello");
        groupsBackground.setFont(openSansBold);

        settingsButton.setBounds(1170,50,40,40);
        settingsButton.setIcon(settingsIcon);
        settingsButton.setFocusPainted(false);
        settingsButton.setOpaque(false);
        settingsButton.setContentAreaFilled(false);
        settingsButton.setBorderPainted(false);
        settingsButton.addActionListener(e->
        {
            System.out.println("Settings Pressed");
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













    }
    void initializePanel() throws InterruptedException {
        panel.add(loginButton);

        panel.add(usernameField);
        panel.add(passwordField);
        panel.add(login);
        panel.add(settingsButton);
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
















}
