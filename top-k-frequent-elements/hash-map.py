# given an interger array nums and an integer k, return the k most frequent elements. You may return the answer in any order.

import heapq

def topKFrequent(nums, k):
  freq_map = {}

  for num in nums:
    freq_map[num] = freq_map.get(num, 0) + 1

  heap = []
  print(freq_map)

  for element, frequency in freq_map.items():
    heapq.heappush(heap, (frequency, element))
    print(heap)

    if len(heap) > k:
      heapq.heappop(heap) 
      print(heap)

  return [pair[1] for pair in heap]

if __name__ == "__main__":
  print(topKFrequent([1,1,1,2,3,3,3,3,4,4], 2))