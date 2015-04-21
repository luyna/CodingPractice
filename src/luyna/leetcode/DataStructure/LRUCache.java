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
	 * 思路一：用一个map和一个队列分别保存键值对和淘汰顺序
	 * 因为需要遍历，提交后 time limit exceeded
	 * @author luyna
	 *
	 */
   /* private int capacity;
    private LinkedList<Integer>  cacheQueue; //存放key值
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
	 * 思路二：用一个LinkedHashMap保存键值对和顺序，（或者可以继承LinkedHashMap，然后覆写removeEldestEntry()方法）
	 * 缺点：set时要遍历map以获取到最近最少使用的数据，超时
	 * 提交 time limit exceeded
	 * @author luyna
	 *
	 */
	 /*private LinkedHashMap<Integer,Integer> cache;
	 private int capacity;
	 public LRUCache(int capacity) {
	     this.capacity=capacity;
	     cache=new LinkedHashMap<Integer,Integer>(capacity,1,true);//第三个参数表示维护的顺序是访问顺序，如果为false则为插入顺序
	 }
	    
	 public int get(int key) {
		 int value=cache.get(key)==null?-1:cache.get(key);
		 if(value != -1) cache.put(key, value);   //若构造函数中指定为插入顺序，则需要重新put一下来更新插入顺序，否则不需要此语句
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
	  * 思路三：模拟LinkedHashMap，自定义数据结构实现：用一个HashMap和一个双向链表
	  */
	 private HashMap<Integer,CacheValue> cache;
	 private CacheValue head; //首尾节点是两个无效节点，双向链表保存访问顺序
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
	      * 如果cache中已经存在该key，则不管队列有没有满，都将该key对应的值更新（即先删除然后重新插入）
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
	  * 调整顺序，最近访问的置于双向链表的首部
	  * @param key
	  */
	 public void aheadAccess(CacheValue value){
		 //将value节点删除
		 value.prev.next=value.next;
		 value.next.prev=value.prev;
		 //将value节点置于双向链表首部
		 value.next=head.next;
		 head.next.prev=value;
		 head.next=value;
		 value.prev=head;
	 }
	 class CacheValue{
		  int value;
		  int key;//删除时会用到该值，即key存储两次
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

