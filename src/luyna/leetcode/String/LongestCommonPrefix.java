package luyna.leetcode.String;

public class LongestCommonPrefix {
	/**
	 * 找出数组中字符串的最长公共前缀
	 * 最直观的思路：根据数组中第一个字符串中的字符，遍历数组中所有字符串，
	 * 所有字符串均含有的字符加入到前缀字符串中
	 * @param strs
	 * @return
	 */
	public String longestCommonPrefix(String[] strs) {
		if(strs.length==0) return "";
		if(strs.length==1) return strs[0];
        StringBuffer sb=new StringBuffer("");
        for(int i=0;i<strs[0].length();i++){
        	char tmp=strs[0].charAt(i);
        	int j;
        	for(j=1;j<strs.length;j++){
        		if(i>=strs[j].length() || strs[j].charAt(i)!=tmp)
        			break;
        	}
        	if(j==strs.length) sb.append(tmp);
        	else break;
        }
        return sb.toString();
    }
}
