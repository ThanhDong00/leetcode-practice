class Solution:
  def generateParentheses(n: int) -> list[str]:
    result = []

    def backtrack(path, open, close):
      if len(path) == n * 2:
        result.append(path)
        return

      if open < n:
        backtrack(path + "(", open + 1, close)

      if close < open:
        backtrack(path + ")", open, close + 1)

    backtrack("", 0, 0)

    return result

if __name__ == "__main__":
  testCase = [
              # (3, ["((()))", "(()())", "(())()", "()(())", "()()()"]),    
              # (1, ["()"]),
              (2, ["(())", "()()"])
              ]

  for i, (n, expected) in enumerate(testCase):
    result = Solution.generateParentheses(n)
    assert result == expected, f"Test case {i+1} failed: expected {expected}, got {result}"
    print(f"Test case {i+1} passed: expected {expected}, got {result}")