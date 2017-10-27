package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        /*
        System.out.println("Running tests.\n");
        LinkedListDequeTest.addIsEmptySizeTest();
        LinkedListDequeTest.addRemoveTest();

        // Test case for base function

       */
        /*
        LinkedListDeque <String>lista= new <String>LinkedListDeque("yao");
        lista.addLast("is");
        lista.addLast("cool");
        System.out.print(lista.get(1)+" "+lista.getRecursive(1));
        */
        ArrayDeque <Integer> a = new <Integer> ArrayDeque();

        for (int i=0;i<100;i++){
            a.addFirst(i);
        }
        a.printDeque();
        for(int i=0;i<90;i++) {
            a.removeLast();
        }
        a.printDeque();

    }
}
