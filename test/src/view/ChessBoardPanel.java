package view;

import components.ChessGridComponent;
import model.ChessPiece;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

import static components.ChessGridComponent.*;

public class ChessBoardPanel extends JPanel {
    private final int CHESS_COUNT = 8;
    private ChessGridComponent[][] chessGrids;
    public static int[][]board=new int[8][8];


    public void setBoard() {
        for (int i=0;i<8;i++){
            for (int j=0;j<8;j++){
                if(board[i][j]==0){this.chessGrids[i][j].setChessPiece(null);}
                if(board[i][j]==-1){this.chessGrids[i][j].setChessPiece(ChessPiece.BLACK);}
                if(board[i][j]==1){this.chessGrids[i][j].setChessPiece(ChessPiece.WHITE);}
            }
        }repaint();
    }

    private static int[][][]boardlist=new int[61][8][8];
    private int newboardstep=0;
    private int boardstep=0;
    private static int b=-1;
    public int c1=0;
    private int row;
    private int col;
    public static JFrame NoWay=new JFrame("再悔棋然然要生气了！");
    public int getCol() {
        return col;
    }

    public int getNewboardstep() {
        return newboardstep;
    }

    public void setNewboardstep(int newboardstep) {
        this.newboardstep = newboardstep;
    }

    public int getRow() {
        return row;
    }

    public int getBoardstep() {
        return boardstep;
    }

    public void addBoardstep() {
        this.boardstep++;
    }


    public static void setBoard(int row, int col, int i) {
        ChessBoardPanel.board[row][col]=i;
    }

    public static int[][] getBoard() {
        return board;
    }

    public ChessGridComponent[][] getChessGrids() {
        return chessGrids;
    }

    public static int getB() {
        return b;
    }

    public int getC1() {
        return c1;
    }

    public int getCHESS_COUNT() {
        return CHESS_COUNT;
    }

    public void setB(int b) {
        this.b = b;
    }




    public void setC1(int c1) {
        this.c1 = c1;
    }

    public void setChessGrids(ChessGridComponent[][] chessGrids) {
        this.chessGrids = chessGrids;
    }

    public void resetChessboard(int width, int height){
        this.boardstep=0;
        this.setVisible(true);
        this.setFocusable(true);
        this.setLayout(null);
        this.setBackground(Color.BLACK);
        this.setOpaque(false);
        int length = Math.min(width, height);
        this.setSize(length, length);
        this.newboardstep=0;
        gridSize = length / CHESS_COUNT;
        chessSize = (int) (gridSize * 0.8);
        targetsize=(int)(gridSize*0.3);

        System.out.printf("width = %d height = %d gridSize = %d chessSize = %d\n",
                width, height, gridSize, chessSize);
       for(int i=0;i<8;i++){
           for(int j=0;j<8;j++){
               this.board[i][j]=0;
               this.chessGrids[i][j].setChessPiece(null);
               this.boardlist[boardstep][i][j]=0;

           }
       }

        initialGame();//add initial four chess

        repaint();
    }
    public ChessBoardPanel(int width, int height) {
        this.setVisible(true);
        this.setFocusable(true);
        this.setLayout(null);
        this.setBackground(Color.BLACK);
        int length = Math.min(width, height);
        this.setSize(length, length);
        this.setOpaque(false);
        gridSize = length / CHESS_COUNT;
        chessSize = (int) (gridSize * 0.8);
        targetsize=(int)(gridSize*0.3);
        System.out.printf("width = %d height = %d gridSize = %d chessSize = %d\n",
                width, height, gridSize, chessSize);
        initialChessGrids();//return empty chessboard
        initialGame();//add initial four chess

        repaint();
    }

    /**
     * set an empty chessboard
     */
    public void initialChessGrids() {
        chessGrids = new ChessGridComponent[CHESS_COUNT][CHESS_COUNT];

        //draw all chess grids
        for (int i = 0; i < CHESS_COUNT; i++) {
            for (int j = 0; j < CHESS_COUNT; j++) {
                ChessGridComponent gridComponent = new ChessGridComponent(i, j);
                gridComponent.setLocation(j * gridSize, i * gridSize);
                chessGrids[i][j] = gridComponent;
                this.add(chessGrids[i][j]);
            }
        }
    }

    /**
     * initial origin four chess
     */
    public void initialGame() {
        b=-1;
        c1=0;
        board[3][3]=-1;
        board[3][4]=1;
        board[4][3]=1;
        board[4][4]=-1;
        boardlist[0][3][3]=-1;
        boardlist[0][3][4]=1;
        boardlist[0][4][3]=1;
        boardlist[0][4][4]=-1;
        chessGrids[3][3].setChessPiece(ChessPiece.BLACK);
        chessGrids[3][4].setChessPiece(ChessPiece.WHITE);
        chessGrids[4][3].setChessPiece(ChessPiece.WHITE);
        chessGrids[4][4].setChessPiece(ChessPiece.BLACK);
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLACK);

        g.fillRect(0, 0, this.getWidth(), this.getHeight());
    }



    public void find(int b, int x, int y, int X, int Y){
        int c=0;
        if(x+X>=0&&x+X<8&&y+Y>=0&&y+Y<8&& this.board[x+X][y+Y]==0){return;}
        do {c++;
            x+=X;
            y+=Y;
        }while (x>=0&&x<8&&y>=0&&y<8&&this.board[x][y]==-b);
        if (x>=0&&x<8&&y>=0&&y<8&&this.board[x-X][y-Y]!=b&&this.board[x][y]==b&&c>1){


                //board[x-X*i][y-Y*i]=b;
                //chessSize = (int) (gridSize * 0.4);
                //if(b==1){chessGrids[x][y].setChessPiece(ChessPiece.RED);}
                //if(b==-1){chessGrids[x][y].setChessPiece(ChessPiece.RED);}
                c1++;

        }
    }
    public int renjimove(int b,int row,int col){
        int chizi=0;
        chizi+=renjistep(b,row,col,-1,0);
        chizi+=renjistep(b,row,col,1,0);
        chizi+=renjistep(b,row,col,0,-1);
        chizi+=renjistep(b,row,col,0,1);
        chizi+=renjistep(b,row,col,-1,-1);
        chizi+=renjistep(b,row,col,-1,1);
        chizi+=renjistep(b,row,col,1,-1);
        chizi+=renjistep(b,row,col,1,1);
        return chizi;
    }
    public int renjistep(int b, int x, int y, int X, int Y){
        int chizi=0;
        if(x+X>=0&&x+X<8&&y+Y>=0&&y+Y<8&&this.board[x+X][y+Y]==0){return 0;}
        do {chizi++;
            x+=X;
            y+=Y;
        }while (x>=0&&x<8&&y>=0&&y<8&&this.board[x][y]==-b);
        if (x>=0&&x<8&&y>=0&&y<8&&this.board[x-X][y-Y]!=b&&board[x][y]==b&&chizi>1){
           return chizi;
            }return 0;
        }

    public void set(int b, int x, int y, int X, int Y){
        int c=0;
        c1=0;
        //System.out.printf("\n%d %d %d %d %d\n",b, x, y, X, Y);
        if(x+X>=0&&x+X<8&&y+Y>=0&&y+Y<8&&this.board[x+X][y+Y]==0){return;}
        do {c++;
            x+=X;
            y+=Y;
        }while (x>=0&&x<8&&y>=0&&y<8&&this.board[x][y]==-b);
        if (x>=0&&x<8&&y>=0&&y<8&&this.board[x-X][y-Y]!=b&&board[x][y]==b&&c>1){
            for(int i=0;i<=c;i++){
                this.board[x-X*i][y-Y*i]=b;
                if(b==1){this.chessGrids[x-X*i][y-Y*i].setChessPiece(ChessPiece.WHITE);}
                if(b==-1){this.chessGrids[x-X*i][y-Y*i].setChessPiece(ChessPiece.BLACK);}
                c1++;
                repaint();
            }
        }
    }
    public void machineplay(ChessPiece currentPlayer){

        int cal=0; row=0; col=0;int compare=0;
        if(currentPlayer.getColor()==Color.BLACK){b=-1;}
        if(currentPlayer.getColor()==Color.WHITE){b=1;}
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                if(this.board[i][j]==0){
                compare=renjimove(b,i,j);
                if(compare>cal){
                    cal=compare;row=i;col=j;}
                }
            }
        }
        if(cal!=0){GameFrame.controller.putpiece(row,col);}
    }

    public void setBoardstep(int boardstep){
        this.boardstep=boardstep;
    }
    public void backstep(){
        if(this.boardstep<=this.newboardstep){
            JPanel Noway=new JPanel();
            ImageIcon noWay=new ImageIcon("C:\\test\\picture\\noway.jpg");
            JLabel noway=new JLabel(noWay);
            Noway.add(noway);
            NoWay.setSize(620,780);
            noway.setLayout(null);
            NoWay.setContentPane(Noway);
            NoWay.setDefaultCloseOperation(NoWay.HIDE_ON_CLOSE);
            NoWay.setLocationRelativeTo(null);
            NoWay.setVisible(true);
            GameFrame.controller.swapPlayer();
            return;
        }
        boardstep--;
        /*System.out.println(boardstep);for (int i=0;i<8;i++){
            for (int j=0;j<8;j++){
                System.out.print(boardlist[boardstep][i][j]);
            }System.out.println("");}
        System.out.println(boardstep);for (int i=0;i<8;i++){
            for (int j=0;j<8;j++){
                System.out.print(board[i][j]);
            }System.out.println("");
        }*/
        for (int i=0;i<8;i++){
            for (int j=0;j<8;j++){
                board[i][j]=boardlist[boardstep][i][j];
            }System.out.println("");}

        for (int i=0;i<8;i++){
            for (int j=0;j<8;j++){
                if(board[i][j]==0){this.chessGrids[i][j].setChessPiece(null);}
                if(board[i][j]==-1){this.chessGrids[i][j].setChessPiece(ChessPiece.BLACK);}
                if(board[i][j]==1){this.chessGrids[i][j].setChessPiece(ChessPiece.WHITE);}
            }
        }repaint();
    }
    public void play(int b, int x, int y){
        boardstep++;
        backway();
        set(b,x,y,-1,0);
        set(b,x,y,1,0);
        set(b,x,y,0,-1);
        set(b,x,y,0,1);
        set(b,x,y,-1,-1);
        set(b,x,y,-1,1);
        set(b,x,y,1,-1);
        set(b,x,y,1,1);
        if (GameFrame.controller.getcheat()){boardstep++;board[x][y]=b;
            if(board[x][y]==-1){this.chessGrids[x][y].setChessPiece(ChessPiece.BLACK);}
            if(board[x][y]==1){this.chessGrids[x][y].setChessPiece(ChessPiece.WHITE);}}

        System.out.println(boardstep);
        for (int i=0;i<8;i++){
            for (int j=0;j<8;j++){
                System.out.print(boardlist[boardstep][i][j]);
                boardlist[boardstep][i][j]=board[i][j];
            }System.out.println("");}
        System.out.println(boardstep);
        }


    public void check(int b, int x, int y){
        find(b,x,y,-1,0);
        find(b,x,y,1,0);
        find(b,x,y,0,-1);
        find(b,x,y,0,1);
        find(b,x,y,-1,-1);
        find(b,x,y,-1,1);
        find(b,x,y,1,-1);
        find(b,x,y,1,1);
    }

    public boolean canClickGrid(int row, int col, ChessPiece currentPlayer) {
        //todo: complete this method
        if(this.board[row][col]!=0){return false;}
        if(currentPlayer.getColor()==Color.BLACK){b=-1;}
        if(currentPlayer.getColor()==Color.WHITE){b=1;}
        check(b,row,col);
        if(c1==0){return false;}
        c1=0;
        repaint();
        return true;
    }
public void checkway(ChessPiece currentPlayer){

    if(currentPlayer.getColor()==Color.BLACK){b=-1;}
    if(currentPlayer.getColor()==Color.WHITE){b=1;}
    for(int i=0;i<8;i++){
        for(int j=0;j<8;j++){
            if(this.board[i][j]==0){
                check(b,i,j);
                if(c1!=0)
                {
                    this.chessGrids[i][j].setChessPiece(ChessPiece.RED);
                }
                c1=0;
            }
        }
    }
}
public void backway(){
    for(int i=0;i<8;i++){
        for(int j=0;j<8;j++){
            if(chessGrids[i][j].getChessPiece() == ChessPiece.RED){
                chessGrids[i][j].setChessPiece(null);
            }
            }
        }
}

}
