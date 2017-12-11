package main.scala

object Main extends App {
    val PAIRS_OF_VALUES = 1 to 2
    val NUMBER_OF_CARD_VALUES = 1 to 26
    val SPACES = 1 to 26
    val GAMES_PLAYED = 1000

    def printSolitareGameInfo(pairsOfValues: Int, numberOfCardValues: Int, spaces: Int, gamesPlayed: Int): Unit = {
        print(s"Pairs of Values: $pairsOfValues")
        print(s"\tNumber of card values: $numberOfCardValues")
        print(s"\tSpaces: $spaces")
        val winPercentage = 100.0 * (1 to gamesPlayed).count((i: Int) =>
            new PairsSolitare(new Deck(pairsOfValues, numberOfCardValues).shuffle(), spaces).play()) / gamesPlayed
        print(s"\tWin Percentage: $winPercentage")
        println()
    }
    
    PAIRS_OF_VALUES.map((pairsOfValues: Int) => {
        NUMBER_OF_CARD_VALUES.map((numberOfCardValues: Int) => {
            SPACES.map((spaces: Int) => {
                if (spaces <= numberOfCardValues) {
                    printSolitareGameInfo(pairsOfValues, numberOfCardValues, spaces, GAMES_PLAYED)
                }
            })
        })
    })
}
