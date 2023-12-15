package subway.config;

import subway.domain.Line;
import subway.domain.LineRepository;

public class LineInitializer {

    public void initialize(){
        LineRepository.addLine(new Line("2호선"));
        LineRepository.addLine(new Line("3호선"));
        LineRepository.addLine(new Line("신분당선"));
    }
}
