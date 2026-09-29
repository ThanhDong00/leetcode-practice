class Solution:
  def maxArea(self, height: list[int]) -> int:
    left = 0
    right = len(height) - 1
    max_area = 0

    while left < right :
      area = min(height[left], height[right]) * (right - left)

      max_area = max(max_area, area)

      if (height[left] < height[right]): left += 1
      else: right -= 1

    return max_area

if __name__ == "__main__":
  solution = Solution()
  testcases = [
    ([1, 8, 6, 2, 5, 4, 8, 3, 7], 49),
    ([1, 1], 1),
    ([4, 3, 2, 1, 4], 16),
    ([1, 2, 1], 2),
  ]
  for i, (height, expected) in enumerate(testcases):
    result = solution.maxArea(height)
    assert result == expected, f"Test case {i+1} failed: expected {expected}, got {result}"
    print(f"Test case {i+1} passed: expected {expected}, got {result}")
