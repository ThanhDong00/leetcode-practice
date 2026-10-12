function removeDuplicates(nums) {
  const map = new Map();
  var skip = 0;
  for (var i = 0; i < nums.length; i++) {
    if (map.has(nums[i])) {
      skip++;
    } else {
      map.set(nums[i], 1);
      nums[i - skip] = nums[i];
    }
  }
  return map.size;
}
