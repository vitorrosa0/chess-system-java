package com.chess.Chess_System;

import com.chess.Chess_System.chess.ChessException;
import com.chess.Chess_System.chess.ChessMatch;
import com.chess.Chess_System.chess.ChessPiece;
import com.chess.Chess_System.chess.ChessPosition;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class ChessSystemApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ChessSystemApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Scanner sc = new Scanner(System.in);
		ChessMatch chessMatch = new ChessMatch();
		List<ChessPiece> captured = new ArrayList<>();

		while (!chessMatch.isCheckMate()) {
			try {
				UI.clearScreen();
				UI.printMatch(chessMatch, captured);
				System.out.println();
				System.out.print("Source: ");
				ChessPosition source = UI.readChessPosition(sc);

				boolean[][] possibleMoves = chessMatch.possibleMoves(source);
				UI.clearScreen();
				UI.printBoard(chessMatch.getPieces(), possibleMoves);
				System.out.println();
				System.out.print("Target: ");
				ChessPosition target = UI.readChessPosition(sc);

				ChessPiece capturedPiece = chessMatch.performChessMove(source, target);

				if (capturedPiece != null){
					captured.add(capturedPiece);
				}

				if (chessMatch.getPromoted() != null){
					System.out.println("Enter piece for promotion (B/N/R/Q): ");
					String type = sc.nextLine();
					chessMatch.replacePromotedPiece(type);
				}

			} catch (ChessException | InputMismatchException e) {
				System.out.println(e.getMessage());
				sc.nextLine();
			}
        }
		UI.clearScreen();
		UI.printMatch(chessMatch, captured);
	}
}
