/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer,
 *     // rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds,
 *     // if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds,
 *     // if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 * Given a nested list of integers, return the sum of all integers in the list weighted by their depth.
*
*Each element is either an integer, or a list -- whose elements may also be integers or other lists.*
*
*Example 1:
*Given the list [[1,1],2,[1,1]], return 10. (four 1's at depth 2, one 2 at depth 1)
 */

 public class Solution {
    public int depthSum(List<NestedInteger> nestedList) {
        // Write your code here
    	return helper(nestedList, 1);
    }

    public int helper(List<NestedInteger> nestedList, int depth){
        if (nestedList == null || nestedList.size() == 0) {
            return 0;
        }
        int sum = 0;
     	for(NestedInteger ni : nestedList){
     		if(ni.isInteger()){
     			sum + = ni.getInteger() * depth;
     		}else{
     			sum += helper(ni.getList(), depth + 1);
     		}
     	}  
     	return sum; 
    }
}


public class Solution {
    public int depthSum(List<NestedInteger> nestedList) {
        // Write your code here
    	if (nestedList == null || nestedList.size() == 0) {
            return 0;
        }
        int sum = 0;
        int depth = 0;
        Queue<NestedInteger> queue = new LinkedList<NestedInteger>();
        for(NestedInteger ni : nestedList){        	
        		queue.offer(ni);
        }
       	while(!queue.isEmpty()){
       		depth ++;
       		int size = queue.size();
       		NestedInteger top = queue.poll();
       		if(top.isInteger){
       			sum += top.getInteger() * depth;
       		}else{
       			for(NestedInteger ni : top){
       				queue.offer(ni);
       			}
       		}
       	}
       	return sum;


    }
    
}