import java.io.*;

/**
 * SearchEngine
 */
public class SearchEngine {

    SearchEngine()
    {
        InvertedPageIndex listofpages = new InvertedPageIndex();
    }

    void performAction(String actionMessage)
    {
        int a,b;
		String[] split = actionMessage.split(" ",0);
		
        if(Objects.equals(split[0], "addPage"))
        {
            a = split[1];
            File dir = new File("~/DS/2018COL106assn3/webpages");
            String[] children = dir.list();
            for(int i=0; i< children.length;i++)
            {
                if(children[i]==a)
                {
                    
                }
            }
        }
    }

}