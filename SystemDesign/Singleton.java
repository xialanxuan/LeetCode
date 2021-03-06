/*
9 - Message System & Rate Limiter

204  Singleton



Singleton is a most widely used design pattern. If a class has and only has one instance at every moment, we call this design as singleton. For example, for class Mouse (not a animal mouse), we should design it in singleton.

You job is to implement a getInstance method for given class, return the same instance of this class every time you call this method.

Have you met this question in a real interview? Yes
Example
In Java:

A a = A.getInstance();
A b = A.getInstance();
a should equal to b.

*/


class Solution {
    /**
     * @return: The same instance of this class every time
     */
    private static Solution sol = new Solution();
     
    public static Solution getInstance() {
        // write your code here
       return sol;
    }
};