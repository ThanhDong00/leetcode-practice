# you are given an array prices where pricespi[ is the price of a given stock on the i-th day. You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock. Return the maximun profit you can achieve from this transaction. If you cannot achieve any profit, return 0.

def maxProfit(prices: list[int]) -> int:
  if len(prices) < 2 : return 0

  min_price: int = prices[0] 
  max_profit: int = 0

  for price in prices[1:]:
      min_price = min(price,min_price)
      max_profit = max(max_profit, price - min_price)

  return max_profit

if __name__ == "__main__":
  testcases = [
    ([7, 1, 5, 3, 6, 4], 5), 
    ([7, 6, 4, 3, 1], 0), 
    ([1, 2], 1), 
    ([2, 4, 1], 2), 
    ([3, 2, 6, 5, 0, 3], 4),
    ([2,10,1,7], 8)
  ]
  for i, (prices, expected) in enumerate(testcases):
    result = maxProfit(prices)
    assert result == expected, f"Test case {i + 1} failed: {prices} -> {result}, expected {expected}"
    print(f"Test case {i + 1} passed: {prices} -> {result}")