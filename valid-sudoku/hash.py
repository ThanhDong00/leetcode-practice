# determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:
# Each row must contain the digits 1-9 without repetition.
# Each column must contain the digits 1-9 without repetition.
# Each of the 9 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.

# note:
# A Sudoku board (partially filled) could be valid but is not necessarily solvable.
# Only the filled cells need to be validated according to the mentioned rules.

# Constraints:
# board.length == 9
# board[i].length == 9
# board[i][j] is a digit from 1 to 9 or '.'

def isValidSudoku(board: list[list[str]]) -> bool:
  rows = [set() for _ in range(9)]
  cols = [set() for _ in range(9)]
  boxes = [[set() for _ in range(3)] for _ in range(3)]

  # print(f"rows: {rows}")
  # print(f"cols: {cols}")
  # print(f"boxes: {boxes}")

  for i in range(9):
    for j in range(9):
      cell = board[i][j]

      if cell == ".":
        continue

      if (cell in rows[i] or 
          cell in cols[j] or 
          cell in boxes[i//3][j//3]):
        return False

      rows[i].add(cell)
      cols[j].add(cell)
      boxes[i//3][j//3].add(cell)

  return True 

if __name__ == "__main__":
  board = [["5","3",".",".","7",".",".",".","."],
           ["6",".",".","1","9","5",".",".","."],
           [".","9","8",".",".",".",".","6","."],
           ["8",".",".",".","6",".",".",".","3"],
           ["4",".",".","8",".","3",".",".","1"],
           ["7",".",".",".","2",".",".",".","6"],
           [".","6",".",".",".",".","2","8","."],
           [".",".",".","4","1","9",".",".","5"],
           [".",".",".",".","8",".",".","7","9"]]
  print(f"result: {isValidSudoku(board)}")