import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

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
     static ImageIcon todosicon = new ImageIcon("res/Group_7.png");
     static JButton text = new JButton();
     static JLabel text2 = new JLabel("Hello",SwingConstants.CENTER);


     JScrollBar bar = new JScrollBar();


    OpenSesameUI() throws IOException, FontFormatException {
       initializeObjects();
       initializePanel();


    }

     void initializeObjects() throws IOException, FontFormatException {
        Font openSans = Font.createFont( Font.TRUETYPE_FONT,
                new FileInputStream("res/OpenSans-Bold.ttf") );
        frame.setSize(1280,760);
        frame.setLocationRelativeTo(null);
        frame.add(panel);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setIconImage(testUI.openSesameLogo.getImage());
        //panel.setBackground(new Color(229,174,174));
        //panel.setBackground(new Color(222,222,222));

        panel.setLayout(null);
        frame.setVisible(true);

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        OpenSesameIcon.setVisible(true);
        OpenSesameIcon.setBounds(56,8,192,73);
        OpenSesameIcon.setIcon(openSesameLogo);

       // groupsBackground.setIcon(groupsBacking);
        groupsBackground.setVisible(true);
        groupsBackground.setBounds(60,105,240,559);
        groupsBackground.setText("hello");
        groupsBackground.setFont(openSans);

        todos.setVisible(true);
        todos.setLocation(0,0);
        todos.setSize(1280,720);
        todos.setIcon(todosicon);
         Font derivedOpenSansFont = openSans.deriveFont(Font.BOLD,15);


         text.setIcon(new ImageIcon("res/groupButton.png"));
        text.setFont(derivedOpenSansFont);
        text.setBounds(62,163,220,45);
        text.setVisible(true);
        text.setOpaque(true);
        text.setContentAreaFilled(false);
         text.setBorderPainted(false);
         text.setFocusPainted(false);

         text2.setBounds(62,163,220,45);
         text2.setVisible(true);
         text2.setOpaque(false);
         text2.setFont(derivedOpenSansFont);






    }
    void initializePanel()
    {
        panel.add(text);
        panel.add(text2);
        //panel.add(OpenSesameIcon);
        //panel.add(groupsBackground);
       // panel.add(bar);
        panel.add(todos);

    }

}
