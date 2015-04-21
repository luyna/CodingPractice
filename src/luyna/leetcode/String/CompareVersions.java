package luyna.leetcode.String;

public class CompareVersions {
	/**
	 * 比较版本号
	 * 1.1<2.3<2.15<13.3
	 * @param version1
	 * @param version2
	 * @return
	 */
	public int compareVersion(String version1, String version2) {
		if(version1.equals(version2)) return 0;
		if(version1.length()==0) return -1;
		if(version2.length()==0) return 1;
        String [] ver1=version1.split("\\."); //、“.”和“|”都是转义字符，必须得加"\\";
        String [] ver2=version2.split("\\.");
        //如果分离的长度不同，则将短的一方向长的加零补齐 如1.0和 1
        //该段代码可以省略优化，在比较时选择性的与0比较
        int maxlen=ver1.length;
        if(ver1.length>ver2.length){
        	String[] tmp=new String[maxlen];
        	for(int j=0;j<tmp.length;j++){
        		if(j<ver2.length) tmp[j]=ver2[j];
        		else tmp[j]="0";
        	}
        	ver2=tmp;
        }else if(ver1.length<ver2.length){
        	maxlen=ver2.length;
        	String[] tmp=new String[maxlen];
        	for(int j=0;j<tmp.length;j++){
        		if(j<ver1.length) tmp[j]=ver1[j];
        		else tmp[j]="0";
        	}
        	ver1=tmp;
        }
        
        
        int i=0;
        //多个分隔符
        for(i=0;i<maxlen;i++){
        	if(Integer.parseInt(ver1[i])>Integer.parseInt(ver2[i])) 
        		return 1;
        	if(Integer.parseInt(ver1[i])<Integer.parseInt(ver2[i]))
        		return -1;       	
        }
        
		return 0;
    }
}
