public class OneLinkedList {
    public static class Node{
        Node next;
        int value;
    }

    static Node head;

    public static void add(int value){
        Node newNode = new Node();
        newNode.value = value;
        if (head != null) newNode.next = head;
        head = newNode;

        }
    public void remove(){
        if (head != null){
            head = head.next;
        }
    }
    public boolean serch(int value){
        Node correntNode = head;
        while (correntNode != null){
            if (correntNode.value == value) return true;
            correntNode = correntNode.next;

        }
        return false;
    }

    public void addEnd(int value){
        Node newNode = new Node();
        newNode.value = value;
        if (head == null) head = newNode;
        else{
            Node lastNode = newNode;
            while (newNode != null) lastNode = lastNode.next;
            lastNode.next = newNode;
        }
    }

    public void removeEnd(){
        if (head != null){
            Node preListElement = head;
            while (preListElement.next != null){
                if (preListElement.next.next == null){
                    preListElement.next = null;
                    break;
                }
                preListElement = preListElement.next;
            }
        }
        head = null;
    }

    public void revert(){ // Разварот односвязвнного списка
        if (head != null && head.next != null){
            Node temp = head;
            revert(head.next, head);
            temp.next = null;
        }
    }

    public static void revert(Node currentNode, Node previousNode){
        if (currentNode.next == null) head = currentNode;
        else revert(currentNode.next, currentNode);
        currentNode.next =previousNode;
        previousNode.next = null;
    }

}
