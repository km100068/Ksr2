package pl.lodz.p.edu.krs.task2.logic;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
@AllArgsConstructor
public class Song {
    private String id;
    private String name;
    private double  popularity;
    private double duration_ms;
    private String explicit;
    private String artists;
    private String id_artists;
    private String release_date;
    private double danceability;
    private double energy;
    private String key;
    private double loudness;
    private String mode;
    private double speechiness;
    private double acousticness;
    private double instrumentalness;
    private double liveness;
    private double valence;
    private double tempo;
    private String time_signature;


}
