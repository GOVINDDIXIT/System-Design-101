import org.junit.Test
import ticTacToe.Game
import ticTacToe.Symbol
import ticTacToe.Player

class TicTacToeTest {

    @Test
    fun gameTest() {
        val p1 = Player("Govind", "gd", Symbol.X)
        val p2 = Player("Anuj", "aj", Symbol.O)

        val ticTac = Game(p1, p2)
        ticTac.makeMove(0, 0)
        ticTac.makeMove(0, 1)
        ticTac.makeMove(0, 2)
        ticTac.makeMove(1, 1)
        ticTac.makeMove(1, 0)
        ticTac.makeMove(2, 1)
        ticTac.makeMove(2, 2)
    }
}