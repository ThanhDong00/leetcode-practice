/**
 * @param {string} s
 * @return {boolean}
 */
var isValid = function (s) {
  const stack = [];

  const pair = {
    "}": "{",
    "]": "[",
    ")": "(",
  };

  for (var i = 0; i < s.length; i++) {
    if (["{", "[", "("].includes(s[i])) {
      stack.push(s[i]);
    } else if (["}", "]", ")"].includes(s[i])) {
      if (stack.length === 0 || stack.pop() !== pair[s[i]]) {
        return false;
      }
    }
  }
  return stack.length === 0;
};

// (){}[]
// 012345
// ({[]})
// ([)]

// 5/2 = 2
// i <= 2
// j > 2
