import java.util.*;

/**
 * MyHashTable
 */
@SuppressWarnings("unchecked")
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
        for (int i = 0; i < hashs.get(j).size(); i++) 
        {
            if(hashs.get(j).get(i).word == w.word)
            {
                hashs.get(j).get(i).addPositions(w.getAllPositionsForThisWord());
                return;
            }
        }
        // ## that particular word not found ##
        hashs.get(j).add(w);
        return;
    }
}