# longest substring without repeating characters 

def length_of_longest_substring(s: str) -> int:
  if len(s) == 1: return 1

  max_length: int = 0
  left: int = 0
  char_set: list = set()

  for right in range(len(s)):
    while s[right] in char_set:
      char_set.remove(s[left])
      left += 1

    char_set.add(s[right])
    max_length = max(max_length, right - left + 1)
    
  return max_length

if __name__ == "__main__":
  testcases = [("abcabcbb", 3), ("bbbbb", 1), ("pwwkew", 3), ("", 0), (" ", 1), ("au", 2), ("dvdf", 3)]

  for i, (s, expected) in enumerate(testcases):
    result = length_of_longest_substring(s)
    assert result == expected, f"Test case {i+1} failed: expected {expected}, got {result}"
    print(f"Test case {i+1} passed: {s} -> {result}")