import java.util.*;
import java.io.*;
/**
 * PageEntry
 */
public class PageEntry {

    String pagedaName;
    PageIndex info = new PageIndex();
    public PageEntry(String pageName)
    {
        try {
            pagedaName = pageName;
            // System.out.println(pagedaName);
            FileInputStream fstream = new FileInputStream("webpages/"+pageName);
            Scanner s = new Scanner(fstream);
            int i=1;
            while(s.hasNextLine())
            {
                String t = s.nextLine();
                // System.out.println(t);
                String[] split = t.split("[:, ?.{}\\[\\]<>=();'\"#!-]+");
                if(t.length()!=0)
                {
                    for (int j=0;j<split.length; j++) {
                        Position pos = new Position(this, i);
                        String a = split[j].toLowerCase();
                        // System.out.println(split[j]);
                        if(!(Objects.equals(a, "a")||Objects.equals(a, "an")||Objects.equals(a, "the")||Objects.equals(a, "they")||Objects.equals(a, "these")||Objects.equals(a, "this")||Objects.equals(a, "for")||Objects.equals(a, "is")||Objects.equals(a, "are")||Objects.equals(a, "was")||Objects.equals(a, "of")||Objects.equals(a, "or")||Objects.equals(a, "and")||Objects.equals(a, "does")||Objects.equals(a, "will")||Objects.equals(a, "whose")))
                        {
                            if(Objects.equals(a, "stacks"))
                            {
                                info.addPostionForWord("stack", pos);
                                // System.out.printf("%d %s",pos.word,a);
                                // System.out.println("");
                            }
                            else if(Objects.equals(a, "applications"))
                            {
                                info.addPostionForWord("application", pos);
                                // System.out.printf("%d %s",pos.word,a);
                                // System.out.println("");
                            }
                            else if(Objects.equals(a, "structures"))
                            {
                                info.addPostionForWord("structure", pos);
                                // System.out.printf("%d %s",pos.word,a);
                                // System.out.println("");
                            }
                            else
                            {
                                info.addPostionForWord(a, pos);
                                // System.out.printf("%d %s",pos.word,a);
                                // System.out.println("");
                            }
                            
                        }
                        // System.out.printf("%d ",i);
                        // System.out.println(info.words.get(i).word);
                        i=i+1;
                    }
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