package linkedlist;

public class CustomLinkedList {
    Node head;
    class Node{
        String data;
        Node next;
        Node(String data){
            this.data=data;
            this.next=null;
        }
    }

    //add- first, last
    public Node addFirst(String data){
        Node newNode=new Node(data);
        if(head==null){
            head=newNode;
            return head;
        }
        newNode.next=head;
        head=newNode;
        return head;
    }
    public Node addLast(String data){
        Node newNode=new Node(data);
        if(head==null){
            head=newNode;
            return head;
        }
        Node current=head;
        while(current.next!=null){
            current=current.next;
        }
        current.next=newNode;
        return head;
    }

    //print list
    public void printList(){
        if(head==null){
            System.out.println("List is empty");
        }
        Node currentNode=head;
        while(currentNode!=null){
            System.out.println(currentNode.data);
            currentNode=currentNode.next;
        }
    }

    //delete a node in linkedlist delete first and delete last
    public Node deleteFirst(){
        if(head==null){
            System.out.println("LinkedList Is Empty");
            return null;
        }
        Node node=head;
        head=head.next;
        return node;
    }

    public Node deleteLast(){
        if(head==null){
            System.out.println("LinkedList is empty");
            return null;
        }
        if(head.next==null){
            Node result=head;
            head=null;
            return result;
        }
        Node secondLast=head;
        Node lastNode=head.next;
        while(lastNode.next!=null){
            lastNode=lastNode.next;
            secondLast=secondLast.next;
        }
        secondLast.next=null;
        return lastNode;
    }

    //reverse a linked list
    public Node reverseLinkedList(){
        Node current=head;
        Node previous=null;
        Node next;
        while(current!=null){
            next=current.next;
            current.next=previous;
            previous=current;
            current=next;
        }
        head=previous;
        return head;
    }

    // find middle of linked list
    //get the size and then /2 for even /2



    //slow fast pointer approach
    //slow pointer=head
    //fast pointer=head
    //slow pointer update by one
    //fast pointer update by two
    public Node findMiddle(){
        Node fast=head;
        Node slow=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }

    //detect if cycle exist in linkedlist
    public boolean detectCycle(){
        Node fast=head;
        Node slow=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast){
                return true;
            }
        }
        return false;
    }

    // remove cycle
    //first detect cycle
    public Node removedCycle(){
        boolean isCycling=false;
        Node slow=head;
        Node fast=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast){
                isCycling=true;
                break;
            }
        }
        if(!isCycling){
            return null;
        }
        // Find start of cycle
        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        // slow (or fast) is now at start of cycle

        // Remove cycle
        Node ptr = slow;
        while (ptr.next != slow) {  // find last node in cycle
            ptr = ptr.next;
        }

        ptr.next = null;  // break the cycle

        return slow;  // return start of cycle
    }


    public static void main(String[] args) {
        CustomLinkedList linkedList=new CustomLinkedList();
        linkedList.addFirst("hello");
        linkedList.addFirst("arif");
        linkedList.addLast("ruqaiya");
        linkedList.printList();
        linkedList.reverseLinkedList();
        linkedList.printList();
        System.out.println(linkedList.deleteFirst().data);
        System.out.println(linkedList.deleteLast().data);

    }
}