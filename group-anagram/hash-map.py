import unittest

# function to group anagrams
def groupAnagrams(strs): 
  anagrams = {}

  for word in strs:
    sorted_word = "".join(sorted(word))

    if sorted_word not in anagrams:
      anagrams[sorted_word] = [word]
    else:
      anagrams[sorted_word].append(word)

  return list(anagrams.values())

# unit tests
class TestGroupAnagrams(unittest.TestCase):
  def test_group_anagrams_1(self):
    input_strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
    expected_output = [["eat", "tea", "ate"], ["tan", "nat"], ["bat"]]
    self.assertEqual(groupAnagrams(input_strs), expected_output)

  def test_group_anagrams_2(self):
    input_strs = [""]
    expected_output = [[""]]
    self.assertEqual(groupAnagrams(input_strs), expected_output)

# main
if __name__ == "__main__":
  unittest.main()

