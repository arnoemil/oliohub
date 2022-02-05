package Viikko4;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.zip.ZipInputStream;

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
                if (output.trim().length() > 1 && output.trim().length() < 30) { 
                    if(output.trim().contains("v")) {
                        wf.write(output+"\n");  
                    }
                }              
            }
            rf.close();
            wf.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    } 

    public void readZip(String fname) {
        try {
            BufferedInputStream bs = new BufferedInputStream(new FileInputStream(fname));
            ZipInputStream zs = new ZipInputStream(bs);
            while (zs.getNextEntry() != null) {
                String output = new String(zs.readAllBytes());
                System.out.println(output);
            }
            zs.close();
            bs.close();
            
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


    }
}