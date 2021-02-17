package ye.golovnya.streamr.services.impl;

import org.springframework.stereotype.Service;
import ye.golovnya.streamr.dtos.SearchRequestDto;
import ye.golovnya.streamr.dtos.SearchResponseDto;
import ye.golovnya.streamr.dtos.ShowSearchTermDto;
import ye.golovnya.streamr.feign.StreamrApiUtellyClient;
import ye.golovnya.streamr.services.SearchService;

import java.util.List;

@Service
public class SearchServiceUtellyImpl implements SearchService {

    private final StreamrApiUtellyClient streamrApiUtellyClient;

    public SearchServiceUtellyImpl(StreamrApiUtellyClient streamrApiUtellyClient) {
        this.streamrApiUtellyClient = streamrApiUtellyClient;
    }

    @Override
    public SearchResponseDto search(ShowSearchTermDto showSearchTermDto) {
        var requestDto = new SearchRequestDto(List.of(showSearchTermDto));
        return streamrApiUtellyClient.search(requestDto);
    }
}
