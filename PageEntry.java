import java.util.*;
import java.io.*;
/**
 * PageEntry
 */
public class PageEntry {

    PageIndex info = new PageIndex();
    String pagedaName;
    public PageEntry(String pageName)
    {
        try {
            pagedaName = pageName;
            // System.out.println(pagedaName);
            FileInputStream fstream = new FileInputStream("webpages/"+pageName);
            Scanner s = new Scanner(fstream);
            int i=0;
            while(s.hasNextLine())
            {
                String t = s.nextLine();
                // System.out.println(t);
                String[] split = t.split("[, ?.@():'\"]+");
                for (int j=0;j<split.length; j++) {
                    Position pos = new Position(this, i);
                    info.addPostionForWord(split[j].toLowerCase(), pos);
                    // System.out.printf("%d ",i);
                    // System.out.println(info.words.get(i).word);
                    i=i+1;
                }
            }
            s.close();
        } catch (FileNotFoundException e) {
            System.out.println("file not found");
        }
    }
    PageIndex getPageIndex()
    {
        return info;
    }
    // Make a java file for this
}