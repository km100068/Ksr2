package pl.lodz.p.edu.krs.task2.logic;

import com.opencsv.bean.CsvToBeanBuilder;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class CsvReader {

    public static void main(String[] args) throws IOException {

        String fileName = "src/main/java/pl/lodz/p/edu/krs/task2/logic/tracks/tracks.csv";

        List<Song> beans = new CsvToBeanBuilder(new FileReader(fileName))
                .withType(Song.class)
                .build()
                .parse();

        beans.forEach(System.out::println);

    }

}