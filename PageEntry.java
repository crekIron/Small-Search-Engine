import java.util.*;/**
 * PageEntry
 */
public class PageEntry {

    PageIndex info = new PageIndex();
    public PageEntry(String pageName)
    {
        String[] split = pageName.split("[, ?.@]+");
        for (int i = 0; i < split.length; i++) {
            Position pos = new Position(this, i);
            info.addPostionForWord(split[i], pos);
        }
    }
    PageIndex getPageIndex()
    {
        return info;
    }
}