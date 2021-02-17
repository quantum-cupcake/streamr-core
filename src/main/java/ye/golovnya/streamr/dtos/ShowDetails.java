package ye.golovnya.streamr.dtos;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Value;
import org.springframework.data.annotation.Immutable;

@Immutable
@Value
public class ShowDetails {

    String title;
    String serviceName;
    String image;

    @JsonCreator
    public ShowDetails(@JsonProperty("title") String title,
                       @JsonProperty("serviceName") String serviceName,
                       @JsonProperty("image") String image) {
        this.title = title;
        this.serviceName = serviceName;
        this.image = image;
    }

}
