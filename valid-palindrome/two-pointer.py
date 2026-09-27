# a phrase is pa palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, it reads the same forward and backward. alphanumeric characters include letters and numbers.
# given a string s, return true if it is a palindrome, or false otherwise

def isPalindrome(s):
  left = 0
  right = len(s)-1 

  while left < right:
    while left < right and not s[left].isalnum():
      left += 1
    while left < right and not s[right].isalnum():
      right-= 1

    if s[left].lower() != s[right].lower():
      return False

    left += 1
    right -= 1  

  return True

if __name__ == "__main__":
  testcase = ["", "A man, a plan, a canal: Panama", "race a car", "0P", " "]

  print("Test cases for isPalindrome function:")
  for s in testcase:
    print(f"{s}: {isPalindrome(s)}")
