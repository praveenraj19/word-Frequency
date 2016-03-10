import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
//import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
//import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
//import java.util.SortedSet;
//import java.util.TreeSet;
import java.util.stream.Collectors;
//import java.io.PrintWriter;


public class WordFrequency {



    public static void main(String[] file) throws FileNotFoundException, IOException {
    	
    	long starttime = System.currentTimeMillis();
    File input = new File("C:/Users/User/Downloads/pg2600.txt");
    String outFile = "C:/Users/User/Desktop/CloudwickTraining/workspace/word/src/tf.csv";
    BufferedReader br = new BufferedReader(new FileReader(input));

        String inputLine = null;

        HashMap<String, Integer> map = new HashMap<String, Integer>();
        FileWriter fw = new FileWriter(new File(outFile));
        BufferedWriter p = null;
        p = new BufferedWriter(fw);
        
       try {
    	     //System.out.println("1");

           while ((inputLine = br.readLine()) != null) {

            String[] words = inputLine.split("[^a-zA-Z]");
            //System.out.println("2");

 for (int wordCounter = 0; wordCounter < words.length; wordCounter++) {

            String key = words[wordCounter].toLowerCase();
            
            //System.out.println(key);
 
            if (key.length() > 0) {

               if (map.get(key) == null) {

                map.put(key, 1);

                 }else {
               int value = map.get(key);

                 value++;

                 map.put(key, value);

                        }

                    }
                    
               //System.out.println("Can");


                 
                    }	
 
 //System.out.println("3");
             

        }
           br.close();
           //System.out.println(map.get("the"));
           Set<Map.Entry<String, Integer>> entrySet = map.entrySet();
           
           /////////
           for (String key : map.keySet()){
        	   p.write(key + " , " + map.get(key));
        	   p.newLine();
           }
           
           ///////
           /*for (Map.Entry<String, Integer> entry : entrySet) {

                p.write(entry.getValue() + "," + entry.getKey());
                p.newLine();
               
           }*/
           
           
        }
       
        catch (IOException error) {

            System.out.println("Invalid File"); 

        }
       finally {

            


       }

       Map<String, Integer> sort = map.entrySet().stream()
		    .sorted(Map.Entry.comparingByValue())
		    .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
		                              (e1, e2) -> e1, LinkedHashMap::new));
	ArrayList <Map.Entry<String,Integer>> list = new ArrayList<>(sort.entrySet());
	for( int i = list.size() -1 ; i >= list.size() -11 ; i --){
		Map.Entry<String, Integer> current = list.get(i);
		System.out.print( current.getKey() + ", " + current.getValue() + "\n");
		p.write(current.getKey() + ", " + current.getValue() + "\n");
		p.newLine();
	}
		
		
		long endtime = System.currentTimeMillis();
		System.out.println(endtime - starttime);
}

    }