/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number}
 */
var searchInsert = function (nums, target) {
  if (target > nums[nums.length - 1]) return nums.length;
  if (target < nums[0]) return 0;

  var l = 0;
  var r = nums.length - 1;
  while (l <= r) {
    var mid = Math.floor((l + r) / 2);
    if (nums[mid] === target) return mid;
    if (nums[mid] < target) l = mid + 1;
    else r = mid - 1;
  }
  return l;
};

const result = searchInsert([1, 3, 5, 6], 2);
console.log(result);
