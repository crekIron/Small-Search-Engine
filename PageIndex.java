import java.io.*;
import java.util.*;
/**
 * PageIndex
 */
public class PageIndex {

    MyLinkedList<WordEntry> words = new MyLinkedList<WordEntry>();
    public void addPostionForWord(String str, Position p)
    {
        int i=0;
        for (i = 0; i < words.size(); i++) {
            if(Objects.equals(str, words.get(i).word))
            {
                words.get(i).addPosition(p);
                return;
            }
        }
        // there is no word with entry str
        if(i==words.size())
        {
            WordEntry newAdd = new WordEntry(str);
            newAdd.addPosition(p);
            words.add(newAdd);
        }
       
        return;
    }

    public MyLinkedList<WordEntry> getWordEntries(){
        return words;
    }
}
