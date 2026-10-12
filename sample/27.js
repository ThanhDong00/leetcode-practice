function removeElement(nums, val) {
  var skip = 0;
  for (var i = 0; i < nums.length; i++) {
    if (nums[i] == val) {
      skip++;
    } else {
      nums[i - skip] = nums[i];
    }
  }
  console.log(nums);
  return nums.length - skip;
}
