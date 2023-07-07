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

    Color primaryColor = new Color(255,172,172);
    //Color primaryColor = new Color(124,220,220);
    // feel free to change color i was trying to find one that matched the logo well

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
    static JLabel incorrectPasswordLabel = new JLabel();

    //Homepage objects

    static JLabel homeScreenIcon = new JLabel();
    static JLabel taskbar = new JLabel();
    static JButton plusIcon = new JButton();
    static ImageIcon plusIconPng = new ImageIcon("res/plusIcon.png");
    static JButton groupIcon = new JButton();
    static ImageIcon groupsIconPng = new ImageIcon("res/groupIcon.png");
    static JButton settingsIcon = new JButton();
    static ImageIcon settingsIconPng = new ImageIcon("res/settingsIcon.png");
    static JLabel addFriendsLabel = new JLabel("Add Friends or Groups");
    static JLabel addFriendsFrame = new JLabel();
    static JComboBox comboBox = new JComboBox();
    Group [] groupsIntoArray;
    static JLabel recentGroupsLabel = new JLabel("Recent Groups");
    static JLabel homepageFrame = new JLabel();
    static JLabel searchBarTemp = new JLabel();
    static ImageIcon searchbarPng = new ImageIcon("res/serachbar.png");
    static JButton groupPositionA = new JButton();
    static JButton groupPositionB = new JButton();
    static JButton groupPositionC = new JButton();
    static JButton groupPositionD = new JButton();
    static boolean drawA = false;
    static boolean drawB = false;
    static boolean drawC = false;
    static boolean drawD = false;
    static Color groupColor = new Color(186,82,82);
    static JLabel plusMenuOr = new JLabel("- - - - - - or - - - - - -");
    static JLabel createNewGroupLabel = new JLabel("Create a New Group");
    static JButton createNewGroupButton = new JButton();
    static boolean taskbarIsOpening = false;


    public testUI(GroupManager groupManager)
    {   this.groupManager=groupManager;
        initializePanel();
       loginPage();
       groupsIntoArray = new Group[groupManager.groups.size()];
       for(int i=0;i<groupsIntoArray.length;i++)
       {
           groupsIntoArray[i] = groupManager.groups.get(i);
       }
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

        incorrectPasswordLabel.setForeground(Color.red);
        incorrectPasswordLabel.setBounds(100,465,300,100);
        incorrectPasswordLabel.setFont(new Font("Tahoma", Font.PLAIN, 10));
        incorrectPasswordLabel.setVisible(false);
        incorrectPasswordLabel.setText("<html>Your login details don't match our records,<br/>&nbsp;&nbsp;&nbsp;" +
                "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;please try again.<html>");


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
                } else
                {
                    incorrectPasswordLabel.setVisible(true);
                }



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
    {  incorrectPasswordLabel.setVisible(false);
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
                taskbarIsOpening=true;

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
        addFriendsLabel.setFont(new Font("Tahoma", Font.TRUETYPE_FONT, 15));
        addFriendsLabel.setVisible(true);

        createNewGroupLabel.setBounds(200,-100,175,85);
        createNewGroupLabel.setFont(new Font("Tahoma", Font.TRUETYPE_FONT, 15));
        createNewGroupLabel.setVisible(true);

        createNewGroupButton.setBounds(200,-100,175,50);
        createNewGroupButton.setFont(new Font("Tahoma", Font.TRUETYPE_FONT, 15));
        createNewGroupButton.setVisible(true);
        createNewGroupButton.setOpaque(true);
        createNewGroupButton.setContentAreaFilled(true);
        createNewGroupButton.setBorderPainted(false);
        createNewGroupButton.setFocusPainted(false);
        createNewGroupButton.setBorderPainted(true);
        createNewGroupButton.setBorder(blackline);
        createNewGroupButton.setBackground(new Color(144,140,140));
        createNewGroupButton.setText("Create");


        plusMenuOr.setBounds(200,-100,175,85);
        plusMenuOr.setVisible(true);
        plusMenuOr.setFont(new Font("Tahoma", Font.TRUETYPE_FONT, 20));

        addFriendsFrame.setBorder(roundedTitledBorder);
        addFriendsFrame.setBackground(Color.white);
        addFriendsFrame.setVisible(true);
        addFriendsFrame.setOpaque(true);
        addFriendsFrame.setBounds(45,900,300,550);

        comboBox = new JComboBox(groupsIntoArray);
        comboBox.setBounds(85,830,210,20);
        comboBox.setVisible(true);

        recentGroupsLabel.setFont(new Font("Tahoma", Font.TRUETYPE_FONT, 20));
        recentGroupsLabel.setBounds(130,135,150,50);
        recentGroupsLabel.setForeground(new Color(255,172,172));


        homepageFrame.setBackground(Color.white);
        homepageFrame.setVisible(true);
        homepageFrame.setOpaque(true);
        homepageFrame.setBounds(45,90,300,570);
        homepageFrame.setBackground(new Color(255,172,172));

        searchBarTemp.setIcon(searchbarPng);
        searchBarTemp.setVisible(true);
        searchBarTemp.setBounds(125,900, 250,52);

        groupPositionA.setBounds(95,210,200,75);
        groupPositionA.setFont(new Font("Tahoma", Font.ITALIC, 20));
        groupPositionA.setVisible(false);
        groupPositionA.setBorder(new RoundedBorder(15));
        groupPositionA.setOpaque(false);
        groupPositionA.setContentAreaFilled(true);
        groupPositionA.setBorderPainted(true);
        groupPositionA.setFocusPainted(false);
        groupPositionA.setBackground(groupColor);

        groupPositionB.setBounds(95,310,200,75);
        groupPositionB.setFont(new Font("Tahoma", Font.ITALIC, 20));
        groupPositionB.setVisible(false);
        groupPositionB.setBorder(blackline);
        groupPositionB.setOpaque(true);
        groupPositionB.setContentAreaFilled(true);
        groupPositionB.setBorderPainted(true);
        groupPositionB.setFocusPainted(false);
        groupPositionB.setBackground(groupColor);

        groupPositionC.setBounds(95,410,200,75);
        groupPositionC.setFont(new Font("Tahoma", Font.ITALIC, 20));
        groupPositionC.setVisible(false);
        groupPositionC.setBorder(blackline);
        groupPositionC.setOpaque(true);
        groupPositionC.setContentAreaFilled(true);
        groupPositionC.setBorderPainted(true);
        groupPositionC.setFocusPainted(false);
        groupPositionC.setBackground(new Color(95,96,96));

        groupPositionD.setBounds(95,510,200,75);
        groupPositionD.setFont(new Font("Tahoma", Font.ITALIC, 20));
        groupPositionD.setVisible(false);
        groupPositionD.setBorder(blackline);
        groupPositionD.setOpaque(true);
        groupPositionD.setContentAreaFilled(true);
        groupPositionD.setBorderPainted(true);
        groupPositionD.setFocusPainted(false);
        groupPositionD.setBackground(primaryColor);


        drawGroups();

        OpenHomepageAnimation a = new OpenHomepageAnimation();
        Thread b = new Thread(a);
        b.start();


    };



    public void initializePanel()
    {   panel.add(searchBarTemp);
        panel.add(plusMenuOr);
        //Login objects
        panel.add(createNewAccountButton);
        panel.add(or);
        panel.add(username);
        panel.add(password);
        panel.add(loginButton);
        panel.add(login);
        panel.add(title);
        panel.add(incorrectPasswordLabel);
        panel.add(loginFrame);

        //plus menu objects
        panel.add(createNewGroupButton);
        panel.add(createNewGroupLabel);
        panel.add(addFriendsLabel);
        panel.add(addFriendsFrame);


        //homepage objects
        panel.add(settingsIcon);
        panel.add(groupIcon);
        panel.add(plusIcon);


        panel.add(homeScreenIcon);
        panel.add(taskbar);
        panel.add(groupPositionA);
        panel.add(groupPositionB);
        panel.add(groupPositionC);
        panel.add(groupPositionD);
        panel.add(recentGroupsLabel);
        panel.add(homepageFrame);

        panel.add(comboBox);



    }
    public void drawGroups()
    {   int start =200;

        for(int i=0;i<groupsIntoArray.length;i++)
        {
            if(i<4)
            {
                switch (i) {

                    case 0:
                        drawA =true;
                        groupPositionA.setText(groupsIntoArray[i].groupName);

                        break;
                    case 1:
                        drawB=true;
                        groupPositionB.setText(groupsIntoArray[i].groupName);
                        break;
                    case 2:
                        drawC=true;
                        groupPositionC.setText(groupsIntoArray[i].groupName);
                        break;
                    case 3:
                        drawD=true;
                        groupPositionD.setText(groupsIntoArray[i].groupName);
                        break;

            }
            }
        }
    }

    public void openGroup(Group group)
    {

    }

    public void login()
    {

    }

}
