package com.chess.Chess_System;

import com.chess.Chess_System.chess.ChessMatch;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ChessSystemApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ChessSystemApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		ChessMatch chessMatch = new ChessMatch();
		UI.printBoard(chessMatch.getPieces());
	}
}
