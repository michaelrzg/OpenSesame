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
     static JLabel text2 = new JLabel("The Boys",SwingConstants.CENTER);
      static JButton gruop2Button = new JButton();
     static JLabel group2Label = new JLabel("The Infidels",SwingConstants.CENTER);
     static JButton group3Button = new JButton();
     static JLabel group3JLabel = new JLabel("Casamigos",SwingConstants.CENTER);
     static JButton group4Button = new JButton();
     static JLabel group4JLabel = new JLabel("The Smith Dynasty",SwingConstants.CENTER);


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
        text.setBounds(72,192,200,42);
        text.setVisible(true);
        text.setOpaque(true);
        text.setContentAreaFilled(false);
         text.setBorderPainted(false);
         text.setFocusPainted(false);

         text2.setBounds(72,192,200,42);
         text2.setVisible(true);
         text2.setOpaque(false);
         text2.setFont(derivedOpenSansFont);

           gruop2Button.setIcon(new ImageIcon("res/groupButton.png"));
        gruop2Button.setFont(derivedOpenSansFont);
        gruop2Button.setBounds(72,258,200,42);
        gruop2Button.setVisible(true);
        gruop2Button.setOpaque(true);
        gruop2Button.setContentAreaFilled(false);
         gruop2Button.setBorderPainted(false);
         gruop2Button.setFocusPainted(false);

          group2Label.setBounds(72,258,200,42);
         group2Label.setVisible(true);
         group2Label.setOpaque(false);
         group2Label.setFont(derivedOpenSansFont);

        group3Button.setFont(derivedOpenSansFont);
        group3Button.setBounds(72,324,200,42);
        group3Button.setVisible(true);
        group3Button.setOpaque(true);
        group3Button.setContentAreaFilled(false);
         group3Button.setBorderPainted(false);
         group3Button.setFocusPainted(false);
        group3Button.setIcon(new ImageIcon("res/groupButton.png"));
      
          group3JLabel.setBounds(72,324,200,42);
         group3JLabel.setVisible(true);
         group3JLabel.setOpaque(false);
         group3JLabel.setFont(derivedOpenSansFont);

        group4Button.setFont(derivedOpenSansFont);
        group4Button.setBounds(72,390,200,42);
        group4Button.setVisible(true);
        group4Button.setOpaque(true);
        group4Button.setContentAreaFilled(false);
         group4Button.setBorderPainted(false);
         group4Button.setFocusPainted(false);
        group4Button.setIcon(new ImageIcon("res/groupButton.png"));
      
          group4JLabel.setBounds(72,390,200,42);
         group4JLabel.setVisible(true);
         group4JLabel.setOpaque(false);
         group4JLabel.setFont(derivedOpenSansFont);








    }
    void initializePanel()
    {  
        panel.add(text);
        panel.add(text2);
        panel.add(group2Label);
        panel.add(gruop2Button);
        panel.add(group3Button);
        panel.add(group3JLabel);
      panel.add(group4Button);
        panel.add(group4JLabel);
        //panel.add(OpenSesameIcon);
        //panel.add(groupsBackground);
       // panel.add(bar);
        panel.add(todos);

    }

}
