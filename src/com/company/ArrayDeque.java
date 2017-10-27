package com.company;

public class ArrayDeque<Item> {
    private Item [] Items;
    private int size;
    private int nextFirst =4;
    private int nextLast = 5;
    public int minusone(int index){
        if (index==0){
            return Items.length-1;
        }
        else return index-1;
    }

    public int addone(int index){
        if (index==Items.length-1){
            return 0;
        }
        else return index+1;
    }

    public ArrayDeque(){
        Items = (Item[]) new Object[8];
        size = 0;
    }
    public ArrayDeque(Item a){
        Items[size] = a;
        size+=1;
    }
    public boolean isEmpty(){
        return size==0? true:false;
    }
    public int size(){
        return size;
    }
    public void addFirst(Item a){  // works and resize
        size+=1;
        Items[nextFirst]=a;
        resize();
        nextFirst=minusone(nextFirst);

    }
    public void addLast(Item a){  // works and resize
        size+=1;
        Items[nextLast]=a;
        resize();
        nextLast=addone(nextLast);

    }
    public void resize(){  // Works
        if (size==Items.length) {
            Item[] a = (Item[]) new Object[size*4];
            if (nextFirst ==0 && nextLast==Items.length-1){  // If the nextFirst at the start, nextLast at end
                                                             // To keep the structure, copy the array in front
                System.arraycopy(Items, 0, a, 0, size);
                Items = a;
            }
            else { // The Last at left, the first at the right
                System.arraycopy(Items,0,a,0,nextLast);//Copy the last to the right
                System.arraycopy(Items,nextFirst,a,a.length-(size-nextLast),size-nextLast);
                //Copy the first to the end to the left
                nextFirst= a.length-(size-nextLast);
            }

        }else if (Items.length>=16 && size<Items.length*0.25){  // This part doesn't work
            int taget_length = size *2;
            Item[] b =(Item[]) new Object[taget_length];
            System.arraycopy(Items, 0, b, 0, size);
            //Items =b;
        }
    }
    public void printDeque(){ // This part works fine
        int print_index = addone(nextFirst);
        for(int i=0;i<size;i++){
            System.out.print(Items[print_index]+" ");
            print_index=addone(print_index);
        }
        System.out.println(" ");
    }
    public Item get(int index){
        int target_index = nextFirst;
        for (int i=0;i<index;i++){
            target_index = addone(target_index);
        }
        return Items[target_index];
    }
    public Item removeFirst(){
        Item output=Items[addone(nextFirst)];
        Items[addone(nextFirst)]=null;
        size-=1;
        resize();
        nextFirst = addone(nextFirst);
        return output;
    }
    public Item removeLast(){
        Item output=Items[minusone(nextLast)];
        Items[minusone(nextLast)]=null;
        size-=1;
        resize();
        nextLast = minusone(nextLast);
        return output;
    }
}
