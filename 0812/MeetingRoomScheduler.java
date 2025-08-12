import java.util.*;

public class MeetingRoomScheduler {
    public static int minMeetingRooms(int[][] intervals) {
        if (intervals.length == 0) return 0;
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        PriorityQueue<Integer> endTimes = new PriorityQueue<>();

        endTimes.offer(intervals[0][1]);
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= endTimes.peek()) endTimes.poll();
            endTimes.offer(intervals[i][1]);
        }
        return endTimes.size();
    }

    public static void main(String[] args) {
        int[][] meetings = {{0,30},{5,10},{15,20}};
        System.out.println(minMeetingRooms(meetings)); // 2
    }
}
