package ye.golovnya.streamr.dtos;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Value;
import org.springframework.data.annotation.Immutable;

import javax.validation.constraints.NotNull;
import java.util.Collections;
import java.util.List;

@Immutable
@Value
public class SearchResponseDto {

    List<ShowDetails> searchResults;

    @JsonCreator
    public SearchResponseDto(@JsonProperty("searchResults") @NotNull List<ShowDetails> searchResults) {
        this.searchResults = Collections.unmodifiableList(searchResults);
    }
}
