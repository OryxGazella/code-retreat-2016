"use strict";
var assert = require('assert');
describe("Conway's Game of Life", function () {
    describe("Is Cell Alive", function () {
        it("Returns 1 for a cell in the map", function () {
            assert.equal(cellValue(0, 0, {
                "0": {"0": 1}
            }), 1)
        });

        it("Returns 0 for a cell not in the map", function () {
            assert.equal(cellValue(0, 1, {
                "0": {"0": 1}
            }), 0)
        })
    });

    describe("Number of living neighbours", function () {
        //given
        const blinker = {
            "1":{
                "0": 1,
                "1":1,
                "2":1
            }
        };

        it("Shows 2 for the origin cell (0, 0)", function () {
            assert.equal(numberOfLiveNeighboursForCell(0, 0, blinker), 2)
        })

        it("Shows 3 for (2, 1)", function () {
            assert.equal(numberOfLiveNeighboursForCell(0, 0, blinker), 3)
        })
    })
});

function numberOfLiveNeighboursForCell(column, row, grid) {
    // return cellValue(column, row + 1, grid) + cellValue(column + 1, row + 1, grid) + cellValue(column + 1, row, grid)+ cellValue(column+1 ,row -1,grid) + cellValue(column-1,row -1,grid), cellValue(column-1,grid -1,)

    return (column - 1,row + 1)+(column,row +1)+(column + 1,row + 1)+(column,row +1)+(column + 1,row + -1)+(column,row + -1)+(column + 1,row + -1)+(column + 1,row + -1)

}
// 1 is alive 0 is dead
function cellValue(column, row, grid) {
    return (grid[row] !== undefined && grid[row][column] !== undefined && grid[row][column] === 1) ? 1 : 0;
}
/*
   var assert = require('assert');
   describe('Array', function() {
   describe('#indexOf()', function() {
   it('should return -1 when the value is not present', function() {
   assert.equal(-1, [1,2,3].indexOf(4));
   });
   });
   });*/
