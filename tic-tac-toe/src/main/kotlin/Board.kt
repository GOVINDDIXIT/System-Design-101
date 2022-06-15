package ticTacToe

class Board(private val noOfCell: Int) {

    var boxes: Array<Array<Cell?>> = Array(noOfCell) { arrayOfNulls(noOfCell) }

    init {
        initializeBoard()
    }

    fun printBoardStatus() {
        println(" **********************************")
        for (i in 0 until noOfCell) {
            for (j in 0 until noOfCell) {
                if (boxes[i][j]!!.symbol == null) {
                    print(" | " + "  " + " | ")
                } else {
                    print(" | " + boxes[i][j]!!.symbol + "  | ")
                }
            }
            println()
            println(" -----------------------------------")
        }
    }

    private fun initializeBoard() {
        for (i in 0 until noOfCell) {
            for (j in 0 until noOfCell) {
                boxes[i][j] = Cell(null)
            }
        }
        println("GAME STARTED")
        printBoardStatus()
    }
}