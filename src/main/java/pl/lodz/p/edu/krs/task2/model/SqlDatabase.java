package pl.lodz.p.edu.krs.task2.model;

import com.opencsv.exceptions.CsvException;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static pl.lodz.p.edu.krs.task2.model.CsvReader.getSongList;

public class SqlDatabase {
    static String url="jdbc:sqlserver://localhost;databaseName=KSR";
    static String user="";
    static String password="";

    public static void UpdateDatabase() throws IOException, CsvException {

        Connection connection;
        List<Song> songs = getSongList();

        {
            try {

                connection = DriverManager.getConnection(url,user,password);
                System.out.println("podłącznone do bazy danych");
                String insert= new String();
                for (int i=0;i<songs.size();i++){
                    insert =  "INSERT INTO Songs(id, popularity, duration_ms, danceability, energy, loudness ,speechiness, acousticness, instrumentalness, liveness, valence ,tempo)"
                            +"  Values("
                    +"'"+ songs.get(i).getId()+"'"+","+songs.get(i).getPopularity()+","+songs.get(i).getDuration_ms()
                            +","+songs.get(i).getDanceability()+","+songs.get(i).getEnergy()+","+songs.get(i).getLoudness()
                            +","+songs.get(i).getSpeechiness()+","+songs.get(i).getAcousticness()+","+songs.get(i).getInstrumentalness()
                            +","+songs.get(i).getLiveness()+","+songs.get(i).getValence()+","+songs.get(i).getTempo()
                    +")";
                    Statement statement = connection.createStatement();
                    statement.executeUpdate(insert);
                }











            } catch (SQLException e) {
                System.out.println("brak połączenia");
                e.printStackTrace();
            }
        }

    }
    public static void UpdateFirstSet() throws IOException, CsvException {

        List<Song> songs = getSongList();
        Connection connection;
        System.out.println(songs.size());

        {
            try {

                connection = DriverManager.getConnection(url,user,password);
                System.out.println("podłącznone do bazy danych");
                String insert= new String();
                for (int i=0;i<songs.size()/2;i++){
                    insert =  "INSERT INTO FirstSet(id, popularity, duration_ms, danceability, energy, loudness ,speechiness, acousticness, instrumentalness, liveness, valence ,tempo)"
                            +"  Values("
                    +"'"+ songs.get(i).getId()+"'"+","+songs.get(i).getPopularity()+","+songs.get(i).getDuration_ms()
                            +","+songs.get(i).getDanceability()+","+songs.get(i).getEnergy()+","+songs.get(i).getLoudness()
                            +","+songs.get(i).getSpeechiness()+","+songs.get(i).getAcousticness()+","+songs.get(i).getInstrumentalness()
                            +","+songs.get(i).getLiveness()+","+songs.get(i).getValence()+","+songs.get(i).getTempo()
                    +")";
                    Statement statement = connection.createStatement();
                    statement.executeUpdate(insert);
                }










            } catch (SQLException e) {
                System.out.println("brak połączenia");
                e.printStackTrace();
            }

        }

    }
    public static void UpdateSecondSet() throws IOException, CsvException {

        Connection connection;
        List<Song> songs = getSongList();
        {
            try {

                connection = DriverManager.getConnection(url,user,password);
                System.out.println("podłącznone do bazy danych");
                String insert=new String();
                for (int i=0;i<songs.size()/2;i++){
                    insert = "INSERT INTO SecondSet(id, popularity, duration_ms, danceability, energy, loudness ,speechiness, acousticness, instrumentalness, liveness, valence ,tempo)"
                            +"  Values("
                     +"'"+ songs.get(songs.size()/2+i).getId()+"'"+","+songs.get(songs.size()/2+i).getPopularity()+","+songs.get(songs.size()/2+i).getDuration_ms()
                            +","+songs.get(songs.size()/2+i).getDanceability()+","+songs.get(songs.size()/2+i).getEnergy()+","+songs.get(songs.size()/2+i).getLoudness()
                            +","+songs.get(songs.size()/2+i).getSpeechiness()+","+songs.get(songs.size()/2+i).getAcousticness()+","+songs.get(songs.size()/2+i).getInstrumentalness()
                            +","+songs.get(songs.size()/2+i).getLiveness()+","+songs.get(songs.size()/2+i).getValence()+","+songs.get(songs.size()/2+i).getTempo()
                    +")";
                    Statement statement = connection.createStatement();
                    statement.executeUpdate(insert);
                }

                System.out.println(insert);








            } catch (SQLException e) {
                System.out.println("brak połączenia");
                e.printStackTrace();
            }
        }

    }
    public static ArrayList<Song> getSongs(){

        Connection connection;
        ArrayList<Song> songs = new ArrayList<Song>();



        {
            try {

                connection = DriverManager.getConnection(url,user,password);
                System.out.println("podłącznone do bazy danych");
                String select = "Select * FROM Songs";

                Statement statement = connection.createStatement();
                ResultSet Ls = statement.executeQuery(select);
                while(Ls.next()){
                    songs.add(new Song(Ls.getString("id"),
                            Ls.getDouble("popularity"),
                            Ls.getDouble("duration_ms"),
                            Ls.getDouble("danceability"),
                            Ls.getDouble("energy"),
                            Ls.getDouble("loudness"),
                            Ls.getDouble("speechiness"),
                            Ls.getDouble("acousticness"),
                            Ls.getDouble("instrumentalness"),
                            Ls.getDouble("liveness"),
                            Ls.getDouble("valence"),
                            Ls.getDouble("Tempo")
                            ));
//                        song.setId(Ls.getString("id"));
//                        song.setPopularity(Ls.getDouble("popularity"));
//                        song.setDuration_ms(Ls.getDouble("duration_ms"));
//                        song.setDanceability(Ls.getDouble("danceability"));
//                        song.setEnergy(Ls.getDouble("energy"));
//                        song.setLoudness(Ls.getDouble("loudness"));
//                        song.setSpeechiness(Ls.getDouble("speechiness"));
//                        song.setAcousticness(Ls.getDouble("acousticness"));
//                        song.setInstrumentalness(Ls.getDouble("instrumentalness"));
//                        song.setLiveness(Ls.getDouble("liveness"));
//                        song.setValence(Ls.getDouble("valence"));
//                        song.setTempo(Ls.getDouble("Tempo"));
//                        songs.add(song);


                }
                Ls.close();

            } catch (SQLException e) {
                System.out.println("brak połączenia");
                e.printStackTrace();
            }

        }
        return songs;

    }
    public static ArrayList<Song> getSecondSet(){

        Connection connection;
        ArrayList<Song> songs = new ArrayList<Song>();



        {
            try {

                connection = DriverManager.getConnection(url,user,password);
                System.out.println("podłącznone do bazy danych");
                String select = "Select * FROM SecondSet";

                Statement statement = connection.createStatement();
                ResultSet Ls = statement.executeQuery(select);
                while(Ls.next()){
                    songs.add(new Song(Ls.getString("id"),
                            Ls.getDouble("popularity"),
                            Ls.getDouble("duration_ms"),
                            Ls.getDouble("danceability"),
                            Ls.getDouble("energy"),
                            Ls.getDouble("loudness"),
                            Ls.getDouble("speechiness"),
                            Ls.getDouble("acousticness"),
                            Ls.getDouble("instrumentalness"),
                            Ls.getDouble("liveness"),
                            Ls.getDouble("valence"),
                            Ls.getDouble("Tempo")
                    ));
//                        song.setId(Ls.getString("id"));
//                        song.setPopularity(Ls.getDouble("popularity"));
//                        song.setDuration_ms(Ls.getDouble("duration_ms"));
//                        song.setDanceability(Ls.getDouble("danceability"));
//                        song.setEnergy(Ls.getDouble("energy"));
//                        song.setLoudness(Ls.getDouble("loudness"));
//                        song.setSpeechiness(Ls.getDouble("speechiness"));
//                        song.setAcousticness(Ls.getDouble("acousticness"));
//                        song.setInstrumentalness(Ls.getDouble("instrumentalness"));
//                        song.setLiveness(Ls.getDouble("liveness"));
//                        song.setValence(Ls.getDouble("valence"));
//                        song.setTempo(Ls.getDouble("Tempo"));
//                        songs.add(song);


                }
                Ls.close();

            } catch (SQLException e) {
                System.out.println("brak połączenia");
                e.printStackTrace();
            }

        }
        return songs;

    }
    public static ArrayList<Song> getFirstSet(){

        Connection connection;
        ArrayList<Song> songs = new ArrayList<Song>();



        {
            try {

                connection = DriverManager.getConnection(url,user,password);
                System.out.println("podłącznone do bazy danych");
                String select = "Select * FROM FirstSet";

                Statement statement = connection.createStatement();
                ResultSet Ls = statement.executeQuery(select);
                while(Ls.next()){
                    songs.add(new Song(Ls.getString("id"),
                            Ls.getDouble("popularity"),
                            Ls.getDouble("duration_ms"),
                            Ls.getDouble("danceability"),
                            Ls.getDouble("energy"),
                            Ls.getDouble("loudness"),
                            Ls.getDouble("speechiness"),
                            Ls.getDouble("acousticness"),
                            Ls.getDouble("instrumentalness"),
                            Ls.getDouble("liveness"),
                            Ls.getDouble("valence"),
                            Ls.getDouble("Tempo")
                    ));
//                        song.setId(Ls.getString("id"));
//                        song.setPopularity(Ls.getDouble("popularity"));
//                        song.setDuration_ms(Ls.getDouble("duration_ms"));
//                        song.setDanceability(Ls.getDouble("danceability"));
//                        song.setEnergy(Ls.getDouble("energy"));
//                        song.setLoudness(Ls.getDouble("loudness"));
//                        song.setSpeechiness(Ls.getDouble("speechiness"));
//                        song.setAcousticness(Ls.getDouble("acousticness"));
//                        song.setInstrumentalness(Ls.getDouble("instrumentalness"));
//                        song.setLiveness(Ls.getDouble("liveness"));
//                        song.setValence(Ls.getDouble("valence"));
//                        song.setTempo(Ls.getDouble("Tempo"));
//                        songs.add(song);


                }
                Ls.close();

            } catch (SQLException e) {
                System.out.println("brak połączenia");
                e.printStackTrace();
            }

        }
        return songs;

    }
    public static void main(String[] args) throws IOException, CsvException {
        List<Song> songs = getSongs();

        List<Song> firstSet = getFirstSet();
        List<Song> secondSet = getSecondSet();



//        System.out.println("size: " + songs.size());
//        for (Song song: songs) {
//            System.out.println(song);
//        }
        System.out.println(songs.size());
        System.out.println(firstSet.size());
        System.out.println(secondSet.size());
    }

}
