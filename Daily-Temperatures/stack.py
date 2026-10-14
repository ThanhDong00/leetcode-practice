# Daily Temperatures

def dailyTemperatures(Temps: list[int]) -> list[int]:
  stack: list[int] = []
  result: list[int] = [0] * len(Temps)

  for i in range(len(Temps)):
    while stack and Temps[i] > Temps[stack[-1]]:
      last_index = stack.pop()
      result[last_index] = i - last_index

    stack.append(i)

  return result

if __name__ == "__main__":
  test_cases = [([73, 74, 75, 71, 69, 72, 76, 73], [1, 1, 4, 2, 1, 1, 0, 0]),
                ([30, 40, 50, 60], [1, 1, 1, 0]),
                ([30, 60, 90], [1, 1, 0]),
                ([10,9,8,7], [0,0,0,0])]
  for i, (temps, expected) in enumerate(test_cases):
    result = dailyTemperatures(temps)
    assert result == expected, f"Test case {i + 1} failed: expected {expected}, got {result}"
    print(f"Test case {i + 1} passed: {result}")
