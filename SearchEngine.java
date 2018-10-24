import java.io.*;
import java.util.*;
/**
 * SearchEngine
 */
public class SearchEngine {

    InvertedPageIndex listofpages;
    SearchEngine()
    {
        listofpages = new InvertedPageIndex();
    }

    void performAction(String actionMessage)
    {
        String a,b;
		String[] split = actionMessage.split(" ",0);
        // System.out.printf("%s: ",actionMessage);
        // System.out.println("");        
        if(Objects.equals(split[0], "addPage"))
        {
            a = split[1];
            PageEntry web = new PageEntry(a);
            listofpages.addPage(web);
            // System.out.println(listofpages.pages.head.size());
        }
        else if(Objects.equals(split[0], "queryFindPagesWhichContainWord"))
        {
            a = split[1];
            MySet<PageEntry> setPage = new MySet<PageEntry>();
            try {
                if(Objects.equals(a, "stacks"))
                {
                    setPage = listofpages.getPagesWhichContainWord("stack");
                }
                else if(Objects.equals(a, "applications"))
                {
                    setPage = listofpages.getPagesWhichContainWord("application");
                }
                else if(Objects.equals(a, "structures"))
                {
                    setPage = listofpages.getPagesWhichContainWord("structure");
                }
                else
                {
                    setPage = listofpages.getPagesWhichContainWord(a.toLowerCase());
                }

                // System.out.printf("%d %d ",setPage.head.size(),listofpages.pages.head.size());
                for (int i = 0; i < setPage.head.size(); i++) 
                {
                    // System.out.printf("%d ",setPage.head.size());
                    if(i==setPage.head.size()-1)
                    {
                        // System.out.printf("%d ",setPage.head.size());
                        System.out.println(setPage.head.get(i).pagedaName);  
                        break; 
                    }
                    System.out.printf("%s, ",setPage.head.get(i).pagedaName);    
                }
            } catch (NullPointerException e) {
                System.out.println("No webpage contains word "+a);
            }
            
        }
        else if(Objects.equals(split[0], "queryFindPositionsOfWordInAPage"))
        {
            a = split[1];
            b = split[2];
            int g;
            int j;
            for(g=0;g<listofpages.pages.head.size();g++)
            {
                if(Objects.equals(listofpages.pages.head.get(g).pagedaName, b))
                {
                    break;
                }
            }
            if(g==listofpages.pages.head.size())
            {
                System.out.println("No webpage "+b+" found");
                return;
            }

            if(Objects.equals(a, "stacks"))
            {
                a="stack";
            }
            else if(Objects.equals(a, "applications"))
            {
                a="application";
            }
            else if(Objects.equals(a, "structures"))
            {
                a="structure";
            }
        
            
            
            PageEntry p = listofpages.pages.head.get(g);
            // System.out.println(p.pagedaName);
            for (j = 0; j < p.info.words.size(); j++) {
                // System.out.println(p.info.words.get(j).word);
                if(Objects.equals(a.toLowerCase(), p.info.words.get(j).word))
                {
                    MyLinkedList<Position> indices = p.info.words.get(j).getAllPositionsForThisWord();
                    // System.out.println(indices);
                    for (int k = 0; k < indices.size(); k++) {
                        if(k==indices.size()-1)
                        {
                            System.out.println(indices.get(k).getWordIndex());
                            break;
                        }
                        System.out.printf("%d, ",indices.get(k).getWordIndex());
                    }
                    return;
                }
            }
            // System.out.println(j);
            // System.out.println(listofpages.pages.head.size());
            if(j==p.info.words.size())
                {
                    System.out.println("Webpage "+b+" does not contain word "+a);
                }
        }
    }
    public static void main(String[] args) {
        SearchEngine r = new SearchEngine();
        r.performAction("addPage stack_datastructure_wiki");
        r.performAction("queryFindPagesWhichContainWord delhi");
        r.performAction("queryFindPagesWhichContainWord stack");
    }

}