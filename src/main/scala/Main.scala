package main.scala

object Main extends App {
    val PAIRS_OF_VALUES = 1 to 2
    val NUMBER_OF_CARD_VALUES = 1 to 26
    val SPACES = 1 to 26
    val GAMES_PLAYED = 1000
    
    PAIRS_OF_VALUES.map((pairsOfValues: Int) => {
        println()
        print(s"Pairs of Values: $pairsOfValues")
        println()
        print("C\\S")
        SPACES.map((spaces: Int) => {
            print(s"\t$spaces")
        })
        println()
        NUMBER_OF_CARD_VALUES.map((numberOfCardValues: Int) => {
            print(s"$numberOfCardValues")
            SPACES.map((spaces: Int) => {
                val winPercentage = if (spaces <= numberOfCardValues) Math.round(100.0 * (1 to GAMES_PLAYED).count((i: Int) =>
                    new PairsSolitare(new Deck(pairsOfValues, numberOfCardValues).shuffle(), spaces).play()) / GAMES_PLAYED) else 100
                print(s"\t$winPercentage")
            })
            println()
        })
    })
}
