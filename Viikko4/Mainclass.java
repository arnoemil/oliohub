package Viikko4;

public class Mainclass {
    
    public static void main(String[] args) {
        ReadAndWriteIO io = new ReadAndWriteIO();
        /*io.readAndWrite("/home/arnoemil/Documents/oliohub/Viikko4/input.txt",
        "output.txt");*/
        io.readZip("/home/arnoemil/Documents/oliohub/Viikko4/zipinput.zip");
    }
}
