package main.scala

import scala.util.Random

object Deck {

    def shuffle(pairsOfValues: Int, numberOfCardValues: Int): Seq[Int] = {
        Random.shuffle((1 to 2 * pairsOfValues * numberOfCardValues)
                .map((i: Int) => i % numberOfCardValues))
    }
}
