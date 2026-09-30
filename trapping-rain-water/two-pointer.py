# trapping rain water using two pointer approach 
# giving n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.

def trap(height: list[int]) -> int:
  if not height:
    return 0

  left: int = 0
  right: int = len(height) - 1
  left_max: int = height[left]
  right_max: int = height[right]
  water: int = 0

  while left < right:
    if (height[left] <= height[right]):
      if (height[left] < left_max):
        water += left_max - height[left]
      else:
        left_max = height[left]
      left += 1
    else:
      if (height[right] < right_max):
        water += right_max - height[right]
      else:
        right_max = height[right]
      right -= 1

  return water

if __name__ == "__main__":
  testcases = [
    ([0,1,0,2,1,0,1,3,2,1,2,1], 6),
    ([4,2,0,3,2,5], 9),
    ([4,2,3], 1),
    ([], 0),           
    ([5], 0),          
    ([3,3,3], 0),     
    ([5,4,3,2,1], 0),  
]
  for i, (height, expected) in enumerate(testcases):
    result = trap(height)
    assert result == expected, f"Test case {i+1} failed: expected {expected}, got {result}"
    print(f"Test case {i+1} passed: {result}")