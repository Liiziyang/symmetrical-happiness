import controller.GameController;
import view.ChessBoardPanel;
import view.GameFrame;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;


public class test{

        public static JFrame Wrongid=new JFrame("账号或者密码错误哦！再重新试一次吧！");
        public static JFrame Exist=new JFrame("别人已经用过这个帐号了，不如换一个试试");
        public static class task1 extends TimerTask {
                public void run(){Wrongid.setVisible(false);}
        }
        public static class task2 extends TimerTask {
                public void run(){Exist.setVisible(false);}
        }
        public static void wrongID(){
                ImageIcon notKnow=new ImageIcon("C:\\test\\picture\\wrongid.jpg");
                JLabel nkLabel=new JLabel(notKnow);
                Wrongid.setSize(610,710);
                Wrongid.setLayout(null);
                Wrongid.setContentPane(nkLabel);
                Wrongid.setVisible(true);
                Wrongid.setLocationRelativeTo(null);
                Wrongid.setDefaultCloseOperation(Wrongid.HIDE_ON_CLOSE);
                java.util.Timer timer = new Timer();
                timer.schedule(new task1(), 2200);
        }
        public static void Exist(){
                ImageIcon notKnow=new ImageIcon("C:\\test\\picture\\exist.jpg");
                JLabel Label=new JLabel(notKnow);
                Exist.setSize(610,690);
                Exist.setLayout(null);
                Exist.setContentPane(Label);
                Exist.setVisible(true);
                Exist.setLocationRelativeTo(null);
                Exist.setDefaultCloseOperation(Exist.HIDE_ON_CLOSE);
                java.util.Timer timer = new Timer();
                timer.schedule(new task2(), 2200);
        }

        public static void play(){

                JPanel login1=new JPanel();
                login1.setBounds(0,0,600,700);

                JFrame window=new JFrame("嘉然!我的超人！"); //create a Frame
                ImageIcon picture=new ImageIcon("C:\\test\\picture\\test.png");
//load a picture from computer
                JLabel label=new JLabel(picture); //add the picture to a label
                Circle a=new Circle(5,10,20);
                login1.add(label); //add the label to the frame
                window.setVisible(true); //Set the window to visible
                window.setSize(600,660); //set the size of the window
                window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //let the window can be close by click "x"
                JCheckBox left = new JCheckBox("是新用户惹");
                JCheckBox right= new JCheckBox("老嘉心糖捏",true);
                ButtonGroup login=new ButtonGroup();
                login.add(left);
                login.add(right);

                JButton logIn=new JButton("注册/登录");
                Font f=new Font("华文行楷",Font.BOLD,47);
                left.setFont(f);
                right.setFont(f);
                left.setSize(10,5);
                right.setSize(10,5);
                left.setBackground(Color.MAGENTA);
                left.setForeground(Color.white);
                right.setBackground(Color.YELLOW);
                new FlowLayout(FlowLayout.LEADING,800,600);
                window.setLocationRelativeTo(null);
                login1.add(left);
                login1.add(right);
                login1.add(new JLabel("用户名"));
                JTextField nameField=new JTextField(10);
                login1.add(nameField);
                String name=nameField.getText();
                login1.add(new JLabel("密码"));
                JPasswordField passwordField=new JPasswordField(10);
                login1.add(passwordField);

                login1.add(logIn);

                window.setContentPane(login1);
                System.out.print(a);
                logIn.addMouseListener(new MouseAdapter() {
                        @Override
    public void mouseClicked(MouseEvent e) {
                 if(left.isSelected()) {
                         super.mouseClicked(e);
                         String account = nameField.getText();
                         if(contain(account)){Exist();}
                         if (!contain(account)){
                                 window.setVisible(false);
                         JFrame Menu = new JFrame("主菜单");
                         Menu.setSize(520, 650);
                         Menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                         ImageIcon picture = new ImageIcon("C:\\test\\picture\\11.png");

                         JLabel menu = new JLabel(picture);
                         menu.setSize(520, 650);
                         JButton game = new JButton("开始游戏");
                         JButton shop = new JButton("商店");
                         JButton back = new JButton("返回");
                         JMenuBar menuBar = new JMenuBar();
                         JMenu set = new JMenu("设置");
                         game.setBounds(40, 560, 200, 40);
                         shop.setBounds(200, 30, 200, 40);
                         back.setBounds(280, 560, 200, 40);
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


                                         window.setVisible(true);
                                 }
                         });

                         writeDataToFile(account);
                         String password = String.valueOf(passwordField.getPassword());
                         writeDataToFile2(password);
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
                 } }
              if(right.isSelected()){

                  super.mouseClicked(e);
                      String account=nameField.getText();
                      if (!contain(account)){wrongID();return;}
                      if(contain(account)){
                      readaccount(account);
                      String password = String.valueOf(passwordField.getPassword());
                      readpassword(password);
                      if (!canlogin){wrongID();return;}
                      if(canlogin){
                          window.setVisible(false);
                          JFrame Menu = new JFrame("主菜单");
                          Menu.setSize(520, 650);
                          Menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                          ImageIcon picture = new ImageIcon("C:\\test\\picture\\11.png");

                          JLabel menu = new JLabel(picture);
                          menu.setSize(520, 650);
                          JButton game = new JButton("开始游戏");
                          JButton shop = new JButton("商店");
                          JButton back = new JButton("返回");
                          JMenuBar menuBar = new JMenuBar();
                          JMenu set = new JMenu("设置");
                          game.setBounds(40, 560, 200, 40);
                          shop.setBounds(200, 30, 200, 40);
                          back.setBounds(280, 560, 200, 40);
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
                                          canlogin=false;

                                          window.setVisible(true);
                                  }
                          });

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
                                } } }}
                });

        }
        public static boolean contain(String name){
                String pathname = "C:\\test\\account\\account.txt" ;
                List<String> fileData = new ArrayList<>();
                try {
                        FileReader fileReader = new FileReader(pathname);
                        BufferedReader bufferedReader = new BufferedReader(fileReader);
                        String line;
                        while ((line = bufferedReader.readLine()) != null) {
                                fileData.add(line);
                        }
                } catch (IOException e) {
                        return false;
                }
                if(fileData.contains(name)){return true;}
                else return false;
        }

        public static void writeDataToFile(String name){



                String fileName="account.txt";
                write(fileName,name);

        }
        public static void write(String fileName,  String name){
                RandomAccessFile rFile;
                try {
                        File file= new File("C:\\test\\account\\"+fileName);
                        rFile = new RandomAccessFile(file, "rw");
                        long point = rFile.length();
                        rFile.seek(point);// 到达文件尾
                        rFile.writeBytes(name + "\r\n");

                        rFile.close();
                } catch (IOException e) {

                }
        }
        public static void writeDataToFile2(String name){
                String fileName="password.txt";
               write(fileName,name);
        }
        public  static void readaccount(String name){
                String pathname = "C:\\test\\account\\account.txt" ;
                List<String> fileData = new ArrayList<>();
                try {
                        FileReader fileReader = new FileReader(pathname);
                        BufferedReader bufferedReader = new BufferedReader(fileReader);
                        String line;
                        while ((line = bufferedReader.readLine()) != null) {
                                fileData.add(line);
                        }
                } catch (IOException e) {
                        wrongID();
                        return;
                }if(!fileData.contains(name)){System.out.print("wrong account");}
                else accountline=fileData.indexOf(name);
        }
        public static int accountline;
        public static void readpassword(String name){
                String pathname = "C:\\test\\account\\password.txt" ;
                List<String> fileData = new ArrayList<>();
                try {
                        FileReader fileReader = new FileReader(pathname);
                        BufferedReader bufferedReader = new BufferedReader(fileReader);
                        String line;
                        while ((line = bufferedReader.readLine()) != null) {
                                fileData.add(line);
                        }
                } catch (IOException e) {
                       wrongID(); return;
                }System.out.print(accountline);
                if(!fileData.get(accountline).equals(name)){System.out.print("wrong password");}
                else canlogin=true;

        }
        public static boolean canlogin=false;
        private int sid=0;
        public static void main(String[]args) {

                play();
        }



        private int[][]board=new int[8][8];
        public int [][]getBoard(){
                return board;
        }
        public void setBoard(int[][] board){
                for(int i=0;i<8;i++){
                        System.arraycopy(board[i], 0, this.board[i], 0, 8);
                }
        }}
