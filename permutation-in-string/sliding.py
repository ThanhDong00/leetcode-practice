# permutation in string

def checkInclusion(s1: str, s2: str) -> bool:
  if len(s1) > len(s2):
    return False

  left: int = 0
  s1_count: dict[str, int] = {}
  window_count: dict[str, int] = {}

  for char in s1:
    s1_count[char] = s1_count.get(char, 0) + 1

  for right in range(len(s2)):
    window_count[s2[right]] = window_count.get(s2[right], 0) + 1

    while right - left + 1 > len(s1):
      window_count[s2[left]] -= 1
      if window_count[s2[left]] == 0:
        del window_count[s2[left]]
      left += 1

    if window_count == s1_count:
      return True

  return False

if __name__ == "__main__":
  testcases = [
    ("ab", "eidbaooo", True),
    ("ab", "eidboaoo", False),
    ("adc", "dcda", True),
    ("hello", "ooolleoooleh", False),
    ("", "a b", True),
    ("abc", "cabbac", True),
    ("a", "ab", True),
    ("a", "b", False),
    ("abc", "bbbca", True),
  ]

  for i, (s1, s2, expected) in enumerate(testcases):
    result = checkInclusion(s1, s2)
    assert result == expected, f"Test case {i+1} failed: expected {expected}, got {result}"
    print(f"Test case {i+1} passed: expected {expected}, got {result}")