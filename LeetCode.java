package com.sunxb.sort;

public class LeetCode {
	public int mySqrt(int x) {
		double x0 = 1;
		double x1 = (x0 + x / x0) * 0.5;
		
		do {
			x0 = x1;
			x1 = (x0 + x / x0) * 0.5;
		} while (x0 - x1 >= 0.1);
	
		
		return (int)x1;
    }
	

	public class TreeNode {
		int val;
		TreeNode left;
	    TreeNode right;
	    TreeNode(int x) { val = x; }
	 }
	
	public boolean isSameTree(TreeNode p, TreeNode q) {
		
		if (p == null && q == null) return true;
		if (p == null || q == null) return false;
		if (p.val != q.val) return false;
		
		return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
	
	
    public double myPow(double x, int n) {
        if (n == 0) return 1.0;
        if (n == 1 || x == 1.0) return x;
        if (n > 1) {
        	double res = x;
        	while(n > 1) {
        		res *= x;
        		n --;
        	}
        	return res;
        } else {
        	double res = x;

        	while(n < -1) {
        		res *= x;
        		n ++;
        	}
        	res  = 1 / res;
        	return res;
        }
    }
}
