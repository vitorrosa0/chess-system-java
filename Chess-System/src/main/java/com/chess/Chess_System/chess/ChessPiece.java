package com.chess.Chess_System.chess;

import com.chess.Chess_System.boardgame.Board;
import com.chess.Chess_System.boardgame.Piece;

public abstract class ChessPiece extends Piece {

    private Color color;

    public ChessPiece(Board board, Color color) {
        super(board);
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

}
