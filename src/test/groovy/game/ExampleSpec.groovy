package game

import spock.lang.Specification

/**
 * An example of a Spock BDD Specification
 */
class ExampleSpec extends Specification {
    private blinker
    /*
    [_, _, _, _, _]
    [_, L, L, L, _]
    [_, _, _, _, _]
     */

    void setup() {
        blinker = [1: [1: true],
                   2: [1: true],
                   3: [1: true]]
    }

    def "Given a seed with a single cell at (2, 2)"() {
        given:
        def seed = [2: [2: true]]

        expect:
        assert numberOfLiveCellsInACoordinate(2, 2, seed) == 1
        assert numberOfLiveCellsInACoordinate(2, 1, seed) == 0
    }

    def "Blinker should have cells at TODO"() {
        expect:
        assert numberOfLiveNeighboursAtCoordinate(0, 0, this.blinker) == 1
        assert numberOfLiveNeighboursAtCoordinate(2, 0, this.blinker) == 3
        assert numberOfLiveNeighboursAtCoordinate(2, 1, this.blinker) == 2
    }

    def "Blinker's left and right cells die"() {
        when:
        def resultingLiveCellMap = processGameOfLife(this.blinker)
//        def secondGeneration = processGameOfLife(resultingLiveCellMap)

        then:
        numberOfLiveCellsInACoordinate(1, 1, resultingLiveCellMap) == 0
//        secondGeneration == blinker
    }

    def processGameOfLife(seed) {
        for (int x : seed.keySet()) {
            def yMap = seed.get(x)
            for (int y : yMap.keySet()) {
                if (numberOfLiveNeighboursAtCoordinate(x, y, seed) < 2) {
                    yMap.remove(y)
                }

            }
        }
        return seed
    }

    int numberOfLiveNeighboursAtCoordinate(int x, int y, liveCellMapXByY) {
        return (numberOfLiveCellsInACoordinate(x - 1, y, liveCellMapXByY)
                + numberOfLiveCellsInACoordinate(x - 1, y + 1, liveCellMapXByY)
                + numberOfLiveCellsInACoordinate(x, y + 1, liveCellMapXByY)
                + numberOfLiveCellsInACoordinate(x + 1, y + 1, liveCellMapXByY)
                + numberOfLiveCellsInACoordinate(x + 1, y, liveCellMapXByY)
                + numberOfLiveCellsInACoordinate(x + 1, y - 1, liveCellMapXByY)
                + numberOfLiveCellsInACoordinate(x, y - 1, liveCellMapXByY)
                + numberOfLiveCellsInACoordinate(x - 1, y - 1, liveCellMapXByY))
    }

    //Production code
    int numberOfLiveCellsInACoordinate(int x, int y, liveCellMapXByY) {
        return ((liveCellMapXByY != null && liveCellMapXByY.get(x) != null && liveCellMapXByY.get(x).get(y) != null) ? 1 : 0)
    }
}
