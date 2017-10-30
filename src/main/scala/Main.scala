package main.scala

object Main extends App {
    val CARDS_IN_PACK = 52
    val SPACES = 13
    val GAMES_PLAYED = 1000

    def shuffle(n: Int): Seq[Int] = {
        val numberSet = 1 to CARDS_IN_PACK toSet
        val shuffledDeck = numberSet.toSeq
        return shuffledDeck
    }

    val deck = shuffle(CARDS_IN_PACK)

    def playPairsSolitare(seq: Seq[Int]): Boolean = {
        return true
    }

    println(playPairsSolitare(deck))
}
