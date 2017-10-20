class Solution {
    /*
        use a pair of numbers to simulate the process
    */
    public boolean judgeCircle(String moves) {
        if(moves.length() == 0)
            return true;
        
        char[] move=moves.toCharArray();
        
        int x=0, y=0;
        for(int i=0; i < move.length; i++)
        {
            switch (move[i])
            {
                case 'U': y++;
                    break;
                case 'D': y--;
                    break;
                case 'L': x--;
                    break;
                case 'R': x++;
                    break;  
            }
        }
        if(x==0 && y==0)
            return true;
        else
            return false;
    }
}