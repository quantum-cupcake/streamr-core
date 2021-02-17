package ye.golovnya.streamr.services;

import ye.golovnya.streamr.dtos.SearchResponseDto;
import ye.golovnya.streamr.dtos.ShowSearchTermDto;

public interface SearchService {

    SearchResponseDto search(ShowSearchTermDto showSearchTermDto);
}
