package leetcode;

import java.util.HashMap;

/**
 * @author xuzhangwang
 * @date 2019/7/29
 */
public class _146LRU缓存机制 {
    public static void main(String[] args) {


        Cache cache = new Cache(2);
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

}

class Cache {
    private class Node {
        private int key;
        private int value;
        private Node pre;
        private Node next;
        public Node() {}
        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    private int capacity;
    private int size;
    private Node head = new Node();
    private Node tail = new Node();
    private HashMap<Integer, Node> map = new HashMap<>();


    /**
     * 添加某个节点,将节点添加到虚拟节点之后
     * @param node
     */
    private void add(Node node) {
        Node orginNode = head.next;
        head.next = node;
        node.pre = head;
        node.next = orginNode;
        orginNode.pre = node;
    }

    /**
     * 删除某个节点
     * @param node
     */
    private void del(Node node) {
        Node preNode = node.pre;
        Node nextNode = node.next;
        preNode.next = nextNode;
        nextNode.pre = preNode;
        node.pre = null;
        node.next = null;
    }


    public Cache(int capacity) {
        head.next = tail;
        tail.pre  = head;
        this.capacity = capacity;
        this.size = 0;
    }

    public int get(int key) {
        Node node = map.get(key);
        if (node == null) {
            return -1;
        }
        del(node);
        add(node);
        return node.value;
    }

    public void put(int key, int value) {
        Node node = map.get(key);
        if (node != null) {
            node.value = value;
            del(node);
            add(node);
        } else {
            if (size < capacity) {
                size++;
            } else {
                Node delNode = tail.pre;
                map.remove(delNode);
                del(delNode);
            }
            Node newNode = new Node(key, value);
            add(newNode);
            map.put(key, newNode);
        }
    }


}
