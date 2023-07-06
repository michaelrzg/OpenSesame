import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class testUI {
    //test username is user; password is pass

    //class attributes
    GroupManager groupManager;

    Color primaryColor = new Color(255,172,172); //feel free to change color i was trying to find one that matched the logo well

    //Login objects
    public static JPanel panel= new JPanel();
    public static JFrame frame = new JFrame();
    public static JLabel title = new JLabel("",SwingConstants.CENTER);
    Border blackline = BorderFactory.createEtchedBorder();
    public static JLabel login = new JLabel("Please Login", SwingConstants.CENTER);
    public static ImageIcon openSesameLogo = new ImageIcon("res/openSesameIcon.png");
    public static JLabel loginFrame = new JLabel();
    static LineBorder roundedLineBorder = new LineBorder(Color.GRAY, 2, true);
    static TitledBorder roundedTitledBorder = new TitledBorder(roundedLineBorder, "");
    static JTextField username = new JTextField("  Username");
    static JPasswordField password = new JPasswordField();
    static JButton loginButton = new JButton("Login");
    static  JLabel or = new JLabel("- - - - - or - - - - -");
    static JButton createNewAccountButton = new JButton();

    //Homepage objects

    static JLabel homeScreenIcon = new JLabel();
    static JLabel taskbar = new JLabel();
    static JButton plusIcon = new JButton();
    static ImageIcon plusIconPng = new ImageIcon("res/plusIcon.png");
    static JButton groupIcon = new JButton();
    static ImageIcon groupsIconPng = new ImageIcon("res/groupIcon.png");
    static JButton settingsIcon = new JButton();
    static ImageIcon settingsIconPng = new ImageIcon("res/settingsIcon.png");
    static JLabel addFriendsLabel = new JLabel("Add Friends");
    static JLabel addFriendsFrame = new JLabel();
    static JComboBox comboBox = new JComboBox();
    Object [] groupsIntoArray;
    static JLabel welcomeBack = new JLabel("Welcome Back");
    static JLabel homepageFrame = new JLabel();
    static JLabel searchBarTemp = new JLabel();
    static ImageIcon searchbarPng = new ImageIcon("res/serachbar.png");

    public testUI(GroupManager groupManager)
    {   this.groupManager=groupManager;
        initializePanel();
       loginPage();
         groupsIntoArray = groupManager.groups.toArray();

    }

    public testUI() {
    }

    public void loginPage()
    {
        frame.setSize(400,800);
        frame.setLocationRelativeTo(null);
        frame.add(panel);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setIconImage(openSesameLogo.getImage());
        //panel.setBackground(new Color(229,174,174));
        //panel.setBackground(new Color(222,222,222));
        panel.setBackground(primaryColor);

        panel.setLayout(null);
        frame.setVisible(true);


        title.setIcon(openSesameLogo);
        title.setBounds(90,80,200,85);
        //title.setLocation(50,);
        title.setVisible(true);

        login.setVisible(true);
        login.setSize(200,90);
        login.setLocation(90,210);
        //login.setHorizontalAlignment(JLabel.CENTER);
        login.setFont(new Font("Tahoma", Font.BOLD, 20));


        char c = 0;
        char [] empty = {};
        loginFrame.setBorder(roundedTitledBorder);
        loginFrame.setBackground(Color.white);
        loginFrame.setVisible(true);
        loginFrame.setOpaque(true);
        loginFrame.setBounds(45,200,300,350);

        username.setBounds(95,300,200,50);
        username.setVisible(true);
        username.setBorder(roundedTitledBorder);
        username.addFocusListener(
                new FocusListener() {

                    public void focusGained(FocusEvent e)
                    {
                        username.setText("");
                    }
                    public void focusLost(FocusEvent e) {}
                });

        password.setBounds(95,370,200,50);
        password.setVisible(true);
        password.setEchoChar(c);
        password.setText("  Password");
        password.setBorder(roundedTitledBorder);
        password.addFocusListener(
                new FocusListener() {

                    public void focusGained(FocusEvent e)
                    {
                        password.setText("");
                        password.setEchoChar('*');
                    }
                    public void focusLost(FocusEvent e)
                    {
                        if(password.getPassword() == (empty))
                        {   password.setEchoChar(c);
                            password.setText("  Password");

                        }
                    }
                });
        loginButton.setBorder(roundedTitledBorder);
        loginButton.setBounds(95,440,200,50);
        loginButton.setBackground(primaryColor);
        loginButton.setFocusPainted(false);
        loginButton.setFont(new Font("Tahoma", Font.PLAIN, 16));

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               /*
                String pass="";
                for(int i=0;i<password.getPassword().length;i++)
                {
                    pass+=password.getPassword()[i];
                }
                if(username.getText().equals("user") && pass.equals("pass"))
                {
                    System.out.println("login success");
                    closeLogin();
                    homepage();
                }

                */
                closeLogin();
                homepage();
            }
        });

        or.setBounds(115, 580, 400,30);
        or.setVisible(true);
        or.setFont(new Font("Tahoma", Font.ITALIC, 18));

        createNewAccountButton.setBorder(roundedTitledBorder);
        createNewAccountButton.setBounds(90,640,200,50);
        createNewAccountButton.setBackground(new Color(144,140,140));
        createNewAccountButton.setVisible(true);
        createNewAccountButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
        createNewAccountButton.setText("Create New Account");
        createNewAccountButton.setFocusPainted(false);


    }
    public void closeLogin()
    {
       CloseLoginAnimation a = new CloseLoginAnimation();
       Thread b = new Thread(a);
       b.start();

    }
    public void homepage()
    {
        homeScreenIcon.setVisible(true);
        homeScreenIcon.setBounds(200,-135,200,85); //intentially left off screen
        homeScreenIcon.setFont(new Font("Tahoma", Font.TRUETYPE_FONT, 35));
        homeScreenIcon.setIcon(new ImageIcon("res/openSesameIconHomepage.png"));

        taskbar.setBorder(roundedTitledBorder);
        taskbar.setBackground(Color.white);
        taskbar.setOpaque(true);
        taskbar.setVisible(true);
        taskbar.setBounds(0,800,400,800);
        taskbar.setBackground(new Color(238,185,185));

        plusIcon.setIcon(plusIconPng);
        plusIcon.setBounds(375,825,50,50);
        plusIcon.setOpaque(false);
        plusIcon.setContentAreaFilled(false);
        plusIcon.setBorderPainted(false);
        plusIcon.setFocusPainted(false);
        plusIcon.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("plus icon pressed");
                OpenPlusMenuAnimation a = new OpenPlusMenuAnimation();
                Thread x = new Thread(a);
                x.start();
            }
        });
        groupIcon.setIcon(groupsIconPng);
        groupIcon.setVisible(true);
        groupIcon.setBounds(375,825,50,50);
        groupIcon.setOpaque(false);
        groupIcon.setContentAreaFilled(false);
        groupIcon.setBorderPainted(false);
        groupIcon.setFocusPainted(false);
        groupIcon.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("groupIcon pressed");

            }
        });

        settingsIcon.setIcon(settingsIconPng);
        settingsIcon.setVisible(true);
        settingsIcon.setBounds(375,825,50,50);
        settingsIcon.setOpaque(false);
        settingsIcon.setContentAreaFilled(false);
        settingsIcon.setBorderPainted(false);
        settingsIcon.setFocusPainted(false);
        settingsIcon.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Settings Pressed");
            }
        });

        addFriendsLabel.setBounds(200,-100,175,85);
        addFriendsLabel.setFont(new Font("Tahoma", Font.TRUETYPE_FONT, 20));
        addFriendsLabel.setVisible(true);

        addFriendsFrame.setBorder(roundedTitledBorder);
        addFriendsFrame.setBackground(Color.white);
        addFriendsFrame.setVisible(true);
        addFriendsFrame.setOpaque(true);
        addFriendsFrame.setBounds(45,900,300,550);

        comboBox = new JComboBox(groupsIntoArray);
        comboBox.setBounds(85,830,210,20);
        comboBox.setVisible(true);

        welcomeBack.setFont(new Font("Tahoma", Font.TRUETYPE_FONT, 20));
        welcomeBack.setBounds(130,105,150,50);
        welcomeBack.setForeground(new Color(255,172,172));


        homepageFrame.setBackground(Color.white);
        homepageFrame.setVisible(true);
        homepageFrame.setOpaque(true);
        homepageFrame.setBounds(45,90,300,570);
        homepageFrame.setBackground(new Color(255,172,172));

        searchBarTemp.setIcon(searchbarPng);
        searchBarTemp.setVisible(true);
        searchBarTemp.setBounds(125,900, 250,52);


        OpenHomepageAnimation a = new OpenHomepageAnimation();
        Thread b = new Thread(a);
        b.start();


    };



    public void initializePanel()
    {   panel.add(searchBarTemp);
        //Login objects
        panel.add(createNewAccountButton);
        panel.add(or);
        panel.add(username);
        panel.add(password);
        panel.add(loginButton);
        panel.add(login);
        panel.add(title);
        panel.add(loginFrame);

        //plus menu objects

        panel.add(addFriendsLabel);
        panel.add(addFriendsFrame);


        //homepage objects
        panel.add(settingsIcon);
        panel.add(groupIcon);
        panel.add(plusIcon);

        panel.add(homeScreenIcon);
        panel.add(taskbar);
        panel.add(welcomeBack);
        panel.add(homepageFrame);

        panel.add(comboBox);



    }
    public void drawGroups()
    {   int start =200;
        for (Group i : groupManager.groups)
        {

            JButton button = new JButton();
            button.setBackground(new Color(59, 89, 182));
            button.setText(i.groupName);
            button.setVisible(true);
            button.setBorder(blackline);
            button.setBorderPainted(true);
            button.setBounds(50,start, 100,50);
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    openGroup(i);
                }
            });

            panel.add(button);
            start+=60;
        }
    }

    public void openGroup(Group group)
    {

    }

    public void login()
    {

    }

}
