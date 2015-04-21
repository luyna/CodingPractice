package luyna.leetcode.DataStructure;

import java.util.LinkedHashMap;
import java.util.Map;
/**
 * ºÃ≥–LinkedHashMap µœ÷LRUÀ„∑®
 * @author luyna
 *
 * @param <K>
 * @param <V>
 */
public class LRUCache1<K,V> extends LinkedHashMap<K,V>{
   private int capacity;
   public LRUCache1(int capacity){
	   super(capacity,1,true);
	   
	   this.capacity=capacity;
   }
   @Override
   public boolean removeEldestEntry(Map.Entry<K,V>  eldest){
	   boolean tooBig = size() >= capacity;
       return tooBig;
   }
   
   /*public int get(Object key){	   
	   if(this.containsKey(key)) return this.get(key);
	   else return -1;
   }*/

   public static void main(String[] args){
	   LRUCache1 cache=new LRUCache1(3);
	   cache.put(1, 1);
	   cache.put(2, 2);
	   cache.put(3, 3);
	   System.out.println(cache.get(2));
	   System.out.println(cache.get(3));
	   cache.put(4, 4);
	   System.out.println(cache.get(4));
	   cache.put(1, 1);
	   System.out.println(cache.get(3));
	   cache.put(2, 2);
	   System.out.println(cache.get(1));
   }
}
