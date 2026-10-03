# longest repeating character replacement

def characterReplacement(s: str, k: int) -> int:
  left: int = 0
  max_count: int = 0
  max_length: int = 0
  char_list: dict[str, int] = {}

  for right in range(len(s)):
    char_list[s[right]] = char_list.get(s[right], 0) + 1
    max_count = max(max_count, char_list[s[right]])
    
    while (right - left + 1) - max_count > k:
      char_list[s[left]] -= 1
      left += 1

    max_length = max(max_length, right - left + 1)

  return max_length

if __name__ == "__main__":
  testcases = [
    ("AABBBBA", 1, 5),
    ("ABAB", 2, 4),
    ("AABABBA", 1, 4),
    ("ABCCB", 1, 3),
    ("AAAA", 2, 4),
    ("ABCDE", 1, 2),
    ("AABBA", 2, 5),
    ("AABBA", 0, 2),
    ("AABBA", 1, 3),
  ]

  for i, (s, k, expected) in enumerate(testcases):
    result = characterReplacement(s, k)
    assert result == expected, f"Test case {i+1} failed: expected {expected}, got {result}"
    print(f"Test case {i+1} passed: expected {expected}, got {result}")