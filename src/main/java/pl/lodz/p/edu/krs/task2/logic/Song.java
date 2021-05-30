package pl.lodz.p.edu.krs.task2.logic;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Song {
    private String id;
    private String name;
    private int popularity;
    private int duration_ms;
    private int explicit;
    private String artists;
    private String id_artists;
    private String release_date;
    private double danceability;
    private double energy;
    private int key;
    private double loudness;
    private int mode;
    private double speechiness;
    private double acousticness;
    private double instrumentalness;
    private double liveness;
    private double valence;
    private double tempo;
    private int time_signature;
}
