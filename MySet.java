import java.util.*;
/**
 * MySet
 */
@SuppressWarnings("unchecked")
public class MySet<E>{
    //Using Linked List to implement 
    MyLinkedList<E> head = new MyLinkedList<E>();

    public Boolean IsEmpty(){
        //returns true if set is empty
        return head.size()==0;
    }

    public Boolean IsMember(E o){
        //returns true if o is in the set, false otherwise.
        return head.contains(o);
    }

    public void addElement(E element){
        //insert element in the set.
        if(!this.IsMember(element))
        {
            head.add(element);
        }
        else{
            System.out.println("ELement already exist");
        }
    }

    public void Delete(E o){
        //Deletes o from the set, throws exception if o is not in the set.
        try{
            if(this.IsMember(o))
            {
                head.remove(o);
            }
            else{
                System.out.println("Element does not exist");
            }
        }
        catch(IndexOutOfBoundsException e)
        {
            System.out.println("Your set is empty");
        }
    }

    public MySet<E> Union(MySet<E> a){
        // returns the set Which is the union of the current set with the set a
        MySet<E> union = new MySet<E>();
        int check=0;
        union.head.addAll(this.head);
        for(int i=0; i< a.head.size(); i++)
        {
            for(int j=0; j< this.head.size(); j++){
                if(this.head.get(j)==a.head.get(i))
                {
                    check=0;
                    break;
                }
                check=check+1;
            }
            if(check==this.head.size())
            {
                union.head.add(a.head.get(i));
                check=0;
            }
        }
        return union;
    }
    
    public MySet<E> Intersection(MySet<E> a){
        // returns a set which is the intersection of the current set with the set a
        MySet<E> inter = new MySet<E>();
        for(int i=0; i< a.head.size(); i++)
        {
            for(int j=0; j< this.head.size(); j++){
                if(this.head.get(j)==a.head.get(i))
                {
                    inter.head.add(a.head.get(i));
                    break;
                }
            }
        }
        return inter;
    }

    public static void main(String[] args) {
        MySet<Integer>  check = new MySet<Integer>();
        int a = 252;
        int b = 855;
        int c = 834;
        int d = 8343;
        check.addElement(a);
        check.addElement(b);
        check.addElement(c);
        System.out.println(check.head.get(1));
        MySet pile = new MySet();
        System.out.println(pile.head);
        pile=check.Union(pile);
        System.out.println(pile.head);
        check.Delete(d);
        check.addElement(a);
    }
}