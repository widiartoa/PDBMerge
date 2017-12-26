import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class Traintest {

	public static void main(String[] args) {
		
        String csvFile2005 = "src/input/season_output_2005.csv";
        String csvFile2006 = "src/input/season_output_2006.csv";
        String csvFile2007 = "src/input/season_output_2007.csv";
        String csvFile2008 = "src/input/season_output_2008.csv";
        String csvFile2009 = "src/input/season_output_2009.csv";
        String csvFile2010 = "src/input/season_output_2010.csv";
        String csvFile2011 = "src/input/season_output_2011.csv";
        String csvFile2012 = "src/input/season_output_2012.csv";
        String csvFile2013 = "src/input/season_output_2013.csv";
        String csvFile2014 = "src/input/season_output_2014.csv";
        String csvFile2015 = "src/input/season_output_2015.csv";
        String csvFile2016 = "src/input/season_output_2016.csv";
        String csvFile2017 = "src/input/season_output_2017.csv";
		
		try {

        	String outputFile1 = "src/output/combined.csv";
            FileWriter writer1 = new FileWriter(outputFile1);
                        
            System.out.println("Merging training data...");
            
            supply(writer1, csvFile2005);
            supply(writer1, csvFile2006);
            supply(writer1, csvFile2007);
            supply(writer1, csvFile2008);
            supply(writer1, csvFile2009);
            supply(writer1, csvFile2010);
            supply(writer1, csvFile2011);
            supply(writer1, csvFile2012);
            supply(writer1, csvFile2013);
            supply(writer1, csvFile2014);
            supply(writer1, csvFile2015);
            supply(writer1, csvFile2016);
            supply(writer1, csvFile2017);
            
            writer1.flush();
            writer1.close();
            
            System.out.println("Merging training done.");
            
            //===============================================
            
//            String outputFile2 = "src/output/test.csv";
//            FileWriter writer2 = new FileWriter(outputFile2);
//                        
//            System.out.println("Merging testing data...");
//            
//            supply(writer2, csvFile2013);
//            supply(writer2, csvFile2014);
//            supply(writer2, csvFile2015);
//            supply(writer2, csvFile2016);
//            supply(writer2, csvFile2017);
//            
//            writer2.flush();
//            writer2.close();
//            
//            System.out.println("Merging testing done.");
            
  
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
        	
        }
		
	}
	
	public static void supply(FileWriter writer, String csvPath) throws IOException {
		
		BufferedReader br = new BufferedReader(new FileReader(csvPath));
		String line = "";
		
        while ((line = br.readLine()) != null) {

            String[] data = line.split(",");
            String itemType			= data[0];
            String collection		= data[1];
            String checkoutdatetime = data[2];
            String season			= data[3];
            
            CSVUtils.writeLine(writer, Arrays.asList(itemType, collection, checkoutdatetime, season));
            System.out.println("Supplied data : " + itemType + " - " + collection + " - " + checkoutdatetime + " - " + season);
            System.out.println("=====");
            
        }
	}
}
