package silesiandictionary;

import java.io.*;
import java.util.Scanner;
import java.util.TreeMap;


public class FileClass 
{
    void fillMap(TreeMap<String,String> map)
    {
        synchronized(map)
        {
            File dictionary = new File("dictionary.txt");
            try
            {
                if(!dictionary.exists())
                    dictionary.createNewFile();
            }
            catch (IOException ex)
            {
                System.out.println(ex.getMessage());
            }
           try(Scanner s1 = new Scanner( new BufferedReader(new FileReader("dictionary.txt"))))
            {
                
                String tmp;
                String [] arr;
                while(s1.hasNext())
                {
                    tmp = s1.next();
                    arr = tmp.split("-");
                    map.put(arr[0], arr[1]);
                }
            }
            catch(IOException ex)
            {
                map.put("Sorry", "Some mistake occured");
            }

        }   
    }
    
}
