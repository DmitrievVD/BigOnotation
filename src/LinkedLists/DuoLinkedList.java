package LinkedLists;

public class DuoLinkedList {
    public static class Node{
        Node next;
        Node previus;
        int value;
    }
    static Node head;
    static Node teil;
    public static void add(int value){
        Node newNode = new Node();
        newNode.value = value;
        if (head != null){
            newNode.next = head;
            head.previus = newNode;
        }else teil = newNode;
        head = newNode;
    }

    public static void remove(){
        if (head != null && head.next != null){
            head = head.next;
            head.previus = null;
        }else {
            head = null;
            teil = null;
        }
    }

    public static void addEnd(int value){
        Node newNode = new Node();
        newNode.value = value;
        if (head == null){
            head = newNode;
            teil = newNode;
        }else{
            teil.next = newNode;
            newNode.previus = teil;
            teil = newNode;
        }
    }

    public static void removeEnd(){ // Удаление последнего элемента
        if (head != null && head.next != null){
            teil = teil.previus;
            teil.next = null;
        }else{
            teil = null;
            head = null;
        }
    }

    public static void sortBuble(){ // Сортировка списка пузырьком
        boolean sort = true;
        while (sort){
            sort = false;
            Node i = head;
            while (i != null && i.next != null){
                if (i.value > i.next.value){
                    int temp;
                    temp = i.next.value;
                    i.next.value = i.value;
                    i.value = temp;
                    sort = true;
                }
                i = i.next;
            }
        }
    }

    public static void revert(){ // Разварот двухсвязвнного списка
        Node correntNode = head;
        while (correntNode != null){
            Node next = correntNode.next;
            Node previus = correntNode.previus;
            correntNode.next = previus;
            correntNode.previus = next;
            if (previus == null)teil = correntNode;
            if (next == null) head = correntNode;
            correntNode = next;
        }
    }
}
