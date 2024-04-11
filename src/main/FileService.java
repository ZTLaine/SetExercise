package main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class FileService {
    private String FILE_NAME = "PokerHands.csv";

    public Set<String> populateSet(Set<String> set){
        try(BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))){
            String[] row = new String[2];

            //yeet the header into the abyss from whence it came
            br.readLine();
            while((row[0] = br.readLine()) != null) {
                row = row[0].split(",");
                set.add(row[1]);
            }
        }
        catch (IOException e){
            System.out.println("File not found: " + e.getMessage());
        }

        return set;
    }
}
