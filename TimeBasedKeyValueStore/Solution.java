import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

  public static class TimeMap {

    private static final class Entry {

      final int timestamp;
      final String value;

      Entry(int timestamp, String value) {
        this.timestamp = timestamp;
        this.value = value;
      }
    }

    private final Map<String, List<Entry>> store = new HashMap<>();

    public void set(String key, String value, int timestamp) {
      store
        .computeIfAbsent(key, k -> new ArrayList<>())
        .add(new Entry(timestamp, value));
    }

    public String get(String key, int timestamp) {
      List<Entry> entries = store.get(key);
      if (entries == null) return "";

      int left = 0,
        right = entries.size() - 1,
        ans = -1;

      while (left <= right) {
        int mid = left + (right - left) / 2;
        if (entries.get(mid).timestamp <= timestamp) {
          ans = mid;
          left = mid + 1;
        } else {
          right = mid - 1;
        }
      }

      return ans == -1 ? "" : entries.get(ans).value;
    }
  }

  public static void main(String[] args) {
    TimeMap timeMap = new TimeMap();

    timeMap.set("love", "high", 10);
    timeMap.set("love", "low", 20);

    IO.println(timeMap.get("love", 5)); // ""
    IO.println(timeMap.get("love", 10)); // high
    IO.println(timeMap.get("love", 15)); // high
    IO.println(timeMap.get("love", 25)); // low
    IO.println(timeMap.get("hate", 10)); // ""
  }
}
