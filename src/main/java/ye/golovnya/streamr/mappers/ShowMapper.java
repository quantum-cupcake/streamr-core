package ye.golovnya.streamr.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import ye.golovnya.streamr.dtos.ShowDetails;
import ye.golovnya.streamr.entities.Show;

import java.util.Collection;
import java.util.List;

@Mapper(componentModel= "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ShowMapper {

    Show showDetailsToModel(ShowDetails showDetails);
    ShowDetails modelToShowDetails(Show model);

    List<ShowDetails> modelsToShowDetailsList(Collection<Show> models);
}
