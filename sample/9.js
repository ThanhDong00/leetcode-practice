function ai_isPalindrome(x) {
  const str = x.toString();
  const reversed = str.split("").reverse().join("");
  return str === reversed;
}

// Method 2
function isPalindrome(x) {
  if (x < 0) return false;

  const arrayString = x.toString().split("");
  const l = arrayString.length;
  const m = l / 2;
  for (let i = 0; i <= m; i++) {
    if (arrayString[i] != arrayString[l - 1 - i]) {
      return false;
    }
  }

  return true;
}

// Method 3: Without converting to string - reverse half of the number
function isPalindromeNoString(x) {
  // Negative numbers are not palindromes
  if (x < 0) return false;

  // Single digit numbers are palindromes
  if (x < 10) return true;

  // Numbers ending in 0 (except 0 itself) are not palindromes
  if (x % 10 === 0) return false;

  let reversedHalf = 0;

  // Reverse half of the number
  // We stop when original number becomes less than or equal to reversed half
  while (x > reversedHalf) {
    reversedHalf = reversedHalf * 10 + (x % 10);
    x = Math.floor(x / 10);
  }

  // For even number of digits: x === reversedHalf
  // For odd number of digits: x === Math.floor(reversedHalf / 10)
  return x === reversedHalf || x === Math.floor(reversedHalf / 10);
}
