package ye.golovnya.streamr.services;

import ye.golovnya.streamr.dtos.ShowDetails;
import ye.golovnya.streamr.dtos.TopServiceDto;
import ye.golovnya.streamr.entities.Show;

import java.util.Collection;
import java.util.List;

public interface ShowService {

    Show getOrCreateShow(ShowDetails showDetails);

    void updateShow(Show show);

    List<ShowDetails> getShows(Collection<Long> ids);

    TopServiceDto getTopServiceForUser(Collection<Long> ids);
}
