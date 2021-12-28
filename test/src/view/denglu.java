package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class denglu extends Frame{
    public void denglu(){
        JPanel panel=new JPanel();
        JPanel login1=new JPanel();
        login1.setBounds(0,600,600,100);
        panel.setBounds(0,0,600,600);
        JFrame window=new JFrame("嘉然!我的超人！"); //create a Frame
        ImageIcon picture=new ImageIcon("C:\\Users\\86136\\IdeaProjects\\test\\picture\\test.png");
//load a picture from computer
        JLabel label=new JLabel(picture); //add the picture to a label
        panel.add(label); //add the label to the frame
        window.setVisible(true); //Set the window to visible
        window.setSize(600,720); //set the size of the window
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //let the window can be close by click "x"
        JCheckBox left = new JCheckBox("新用户注册");
        JCheckBox right= new JCheckBox("老用户登录",true);
        ButtonGroup login=new ButtonGroup();
        login.add(left);
        login.add(right);
        JButton logIn=new JButton("注册/登录");
        Font f=new Font("华文行楷",Font.BOLD,50);
        left.setFont(f);
        right.setFont(f);
        left.setSize(10,5);
        right.setSize(10,5);
        left.setBackground(Color.MAGENTA);
        left.setForeground(Color.white);
        right.setBackground(Color.YELLOW);
        new FlowLayout(FlowLayout.LEADING,800,600);
        window.setLocationRelativeTo(null);
        login1.add(new JLabel("用户名"));
        JTextField nameField=new JTextField(10);
        login1.add(nameField);
        login1.add(new JLabel("密码"));
        JPasswordField passwordField=new JPasswordField(10);
        login1.add(passwordField);
        panel.add(left);
        panel.add(right);
        login1.add(logIn);
        window.add(login1);
        window.setContentPane(panel);
        window.setContentPane(login1);
        logIn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                super.mouseClicked(e);
                window.setVisible(false);
                JFrame Menu=new JFrame("主菜单");
                Menu.setSize(520,650);
                Menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                ImageIcon picture=new ImageIcon("C:\\Users\\86136\\IdeaProjects\\test\\picture\\11.png");

                JLabel menu =new JLabel(picture);
                menu.setSize(520,650);
                JButton game=new JButton("开始游戏");
                JButton shop=new JButton("商店");
                JButton back=new JButton("返回");
                JMenuBar menuBar=new JMenuBar();
                JMenu set=new JMenu("设置");
                game.setBounds(40,560,200,40);
                shop.setBounds(200,30,200,40);
                back.setBounds(280,560,200,40);
                game.setBackground(Color.MAGENTA);
                game.setForeground(Color.white);
                shop.setBackground(Color.YELLOW);
                shop.setForeground(Color.BLACK);
                back.setForeground(Color.ORANGE);
                back.setBackground(Color.cyan);
                shop.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        super.mouseClicked(e);
                        SwingUtilities.invokeLater(() -> {
                            Menu.setVisible(false);
                        });

                    }
                });
                game.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        super.mouseClicked(e);
                        Menu.setVisible(false);
                        SwingUtilities.invokeLater(() -> {

                            GameFrame mainFrame = new GameFrame(800);
                            mainFrame.setVisible(true);
                        });
                    }
                });
                back.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        super.mouseClicked(e);
                        denglu();

                    }
                });
                char []password=passwordField.getPassword();
                nameField.getText();
                menu.add(game);
                //menu.add(shop);
                menu.add(back);
                Menu.add(menu);
                Menu.setLocationRelativeTo(null);
                Menu.setVisible(true);

                menu.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        super.mouseClicked(e);


                    }
                });
            }
        });



    }
}
