import java.util.*;
import java.io.*; 

/**
 * MyHashTable
 */
public class MyHashTable {

    HashMap<Integer, MyLinkedList<WordEntry>> hashs = new HashMap<Integer,MyLinkedList<WordEntry>>();
    private int getHashIndex(String str)
    {
        int hashint=0;
        for (int i = 0; i < str.length(); i++) 
        {
            hashint = hashint + (int)str.charAt(i);
        }   
        hashint = hashint%2069;
        return hashint;
    }
    public void addPositionsForWord(WordEntry w)
    {
        int j;
        j = this.getHashIndex(w.word);
        if(hashs.get(j)!=null){
            for (int i = 0; i < hashs.get(j).size(); i++) 
            {
                if(Objects.equals(hashs.get(j).get(i).word, w.word))
                {
                    hashs.get(j).get(i).addPositions(w.getAllPositionsForThisWord());
                    return;
                }
            }
        }
        else
        {
            MyLinkedList<WordEntry> newList = new MyLinkedList<WordEntry>();
            newList.add(w);
            hashs.put(j, newList);
            // System.out.printf("%d ",j);
            // System.out.println(hashs.get(j).get(0).word);
            return;
        }
        // ## that particular word not found ##
        hashs.get(j).add(w);
        return;
    }
}