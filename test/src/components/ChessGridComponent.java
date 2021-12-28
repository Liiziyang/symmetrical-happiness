package components;

import model.ChessPiece;
import view.ChessBoardPanel;
import view.GameFrame;

import javax.swing.*;
import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

public class ChessGridComponent extends BasicComponent {
    public static int chessSize;
    public static int gridSize;
    public static int targetsize;
    public static Color gridColor = new Color(255, 150, 50);
    private ChessPiece chessPiece;
    private int row;
    private int col;
    public static JFrame Wrong=new JFrame("为什么受伤的总是我！");
    public ChessGridComponent(int row, int col) {
        this.setSize(gridSize, gridSize);
        this.row = row;
        this.col = col;
    }

    public static int getTargetsize() {
        return targetsize;
    }

    public static void setTargetsize(int targetsize) {
        ChessGridComponent.targetsize = targetsize;
    }

    public void target(int targetsize){
        this.chessSize=targetsize;


    }
    public class task extends TimerTask{
        @Override
        public void run()
        {
            Wrong.setVisible(false);
        }
    }


    public class task2 extends TimerTask{
        @Override
        public void run()
        {
   if(noway()&&GameFrame.controller.getStepcount()!=60)
        {
            openwrong();GameFrame.controller.swapPlayer();
            return;
        }repaint();
            GameFrame.controller.machinePlay();
            repaint();
        }
    }




    public boolean noway(){
        int wrong[][]=ChessBoardPanel.getBoard();
        for (int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                if(wrong[i][j]==0&&GameFrame.controller.canClick(i,j)){
                  return false;
                }
            }
        }return true;
    }
public void bukeyi(){
    JPanel panel=new JPanel();
    ImageIcon picture=new ImageIcon("C:\\test\\picture\\123.jpg");
    JLabel back=new JLabel(picture);
    JFrame Error=new JFrame("不可以!不可以!");
    Error.setSize(420,550); //set the size of the window
    Error.setDefaultCloseOperation(Error.HIDE_ON_CLOSE); //let the window can be close by click "x"
    Error.setLocationRelativeTo(null);
    back.setLayout(null);
    panel.add(back);
    Error.setContentPane(panel);
    Error.setVisible(true); //Set the window to visible
    //ShowError('Error 101: It is aviable...')
    repaint();
}
    public void result(){
        JFrame Result=new JFrame();
        JPanel result=new JPanel();
        Result.setSize(666,666);
        if(GameFrame.controller.getWhiteScore()==0){ ImageIcon picture=new ImageIcon("C:\\test\\picture\\black.jpg");
            JLabel label=new JLabel(picture);
            label.setLayout(null);
            result.add(label);
            Result.setLocationRelativeTo(null);
            Result.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
            Result.setContentPane(result);
            Result.setVisible(true);
        }
        if(GameFrame.controller.getBlackScore()==0){ ImageIcon picture=new ImageIcon("C:\\test\\picture\\white.jpg");
            JLabel label=new JLabel(picture);
            label.setLayout(null);
            result.add(label);
            Result.setLocationRelativeTo(null);
            Result.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
            Result.setContentPane(result);
            Result.setVisible(true);}

        if(GameFrame.controller.getStepcount()==60){

            if(GameFrame.controller.getBlackScore()>GameFrame.controller.getWhiteScore()){
                ImageIcon picture=new ImageIcon("C:\\test\\picture\\black.jpg");
                JLabel label=new JLabel(picture);
                label.setLayout(null);
                result.add(label);
                Result.setLocationRelativeTo(null);
                Result.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                Result.setContentPane(result);
                Result.setVisible(true);
            }
            if(GameFrame.controller.getBlackScore()<GameFrame.controller.getWhiteScore()){
                ImageIcon picture=new ImageIcon("C:\\test\\picture\\white.jpg");
                JLabel label=new JLabel(picture);
                label.setLayout(null);
                result.add(label);
                Result.setLocationRelativeTo(null);
                Result.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                Result.setContentPane(result);
                Result.setVisible(true);
            }
            if(GameFrame.controller.getBlackScore()==GameFrame.controller.getWhiteScore()){
                ImageIcon picture=new ImageIcon("C:\\test\\picture\\equal.jpg");
                JLabel label=new JLabel(picture);
                label.setLayout(null);
                result.add(label);
                Result.setLocationRelativeTo(null);
                Result.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                Result.setContentPane(result);
                Result.setVisible(true);
            }
        }}
    public void openwrong(){
            ImageIcon background=new ImageIcon("C:\\test\\picture\\wrong.jpg");
            JLabel wrong=new JLabel(background);
            Wrong.setSize(630,710);
            wrong.setLayout(null);
            Wrong.setContentPane(wrong);
            Wrong.setVisible(true);
            Wrong.setLocationRelativeTo(null);
            Wrong.setDefaultCloseOperation(Wrong.HIDE_ON_CLOSE);
            Timer timer = new Timer();
            timer.schedule(new task(), 2500);
            GameFrame.controller.swapPlayer();
            //GameFrame.controller.machinePlay();
            //GameFrame.controller.swapPlayer();
        repaint();

    }
    @Override
    public void onMouseClicked() {
        System.out.printf("%s clicked (%d, %d)\n", GameFrame.controller.getCurrentPlayer(), row, col);
        //todo: complete mouse click method
System.out.print(GameFrame.controller.getcheat());
       if(GameFrame.controller.getcheat()==false){
        if(GameFrame.controller.getModel()==1){
        if (GameFrame.controller.canClick(row, col)) {
            GameFrame.controller.putpiece(row,col);
            //Shansuo()
            //if (this.chessPiece == null) {

                //this.chessPiece = GameFrame.controller.getCurrentPlayer();
                GameFrame.controller.swapPlayer();
            //}
            repaint();
            /*GameFrame.controller.machinePlay();
            System.out.printf("%s clicked (%d, %d)\n", GameFrame.controller.getCurrentPlayer(), GameFrame.controller.getrow(), GameFrame.controller.getcol());
            GameFrame.controller.swapPlayer();
            repaint();*/


        }
        else
        {   bukeyi();
        }
        System.out.print(GameFrame.controller.getStepcount());
        if(GameFrame.controller.getWhiteScore()!=0&&GameFrame.controller.getBlackScore()!=0){
        if(noway()&&GameFrame.controller.getStepcount()!=60){
            openwrong();
        }}result();

        repaint();}
if(GameFrame.controller.getModel()==-1){
            if (GameFrame.controller.canClick(row, col)) {
                GameFrame.controller.putpiece(row,col);
                result();
                //Shansuo()
                //if (this.chessPiece == null) {

                //this.chessPiece = GameFrame.controller.getCurrentPlayer();
                GameFrame.controller.swapPlayer();
                //}
                repaint();

                Timer timer = new Timer();
                timer.schedule(new task2(), 800);
                //repaint();
            }
            else
            {   bukeyi();
            }
            System.out.print(GameFrame.controller.getStepcount());
    if(GameFrame.controller.getWhiteScore()!=0&&GameFrame.controller.getBlackScore()!=0){
        if(noway()&&GameFrame.controller.getStepcount()!=60){
            openwrong();
        }}

            result();
            repaint();}}
        if(GameFrame.controller.getcheat()==true){
            if(GameFrame.controller.getModel()==1){

                    GameFrame.controller.putpiece(row,col);
                    //Shansuo()
                    //if (this.chessPiece == null) {

                    //this.chessPiece = GameFrame.controller.getCurrentPlayer();
                    GameFrame.controller.swapPlayer();
                    //}
                    repaint();
            /*GameFrame.controller.machinePlay();
            System.out.printf("%s clicked (%d, %d)\n", GameFrame.controller.getCurrentPlayer(), GameFrame.controller.getrow(), GameFrame.controller.getcol());
            GameFrame.controller.swapPlayer();
            repaint();*/


                }

                System.out.print(GameFrame.controller.getStepcount());


                repaint();
            if(GameFrame.controller.getModel()==-1){

                    GameFrame.controller.putpiece(row,col);
                    //Shansuo()
                    //if (this.chessPiece == null) {

                    //this.chessPiece = GameFrame.controller.getCurrentPlayer();
                    GameFrame.controller.swapPlayer();
                    //}
                    repaint();

                    Timer timer = new Timer();
                    timer.schedule(new task2(), 800);
                    //repaint();
                }

                System.out.print(GameFrame.controller.getStepcount());

                result();
                repaint();}}





    public ChessPiece getChessPiece() {
        return chessPiece;
    }

    public void setChessPiece(ChessPiece chessPiece) {
        this.chessPiece = chessPiece;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public void drawPiece(Graphics g) {
        g.setColor(gridColor);
        g.fillRect(1, 1, this.getWidth() - 2, this.getHeight() - 2);
        if (this.chessPiece != null) {

            g.setColor(chessPiece.getColor());
            if(this.chessPiece.getColor()==Color.RED){
                //按钮控制
            g.fillOval((gridSize - chessSize)+10, (gridSize - chessSize)+10, targetsize, targetsize);
        }else g.fillOval((gridSize - chessSize) / 2, (gridSize - chessSize) /2, chessSize, chessSize);

    }}
    public void setTargetpiece(ChessPiece chessPiece) {
        this.chessPiece=chessPiece;
    }
    public void drawtargetPiece(Graphics g) {
        g.setColor(gridColor);
        g.fillRect(1, 1, this.getWidth() - 2, this.getHeight() - 2);
        if (this.chessPiece != null) {
            g.setColor(chessPiece.getColor());
            g.fillOval((gridSize - chessSize) / 2, (gridSize - chessSize) / 2, chessSize/2, chessSize/2);
        }
    }


    @Override
    public void paintComponent(Graphics g) {
        super.printComponents(g);
        drawPiece(g);
    }
    public void paintsComponent(Graphics g) {
        super.printComponents(g);
        drawtargetPiece(g);
    }


}
