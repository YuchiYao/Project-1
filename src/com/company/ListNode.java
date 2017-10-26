package com.company;

import java.util.List;

public class ListNode<typename_list> {

    private typename_list val;

    private ListNode next ;

    private ListNode previous;

    public ListNode (typename_list v, ListNode n, ListNode p){
        val = v;
        next = n;
        previous = p ;
    }
}
