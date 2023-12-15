package subway.config;

import subway.domain.NextStation;
import subway.domain.Station;
import subway.domain.StationRepository;

public class StationInitializer {

    private static final NextStation finalStation = new NextStation(new Station("종점"),0,0);

    public void initialize(){
        initializeLineNumberTwo();
        initializeLineNumberThree();
        initializeNewBundangLine();
    }
    private void initializeLineNumberTwo(){
        Station yunkSamStation = new Station("역삼역", finalStation);
        Station gangNamStation = new Station("강남역", new NextStation(yunkSamStation,2,3));
        Station educationUnivStation = new Station("교대역", new NextStation(gangNamStation,2,3));
        StationRepository.addStation(educationUnivStation);
        StationRepository.addStation(gangNamStation);
        StationRepository.addStation(yunkSamStation);
    }

    private void initializeLineNumberThree(){
        Station maeBongStation = new Station("매봉역", finalStation);
        Station yangJaeStation = new Station("양재역", new NextStation(maeBongStation,1,1));
        Station nambuTerminalStation
                = new Station("남부터미널역",new NextStation(yangJaeStation,6,5));
        Station educationalStation
                = new Station("교대역", new NextStation(nambuTerminalStation,3,2));
    }

    public void initializeNewBundangLine(){
        Station yangjaeCitizenForestStation = new Station("양재시민의숲역", finalStation);
        Station yangjaeStation
                = new Station("양재역", new NextStation(yangjaeCitizenForestStation,10,3));
        Station gangnamStation = new Station("강남역", new NextStation(yangjaeStation,2,8));
    }
}
