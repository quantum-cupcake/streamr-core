package ye.golovnya.streamr.dtos;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Value;
import org.springframework.data.annotation.Immutable;

import java.net.URI;
import java.util.List;

@Immutable
@Value
public class OpenApiResults {

    List<Result> results;

    @JsonCreator
    public OpenApiResults(@JsonProperty("results") List<Result> results) {
        this.results = results;
    }

    @Immutable
    @Value
    public static class Result {
        @JsonCreator
        public Result(@JsonProperty("name") String name,
                      @JsonProperty("picture") URI picture,
                      @JsonProperty("locations") List<Location> locations) {
            this.name = name;
            this.picture = picture;
            this.locations = locations;
        }

        String name;
        URI picture;
        List<Location> locations;
    }

    @Immutable
    @Value
    public static class Location {
        String displayName;
        String id;

        @JsonCreator
        public Location(@JsonProperty("display_name") String displayName,
                        @JsonProperty("id") String id) {
            this.displayName = displayName;
            this.id = id;
        }
    }
}
//{5 items
//"variant":"rapidapi_basic"
//"results":[1 item
//0:{7 items
//"locations":[1 item
//0:{5 items
//"display_name":"Netflix"
//"id":"5d84d6e2d95dc7385f6a442d"
//"url":"https://www.netflix.com/title/70298933"
//"name":"NetflixIVAGB"
//"icon":"https://utellyassets7.imgix.net/locations_icons/utelly/black_new/NetflixIVAGB.png?w=92&auto=compress&app_version=23f8e481-9672-42ce-b1c8-b950bb12d45a_e12122021-01-29"
//}
//]
//"weight":5653
//"id":"5d914028302b840050acbe62"
//"external_ids":{8 items
//"imdb":{2 items
//"url":"https://www.imdb.com/title/tt3398228"
//"id":"tt3398228"
//}
//"tmdb":{...
//}2 items
//"iva":{...
//}1 item
//"facebook":NULL
//"rotten_tomatoes":NULL
//"wiki_data":{...
//}2 items
//"iva_rating":NULL
//"gracenote":NULL
//}
//"picture":"https://utellyassets9-1.imgix.net/api/Images/4e4d50a0040fd4500193202edbafce6a/Redirect?fit=crop&auto=compress&crop=faces,top"
//"provider":"iva"
//"name":"BoJack Horseman"
//}
//]
//"updated":"2021-01-29T05:09:14+0000"
//"term":"bojack"
//"status_code":200
//}