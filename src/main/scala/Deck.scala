package main.scala

import scala.util.Random

class Deck(pairsOfValues: Int, numberOfCardValues: Int) {

    def shuffle(): Seq[Int] = {
        Random.shuffle((1 to 2 * pairsOfValues * numberOfCardValues)
                .map((i: Int) => i % numberOfCardValues))
    }
}
