package ticTacToe

class Game(p1: Player?, p2: Player?) {
    private val board: Board
    private val players: Array<Player?>
    private var currentPlayer: Player?

    private val cellCount = 3
    private val noOfPlayers = 2
    private var dRtoL = 0
    private var dLToR = 0

    private val arrRow = IntArray(cellCount)
    private val arrCol = IntArray(cellCount)
    private var gameState: GameState

    init {
        players = arrayOfNulls(noOfPlayers)
        players[0] = p1
        players[1] = p2
        board = Board(cellCount)
        currentPlayer = players[0]
        gameState = GameState.PLAYING
    }

    fun makeMove(row: Int, col: Int): Boolean {
        return if (gameState == GameState.PLAYING) {
            if (isValidMove(row, col)) {
                board.boxes[row][col]?.symbol = currentPlayer?.symbol
                if (checkIfGameIsWon(row, col)) {
                    board.printBoardStatus()
                    return false
                } else if (checkIfGameIsDraw(row, col)) {
                    board.printBoardStatus()
                    return false
                }
                gameState = GameState.PLAYING
                changePlayerTurn()
                board.printBoardStatus()
                return true
            }
            println(currentPlayer?.userName + " Not a valid move, Please put valid move!")
            board.printBoardStatus()
            false
        } else {
            println(currentPlayer?.userName + " is the winner! GAME IS OVER")
            board.printBoardStatus()
            false
        }
    }

    private fun checkIfGameIsDraw(row: Int, col: Int): Boolean {
        if (dRtoL > cellCount || dLToR > cellCount || arrCol[col] > cellCount || arrRow[row] > cellCount || -cellCount > arrRow[row] || dRtoL < -cellCount || dLToR < -cellCount || arrCol[col] < -cellCount) {
            gameState = GameState.DRAW
            println("Game has been finished with status DRAW!!")
            return true
        }
        return false
    }

    private fun checkIfGameIsWon(row: Int, col: Int): Boolean {
        if (currentPlayer?.userId == players[0]?.userId) {
            if (row == col) {
                dLToR++
            } else if (row + col == cellCount - 1) {
                dRtoL++
            }
            arrRow[row]++
            arrCol[col]++
            if (arrRow[row] == cellCount || arrCol[col] == cellCount || dRtoL == cellCount || dLToR == cellCount) {
                gameState = GameState.WON
                println(currentPlayer?.userName + " has won the Game!!")
                return true
            }
        } else {
            if (row == col) {
                dLToR--
            } else if (row + col == -(cellCount - 1)) {
                dRtoL--
            }
            arrRow[row]--
            arrCol[col]--
            if (arrRow[row] == -cellCount || arrCol[col] == -cellCount || dRtoL == -cellCount || dLToR == -cellCount) {
                gameState = GameState.WON
                println(currentPlayer?.userName + " has won the Game!!")
                return true
            }
        }
        return false
    }

    private fun isValidMove(row: Int, col: Int): Boolean {
        return row < cellCount && col < cellCount && board.boxes[row][col] != null
    }

    private fun changePlayerTurn() {
        currentPlayer = if (currentPlayer?.userId != players[0]?.userId) {
            players[0]
        } else {
            players[1]
        }
    }
}