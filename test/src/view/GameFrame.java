package view;


import controller.GameController;
import model.ChessPiece;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.*;
import java.io.File;


public class GameFrame extends JFrame {

    public static GameController controller;
    private ChessBoardPanel chessBoardPanel;
    private StatusPanel statusPanel;
    private musicStuff musicObject = new musicStuff();

    private  ImageIcon back=new ImageIcon("C:\\test\\picture\\cat.jpg");
    private JPanel backpanel=new JPanel();
    private JLabel backlabel=new JLabel(back);
    private JCheckBox cheatmodel=new JCheckBox();


    public void playmusic(){

        String filepath=new String("C:\\test\\music\\6+7+8.wav");

        musicStuff musicObject = new musicStuff();
        musicObject.playMusic(filepath);

    }
    public GameFrame(int frameSize) {
      playmusic();
        ImageIcon backgroundIcon = new ImageIcon("C:\\test\\picture\\background.jpg");
        JLabel backgroundLabel = new JLabel((backgroundIcon));
        backgroundLabel.setHorizontalAlignment(SwingConstants.CENTER);
        backgroundLabel.setVerticalAlignment(SwingConstants.BOTTOM);
        backgroundIcon.setImage(backgroundIcon.getImage().getScaledInstance(1459, 1100,Image.SCALE_DEFAULT));
        backgroundLabel.setSize(1459,1100);
        backgroundLabel.setLocation(0,0);






        this.setTitle("2021F CS102A Project Reversi");
        this.setLayout(null);





        //获取窗口边框的长度，将这些值加到主窗口大小上，这能使窗口大小和预期相符
        Insets inset = this.getInsets();
        this.setSize(1478, 1100);

        this.setLocationRelativeTo(null);


        chessBoardPanel = new ChessBoardPanel((int) (this.getWidth() * 0.75), (int) (this.getHeight() * 0.6));
        chessBoardPanel.setLocation((this.getWidth() - chessBoardPanel.getWidth()) / 2, (this.getHeight() - chessBoardPanel.getHeight()) / 3);
        statusPanel = new StatusPanel((int) (this.getWidth() * 0.8), (int) (this.getHeight() * 0.1));
        statusPanel.setLocation((this.getWidth() - chessBoardPanel.getWidth()) / 2, 0);
        controller = new GameController(chessBoardPanel, statusPanel);
        controller.setGamePanel(chessBoardPanel);
        chessBoardPanel.setOpaque(false);
        statusPanel.setOpaque(false);

        this.add(chessBoardPanel);
        this.add(statusPanel);
        JButton restartBtn = new JButton("重新开始");
        restartBtn.setSize(120, 50);
        restartBtn.setLocation((this.getWidth() - chessBoardPanel.getWidth()) / 2-30, (this.getHeight() + chessBoardPanel.getHeight()) / 2+4);
        add(restartBtn);
        restartBtn.addActionListener(e -> {
            System.out.println("click restart Btn");
            GameFrame.controller.setCurrentPlayer(ChessPiece.BLACK);
            chessBoardPanel.resetChessboard((int) (this.getWidth() * 0.75), (int) (this.getHeight() * 0.6));
            GameFrame.controller.resetplayer();

        });

        JButton loadGameBtn = new JButton("载入");
        loadGameBtn.setSize(120, 50);
        loadGameBtn.setLocation(restartBtn.getX()+restartBtn.getWidth()+30, restartBtn.getY());
        add(loadGameBtn);
        loadGameBtn.addActionListener(e -> {
            System.out.println("clicked Load Btn");
            String filePath = JOptionPane.showInputDialog(this, "请输入载入路径");
            controller.readFileData(filePath);
            repaint();
        });

        JButton saveGameBtn = new JButton("保存");
        saveGameBtn.setSize(120, 50);
        saveGameBtn.setLocation(loadGameBtn.getX()+restartBtn.getWidth()+30, restartBtn.getY());
        add(saveGameBtn);
        saveGameBtn.addActionListener(e -> {
            System.out.println("clicked Save Btn");
            String filePath = JOptionPane.showInputDialog(this, "请输入保存路径");
            controller.writeDataToFile(filePath);
        });
        JButton backstepBtn = new JButton("悔棋");
        backstepBtn.setSize(120, 50);
        backstepBtn.setLocation(saveGameBtn.getX()+restartBtn.getWidth()+30, restartBtn.getY());
        add(backstepBtn);
        backstepBtn.addActionListener(e -> {
            System.out.println("click backstep Btn");
            if(GameFrame.controller.getModel()==-1){GameFrame.controller.backstep();}
           GameFrame.controller.backstep();
        });
        JComboBox change=new JComboBox();
        JButton modelchangeBtn = new JButton("切换模式");
        modelchangeBtn.setSize(120, 50);
        modelchangeBtn.setLocation(backstepBtn.getX()+restartBtn.getWidth()+30, restartBtn.getY());
        add(modelchangeBtn);
        modelchangeBtn.addActionListener(e -> {
            System.out.println("click modelchange Btn");
            if (GameFrame.controller.getModel()==1){
             GameFrame.controller.Renji();
            }GameFrame.controller.changemodel();
            //GameFrame.controller.setCurrentPlayer(ChessPiece.BLACK);
            //chessBoardPanel.resetChessboard((int) (this.getWidth() * 0.75), (int) (this.getHeight() * 0.6));
            GameFrame.controller.resetplayer();

        });


           cheatmodel.setSize(250,50);
        Font f=new Font("华文行楷",Font.BOLD,40);
           cheatmodel.setFont(f);
           cheatmodel.setLocation(650,90);
           cheatmodel.setText("任意模式");
           cheatmodel.setOpaque(false);
           add(cheatmodel);
           cheatmodel.addActionListener(e -> {
               System.out.println("click cheatmodel");
               if(cheatmodel.isSelected()){GameFrame.controller.setcheat(true);}
               if (!cheatmodel.isSelected()){GameFrame.controller.setcheat(false);}
           });
        JButton hintBtn = new JButton("然然教我！");
        hintBtn.setSize(120, 50);
        hintBtn.setLocation(1100,40);
        add(hintBtn);
        hintBtn.addActionListener(e -> {
            System.out.println("click hintBtn Btn");
            GameFrame.controller.checkway();
            repaint();
        });

           repaint();



        this.add(backgroundLabel);
        this.setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public class musicStuff {
        void playMusic(String musicLocation)
        {
            try
            {
                File musicPath = new File(musicLocation);

                if(musicPath.exists())
                {
                    AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
                    Clip clip = AudioSystem.getClip();
                    clip.open(audioInput);
                    clip.start();
                    clip.loop(Clip.LOOP_CONTINUOUSLY);
                }
                else
                {

                }
            }
            catch(Exception ex)
            {
                ex.printStackTrace();
            }
        }

    }

}
