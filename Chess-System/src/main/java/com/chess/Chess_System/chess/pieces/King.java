package com.chess.Chess_System.chess.pieces;

import com.chess.Chess_System.boardgame.Board;
import com.chess.Chess_System.boardgame.Position;
import com.chess.Chess_System.chess.ChessMatch;
import com.chess.Chess_System.chess.ChessPiece;
import com.chess.Chess_System.chess.Color;

public class King extends ChessPiece {

    private ChessMatch chessMatch;

    public King(Board board, Color color, ChessMatch chessMatch) {
        super(board, color);
        this.chessMatch = chessMatch;
    }

    @Override
    public String toString() {
        return "K";
    }

    private boolean canMove(Position position){
        ChessPiece p = (ChessPiece) getBoard().piece(position);
        return p== null || p.getColor() != getColor();
    }

    private boolean testRookCastling(Position position){
        ChessPiece p = ((ChessPiece) getBoard().piece(position));
        return p != null && p instanceof Rook && p.getColor() == getColor() && p.getMoveCount() == 0;
    }

    @Override
    public boolean[][] possibleMoves() {
        boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];

        Position p = new Position(0,0);

        // above
        p.setValues(position.getRow() - 1, position.getColumn());
        if (getBoard().positionExists(p) && canMove(p)){
            mat[p.getRow()][p.getColumn()] = true;
        }
        // diagonal up right
        p.setValues(position.getRow() - 1, position.getColumn() + 1);
        if (getBoard().positionExists(p) && canMove(p)){
            mat[p.getRow()][p.getColumn()] = true;
        }
        // right
        p.setValues(position.getRow(), position.getColumn() + 1);
        if (getBoard().positionExists(p) && canMove(p)){
            mat[p.getRow()][p.getColumn()] = true;
        }
        // diagonal down right
        p.setValues(position.getRow() + 1, position.getColumn() + 1);
        if (getBoard().positionExists(p) && canMove(p)){
            mat[p.getRow()][p.getColumn()] = true;
        }
        // below
        p.setValues(position.getRow() + 1, position.getColumn());
        if (getBoard().positionExists(p) && canMove(p)){
            mat[p.getRow()][p.getColumn()] = true;
        }
        // diagonal down left
        p.setValues(position.getRow() + 1, position.getColumn() - 1);
        if (getBoard().positionExists(p) && canMove(p)){
            mat[p.getRow()][p.getColumn()] = true;
        }
        // left
        p.setValues(position.getRow(), position.getColumn() - 1);
        if (getBoard().positionExists(p) && canMove(p)){
            mat[p.getRow()][p.getColumn()] = true;
        }
        // diagonal up left
        p.setValues(position.getRow() - 1, position.getColumn() - 1);
        if (getBoard().positionExists(p) && canMove(p)){
            mat[p.getRow()][p.getColumn()] = true;
        }

        // special move castling
        if (getMoveCount() == 0 && !chessMatch.isCheck()){
            // special move castling kingside rook
            Position posT1 = new Position(position.getRow(), position.getColumn() + 3);
            if (testRookCastling(posT1)){
                Position p1 = new Position(position.getRow(), position.getColumn() + 1);
                Position p2 = new Position(position.getRow(), position.getColumn() + 2);
                if (getBoard().piece(p1) == null && getBoard().piece(p2) == null){
                    mat[position.getRow()][position.getColumn() + 2] = true;
                }
            }
            // special move castling queenside rook
            Position posT2 = new Position(position.getRow(), position.getColumn() - 4);
            if (testRookCastling(posT2)){
                Position p1 = new Position(position.getRow(), position.getColumn() - 1);
                Position p2 = new Position(position.getRow(), position.getColumn() - 2);
                Position p3 = new Position(position.getRow(), position.getColumn() - 3);
                if (getBoard().piece(p1) == null && getBoard().piece(p2) == null && getBoard().piece(p3) == null){
                    mat[position.getRow()][position.getColumn() - 2] = true;
                }
            }
        }

        return mat;
    }
}
