package Hashtable;

import java.util.HashMap;

public class HashTable<K, V> {

    private static final int initBusketSize = 10;
    private Basket[] busketArrey;
    private int size;
    private final double lowfaktor = 0.75;
    private class Entity{
        private K kay;
        private V value;

        public Entity(K kay, V value) {
            this.kay = kay;
            this.value = value;
        }
    }

    private class Basket{
        private class BasketNode{
            private BasketNode next;
            private Entity entity;
            public BasketNode(K kay, V value){
                entity = new Entity(kay,value);
            }

        }
        private BasketNode head;
        public V find(K key){
            BasketNode currentNode = head;
            while (currentNode != null){
                if (currentNode.entity.kay.equals(key)) return currentNode.entity.value;
                currentNode = currentNode.next;
            }
            return null;
        }
        public boolean add(K key, V value){
            BasketNode currentNode = head;
            BasketNode basketNode = new BasketNode(key, value);
            while (currentNode != null){

                if (currentNode.entity.kay.equals(key)) return false;
                else if (currentNode.next == null){
                    currentNode.next = basketNode;
                    return true;
                }
                currentNode = currentNode.next;
            }
            head = basketNode;
            return true;
        }
        public boolean remove(K key){
            BasketNode currentNode = head;
            if (currentNode == null) return false;
            else if (currentNode.entity.kay.equals(key)){
                head = head.next;
                return true;
            }
            while (currentNode.next != null){
                if (currentNode.next.entity.kay.equals(key)){
                    currentNode.next = currentNode.next.next;
                    return true;
                }
                currentNode = currentNode.next;
            }
            return false;
        }


    }

    private int calcylaleIndex(K key){
        return Math.abs(key.hashCode()) % busketArrey.length;
    }
    public HashTable(){
        this(initBusketSize);
    }

    public HashTable(int initSize){
        busketArrey = (Basket[]) new Object[initSize];
    }
    public V find(K key){
        Basket basket = busketArrey[calcylaleIndex(key)];
        return basket != null ? basket.find(key) : null;
    }

    public boolean add(K key, V value){
        if (lowfaktor * busketArrey.length > size) resize();
        int calculateIndex = calcylaleIndex(key);
        Basket basket = busketArrey[calculateIndex];
        if (basket == null){
            busketArrey[calculateIndex] = new Basket();
        }
        boolean valueAdded = busketArrey[calculateIndex].add(key, value);
        if (valueAdded) size++;
        return valueAdded;

    }
    public boolean remove(K key){
        Basket basket = busketArrey[calcylaleIndex(key)];
        if (basket == null)return false;
        else {
            boolean valueRemoved = basket.remove(key);
            if (valueRemoved)size--;
            return valueRemoved;
        }
    }
    private void resize(){
        Basket[] oldBasket = busketArrey;
        busketArrey = (Basket[]) new Object[oldBasket.length * 2];
        size = 0;
        for (Basket basket: oldBasket){
            if (basket != null){
                Basket.BasketNode basketNode = basket.head;
                while (basketNode != null){
                    add(basketNode.entity.kay, basketNode.entity.value);
                    basketNode = basketNode.next;
                }
            }
        }

    }


}
