/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
/*
    Idea: divide list into three parts:
        [interval.end<newInterval.start][overlapping part][interval.start > newInterval.end]
        make a new node to merge the second part 
*/

class Solution {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        
        List<Interval> res = new LinkedList<>();
        int pointer = 0;
        //  the first part isn't influenced.
        for(;pointer < intervals.size() && intervals.get(pointer).end < newInterval.start;pointer++)
        {
            res.add(intervals.get(pointer));
        }
        //  merge the overlapping part. keep updating the newNode.
        Interval newNode = new Interval(newInterval.start, newInterval.end);
        for(;pointer < intervals.size() && intervals.get(pointer).start <= newInterval.end;pointer++)
        {
            newNode.start = Math.min(intervals.get(pointer).start, newNode.start);
            newNode.end = Math.max(intervals.get(pointer).end, newNode.end);    
        }
        res.add(newNode);
        //  the third part isn't affected.
        for(;pointer<intervals.size();pointer++)
        {
            res.add(intervals.get(pointer));
        }
        return res;
    }
}