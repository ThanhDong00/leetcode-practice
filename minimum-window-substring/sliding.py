# minimun window substring

def min_window_substring(s: str, t: str) -> str:
  # if not s or not t: return ""

  # t_count: dict[str, int] = {}
  # for char in t:
  #   t_count[char] = t_count.get(char, 0) + 1

  # required: int = len(t_count)
  # left: int = 0
  # right: int = 0
  # formed: int = 0
  # window_counts: dict[str, int] = {}
  # min_length: int = float("inf")
  # min_left: int = 0

  # while right < len(s):
  #   char: str = s[right]
  #   window_counts[char] = window_counts.get(char, 0) + 1

  #   if char in t_count and window_counts[char] == t_count[char]:
  #     formed += 1

  #   while left <= right and formed == required:
  #     char = s[left]

  #     if right - left + 1 < min_length:
  #       min_length = right - left + 1
  #       min_left = left

  #     window_counts[char] -= 1
  #     if char in t_count and window_counts[char] < t_count[char]:
  #       formed -= 1

  #     left += 1
    
  #   right += 1

  # return "" if min_length == float("inf") else s[min_left:min_left + min_length]

  if not s or not t: return ""

  t_count: dict[str, int] = {}
  for char in t:
    t_count[char] = t_count.get(char, 0) + 1

  left: int = 0
  right: int = 0
  formed: int = 0
  window_count: dict[str, int] = {}
  min_left: int = 0
  min_length: int = float("inf")

  while right < len(s):
    char = s[right]
    window_count[char] = window_count.get(char, 0) + 1

    if char in t_count and t_count[char] == window_count[char]:
      formed += 1

    while left <= right and formed == len(t_count):
      char = s[left]

      if right - left + 1 < min_length:
        min_length = right - left + 1 
        min_left = left

      window_count[char] -= 1
      if char in t_count and window_count[char] < t_count[char]:
        formed -= 1
      
      left += 1

    right += 1

  return "" if min_length == float("inf") else s[min_left: min_left + min_length]
    
if __name__ == "__main__":
  test_cases = (
    ("ADOBECODEBANC", "ABC", "BANC"),
    ("a", "a", "a"),
    ("a", "aa", ""),
    ("ab", "b", "b"),
    ("ab", "a", "a"),
    ("ab", "ab", "ab"),
    ("ab", "ba", "ab"),
    ("accbca", "ab", "bca")
  )

  for i, (s, t, expected) in enumerate(test_cases):
    result = min_window_substring(s, t)
    assert result == expected, f"Test case {i + 1} failed: expected {expected}, got {result}"
    print(f"Test case {i + 1} passed: {s}, {t} => {result}")
