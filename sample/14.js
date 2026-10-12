/**
 * @param {string[]} strs
 * @return {string}
 */
var longestCommonPrefix = function (strs) {
  if (strs.length == 0) return "";
  if (strs.length == 1) return strs[0];

  const base = strs[0];

  for (var i = 0; i < base.length; i++) {
    for (var j = 1; j < strs.length; j++) {
      if (base[i] !== strs[j][i]) {
        base = base.substring(0, i);
      }
    }
  }

  return base;
};

longestCommonPrefix(["flower", "flow", "flight"]);

// ["flower", "flow", "flight"]
// flower
// flow
// flight
