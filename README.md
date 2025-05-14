# ♟️ Chess System in Java

Este é um projeto pessoal de um **jogo de xadrez em Java**, desenvolvido com foco em conceitos de **programação orientada a objetos**, boas práticas de organização de código, e estrutura MVC básica.

## 📁 Estrutura do Projeto

O projeto está estruturado da seguinte forma:

src

└── main

└── java

└── com.chess.Chess_System

├── boardgame

│ ├── Board

│ ├── BoardException

│ ├── Piece

│ └── Position

└── chess

├── pieces

│ ├── Bishop

│ ├── King

│ ├── Knight

│ ├── Pawn

│ ├── Queen

│ └── Rook

├── ChessException

├── ChessMatch

├── ChessPiece

├── ChessPosition

├── Color

├── UI

└── ChessSystemApplication

### 📦 Pacotes

- `boardgame`: Contém as classes genéricas do tabuleiro e peças.
- `chess`: Contém a lógica específica do jogo de xadrez.
- `pieces`: Implementa as peças individuais (Rei, Rainha, Bispo, etc.).
- `UI`: Interface simples via terminal para interação com o usuário.

## 🚀 Funcionalidades

- Movimentação de peças com validação de regras.
- Lógica de partida de xadrez com alternância entre jogadores.
- Detecção de jogadas inválidas.
- Interface via terminal para visualização do tabuleiro.

## 🛠️ Tecnologias Utilizadas

- Java 17 (ou superior recomendado)
- Maven (gerenciamento de dependências e build)

## ▶️ Como Executar

1. Clone o repositório:
   ```bash
   git clone https://github.com/vitorrosa0/chess-system-java.git

2. Compile o projeto com Maven:
   mvn compile

3. Execute o jogo:
   mvn exec:java -Dexec.mainClass="com.chess.Chess_System.ChessSystemApplication"
