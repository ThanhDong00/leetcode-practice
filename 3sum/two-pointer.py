# given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0 

def threeSum(nums: list[int]) -> list[list[int]]:
  nums = sorted(nums)
  result: list[list[int]] = []
  n: int = len(nums)

  for i in range(n-2):
    if nums[i] > 0:
       break 
    if (i > 0) and nums[i] == nums[i-1]:
      continue

    left: int = i+1
    right: int = n-1
    target: int = -nums[i]

    while left < right:
        current_sum = nums[left] + nums[right]
        if current_sum == target:
          result.append([nums[i], nums[left], nums[right]])
          left += 1
          right -= 1

          while left < right and nums[left] == nums[left-1]:
              left += 1
          while left < right and nums[right] == nums[right+1]:
              right -= 1  
          
        elif current_sum < target:
          left += 1
        else:
          right -= 1

  return result

if __name__ == "__main__":
  testcases = (
    ([-1, 0, 1, 2, -1, -4], [[-1, -1, 2], [-1, 0, 1]]),
    ([0, 1, 1], []),
    ([0, 0, 0], [[0, 0, 0]]),
    ([0, 0, 0, 0], [[0, 0, 0]]),
    ([-2, 0, 1, 1, 2], [[-2, 0, 2], [-2, 1, 1]]),
    ([-1, 0, 1], [[-1, 0, 1]]),
    ([-1, 2, -1], [[-1, -1, 2]]),
    ([1, 2, -2, -1], []),
    ([], []),
    ([1], []),
    ([1, 2], []),
    ([-1, -1, 2, 0, 1], [[-1, -1, 2], [-1, 0, 1]]),
    ([-2, -2, 0, 1, 1, 2, 2], [[-2, 0, 2], [-2, 1, 1]]))
  for i, (nums, expected) in enumerate(testcases):
    result = threeSum(nums)
    assert result == expected, f"Test case {i+1} failed: expected {expected}, got {result}"
    print(f"Test case {i+1} passed: expected {expected}, got {result}")
               
