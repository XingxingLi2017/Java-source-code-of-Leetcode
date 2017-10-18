/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution {
    /*
        sort the list based on interval.start, then use cur, next  poiter traverse the list
    */
    public List<Interval> merge(List<Interval> intervals) {
          if(intervals.size() == 0)   
            return intervals;
        //sort the list by Interval.start
        Collections.sort(intervals, new Comparator(){
            public int compare(Object a, Object b)
            {
                if(a instanceof Interval && b instanceof Interval)
                {
                    Interval pre = (Interval)a;
                    Interval suff = (Interval)b;
                    int flag = pre.start - suff.start;
                    return flag == 0? (pre.end-suff.end) :flag;
                }
                else
                {
                    throw new ClassCastException();
                }
            }
        });  
        // Traverse and Merge
        List<Interval> res = new LinkedList<>();
        res.add(intervals.get(0));
        for(Interval t: intervals)
        {
            Interval cur = res.get(res.size()-1);
            if(t.start <= cur.end)      // it's impossible that t.start < cur.start
            {
                cur.end = Math.max(t.end, cur.end);
            }
            else
            {
                res.add(t);
            }
            
        }
        return res;
        
    }
}