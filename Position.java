/**
 * Position
 */
public class Position{
    PageEntry page;
    int word;
    
    public Position(PageEntry pa,int wordIndex)
    {
        page=pa;
        word = wordIndex;
    }
    public PageEntry getPageEntry()
    {
        return page;
    }
    public int getWordIndex(){
        return word;
    }
    
    
}