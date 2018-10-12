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
                setPage = listofpages.getPagesWhichContainWord(a.toLowerCase());
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
            int i;
            int g;
            for(g=0;g<listofpages.pages.head.size();g++)
            {
                if(listofpages.pages.head.get(g).pagedaName==b)
                {
                    break;
                }
            }
            if(g==listofpages.pages.head.size())
            {
                System.out.println("Webpage "+b+" does not contain word "+a);
                return;
            }
            for (i = 0; i < listofpages.pages.head.size(); i++) 
            {
                if(listofpages.pages.head.get(i).pagedaName==b)
                {
                    PageEntry p = listofpages.pages.head.get(i);
                    for (int j = 0; j < p.info.words.size(); j++) {
                        if(a.toLowerCase()==p.info.words.get(i).word)
                        {
                            MyLinkedList<Position> indices = p.info.words.get(i).getAllPositionsForThisWord();
                            for (int k = 0; k < indices.size(); k++) {
                                if(k==indices.size()-1)
                                {
                                    System.out.println(indices.get(k).getWordIndex());
                                }
                                System.out.printf("%d, HAGO ",indices.get(k).getWordIndex());
                            }
                            return;
                        }
                    }
                }
            }
            if(i==listofpages.pages.head.size())
                {
                    System.out.println("Webpage "+b+" does not contain word magazines");
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