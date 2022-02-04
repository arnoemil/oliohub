package Viikko4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ReadAndWriteIO {
    
    public void readFile(String fname) {
        try {
            BufferedReader rf = new BufferedReader(new FileReader(fname));
            String output;
            while ((output = rf.readLine()) != null) {
                System.out.println(output);
            }
            rf.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readAndWrite(String rfile, String wfile) {

        try {
            BufferedReader rf = new BufferedReader(new FileReader(rfile));
            BufferedWriter wf = new BufferedWriter(new FileWriter(wfile));
            String output;
            while((output = rf.readLine()) != null) {
                wf.write(output);                
            }
            rf.close();
            wf.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
