package luyna.leetcode.String;
/**
 * 求出数字字符串的解码方式一共有多少种
 * @author luyna
 * 2015年3月4日
 */
public class DecodeWays {
	public int numDecodings(String s) {
        if(s.isEmpty() || s==null) return 0;
        int len=s.length();
        int []result=new int[s.length()];
        if(s.charAt(0)!='0')
        	result[0]=1;
        else return 0;
        if(len==1) return result[0];
        int tmp;
        if(s.charAt(1)=='0') result[1]=result[0];       
        else{
        	 tmp=Integer.parseInt(s.substring(0,2));
             if(tmp>=1 && tmp<=26) result[1]=result[0]+1;
             else result[1]=result[0];
        }
       
        for(int j=2;j<len;j++) result[j]=0;
        for(int i=2;i<len;i++){
        	if(s.charAt(i)=='0'){
        		if(s.charAt(i-1)=='0' || s.charAt(i-1)>2) return 0;
        		result[i]=result[i-2];
        		continue;
        	}
        	tmp=Integer.parseInt(s.substring(i-1, i+1));
        	if(tmp>=1 && tmp<=26){
        		result[i] +=result[i-2];
        	}
        	result[i] +=result[i-1];
        }
        return result[len-1];
    }
	
	public static void main(String [] args){
		System.out.println(new DecodeWays().numDecodings("101"));
	}
}
