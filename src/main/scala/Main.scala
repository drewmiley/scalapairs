package main.scala

import scala.util.Random

object Main extends App {
    val CARDS_IN_PACK = 52
    val SPACES = 13
    val GAMES_PLAYED = 1000

    def newShuffle(n: Int): Seq[Int] = {
        val orderedDeck = (1 to CARDS_IN_PACK).map((i: Int) => i % 13)
        Random.shuffle(orderedDeck)
    }

    def spacesRequiredForPairs(shuffledDeck: Seq[Int]): Int = {
        println(shuffledDeck)
        0
    }

    def playPairsSolitare(shuffledDeck: Seq[Int], spaces: Int): Boolean = {
        val spacesRequired = spacesRequiredForPairs(shuffledDeck)
        spacesRequired <= spaces
    }

    def solitareWinPercentage(cardsInPacks: Int, spaces: Int, gamesPlayed: Int): Double = {
        val gameOutcomes = (1 to gamesPlayed).map((i: Int) => playPairsSolitare(newShuffle(cardsInPacks), spaces))
        val gamesWon = gameOutcomes.filter((b: Boolean) => b).size
        100.0 * gamesWon / gamesPlayed
    }

    println("Cards in Packs")
    println(CARDS_IN_PACK)
    println("Spaces")
    println(SPACES)
    println("Win Percentage")
    println(solitareWinPercentage(CARDS_IN_PACK, SPACES, GAMES_PLAYED))
}
