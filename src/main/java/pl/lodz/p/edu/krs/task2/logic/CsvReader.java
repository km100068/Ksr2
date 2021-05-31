package pl.lodz.p.edu.krs.task2.logic;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import java.io.*;
import java.util.*;

public class CsvReader
{ public static void main(String... args) throws IOException, CsvException {
    FileReader fileReader= new FileReader("src/main/java/pl/lodz/p/edu/krs/task2/logic/tracks/tracks.csv");

    CSVReader reader = new CSVReader(fileReader);


    List<String[]> xd=  reader.readAll();
    List<Song> songs= new ArrayList<>();

    for(int i=1;i<12000;i++){
//        System.out.println(new Song(
//                xd.get(i)[0],xd.get(i)[1],Double.parseDouble(xd.get(i)[2]),Double.parseDouble(xd.get(i)[4]),
//                xd.get(i)[4],xd.get(i)[5],xd.get(i)[6],xd.get(i)[7],
//                Double.parseDouble(xd.get(i)[8]),Double.parseDouble(xd.get(i)[9]),xd.get(i)[10],Double.parseDouble(xd.get(i)[11]),
//                xd.get(i)[12],Double.parseDouble(xd.get(i)[13]),Double.parseDouble(xd.get(i)[14]),Double.parseDouble(xd.get(i)[15]),
//                Double.parseDouble(xd.get(i)[16]),Double.parseDouble(xd.get(i)[17]),Double.parseDouble(xd.get(i)[18]),xd.get(i)[19]));

        songs.add(new Song(
                xd.get(i)[0],xd.get(i)[1],Double.parseDouble(xd.get(i)[2]),Double.parseDouble(xd.get(i)[4]),
                xd.get(i)[4],xd.get(i)[5],xd.get(i)[6],xd.get(i)[7],
                Double.parseDouble(xd.get(i)[8]),Double.parseDouble(xd.get(i)[9]),xd.get(i)[10],Double.parseDouble(xd.get(i)[11]),
                xd.get(i)[12],Double.parseDouble(xd.get(i)[13]),Double.parseDouble(xd.get(i)[14]),Double.parseDouble(xd.get(i)[15]),
                Double.parseDouble(xd.get(i)[16]),Double.parseDouble(xd.get(i)[17]),Double.parseDouble(xd.get(i)[18]),xd.get(i)[19]));
    }
//    for( String[] x : xd){
//        System.out.println(new Song(x[0],x[1],Double.parseDouble(x[2]),x[3],x[4],x[5],x[6],x[7],x[8],x[9],x[10],x[11],x[12],x[13],x[14],x[15],x[16],x[17],x[18],x[19]));
//
//    }


    //List<Song> Songs = readSongsFromCSV("src/main/java/pl/lodz/p/edu/krs/task2/logic/tracks/tracks.csv");
//let's print all the person read from CSV file
//for (Song b : Songs) { System.out.println(b); } }
//
//   private static List<Song> readSongsFromCSV(String fileName) {
//  List<Song> Songs = new ArrayList<>();
//    Path pathToFile = Paths.get(fileName);
//
//    try (BufferedReader br = Files.newBufferedReader(pathToFile,
//            StandardCharsets.UTF_8)) {
//        br.readLine();
//        String line = br.readLine();
//        while (line != null) {
//            String[] attributes = line.split(",");
//            Song book = createSong(attributes);
//            Songs.add(book);
//            line = br.readLine();
//        }
//    }
//    catch (IOException ioe) {
//    ioe.printStackTrace();
//        } return Songs;
//    }
//    private static Song createSong(String[] metadata)
//    {
//
//         String id = metadata[0];
//         String name = metadata[1];
//         System.out.println(metadata[2]);
//         double popularity = Double.parseDouble(metadata[2]);
//         String duration_ms = metadata[3];
//         String explicit = metadata[4];
//         String artists = metadata[5];
//         String id_artists = metadata[6];
//         String release_date= metadata[7];
//         String danceability  = metadata[8];
//         String energy = metadata[9];
//         String key = metadata[10];
//         String loudness = metadata[11];
//         String mode = metadata[12];
//         String speechiness = metadata[13];
//         String acousticness = metadata[14];
//         String instrumentalness = metadata[15];
//         String liveness = metadata[16];
//         String valence = metadata[17];
//         String tempo = metadata[18];
//         String time_signature = metadata[19];
//    return new Song(id, name, popularity, duration_ms, explicit, artists, id_artists, release_date, danceability, energy, key, loudness, mode, speechiness, acousticness, instrumentalness, liveness, valence, tempo, time_signature);
    }
}











