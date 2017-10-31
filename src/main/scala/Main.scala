package main.scala

import scala.util.Random

object Main extends App {
    val PAIRS_OF_VALUES = 1 to 2
    val NUMBER_OF_CARD_VALUES = 1 to 26
    val SPACES = 1 to 26
    val GAMES_PLAYED = 1000

    def newShuffle(pairsOfValues: Int, numberOfCardValues: Int): Seq[Int] = {
        Random.shuffle((1 to 2 * pairsOfValues * numberOfCardValues)
                .map((i: Int) => i % numberOfCardValues))
    }

    def spacesRequiredForPairs(shuffledDeck: Seq[Int]): Int = {
        var activeCards = Set[Int]()
        var spacesUsed = 0
        shuffledDeck.map((i: Int) => {
            activeCards = if (activeCards(i)) activeCards - i else activeCards + i
            spacesUsed = math.max(spacesUsed, activeCards.size)
        })
        spacesUsed
    }

    def playPairsSolitare(shuffledDeck: Seq[Int], spaces: Int): Boolean = {
        spacesRequiredForPairs(shuffledDeck) <= spaces
    }

    def solitareWinPercentage(pairsOfValues: Int, numberOfCardValues: Int, spaces: Int, gamesPlayed: Int): Double = {
        100.0 / gamesPlayed * (1 to gamesPlayed).count((i: Int) =>
            playPairsSolitare(newShuffle(pairsOfValues, numberOfCardValues), spaces))
    }

    def printSolitareGameInfo(pairsOfValues: Int, numberOfCardValues: Int, spaces: Int, gamesPlayed: Int): Unit = {
        println("Pairs of Values")
        println(pairsOfValues)
        println("Number of card values")
        println(numberOfCardValues)
        println("Spaces")
        println(spaces)
        println("Win Percentage")
        println(solitareWinPercentage(pairsOfValues, numberOfCardValues, spaces, gamesPlayed))
    }
    
    PAIRS_OF_VALUES.map((i: Int) => {
        NUMBER_OF_CARD_VALUES.map((j: Int) => {
            SPACES.map((k: Int) => {
                printSolitareGameInfo(i, j, k, GAMES_PLAYED)
            })
        })
    })
    printSolitareGameInfo(PAIRS_OF_VALUES(1), NUMBER_OF_CARD_VALUES(12), SPACES(12), GAMES_PLAYED)
}
