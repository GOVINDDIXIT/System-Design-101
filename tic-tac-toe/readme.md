# Tic Tac Toe

## Components

### User:
- A user is someone who is available to play the game
- requires username, userid

### Player:
- Once two users game across inside the game and assigned the symbol, they are called player
- Game will require exactly two users to start the game
- Each user will be assigned a different symbol
- requires username, userid, symbol


### Board:
- Board comprises a two-dimensional array where each cell represent a potential place to made the move
- the size of board is fixed and is 3*3
- Game initialised with empty array
- public apis:
- [x] printBoardStatus() to print the current status of the board

### GameState:
- WON: Game is over and we have a winner
- DRAW: Game is over and we don't have a winner
- PLAYING: Game is not over
- can be represented as an enum

### Symbol:
- 0 & X
- can be represented as an enum

### Game:
- require players, board and simulate the Game (todo: can add DI to inject everything from outside)
- each player plays alternatively and game state is checked on every valid move
- public apis:
- [x] makeMove(row, col) allow user to make a move on the board on coordinates passed
- [x] checkIfGameIsDraw() check whether the current game state is DRAW
- [x] checkIfGameIsWon() check whether the current game state is WON
- [x] isValidMove() check whether the move made by player is a valid move
- [x] changePlayerTurn() method to change the current player
- WON: if any of the row, column or either of diagnols is having the same symbol for all three cells
- DRAW: if above state is not achieved and there is no more empty cell available on grid