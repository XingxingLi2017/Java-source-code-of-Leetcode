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
            return new ArrayList<>();
        List<Interval> res = new ArrayList<>();
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
        Iterator<Interval> itr = intervals.iterator();
        Interval cur = itr.next();
        Interval next = null;
        if(itr.hasNext())           //to avoid NoSuchElementException, always use hasNext() before next()
            next = itr.next();
        while(next != null)
        {
            while(next != null && next.start >= cur.start && next.start <= cur.end)
            {
                if(next.end > cur.end)  //merge the intervals
                {
                    cur.end = next.end;
                }
                if(itr.hasNext())
                    next = itr.next();
                else
                    next = null;
            }
            res.add(cur);
            cur = next;
        }
        if(res.size() == 0)
        {
            res.add(cur);
        }
        return res;
        
    }
}