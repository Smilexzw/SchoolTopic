package code;

import java.util.HashMap;

/**
 * @author xuzhangwang
 * @date 2019/7/29
 */
public class LRUCache {

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        int i = cache.get(1);
        System.out.println(i);
        cache.put(3, 3);
        i = cache.get(2);
        System.out.println(i);
        cache.put(4,4);
        i = cache.get(1);
        System.out.println(i);
        i = cache.get(3);
        System.out.println(i);
        i = cache.get(4);
        System.out.println(i);
    }


    private class Node{
        private int key;
        private int value;
        private Node pre;
        private Node next;
        public Node(){}
        public Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }
    private Node dummyHead = new Node();
    private Node dummyTail = new Node();
    private int capacity;
    private int size;
    private HashMap<Integer, Node> hashMap = new HashMap<>();
    //将节点添加到虚拟头节点之后
    private void add(Node node){
        Node originHead = dummyHead.next;
        dummyHead.next = node;
        node.pre = dummyHead;
        node.next = originHead;
        originHead.pre = node;
    }
    //删除某个节点
    private void del(Node node){
        Node preNode = node.pre;
        Node nextNode = node.next;
        preNode.next = nextNode;
        nextNode.pre = preNode;
        node.pre = null;
        node.next = null;
    }
    public LRUCache(int capacity) {
        dummyHead.next = dummyTail;
        dummyTail.pre = dummyHead;
        this.capacity = capacity;
        size = 0;
    }
    public int get(int key) {
        Node node = hashMap.get(key);
        if(null == node){
            return -1;
        }
        del(node);
        add(node);
        return node.value;
    }
    public void put(int key, int value) {
        Node node = hashMap.get(key);
        if(null != node){
            node.value = value;
            del(node);
            add(node);
        }else{
            if(size < capacity){
                size++;
            }else{
                Node delNode = dummyTail.pre;
                hashMap.remove(delNode.key);
                del(delNode);
            }
            Node newNode = new Node(key, value);
            add(newNode);
            hashMap.put(key, newNode);
        }
    }
}