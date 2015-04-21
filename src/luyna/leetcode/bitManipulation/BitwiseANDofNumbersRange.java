package luyna.leetcode.bitManipulation;
/**
 * 求一个区间（包括区间端点[m,n]， 0 <= m <= n <= 2147483647）中所有整数的and值
 * @author luyna
 *
 */
public class BitwiseANDofNumbersRange {
	/**
	 * 方法一：遍历求与（超时）
	 * @param m
	 * @param n
	 * @return
	 */
	/*public  int rangeBitwiseAnd(int m, int n) {
		int result=Integer.MAX_VALUE;
        while(m<=n){
        	result = result & m;
        	m++;
        }
        return result;
    }*/
	/**
	 *方法二：如果区间至少有两个数字，则最后一位一定一位为0一位为1，所以最后一位and为0；
	 *不断右移两个区间端点数字，如果两个值不同，则说明两者之间至少有两个数字
	 * @param m
	 * @param n
	 * @return
	 */
	public  int rangeBitwiseAnd(int m, int n) {
		int i=0;
		while((m>>i) != (n>>i)){
			i++;
		}
		return m & (0xffffffff<<i);
    }
	public static void main(String[] args){
		int max=Integer.MAX_VALUE;
		System.out.println(new BitwiseANDofNumbersRange().rangeBitwiseAnd(5, 7));
	}
}
