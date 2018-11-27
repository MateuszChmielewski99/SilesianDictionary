
package silesiandictionary;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javafx.scene.control.ListView;

public class FindWordClass
{
    private static final TreeMap<String, String> treeOfWords = new TreeMap<>();

    
    public  TreeMap<String, String> getTreeOfWords() {
        return treeOfWords;
    }
    

    
    public void findWords(ListView <String> list, String match)
    {   
        list.getItems().clear();
        if(match.isEmpty()) {return;}
        
        //if(!match.isEmpty()){
            Stream str = FindWordClass.treeOfWords.entrySet().stream().filter(s->s.getKey().toLowerCase().startsWith(match.toLowerCase()))
                    .map(s -> s.getKey() + " - " + s.getValue());
    
            Object [] tmp = str.toArray();
        
            
            for(Object o : tmp)
                list.getItems().add(o.toString());
        //}     
            
        
    }
    
    public void findSilesianWords(ListView <String> list, String match)
    {
        list.getItems().clear();
        
        if(match.isEmpty())
        {
            return;
        }
        else
        {
            Stream str = FindWordClass.treeOfWords.entrySet().stream().filter(s->s.getValue().toLowerCase().startsWith(match.toLowerCase()))
                        .map(s -> s.getValue() + " - " + s.getKey());
    
            Object [] tmp = str.toArray();
            for(Object o : tmp)
                list.getItems().add(o.toString());   
        }
    }
    
}
