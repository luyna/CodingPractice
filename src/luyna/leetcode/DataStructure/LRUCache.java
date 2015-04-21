package luyna.leetcode.DataStructure;

import java.util.*;

/**
 * Design and implement a data structure for Least Recently Used (LRU) cache. 
 * It should support the following operations: get and set.
 * get(key) - Get the value (will always be positive) of the key if the key exists in the cache, 
 * otherwise return -1.
 * set(key, value) - Set or insert the value if the key is not already present. 
 * When the cache reached its capacity, it should invalidate the least recently used item 
 * before inserting a new item.
 * 
 * @author luyna
 *
 */

public class LRUCache {
	/**
	 * ˼·һ����һ��map��һ�����зֱ𱣴��ֵ�Ժ���̭˳��
	 * ��Ϊ��Ҫ�������ύ�� time limit exceeded
	 * @author luyna
	 *
	 */
   /* private int capacity;
    private LinkedList<Integer>  cacheQueue; //���keyֵ
    Map<Integer,Integer> cache; 
    public LRUCache(int capacity) {
        this.capacity=capacity;
        cache=new HashMap<Integer,Integer>();
        cacheQueue=new LinkedList<Integer>();
    }
    
    public int get(int key) {
    	int value=cache.get(key)==null?-1:cache.get(key);
        Iterator<Integer> itr=cacheQueue.iterator();
        while(itr.hasNext()){
        	int tmp=itr.next();
        	if(tmp==value) itr.remove();
        }
        cacheQueue.addLast(key);
        return value;
    }
    
    public void set(int key, int value) {
        if(cacheQueue.size()<capacity){
        	cache.put(key, value);
        	cacheQueue.addLast(key);
        }else{
        	int outkey=cacheQueue.getFirst();
        	cacheQueue.removeFirst();
        	cache.remove(outkey);
        	cache.put(key, value);
        	cacheQueue.addLast(key);
        }
    }*/
	/**
	 * ˼·������һ��LinkedHashMap�����ֵ�Ժ�˳�򣬣����߿��Լ̳�LinkedHashMap��Ȼ��дremoveEldestEntry()������
	 * ȱ�㣺setʱҪ����map�Ի�ȡ���������ʹ�õ����ݣ���ʱ
	 * �ύ time limit exceeded
	 * @author luyna
	 *
	 */
	 /*private LinkedHashMap<Integer,Integer> cache;
	 private int capacity;
	 public LRUCache(int capacity) {
	     this.capacity=capacity;
	     cache=new LinkedHashMap<Integer,Integer>(capacity,1,true);//������������ʾά����˳���Ƿ���˳�����Ϊfalse��Ϊ����˳��
	 }
	    
	 public int get(int key) {
		 int value=cache.get(key)==null?-1:cache.get(key);
		 if(value != -1) cache.put(key, value);   //�����캯����ָ��Ϊ����˳������Ҫ����putһ�������²���˳�򣬷�����Ҫ�����
		 return value;
	 }
	    
	 public void set(int key, int value) {
	     if(cache.size()>=capacity){
	    	 Iterator itr=cache.keySet().iterator();
	    	 while(itr.hasNext()) itr.next();
	    	 cache.remove(itr);
	     }
	     cache.put(key, value);
	}*/
	 
	 /**
	  * ˼·����ģ��LinkedHashMap���Զ������ݽṹʵ�֣���һ��HashMap��һ��˫������
	  */
	 private HashMap<Integer,CacheValue> cache;
	 private CacheValue head; //��β�ڵ���������Ч�ڵ㣬˫�����������˳��
	 private CacheValue tail;
	 private int capacity;
	 public LRUCache(int capacity) {
	     this.capacity=capacity;
	     cache=new HashMap<Integer,CacheValue>();
	     head=new CacheValue(0,0);
	     tail=new CacheValue(0,0);
	     head.next=tail;
	     tail.prev=head;
	 }
	    
	 public int get(int key) {
		 if(!cache.containsKey(key)) return -1;
		 CacheValue value=cache.get(key);		
		 aheadAccess(value);
		 return value.value;
	 }
	    
	 public void set(int key, int value) {
		 CacheValue del=null;
	     if(cache.size()>=capacity){
	    		 del=tail.prev; 	 
	     }
	     /**
	      * ���cache���Ѿ����ڸ�key���򲻹ܶ�����û������������key��Ӧ��ֵ���£�����ɾ��Ȼ�����²��룩
	      */
	     if(cache.containsKey(key)){
	    	 del=cache.get(key);
	     }
	     if(del!=null){
	    	 cache.remove(del.key);
	    	 del.prev.next=del.next;
	    	 del.next.prev=del.prev;
	     }
   
	     CacheValue newCache=new CacheValue(key,value);
	     cache.put(key, newCache);
	     newCache.next=head.next;
	     head.next.prev=newCache;
	     head.next=newCache;
	     newCache.prev=head;
	}
	 /**
	  * ����˳��������ʵ�����˫��������ײ�
	  * @param key
	  */
	 public void aheadAccess(CacheValue value){
		 //��value�ڵ�ɾ��
		 value.prev.next=value.next;
		 value.next.prev=value.prev;
		 //��value�ڵ�����˫�������ײ�
		 value.next=head.next;
		 head.next.prev=value;
		 head.next=value;
		 value.prev=head;
	 }
	 class CacheValue{
		  int value;
		  int key;//ɾ��ʱ���õ���ֵ����key�洢����
		  CacheValue next;
		  CacheValue prev;
		  public CacheValue(int key,int value){
			  this.key=key;
			  this.value=value;
			  next=null;
			  prev=null;
		  }
	 }
	
}

