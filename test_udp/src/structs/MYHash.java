package structs;

import java.util.LinkedList;
import java.util.Map;

//模拟hash碰撞
class HashTest<K,V>{
    private Object[] tab = new Object[64];

    public void put(K key,V val){
        int idx = key.hashCode()&(tab.length-1);
        tab[idx] = val;
    }
    public V get(K key){
        int idx = key.hashCode()&(tab.length-1);
        return (V)tab[idx];
    }
}

//map拉链寻址对比上面的表添加了链表来辅助冲突的问题
class HashTestList<K,V>{
    //map的结构变成链表数组的结构
    private LinkedList<kv_Node>[] tab = new LinkedList[64];

    //首先是先声明出KV对的node
    static class kv_Node<K,V>{
        K key;
        V val;
        public kv_Node(K key,V val){
            this.key = key;
            this.val = val;
        }

        public K getKey() {
            return key;
        }

        public V getVal() {
            return val;
        }
    }
    //把上面的put\get小改一下


    public void put(K key,V val){
        int idx = key.hashCode()&(tab.length-1);
        if (tab[idx] == null){
            tab[idx] = new LinkedList<>();
            tab[idx].add(new kv_Node(key,val));
        }else {
            tab[idx].add(new kv_Node(key,val));
        }
    }
    public V get(K key){
        int idx = key.hashCode()&(tab.length-1);
        for (kv_Node<K, V> kvNode : tab[idx]) {
            if (key.equals(kvNode.getKey())) {
                return kvNode.val;
            }
        }
        return null;
    }

}




public class MYHash {
    public static void main(String[] args) {
        HashTest<String,String> map = new HashTest<>();

        //这里就是初步的一个map所以需要继续添加链表避免碰撞

        String key1 = "Aa";
        String key2 = "BB";
        map.put(key1, "花花");
        map.put(key2, "豆豆");
        System.out.println(map.get("Aa"));

        //加了拉链寻址
        HashTestList<String,String> map_list = new HashTestList<>();

        map_list.put(key1,"花花");
        map_list.put(key2,"豆豆");
        System.out.println(map_list.get("Aa"));


        System.out.println();



    }
}
