package main.scala

object Main extends App {
    val CARDS_IN_PACK = 52

    def shuffledDeck(n: Int): Seq[Int] = {
        val numberSet = 1 to CARDS_IN_PACK toSet
        val shuffledDeck = numberSet.toSeq
        return shuffledDeck
    }

    println(shuffledDeck(CARDS_IN_PACK))
}
