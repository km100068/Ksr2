package pl.lodz.p.edu.krs.task2.view;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import static pl.lodz.p.edu.krs.task2.model.SqlDatabase.*;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.RadioButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

import pl.lodz.p.edu.krs.task2.logic.*;

import pl.lodz.p.edu.krs.task2.model.CsvReader;
import pl.lodz.p.edu.krs.task2.model.Song;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    private static final String set1Name = "piosenek bardzo starych";
    private static final String set2Name = "piosenek przedwojennych";

    private static final String AND = "i";
    private static final String OR = "czy";
    private static final String NOT = "nie";

    private final QuantifierFactory qf = new QuantifierFactory();
    private final FuzzySetFactory ff = new FuzzySetFactory();

    private final List<QuantifierAbsolute> absoluteQuantifiers = new ArrayList<>();
    private final List<QuantifierRelative> relativeQuantifiers = new ArrayList<>();

    private final LinguisticVariable popularity = new LinguisticVariable("popularność");
    private final LinguisticVariable duration = new LinguisticVariable("trwalość");
    private final LinguisticVariable danceability = new LinguisticVariable("taneczność");
    private final LinguisticVariable energy = new LinguisticVariable("energiczność");
    private final LinguisticVariable loudness = new LinguisticVariable("głośność");
    private final LinguisticVariable speechiness = new LinguisticVariable("wokalność");
    private final LinguisticVariable acousticness = new LinguisticVariable("akustyczność");
    private final LinguisticVariable instrumentalness = new LinguisticVariable("instrumentalność");
    private final LinguisticVariable liveness = new LinguisticVariable("nastrój");
    private final LinguisticVariable tempo = new LinguisticVariable("tempo");
    private final LinguisticVariable multiple = new LinguisticVariable("złożone");

    private final List<Song> universe = new ArrayList<>();
    private final List<Song> firstSet = new ArrayList<>();
    private final List<Song> secondSet = new ArrayList<>();


    @FXML private ChoiceBox<String> conjuctionSelect;

    @FXML private ListView<QuantifierAbsolute> absQuantifierList;
    @FXML private ListView<QuantifierRelative> relQuantifierList;

    @FXML private ListView<LinguisticVariable> qualifierAttrList;
    @FXML private ListView<Label> qualifierList;

    @FXML private ListView<LinguisticVariable> summarizerAttrList;
    @FXML private ListView<Label> summarizerList;

    @FXML private CheckBox multiSummaryOption;

    @FXML private CheckBox inverseSummaryOption;

    @FXML private Button form3Btn;

    @FXML private Button form4Btn;

    @FXML private Text t1Text;
    @FXML private Text t2Text;
    @FXML private Text t3Text;
    @FXML private Text t4Text;
    @FXML private Text t5Text;
    @FXML private Text t6Text;
    @FXML private Text t7Text;
    @FXML private Text t8Text;
    @FXML private Text t9Text;
    @FXML private Text t10Text;
    @FXML private Text t11Text;

    @FXML private TextField t1w;
    @FXML private TextField t2w;
    @FXML private TextField t3w;
    @FXML private TextField t4w;
    @FXML private TextField t5w;
    @FXML private TextField t6w;
    @FXML private TextField t7w;
    @FXML private TextField t8w;
    @FXML private TextField t9w;
    @FXML private TextField t10w;
    @FXML private TextField t11w;

    @FXML private Text tText;

    @FXML private ListView<QuantifierAbsolute> createAbsQuantifierList;
    @FXML private ListView<QuantifierRelative> createRelQuantifierList;

    @FXML private ListView<Label> createLabelsList;

    @FXML private ListView<Label> createMultiplyLabelsList;

    private final ToggleGroup createQuantifierTGroup = new ToggleGroup();

    @FXML private RadioButton absQuantifierOption;

    @FXML private RadioButton relQuantifierOption;

    @FXML private ChoiceBox<LinguisticVariable> createAttrList;

    @FXML private TextField quantifierName;

    @FXML private TextField quantifierA;
    @FXML private TextField quantifierB;
    @FXML private TextField quantifierC;
    @FXML private TextField quantifierD;

    @FXML private TextField labelName;

    @FXML private TextField labelA;
    @FXML private TextField labelB;
    @FXML private TextField labelC;
    @FXML private TextField labelD;

    @FXML private ChoiceBox<Label> label1;
    @FXML private ChoiceBox<Label> label2;

    @FXML private TextArea summaryText;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        getDefaultConfig();
        conjuctionSelect.setItems(FXCollections.observableArrayList(AND, OR, NOT));

        absQuantifierOption.setToggleGroup(createQuantifierTGroup);
        relQuantifierOption.setToggleGroup(createQuantifierTGroup);

        summaryText.setEditable(false);

        label1.getSelectionModel().selectedIndexProperty().addListener((observable, oldValue, newValue) -> {
            if (label2.getSelectionModel().getSelectedItem() != null && label2.getSelectionModel().isSelected(newValue.intValue())) {
                label1.getSelectionModel().clearSelection();
            }
        });

        label2.getSelectionModel().selectedIndexProperty().addListener((observable, oldValue, newValue) -> {
            if (label1.getSelectionModel().getSelectedItem() != null && label1.getSelectionModel().isSelected(newValue.intValue())) {
                label2.getSelectionModel().clearSelection();
            }
        });

        conjuctionSelect.getSelectionModel().selectedIndexProperty().addListener((observable, oldValue, newValue) -> {
                label2.setDisable(newValue.intValue() == 2);
        });

        summaryText.setWrapText(true);

        universe.addAll(getSongs());
        firstSet.addAll(getFirstSet());
        secondSet.addAll(getSecondSet());
    }

    public void onQualifierAttrClick(MouseEvent event) {
        qualifierList.setItems(null);
        if (summarizerAttrList.getSelectionModel().getSelectedItem() == null || !summarizerAttrList.getSelectionModel().getSelectedItem().equals(qualifierAttrList.getSelectionModel().getSelectedItem())) {
            qualifierList.setItems(FXCollections.observableArrayList(qualifierAttrList.getSelectionModel().getSelectedItem().getLabels()));
        }
    }

    public void onSummarizerAttrClick(MouseEvent event) {
        summarizerList.setItems(null);
        if (qualifierAttrList.getSelectionModel().getSelectedItem() == null || !qualifierAttrList.getSelectionModel().getSelectedItem().equals(summarizerAttrList.getSelectionModel().getSelectedItem())) {
            summarizerList.setItems(FXCollections.observableArrayList(summarizerAttrList.getSelectionModel().getSelectedItem().getLabels()));
        }
    }

    public void onAbsQuantifierClick(MouseEvent event) {
        relQuantifierList.getSelectionModel().clearSelection();
    }

    public void onRelQuantifierClick(MouseEvent event) {
        absQuantifierList.getSelectionModel().clearSelection();
    }

    public void onMultiSummaryOptionAction() {
        boolean isSelected = multiSummaryOption.isSelected();

        inverseSummaryOption.setDisable(!isSelected);

        form3Btn.setDisable(!isSelected);
        form4Btn.setDisable(!isSelected);
    }

    public void onCreateQuantifierBtnClick(MouseEvent event) {
        Quantifier newQuantifier =
                (quantifierD.getText().length() == 0 || Double.parseDouble(quantifierD.getText()) == 0.0) ?
                absQuantifierOption.isSelected() ?
                        qf.createAbsoluteQuantifierTriangular(
                                quantifierName.getText(),
                                Double.parseDouble(quantifierA.getText()),
                                Double.parseDouble(quantifierB.getText()),
                                Double.parseDouble(quantifierC.getText())) :

                        qf.createRelativeQuantifierTriangular(
                                quantifierName.getText(),
                                Double.parseDouble(quantifierA.getText()),
                                Double.parseDouble(quantifierB.getText()),
                                Double.parseDouble(quantifierC.getText())) :

                        absQuantifierOption.isSelected() ?
                        qf.createAbsoluteQuantifierTrapezoidal(
                                quantifierName.getText(),
                                Double.parseDouble(quantifierA.getText()),
                                Double.parseDouble(quantifierB.getText()),
                                Double.parseDouble(quantifierC.getText()),
                                Double.parseDouble(quantifierD.getText())) :

                        qf.createRelativeQuantifierTrapezoidal(
                                quantifierName.getText(),
                                Double.parseDouble(quantifierA.getText()),
                                Double.parseDouble(quantifierB.getText()),
                                Double.parseDouble(quantifierC.getText()),
                                Double.parseDouble(quantifierD.getText()));

        if (absQuantifierOption.isSelected()) {
            assert newQuantifier instanceof QuantifierAbsolute;
            absoluteQuantifiers.add((QuantifierAbsolute) newQuantifier);
            absQuantifierList.setItems(FXCollections.observableArrayList(absoluteQuantifiers));
            createAbsQuantifierList.setItems(FXCollections.observableArrayList(absoluteQuantifiers));
        } else {
            assert newQuantifier instanceof QuantifierRelative;
            relativeQuantifiers.add((QuantifierRelative) newQuantifier);
            relQuantifierList.setItems(FXCollections.observableArrayList(relativeQuantifiers));
            createRelQuantifierList.setItems(FXCollections.observableArrayList(relativeQuantifiers));
        }
    }

    public void onCreateLabelBtnClick(MouseEvent event) {
        if (labelD.getText().length() == 0 || Double.parseDouble(labelD.getText()) == 0.0) {
            createAttrList.getSelectionModel().getSelectedItem().addLabel(
                    labelName.getText(),
                    Double.parseDouble(labelA.getText()),
                    Double.parseDouble(labelB.getText()),
                    Double.parseDouble(labelC.getText()),
                    SongGettersExtractor.getMethod(createAttrList.getSelectionModel().getSelectedItem().getName()));
        } else {
            createAttrList.getSelectionModel().getSelectedItem().addLabel(
                    labelName.getText(),
                    Double.parseDouble(labelA.getText()),
                    Double.parseDouble(labelB.getText()),
                    Double.parseDouble(labelC.getText()),
                    Double.parseDouble(labelD.getText()),
                    SongGettersExtractor.getMethod(createAttrList.getSelectionModel().getSelectedItem().getName()));
        }

        setLabels();
    }

    public void onCreateMultiplyLabelBtnClick(MouseEvent event) {
        Label newLabel = conjuctionSelect.getSelectionModel().getSelectedItem().equals(AND) ?
                label1.getSelectionModel().getSelectedItem().and(label2.getSelectionModel().getSelectedItem()) :
                conjuctionSelect.getSelectionModel().getSelectedItem().equals(OR) ?
                        label1.getSelectionModel().getSelectedItem().or(label2.getSelectionModel().getSelectedItem()) :
                        label1.getSelectionModel().getSelectedItem().not();

        multiple.addLabel(newLabel);
        setLabels();
    }

    private void getDefaultConfig() {
        popularity.getLabels().clear();
        duration.getLabels().clear();
        danceability.getLabels().clear();
        energy.getLabels().clear();
        loudness.getLabels().clear();
        speechiness.getLabels().clear();
        acousticness.getLabels().clear();
        instrumentalness.getLabels().clear();
        liveness.getLabels().clear();
        tempo.getLabels().clear();
        absoluteQuantifiers.clear();
        relativeQuantifiers.clear();
        multiple.getLabels().clear();

        popularity.addLabel("mało popularne", 0, 7, 15, 21, Song::getPopularity);
        popularity.addLabel("średnio popularne", 20, 30, 43, 51, Song::getPopularity);
        popularity.addLabel("popularne", 50, 55, 60, 65, Song::getPopularity);

        duration.addLabel("bardzo któtkie", 3400, 6000, 8000, 10000, Song::getDuration_ms);
        duration.addLabel("któtkie", 9900, 13000, 16000, 20000, Song::getDuration_ms);
        duration.addLabel("przeciętne", 19000, 25000, 37000, 50000, Song::getDuration_ms);
        duration.addLabel("długie", 49000, 120000, 200000, 410000, Song::getDuration_ms);
        duration.addLabel("bardzo długie", 400000, 2200000, 2700000, 3010000, Song::getDuration_ms);

        danceability.addLabel("mało taneczne", 0, 0.10, 0.18, 0.30, Song::getDanceability);
        danceability.addLabel("średnio taneczne", 0.29, 0.34, 0.44, 0.62, Song::getDanceability);
        danceability.addLabel("bardzo taneczne", 0.60, 0.70, 0.80, 1, Song::getDanceability);

        energy.addLabel("mało energiczne",0.13, 0.15, 0.19, 0.35, Song::getEnergy);
        energy.addLabel("średnio energiczne",0.33, 0.46, 0.58, 0.66, Song::getEnergy);
        energy.addLabel("bardzo energiczne",0.65, 0.79, 0.88, 1, Song::getEnergy);

        loudness.addLabel("ciche",0, 5, 10, 15, Song::getLoudness);
        loudness.addLabel("przeciętnie głośne",14, 18, 22, 26, Song::getLoudness);
        loudness.addLabel("głośne",25, 31, 37, 43, Song::getLoudness);
        loudness.addLabel("bardzo głośne",42, 49, 55, 64, Song::getLoudness);

        speechiness.addLabel("mało wokalne",0, 0.15, 0.27, 0.37, Song::getSpeechiness);
        speechiness.addLabel("średnio wokalne",0.36, 0.46, 0.58, 0.66, Song::getSpeechiness);
        speechiness.addLabel("bardzo wokalne",0.65, 0.79, 0.88, 0.97, Song::getSpeechiness);

        acousticness.addLabel("mało akustyczne",0.12, 0.25, 0.29, 0.35, Song::getAcousticness);
        acousticness.addLabel("średnio akustyczne",0.33, 0.46, 0.58, 0.69, Song::getAcousticness);
        acousticness.addLabel("bardzo akustyczne",0.68, 0.79, 0.88, 1, Song::getAcousticness);

        instrumentalness.addLabel("mało instrumentalne", 0.14, 0.21, 0.27, 0.35, Song::getInstrumentalness);
        instrumentalness.addLabel("średnio instrumentalne", 0.33, 0.46, 0.58, 0.69, Song::getInstrumentalness);
        instrumentalness.addLabel("bardzo instrumentalne", 0.67, 0.79, 0.88, 0.98, Song::getInstrumentalness);

        liveness.addLabel("smutne",0, 0.21, 0.29, 0.35, Song::getLiveness);
        liveness.addLabel("pogodne",0.34, 0.46, 0.58, 0.72, Song::getLiveness);
        liveness.addLabel("wesole",0.71, 0.79, 0.88, 0.99, Song::getLiveness);


        tempo.addLabel("słabe",0, 37, 43, 47, Song::getTempo);
        tempo.addLabel("średnie",46, 53, 80, 99, Song::getTempo);
        tempo.addLabel("szybkie",98, 120, 140, 170, Song::getTempo);
        tempo.addLabel("bardzo szybkie",169, 180, 200, 220, Song::getTempo);


        absoluteQuantifiers.add(qf.createAbsoluteQuantifierTrapezoidal("Mniej niż 500",0,0,99,499));
        absoluteQuantifiers.add(qf.createAbsoluteQuantifierTriangular("Około 500",490,600,700));
        absoluteQuantifiers.add(qf.createAbsoluteQuantifierTriangular("Około 750",690,750,900));
        absoluteQuantifiers.add(qf.createAbsoluteQuantifierTriangular("Około 1000",890,950,1500));
        absoluteQuantifiers.add(qf.createAbsoluteQuantifierTriangular("Około 2000",1490,2000,2500));
        absoluteQuantifiers.add(qf.createAbsoluteQuantifierTrapezoidal("Więcej niż 2000",1900,2500,12000,12000));

        relativeQuantifiers.add(qf.createRelativeQuantifierTrapezoidal("Mniej niż jedna piąta",0,0,0.2,0.25));
        relativeQuantifiers.add(qf.createRelativeQuantifierTriangular("Około ćwiartki",0.24,0.33,0.41));
        relativeQuantifiers.add(qf.createRelativeQuantifierTriangular("Około połowy",0.4,0.5,0.6));
        relativeQuantifiers.add(qf.createRelativeQuantifierTriangular("Około  trzech czwartych",0.59,0.66,0.76));
        relativeQuantifiers.add(qf.createRelativeQuantifierTriangular("Większość",0.75,0.83,0.93));
        relativeQuantifiers.add(qf.createRelativeQuantifierTrapezoidal("Prawie całość",0.85,0.9,1,1.05));

        absQuantifierList.setItems(FXCollections.observableArrayList(absoluteQuantifiers));
        relQuantifierList.setItems(FXCollections.observableArrayList(relativeQuantifiers));
        createAbsQuantifierList.setItems(FXCollections.observableArrayList(absoluteQuantifiers));
        createRelQuantifierList.setItems(FXCollections.observableArrayList(relativeQuantifiers));

        setLabels();

        createMultiplyLabelsList.setItems(FXCollections.observableArrayList(multiple.getLabels()));

        createAttrList.setItems(FXCollections.observableArrayList(
                popularity,
                duration,
                danceability,
                energy,
                loudness,
                speechiness,
                acousticness,
                instrumentalness,
                liveness,
                tempo
        ));
    }

    private void setLabels() {
        qualifierList.setItems(null);
        summarizerList.setItems(null);

        qualifierAttrList.setItems(FXCollections.observableArrayList(
                popularity,
                duration,
                danceability,
                energy,
                loudness,
                speechiness,
                acousticness,
                instrumentalness,
                liveness,
                tempo,
                multiple
        ));

        summarizerAttrList.setItems(FXCollections.observableArrayList(
                popularity,
                duration,
                danceability,
                energy,
                loudness,
                speechiness,
                acousticness,
                instrumentalness,
                liveness,
                tempo,
                multiple
        ));

        ArrayList<Label> allLabels = new ArrayList<>();
        allLabels.addAll(popularity.getLabels());
        allLabels.addAll(duration.getLabels());
        allLabels.addAll(danceability.getLabels());
        allLabels.addAll(energy.getLabels());
        allLabels.addAll(loudness.getLabels());
        allLabels.addAll(speechiness.getLabels());
        allLabels.addAll(acousticness.getLabels());
        allLabels.addAll(instrumentalness.getLabels());
        allLabels.addAll(liveness.getLabels());
        allLabels.addAll(tempo.getLabels());

        createLabelsList.setItems(FXCollections.observableArrayList(allLabels));

        createMultiplyLabelsList.setItems(FXCollections.observableArrayList(multiple.getLabels()));

        label1.setItems(FXCollections.observableArrayList(allLabels));
        label2.setItems(FXCollections.observableArrayList(allLabels));
    }

    public void reset(MouseEvent event) {
        getDefaultConfig();
    }

    public void getForm1(MouseEvent event) {
        Summary summary = null;

        Quantifier quantifier = absQuantifierList.getSelectionModel().getSelectedItem();
        Label summarizer = summarizerList.getSelectionModel().getSelectedItem();

        if (quantifier == null) {
            quantifier = relQuantifierList.getSelectionModel().getSelectedItem();
        }

        if (multiSummaryOption.isSelected()) {
            List<Song> set1 = firstSet, set2 = secondSet;
            String name1 = set1Name, name2 = set2Name;

            if (inverseSummaryOption.isSelected()) {
                set1 = secondSet;
                set2 = firstSet;
                name1 = set2Name;
                name2 = set1Name;
            }

            summary = new SummaryMultipleForm1(set1, set2, name1, name2, quantifier, summarizer);

            emptyTnTexts();


            summaryText.setText(summary.toString());
            tText.setText(String.valueOf(!Double.isNaN(summary.T1()) ? summary.T1() : 0));

        } else {

            summary = new SummarySingleForm1(universe, quantifier, summarizer);
            calculateMeasures(summary);
        }

    }

    public void getForm2(MouseEvent event) {
        Summary summary = null;

        QuantifierRelative quantifier = relQuantifierList.getSelectionModel().getSelectedItem();
        Label summarizer = summarizerList.getSelectionModel().getSelectedItem();
        Label qualifier = qualifierList.getSelectionModel().getSelectedItem();

        if (multiSummaryOption.isSelected()) {
            List<Song> set1 = firstSet, set2 = secondSet;
            String name1 = set1Name, name2 = set2Name;

            if (inverseSummaryOption.isSelected()) {
                set1 = secondSet;
                set2 = firstSet;
                name1 = set2Name;
                name2 = set1Name;
            }

            summary = new SummaryMultipleForm2(set1, set2, name1, name2, quantifier, qualifier, summarizer);

            emptyTnTexts();

            summaryText.setText(summary.toString());
            tText.setText(String.valueOf(!Double.isNaN(summary.T1()) ? summary.T1() : 0));

        } else {

            summary = new SummarySingleForm2(universe,(QuantifierRelative) quantifier, qualifier, summarizer);
            calculateMeasures(summary);
        }


    }

    public void getForm3(MouseEvent event) {
        List<Song> set1 = firstSet, set2 = secondSet;
        String name1 = set1Name, name2 = set2Name;

        if (inverseSummaryOption.isSelected()) {
            set1 = secondSet;
            set2 = firstSet;
            name1 = set2Name;
            name2 = set1Name;
        }

        QuantifierRelative quantifier = relQuantifierList.getSelectionModel().getSelectedItem();
        Label summarizer = summarizerList.getSelectionModel().getSelectedItem();
        Label qualifier = qualifierList.getSelectionModel().getSelectedItem();

        Summary summary = new SummaryMultipleForm3(set1, set2, name1, name2, quantifier, qualifier, summarizer);

        emptyTnTexts();
        summaryText.setText(summary.toString());
        tText.setText(String.valueOf(!Double.isNaN(summary.T1()) ? summary.T1() : 0));
    }

    public void getForm4(MouseEvent event) {
        List<Song> set1 = firstSet, set2 = secondSet;
        String name1 = set1Name, name2 = set2Name;

        if (inverseSummaryOption.isSelected()) {
            set1 = secondSet;
            set2 = firstSet;
            name1 = set2Name;
            name2 = set1Name;
        }

        Label summarizer = summarizerList.getSelectionModel().getSelectedItem();

        Summary summary = new SummaryMultipleForm4(set1, set2, name1, name2, summarizer);

        emptyTnTexts();
        summaryText.setText(summary.toString());
        tText.setText(String.valueOf(!Double.isNaN(summary.T1()) ? summary.T1() : 0));
    }

    private void calculateMeasures(Summary summary) {
        summaryText.setText(summary.toString());

        double T1 = !Double.isNaN(summary.T1()) ? summary.T1() : 0;
        double T2 = !Double.isNaN(summary.T2()) ? summary.T2() : 0;
        double T3 = !Double.isNaN(summary.T3()) ? summary.T3() : 0;
        double T4 = !Double.isNaN(summary.T4()) ? summary.T4() : 0;
        double T5 = !Double.isNaN(summary.T5()) ? summary.T5() : 0;
        double T6 = !Double.isNaN(summary.T6()) ? summary.T6() : 0;
        double T7 = !Double.isNaN(summary.T7()) ? summary.T7() : 0;
        double T8 = !Double.isNaN(summary.T8()) ? summary.T8() : 0;
        double T9 = !Double.isNaN(summary.T9()) ? summary.T9() : 0;
        double T10 = !Double.isNaN(summary.T10()) ? summary.T10() : 0;
        double T11 = !Double.isNaN(summary.T11()) ? summary.T11() : 0;

        t1Text.setText(String.format("%.3f", T1));
        t2Text.setText(String.format("%.3f", T2));
        t3Text.setText(String.format("%.3f", T3));
        t4Text.setText(String.format("%.3f", T4));
        t5Text.setText(String.format("%.3f", T5));
        t6Text.setText(String.format("%.3f", T6));
        t7Text.setText(String.format("%.3f", T7));
        t8Text.setText(String.format("%.3f", T8));
        t9Text.setText(String.format("%.3f", T9));
        t10Text.setText(String.format("%.3f", T10));
        t11Text.setText(String.format("%.3f", T11));

        double[] t = new double[] {
          T1 * Double.parseDouble(t1w.getText()),
          T2 * Double.parseDouble(t2w.getText()),
          T3 * Double.parseDouble(t3w.getText()),
          T4 * Double.parseDouble(t4w.getText()),
          T5 * Double.parseDouble(t5w.getText()),
          T6 * Double.parseDouble(t6w.getText()),
          T7 * Double.parseDouble(t7w.getText()),
          T8 * Double.parseDouble(t8w.getText()),
          T9 * Double.parseDouble(t9w.getText()),
          T10 * Double.parseDouble(t10w.getText()),
          T11 * Double.parseDouble(t11w.getText()),
        };

        tText.setText(String.format("%.3f", Arrays.stream(t).sum()));
    }

    private void emptyTnTexts() {
        t1Text.setText("0");
        t2Text.setText("0");
        t3Text.setText("0");
        t4Text.setText("0");
        t5Text.setText("0");
        t6Text.setText("0");
        t7Text.setText("0");
        t8Text.setText("0");
        t9Text.setText("0");
        t10Text.setText("0");
        t11Text.setText("0");
    }
}
