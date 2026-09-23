# given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i]. The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.

def productExceptSelf(nums):
  length = len(nums)

  prefix = [1] * length
  suffix = [1] * length

  for i in range(1,length):
    prefix[i] = nums[i-1] * prefix[i-1]
  print(f"prefix: {prefix}")

  for i in range(length-2, -1, -1):
    suffix[i] = nums[i+1] * suffix[i+1]
  print(f"suffix: {suffix}")

  result = []
  for i in range (0,length):
    result.append(prefix[i] * suffix[i])

  return result

if __name__ == "__main__":
  print(f"result: {productExceptSelf([2,0,3])}")
  print(f"result: {productExceptSelf([1,2,3,4])}")