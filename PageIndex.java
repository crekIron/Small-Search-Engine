/**
 * PageIndex
 */
public class PageIndex {

    MyLinkedList<WordEntry> words = new MyLinkedList<WordEntry>();
    public void addPostionForWord(String str, Position p)
    {
        for (int i = 0; i < words.size(); i++) {
            if(str==words.get(i).word)
            {
                words.get(i).addPosition(p);
                return;
            }
        }
        // there is no word with entry str
        WordEntry newAdd = new WordEntry(str);
        newAdd.addPosition(p);
        return;
    }
}