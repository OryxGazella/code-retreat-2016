var assert = require('assert');
const L = true
const E = false
describe("Conway's Game of Life", function() {
  describe('count neighbours', function() {
    ;let grid =
   [[E, E, E, E],
    [E, L, L, E],
    [E, L, L, E],
    [E, E, E, E]]
    it(' should return -1 when the value is not present', function() {
      assert.equal(1, numberOfLiveNeighbours(0, 0, grid));
    });
  });
});

function numberOfLiveNeighbours(column, row, grid) {
  return 0;
}
