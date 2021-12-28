package model;

import java.awt.*;

public enum ChessPiece {
    BLACK(Color.BLACK), WHITE(Color.WHITE),RED(Color.RED),Target(Color.GRAY);
    //标记刚下的棋子


    private final Color color;





    ChessPiece(Color color) {
        this.color = color;

    }

    public Color getColor() {
        return color;
    }

}
