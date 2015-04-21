package luyna.leetcode.bitManipulation;
/**
 * ��һ�����䣨��������˵�[m,n]�� 0 <= m <= n <= 2147483647��������������andֵ
 * @author luyna
 *
 */
public class BitwiseANDofNumbersRange {
	/**
	 * ����һ���������루��ʱ��
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
	 *����������������������������֣������һλһ��һλΪ0һλΪ1���������һλandΪ0��
	 *����������������˵����֣��������ֵ��ͬ����˵������֮����������������
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
