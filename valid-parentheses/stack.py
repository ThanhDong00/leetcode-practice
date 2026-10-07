# valid parentheses

def isValid(s: str) -> bool:
  stack: list[str] = []
  mapping: dict[str, str] = {")": "(", "}": "{", "]": "["}

  for char in s:
    if char in mapping:
      if stack and stack[-1] == mapping[char]:
        stack.pop()
      else:
        return False
    else:
      stack.append(char)

  return len(stack) == 0

if __name__ == "__main__":
  test_cases = [("()", True), ("()[]{}", True), ("(]", False), ("([)]", False), ("{[]}", True)]
  for i, (s, expected) in enumerate(test_cases):
    result = isValid(s)
    assert result == expected, f"Test case {i+1} failed: expected {expected}, got {result}"
    print(f"Test case {i+1} passed: {s} -> {result}")