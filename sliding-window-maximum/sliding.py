# sliding window maximum
from collections import deque 

def sliding_window_maximum(nums: list[int], k: int) -> list[int]:
  if not nums or k <= 0: return []

  res: list[int] = []
  dq: list[int] = deque()

  for i, x in enumerate(nums):
    if dq and dq[0] < i - k + 1:
      dq.popleft()

    while dq and nums[dq[-1]] < x:
      dq.pop()

    dq.append(i)

    if dq and i >= k - 1:
      res.append(nums[dq[0]])

  return res

if __name__ == "__main__":
  test_cases = [
    ([1,3,-1,-3,5,3,6,7], 3, [3,3,5,5,6,7]),
    ([1], 1, [1]),
    ([1, -1], 1, [1, -1]),
    ([9, 11], 2, [11]),
    ([4, -2], 2, [4]),
  ]
  for nums, k, expected in test_cases:
    result = sliding_window_maximum(nums, k)
    assert result == expected, f"Test failed for input {nums} with k={k}. Expected {expected}, got {result}"
    print(f"Test passed for input {nums} with k={k}. Result: {result}")