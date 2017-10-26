package com.company;

public class LinkedListDeque <typename_list> {
    private ListNode first_sentinel;
    private int size ;
    public LinkedListDeque(){
            first_sentinel = new ListNode(null, null,null);
            first_sentinel.next = first_sentinel;
            first_sentinel.previous=first_sentinel;
            size  =0;
    }
    public LinkedListDeque(typename_list a){
        first_sentinel = new ListNode(null, null,null);
        first_sentinel.next = new ListNode(a,first_sentinel,first_sentinel);
        first_sentinel.previous =first_sentinel.next;
        size =1;
    }

    public boolean isEmpty(){
        if (size == 0) return true;
        return false;
    }
    public int size (){
        return size;
    }
    public void addFirst(typename_list Item){
        ListNode next_Node = first_sentinel.next;
        first_sentinel.next = new ListNode(Item,first_sentinel.next,first_sentinel);
        next_Node.previous = first_sentinel.next;
        size+=1;
    }
    public void addLast(typename_list Item){
        ListNode previous_Node = first_sentinel.previous;
        first_sentinel.previous = new ListNode(Item,first_sentinel,first_sentinel.previous);
        previous_Node.next = first_sentinel.previous;
        size+=1;
    }
    public typename_list removeFirst(){
        typename_list output = first_sentinel.next.val;
        first_sentinel.next.next.previous = first_sentinel; // The second item. previous = sentinel 0
        first_sentinel.next = first_sentinel.next.next;     // Sentinel.next = Second Item
        size -=1;
        return  output;
    }
    public  typename_list removeLast(){
        typename_list output = first_sentinel.previous.val;
        first_sentinel.previous.previous.next = first_sentinel; // Same as above but in opposite direction
        first_sentinel.previous = first_sentinel.previous.previous;
        size -=1;
        return output;
    }

    public ListNode getFirst() {   // Addition
        return first_sentinel.next;
    }
    public typename_list get(int index){
        ListNode output_node= first_sentinel;
        for (int i= 0 ; i<index+1 ; i++){
            output_node = output_node.next;
        }
        return output_node.val;
    }

    public typename_list getRecursive(int index){

        ListNode output = first_sentinel;
        int i=0;
        output= gethelper(output,i,index);
        return output.val;
    }

    public ListNode gethelper(ListNode a,int i,int index){

        if (i>index) return a;
        a = gethelper(a.next,i+1,index);
        return a;
    }

    public void printDeque(){
        ListNode temp = first_sentinel.next;
        while (temp.val!=null){
            System.out.print(temp.val+" ");
            temp = temp.next;
        }
        System.out.println("");
    }

    public class ListNode {

        private typename_list val;

        private ListNode next ;

        private ListNode previous ;

        public ListNode (typename_list v, ListNode n, ListNode p){
            val = v;
            next = n;
            previous = p ;
        }
    }

}
