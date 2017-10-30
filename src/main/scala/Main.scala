package main.scala

import scala.util.Random

object Main extends App {
    val PAIRS_OF_VALUES = 2
    val NUMBER_OF_CARD_VALUES = 13
    val SPACES = 13
    val GAMES_PLAYED = 1000

    def newShuffle(pairsOfValues: Int, numberOfCardValues: Int): Seq[Int] = {
        val orderedDeck = (1 to 2 * pairsOfValues * numberOfCardValues).map((i: Int) => i % numberOfCardValues)
        Random.shuffle(orderedDeck)
    }

    def spacesRequiredForPairs(shuffledDeck: Seq[Int]): Int = {
        var deck = shuffledDeck
        var last = 0
        var activeCards = Set[Int]()
        var spacesUsed = 0
        println(deck)
        while (deck.size > 0) {
            last = deck.last
            deck = deck.init
            if (activeCards(last)) {
                activeCards = activeCards - last
                spacesUsed -= 1
            } else {
                activeCards = activeCards + last
                spacesUsed += 1
            }
            println(activeCards)
            println(spacesUsed)
        }
        spacesUsed
    }

    def playPairsSolitare(shuffledDeck: Seq[Int], spaces: Int): Boolean = {
        val spacesRequired = spacesRequiredForPairs(shuffledDeck)
        spacesRequired <= spaces
    }

    def solitareWinPercentage(pairsOfValues: Int, numberOfCardValues: Int, spaces: Int, gamesPlayed: Int): Double = {
        val gamesWon = (1 to gamesPlayed).filter((i: Int) => playPairsSolitare(newShuffle(pairsOfValues, numberOfCardValues), spaces)).size
        100.0 * gamesWon / gamesPlayed
    }

    println("Pairs of Values")
    println(PAIRS_OF_VALUES)
    println("Number of card values")
    println(NUMBER_OF_CARD_VALUES)
    println("Spaces")
    println(SPACES)
    println("Win Percentage")
    println(solitareWinPercentage(PAIRS_OF_VALUES, NUMBER_OF_CARD_VALUES, SPACES, GAMES_PLAYED))
}
