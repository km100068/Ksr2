package pl.lodz.p.edu.krs.task2.logic;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import java.io.*;
import java.util.*;

public class CsvReader {
    public static List<Song> getSongList() throws IOException, CsvException {
    FileReader fileReader= new FileReader("src/main/java/pl/lodz/p/edu/krs/task2/tracks/tracks.csv");

    CSVReader reader = new CSVReader(fileReader);


    List<String[]> xd=  reader.readAll();
    ArrayList<Song> songs= new ArrayList<Song>();

    for(int i=1;i<30000;i++){
//        System.out.println(new Song(
//                xd.get(i)[0],xd.get(i)[1],Double.parseDouble(xd.get(i)[2]),Double.parseDouble(xd.get(i)[4]),
//                xd.get(i)[4],xd.get(i)[5],xd.get(i)[6],xd.get(i)[7],
//                Double.parseDouble(xd.get(i)[8]),Double.parseDouble(xd.get(i)[9]),xd.get(i)[10],Double.parseDouble(xd.get(i)[11]),
//                xd.get(i)[12],Double.parseDouble(xd.get(i)[13]),Double.parseDouble(xd.get(i)[14]),Double.parseDouble(xd.get(i)[15]),
//                Double.parseDouble(xd.get(i)[16]),Double.parseDouble(xd.get(i)[17]),Double.parseDouble(xd.get(i)[18]),xd.get(i)[19]));
        System.out.println(xd.get(i)[3]);
        songs.add(new Song(

                xd.get(i)[0],Double.parseDouble(xd.get(i)[2]),Double.parseDouble(xd.get(i)[3]),
                Double.parseDouble(xd.get(i)[8]),Double.parseDouble(xd.get(i)[9]),Double.parseDouble(xd.get(i)[11]),
                Double.parseDouble(xd.get(i)[13]),Double.parseDouble(xd.get(i)[14]),Double.parseDouble(xd.get(i)[15]),
                Double.parseDouble(xd.get(i)[16]),Double.parseDouble(xd.get(i)[17]),Double.parseDouble(xd.get(i)[18])));
    }
    return songs;}

    public static void main(String[] args) throws IOException, CsvException {
        List<Song> songs = getSongList();

        System.out.println("size: " + songs.size());
        for (Song song: songs) {
            System.out.println(song);
        }
    }
}











