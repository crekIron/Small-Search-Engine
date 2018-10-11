/**
 * InvertedPageIndex
 */
@SuppressWarnings("unchecked")
public class InvertedPageIndex {

    MySet<PageEntry> pages = new MySet();
    MyHashTable tableOfWords = new MyHashTable();
    public void addPage(PageEntry p)
    {
        pages.addElement(p);
        for (int i = 0; i < p.getPageIndex().words.size(); i++) 
        {
            tableOfWords.addPositionsForWord(p.getPageIndex().words.get(i));    
        }           
    }
    public MySet<PageEntry> getPagesWhichContainWord(String str)
    {
        int hashint=0;
        for (int i = 0; i < str.length(); i++) 
        {
            hashint = hashint + (int)str.charAt(i);
        }   
        hashint = hashint%2069;

        WordEntry word = new WordEntry("");
        MySet<PageEntry> listofp = new MySet<PageEntry>();
        for (int i = 0; i < tableOfWords.hashs.get(hashint).size(); i++) 
        {
            if(tableOfWords.hashs.get(hashint).get(i).word == str)
            {
                word = tableOfWords.hashs.get(hashint).get(i);
                break;
            }
        }
        if(word!=null)
        {
            for (int i = 0; i < word.index.size(); i++) 
            {
                listofp.addElement(word.index.get(i).getPageEntry());    
            }
        }
        else
        {
            System.out.println("word does not exist");
        }
        return listofp;
    }
}