package ye.golovnya.streamr.dtos;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Value;
import org.springframework.data.annotation.Immutable;

import java.util.List;

@Immutable
@Value
public class TopServiceDto {

    List<ShowDetails> showsList;
    List<String> topServices;

    @JsonCreator
    public TopServiceDto(@JsonProperty("showsList") List<ShowDetails> showsList,
                         @JsonProperty("topServices") List<String> topServices) {
        this.showsList = showsList;
        this.topServices = topServices;
    }
}
