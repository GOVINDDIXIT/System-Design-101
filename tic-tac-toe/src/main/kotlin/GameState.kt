package ticTacToe

/*
    Possible Game States:
    WON: Game is ended and we have a winner
    DRAW: Game is ended and we don't have a winner
    PLAYING: Game is not ended
 */
enum class GameState {
    WON, DRAW, PLAYING
}