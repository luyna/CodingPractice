package luyna.leetcode.String;

public class ZigZag {
	public String convert(String s, int nRows) {
		if(s.length()==0 || s.length()==1 || nRows==1 ) return s;
		StringBuffer sb=new StringBuffer("");
		
        for(int i=0;i<nRows;i++){
        	int flag=1;
        	for(int j=i;j<s.length();){       		
        		sb.append(s.charAt(j));
        		if(i!=0 && i!=nRows-1){
        			if(flag==1){
            			j=j+2*(nRows-1-i);
            		}else j=j+2*i;
        			flag=1-flag;
        		}else j=j+2*(nRows-1);
        		
        	}
        }
        return sb.toString();
    }
	
	public static void main(String[] agrs){
		StringBuffer bu=new StringBuffer("");
		System.out.println(bu.append('a'));
		System.out.println(new ZigZag().convert("ABCDEF", 3));
	}
}
