# min stack: design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

# just create two stacks, one for tracking main stack, one for tracking minimums. When pushing, if the new value is less than or equal to the current minimum, push it onto the min stack as well. When popping, if the popped value is equal to the current minimum, pop it from the min stack as well.

class MinStack:
  def __init__(self):
    self.main_stack = []
    self.min_stack = []

  def push(self, x: int) -> None:
    self.main_stack.append(x)
    if not self.min_stack or x <= self.min_stack[-1]:
      self.min_stack.append(x)

    print(f"Pushed {x}. Main stack: {self.main_stack}, Min stack: {self.min_stack}")

  def pop(self) -> None:
    if self.main_stack:
      popped_value = self.main_stack.pop()
    if popped_value == self.min_stack[-1]:
      self.min_stack.pop()

    print(f"Popped {popped_value}. Main stack: {self.main_stack}, Min stack: {self.min_stack}")

  def top(self) -> int:
    if self.main_stack:
      return self.main_stack[-1]
    return None

  def get_min(self) -> int:
    if self.min_stack:
      return self.min_stack[-1]
    return None

if __name__ == "__main__":
  min_stack = MinStack()
  print("push 1:")
  min_stack.push(1)
  print("push 1:")
  min_stack.push(1)
  print("push 1:")
  min_stack.push(1)
  print(f"Minimum: {min_stack.get_min()}")  # Returns -3
  print("pop:")
  min_stack.pop()
  print(f"Top: {min_stack.top()}")       # Returns 0
  print(f"Minimum: {min_stack.get_min()}")   # Returns -2