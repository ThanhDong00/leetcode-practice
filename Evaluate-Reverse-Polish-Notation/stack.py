# Evaluate Reverse Polish Notation

def evalRPN(tokens: list[str]) -> int:
  stack: list[int] = []

  for str in tokens:
    if str not in ["+", "-", "*", "/"]:
      stack.append(str)
    else:
      b = int(stack.pop())
      a = int(stack.pop())
      if str == "+":
        result = a + b
      elif str == "-":
        result = a - b
      elif str == "*":
        result = a * b
      else:
        result = int(a/b)
      stack.append(result)
  return stack[0] if stack != {} else 0

if __name__ == "__main__":
  testcases = [
    (["2", "1", "+", "3", "*"], 9),
    (["4", "13", "5", "/", "+"], 6),
    (["10", "6", "9", "3", "/", "-", "*"], 30),
  ]
  for i, (tokens, expected) in enumerate(testcases):
    result = evalRPN(tokens)
    assert result == expected, f"Test failed for input {tokens}. Expected {expected}, got {result}"
    print(f"Test {i + 1} passed for input {tokens}.")