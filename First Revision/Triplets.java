	/*
	 * Kate was given a birthday gift of three theater tickets. 
	 * Now she is browsing the theater program for the next N days. 
	 * On the program, performances are named by integers. 
	 * Every day, one performance is staged. 
	 * Kate wants to choose three days (not necessarily consecutive) to go to the theater.
	 * In how many ways can she use her tickets? 
	 * Two ways are different if the sequences of watched performances are different. 
	 * Kate likes the theater, so she may watch one performance more than once. 
	 * For example, if N = 4 and theater program looks as following: [1, 2, 1, 1], 
	 * Kate has four possibilities to choose the dates: [1, 2, 1, 1], [1, 2, 1, 1], [1, 2, 1, 1], 
	 * and [1, 2, 1, 1], but they create only three different sequences: (1, 2, 1), (1, 1, 1) and (2, 1, 1). 
	 * The correct answer for this example is 3. Notice that the order of performances matters, 
	 * so the first and the last sequences are considered different.
	 * */
	class Solution {
		public int solution(int[] A) {
	        // write your code in Java SE 8
	        if(A.length < 3)
		            return 0;
	        int len = A.length;
	        HashMap<Integer,Integer> hash = new HashMap<>();
	        int[] diff = new int[len];		// amount of different numbers with a[i] in [0, i-1] 
	        int[] pairs = new int[len];		// total pairs in [0, i]
	        int[] triples = new int[len];	// total triples in [0, i]
	        boolean[] flag = new boolean[len+1];
	        for(int i = 0 ; i < len ; i++ )
	        {
	            if(!hash.containsKey(A[i]))
	            {
	            	// diff[i]
	                diff[i] = hash.size();
	                hash.put(A[i],i);
	                // use diff[i] to get pairs[i]
	                if(i >= 1)
		            {
		            	if(i == 1)
		            		pairs[i] = 1;
		            	else
		            		pairs[i] = (pairs[i-1]+diff[i])%1000000007;
		            }
	                // use pairs[i] to get triples[i]
	                if(i >= 2){
		            	triples[i] = (triples[i-1]+pairs[i-1])%1000000007;
		        	}
	            }
	            else{
	            	int preIndex = hash.get(A[i]);
	            	// diff[i]
	            	diff[i] = hash.size()-1;
	            	// use diff[i] to get pairs[i]
	                if(i >= 1)
		            {
		            	if(i == 1)
		            	{
		            		// only in pairs[i] need to consider about the pair with same number
		            		// [... a ... a, b ...] once we count [a, a], the result will be record also in pairs[b] and etc.
		            		if(A[i] == A[i-1])
		            			flag[A[i]] = true;
		            		pairs[i] = 1;
		            	}
		            	else{
		            		// prevent the duplicates pairs
			                pairs[i] = (pairs[i-1] + diff[i]-diff[preIndex])%1000000007;
			                if(!flag[A[i]]){
			                	pairs[i]++;
			                	flag[A[i]] = true;
			                }
		            	}
		            }
	                // use pairs[i] to get triples[i]
	                if(i >= 2){
	                	if(preIndex >= 1)
	                		// prevent the duplicates triples
	                		triples[i] = (triples[i-1]+pairs[i-1]-pairs[preIndex-1])%1000000007;
	                	else
	                		triples[i] = (triples[i-1]+pairs[i-1])%1000000007;
		        	}
	                hash.put(A[i], i);
	            }    
	        }
	        return triples[len-1];
	    }
	}