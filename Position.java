/**
 * Position
 */
public class Position<p,i> {
    p page;
    i word;
    
    public Position(PageEntry p,int wordIndex)
    {
        page=p;
        i = wordIndex;
    }
    public PageEntry getPageEntry()
    {
        return p;
    }
    public int getWordIndex(){
        return i;
    }
    
    
}