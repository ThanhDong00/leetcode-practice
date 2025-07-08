// Method 1
function twoSum(nums: number[], target: number): number[] {
  for (var i = 0; i < nums.length - 1; i++) {
    for (var j = 1; j < nums.length; j++) {
      var total = nums[i] + nums[j];
      if (total == target) {
        return [i, j];
      }
    }
  }
  return [];
}

// Method 2
function twoSum2(nums: number[], target: number): number[] {
  const numMap = new Map<number, number>();
  for (let i = 0; i < nums.length; i++) {
    const complement = target - nums[i];
    if (numMap.has(complement)) {
      return [numMap.get(complement)!, i];
    }
    numMap.set(nums[i], i);
  }
  return [];
}

const r = twoSum([1, 2, 3, 4, 5, 6], 7);
console.log(r);
