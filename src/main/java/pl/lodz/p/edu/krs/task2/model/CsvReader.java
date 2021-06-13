package pl.lodz.p.edu.krs.task2.model;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import pl.lodz.p.edu.krs.task2.model.Song;

import java.io.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class CsvReader {
    public static List<Song> getSongList() throws IOException, CsvException, ParseException {
    FileReader fileReader= new FileReader("tracks.csv");

    CSVReader reader = new CSVReader(fileReader);


    List<String[]> xd=  reader.readAll();
    ArrayList<Song> songs= new ArrayList<Song>();

    for(int i=1;i<12001;i++){


        songs.add(new Song(

                xd.get(i)[0],Double.parseDouble(xd.get(i)[2]),Double.parseDouble(xd.get(i)[3]),
                Double.parseDouble(xd.get(i)[8]),Double.parseDouble(xd.get(i)[9]),Double.parseDouble(xd.get(i)[11])+60,
                Double.parseDouble(xd.get(i)[13]),Double.parseDouble(xd.get(i)[14]),Double.parseDouble(xd.get(i)[15]),
                Double.parseDouble(xd.get(i)[16]),Double.parseDouble(xd.get(i)[17]),Double.parseDouble(xd.get(i)[18])));


    }

    return songs;}

    public static void main(String[] args) throws IOException, CsvException, ParseException {
        List<Song> songs = getSongList();
        System.out.println(songs.get(12).getLoudness());




//        for (Song song: songs) {
//            System.out.println(song);
//        }
        System.out.println("size: " + songs.size());
    }

}











