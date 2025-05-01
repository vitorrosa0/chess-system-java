package com.chess.Chess_System.chess.pieces;

import com.chess.Chess_System.boardgame.Board;
import com.chess.Chess_System.chess.ChessPiece;
import com.chess.Chess_System.chess.Color;

public class Rook extends ChessPiece {

    public Rook(Board board, Color color) {
        super(board, color);
    }

    @Override
    public String toString() {
        return "R";
    }
}
