package ticTacToe

object TicTacToe {

    /*
        Checkout unit tests under test package for exhaustive testing
     */

    fun main(args: Array<String>) {
        val p1 = Player("Govind", "GD", Symbol.X)
        val p2 = Player("Anuj", "AJ", Symbol.O)

        val ticTac = Game(p1, p2)
        ticTac.makeMove(0, 0)
        ticTac.makeMove(1, 0)
        ticTac.makeMove(1, 1)
        ticTac.makeMove(0, 1)
        ticTac.makeMove(2, 2)
    }
}