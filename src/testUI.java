import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.geom.RoundRectangle2D;

public class testUI {
    //test username is user; password is pass

    //class attributes
    GroupManager groupManager;
    //feel free to change color i was trying to find one that matched the logo well
    Color primaryColor = new Color(255,172,172);

    //UI objects
    public JPanel panel= new JPanel();
    public JFrame frame = new JFrame();
    public JLabel title = new JLabel("",SwingConstants.CENTER);
    Border blackline = BorderFactory.createEtchedBorder();

    public JLabel login = new JLabel("Please Login", SwingConstants.CENTER);

    public ImageIcon openSesameLogo = new ImageIcon("res/openSesameIcon.png");

    public JLabel loginFrame = new JLabel();
    LineBorder roundedLineBorder = new LineBorder(Color.GRAY, 2, true);
    TitledBorder roundedTitledBorder = new TitledBorder(roundedLineBorder, "");
    JTextField username = new JTextField("Username");
    JPasswordField password = new JPasswordField();
    JButton loginButton = new JButton("Login");


    testUI(GroupManager groupManager)
    {   this.groupManager=groupManager;
        frame.setSize(400,800);
        frame.setLocationRelativeTo(null);
        frame.add(panel);
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
        login.setLocation(90,200);
        //login.setHorizontalAlignment(JLabel.CENTER);
        login.setFont(new Font("Tahoma", Font.BOLD, 20));


        char c = 0;
        char [] empty = {};
        loginFrame.setBorder(roundedTitledBorder);
        loginFrame.setBackground(Color.white);
        loginFrame.setVisible(true);
        loginFrame.setOpaque(true);
        loginFrame.setBounds(45,200,300,350);

        username.setBounds(120,310,150,30);
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

        password.setBounds(120,360,150,30);
        password.setVisible(true);
        password.setEchoChar(c);
        password.setText("Password");
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
                            password.setText("Password");

                        }
                    }
                });
        loginButton.setBorder(roundedTitledBorder);
        loginButton.setBounds(99,420,200,50);
        loginButton.setBackground(primaryColor);

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

                }
            }
        });


        panel.add(username);
        panel.add(password);
        panel.add(loginButton);
        panel.add(login);
        panel.add(title);
        panel.add(loginFrame);


    }
    public void closeLogin(){}
    public void homepage(){};


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
