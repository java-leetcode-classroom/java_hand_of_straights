import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Solution {
  public boolean isNStraightHand(int[] hand, int groupSize) {
    int nHand = hand.length;
    if (nHand % groupSize != 0) {
      return false;
    }
    HashMap<Integer, Integer> count = new HashMap<>();
    for (int card : hand) {
      int currentCount = 0;
      if (count.containsKey(card)) {
        currentCount = count.get(card);
      }
      count.put(card, currentCount+1);
    }
    PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) ->  a - b);
    for (Map.Entry<Integer, Integer> pair : count.entrySet()) {
      pq.add(pair.getKey());
    }
    while(pq.size() > 0) {
      int start = pq.peek();
      int end = start + groupSize;
      for (int card = start; card < end; card++ ) {
        if (!count.containsKey(card)) {
          return false;
        }
        int currentCount = count.get(card);
        int remain = currentCount - 1;
        count.put(card, remain);
        if (remain == 0) {
          pq.poll();
        }
      }
    }
    return true;
  }
}
