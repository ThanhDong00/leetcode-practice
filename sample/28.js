function strStr(haystack, needle) {
  if (needle === "") return 0;
  if (needle.length > haystack.length) return -1;
  if (haystack.length === 0) return -1;
  var i = 0;
  for (i; i < haystack.length; i++) {
    if (haystack[i] == needle[0]) {
      if (haystack.length == 1 || needle.length == 1) {
        return i;
      }
      for (var j = 1; j < needle.length; j++) {
        if (haystack[i + j] == needle[j]) {
          if (j == needle.length - 1) {
            return i;
          }
        } else {
          break;
        }
      }
    }
  }
  return -1;
}
