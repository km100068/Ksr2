package pl.lodz.p.edu.krs.task2.view;

import pl.lodz.p.edu.krs.task2.model.Song;

import java.util.function.Function;

public class SongGettersExtractor {
    public static Function<Song, Double> getMethod(String attrName) {
        return switch (attrName) {
            case "popularność" -> Song::getPopularity;
            case "trwalość" -> Song::getDuration_ms;
            case "taneczność" -> Song::getDanceability;
            case "energiczność" -> Song::getEnergy;
            case "głośność" -> Song::getLoudness;
            case "wokalność" -> Song::getSpeechiness;
            case "akustyczność" -> Song::getAcousticness;
            case "instrumentalność" -> Song::getAcousticness;
            case "nastrój" -> Song::getLiveness;
            case "tempo" -> Song::getTempo;
            default -> null;
        };
    }
}
