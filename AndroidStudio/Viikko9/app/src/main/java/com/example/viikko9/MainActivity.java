package com.example.viikko9;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class MainActivity extends AppCompatActivity {
    TextView movie;
    TextView showDate;
    TextView showTime;
    TextView place;
    String theaterID;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        movie = (TextView) findViewById(R.id.movie);
        place = (TextView) findViewById(R.id.place);
        showTime = (TextView) findViewById(R.id.showTime);
        showDate = (TextView) findViewById(R.id.showDate);

        LocalDate today = LocalDate.now();
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd-MM-yyy");

        String formattedDate = today.format(dateFormat);
        //System.out.println("Tänään on: " + formattedDate);


        TheatreData theaters = new TheatreData();
        this.readXML(theaters);

        Spinner mySpinner = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, theaters.getData());
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinner.setAdapter(myAdapter);

        ListView lw = (ListView) findViewById(R.id.listView);
        ArrayAdapter adapter = new ArrayAdapter<String>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, Collections.singletonList(it.next()));
        lw.setAdapter(adapter);

        mySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                theaterID = theaters.getID(mySpinner.getSelectedItemPosition());
                MainActivity.getShow(formattedDate, theaterID);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


    }

    public class TheatreData {
        ArrayList<String> id = new ArrayList();
        ArrayList<String> name = new ArrayList();

        public TheatreData() {

        }

        public void setName(String n) {
            name.add(n);
        }

        public String getName(int i) {
            return name.get(i);
        }

        public void setID(String i) {
            id.add(i);
        }

        public String getID(int i) {
            return id.get(i);
        }

        public ArrayList<String> getData() {
            for (int i = 0; i < name.size(); i++) {
                name.get(i);
            }
            return name;
        }
    }

    public TheatreData readXML(TheatreData data) {
        try {
            DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            String urlString = "https://www.finnkino.fi/xml/TheatreAreas/";
            Document doc = builder.parse(urlString);
            doc.getDocumentElement().normalize();
            System.out.println("Root element: " + doc.getDocumentElement().getNodeName());

            NodeList nList = doc.getDocumentElement().getElementsByTagName("TheatreArea");

            for (int i = 0; i < nList.getLength(); i++) {
                Node node = nList.item(i);
                //System.out.println("Node name: " + node.getNodeName());

                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    data.setID(element.getElementsByTagName("ID").item(0).getTextContent());
                    data.setName(element.getElementsByTagName("Name").item(0).getTextContent());


                    System.out.print("ID: ");
                    System.out.println(data.getID(i));
                    //System.out.println(element.getElementsByTagName("ID").item(0).getTextContent());
                    System.out.print("Name: ");
                    System.out.println(data.getName(i));
                    //System.out.println(element.getElementsByTagName("Name").item(0).getTextContent());
                }
            }
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
        return data;
    }


    public static ArrayList<String> getShow(String date, String id) {
        ArrayList<String> shows = new ArrayList<String>();
        try {
            DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            String urlString = "https://www.finnkino.fi/xml/Schedule/?area=" + id + "&dt=" + date + "";
            Document doc = builder.parse(urlString);
            doc.getDocumentElement().normalize();
            System.out.println("Root element: " + doc.getDocumentElement().getNodeName());

            NodeList nList = doc.getDocumentElement().getElementsByTagName("Shows");

            for (int i = 0; i < nList.getLength(); i++) {
                Node node = nList.item(i);
                //System.out.println("Node name: " + node.getNodeName());

                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;

                    String movieName = element.getElementsByTagName("Title").item(0).getTextContent();
                    String theatreAuditorium = element.getElementsByTagName("TheatreAndAuditorium").item(0).getTextContent();
                    String length = element.getElementsByTagName("LengthInMinutes").item(0).getTextContent();
                    String showStart = element.getElementsByTagName("dttmShowStart").item(0).getTextContent();

                    shows.add(movieName);
                    shows.add(theatreAuditorium);
                    shows.add(length);
                    shows.add(showStart);

                    //System.out.println(element.getElementsByTagName("TheatreID").item(0).getTextContent());
                    //data.setName(element.getElementsByTagName("Name").item(0).getTextContent());
                }
            }
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
        return shows;
    }
}