#!/usr/bin/env groovy
@Grab(group='org.spockframework', module='spock-core', version='1.0-groovy-2.4')

import spock.lang.*

class MyFirstSpecification extends Specification {
    def "An empty grid stays empty when the game logic is applied"() {
        given: "A 1x1 grid, with no living cells"
        def gridWithOneCell = [[false]]

        when: "I process a tick for the grid"
        def resultingCell = GameOfLifeProcessor.processGrid(gridWithOneCell)

        then: "The resulting grid should stay the same"
        assert resultingCell == gridWithOneCell
    }

    def "A grid with no neighbours dies"() {
        given: "A 1x1 grid with a living cell"
        def gridWithOneLivingCell = [[true]]

        when: "I process a tick for the grid"
        def resultingCell = GameOfLifeProcessor.processGrid(gridWithOneLivingCell)

        then: "That is a 1x1 grid with a dead cell"
        resultingCell == [[false]]
    }

    def "A 2x1 grid, with no living cells should stay empty"() {
        given: "A 2x1 grid, with no living cells"
        def rowWithTwoEmptyCells = [[false, false]]

        when: "I process a row"
        def resultingRow = GameOfLifeProcessor.processGrid(rowWithTwoEmptyCells)

        then: "Resulting row"
        resultingRow == [[false,false]]
    }

    def "A 5 X 1 grid with three living cells in the middle results in a single survivor"() {
        given:
        def threeLivingCellsInARow = [[false, true, true, true, false]]

        when:
        def resultingRow = GameOfLifeProcessor.processGrid(threeLivingCellsInARow)

        then:
        resultingRow == [[false, false, true, false, false]]
    }
}

class GameOfLifeProcessor {
    static List<List<Boolean>> processGrid(List<List<Boolean>> rows) {

    }
}
