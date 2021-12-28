package controller;

import model.ChessPiece;
import view.*;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;


public class GameController {


    private ChessBoardPanel gamePanel;
    private StatusPanel statusPanel;
    private ChessPiece currentPlayer;
    private int blackScore;
    private int whiteScore;
    private int model=1;
    private int blank=0;
    private boolean cheat=false;
    public static JFrame ranran=new JFrame("然然来陪玩啦！");
    public static JFrame budong=new JFrame("然然不理解...");
    public class task2 extends TimerTask {
        public void run(){ranran.setVisible(false);}
    }
    public class task3 extends TimerTask{
        public void run(){budong.setVisible(false);}
    }

    public void Renji(){
        ImageIcon rjpicture=new ImageIcon("C:\\test\\picture\\renji.jpg");
        JLabel rjLabel=new JLabel(rjpicture);
        ranran.setSize(520,600);
        ranran.setLayout(null);
        ranran.setContentPane(rjLabel);
        ranran.setVisible(true);
        ranran.setLocationRelativeTo(null);
        ranran.setDefaultCloseOperation(ranran.HIDE_ON_CLOSE);
        java.util.Timer timer = new Timer();
        timer.schedule(new task2(), 2000);
    }

    public void setModel(int model) {
        this.model = model;
    }

    public int getModel() {
        return model;
    }

    public int getrow(){
        return gamePanel.getRow();
    }
    public int getcol(){
        return gamePanel.getCol();
    }
    public int getStepcount(){
        return gamePanel.getBoardstep();
    }
    public void backstep(){
        swapPlayer();
        gamePanel.backstep();
    }
    public boolean getcheat(){
        return this.cheat;
    }
   public void setcheat(boolean cheat){
        this.cheat=cheat;
   }
    public void machinePlay(){
        gamePanel.machineplay(currentPlayer);
        System.out.printf("%s clicked (%d, %d)\n", GameFrame.controller.getCurrentPlayer(), GameFrame.controller.getrow(), GameFrame.controller.getcol());
        GameFrame.controller.swapPlayer();

    }
    public void changemodel(){
        model=-model;
    }
    public void setCurrentPlayer(ChessPiece currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public GameController(ChessBoardPanel gamePanel, StatusPanel statusPanel) {
        this.gamePanel = gamePanel;
        this.statusPanel = statusPanel;
        this.currentPlayer = ChessPiece.BLACK;
        blackScore = 2;
        whiteScore = 2;
    }

    public int getBlackScore() {
        return blackScore;
    }

    public int getWhiteScore() {
        return whiteScore;
    }
    public void swapPlayer() {
        countScore();
        currentPlayer = (currentPlayer == ChessPiece.BLACK) ? ChessPiece.WHITE : ChessPiece.BLACK;
        statusPanel.setPlayerText(currentPlayer.name());
        statusPanel.setScoreText(blackScore, whiteScore);
    }
    public void resetplayer(){
        countScore();
        statusPanel.setScoreText(blackScore, whiteScore);
    }


    public void countScore() {
        //todo: modify the countScore method
        int [][]a=ChessBoardPanel.getBoard();
        whiteScore=0;
        blackScore=0;
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                if(a[i][j]==1){whiteScore++;}
                if(a[i][j]==-1){blackScore++;}
                }
            }
        System.out.print("whiteScore:"+whiteScore+" blackScore:"+blackScore);
        }

    public ChessPiece getCurrentPlayer() {
        return currentPlayer;
    }


    public ChessBoardPanel getGamePanel() {
        return gamePanel;
    }


    public void setGamePanel(ChessBoardPanel gamePanel) {
        this.gamePanel = gamePanel;
    }
   public void wrongfile(){
       ImageIcon notKnow=new ImageIcon("C:\\test\\picture\\notknow.jpg");
       JLabel nkLabel=new JLabel(notKnow);
       budong.setSize(400,770);
       budong.setLayout(null);
       budong.setContentPane(nkLabel);
       budong.setVisible(true);
       budong.setLocationRelativeTo(null);
       budong.setDefaultCloseOperation(budong.HIDE_ON_CLOSE);
       java.util.Timer timer = new Timer();
       timer.schedule(new task3(), 2200);
   }
    public void readFileData(String fileName) {
        //todo: read date from file
        int newstep=0;
        String pathname = "C:\\test\\memory\\" + fileName;
        List<String> fileData = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(pathname);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                fileData.add(line);
            }
        } catch (IOException e) {
           wrongfile();return;
        }
        String inputString = new String();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {

                inputString = fileData.get(i * 8 + j);

                switch (inputString) {

                    case "1":
                        gamePanel.board[i][j] = 1;
                        newstep++;
                        break;
                    case "-1":
                        gamePanel.board[i][j] = -1;
                        newstep++;
                        break;
                    case "0":
                        gamePanel.board[i][j] = 0;
                        break;
                    default:wrongfile();return;

                }
            }
        }
        String nowWhoToPlay = fileData.get(64);
        String gameModel = fileData.get(65);
        if(nowWhoToPlay.equals("-1")|nowWhoToPlay.equals("1")){
        switch (nowWhoToPlay) {
            case "-1":
                this.currentPlayer = ChessPiece.BLACK;
                break;
            case "1":
                this.currentPlayer = ChessPiece.WHITE;
                break;
        }}else {wrongfile();return;}
        if(gameModel.equals("-1")|gameModel.equals("1")){
        switch (gameModel) {
            case "-1":
                GameFrame.controller.setModel(-1);
            case "1":
                GameFrame.controller.setModel(1);}}
            else {wrongfile();return;}
        gamePanel.setBoard();
        gamePanel.setNewboardstep(newstep);
        gamePanel.setBoardstep(newstep);

    }

    public static void writeDataToFile(String fileName){
        //todo: write data into file
        List<String> fileData = new ArrayList<>();
        try {
            File file= new File("C:\\test\\memory\\"+fileName);
            FileWriter fileWriter = new FileWriter("C:\\test\\memory\\"+fileName,true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for(int i = 0 ;i<8;i++){
                for(int j = 0 ; j < 8 ;j++){
                    fileData.add(String.valueOf(ChessBoardPanel.getBoard()[i][j]));
                    fileData.add("\n");
                }

            }
            int playerColor = ChessBoardPanel.getB();
            fileData.add(String.valueOf(playerColor));
            int playModel = GameFrame.controller.getModel();
            fileData.add("\n");
            fileData.add(String.valueOf(playModel));
            for(int i = 0 ; i < fileData.size();i++){
                bufferedWriter.write(fileData.get(i));
            }
            bufferedWriter.close();
        } catch (IOException e) {

        }
    }

    public void checkway(){

        gamePanel.checkway(currentPlayer);}

    public boolean canClick(int row, int col) {

        return gamePanel.canClickGrid(row, col, currentPlayer);
    }
    public void putpiece(int row,int col){
        int b = 0;
        if(currentPlayer.getColor()== Color.BLACK){b=-1;}
        if(currentPlayer.getColor()==Color.WHITE){b=1;}
        gamePanel.play(b,row,col);
    }
}
