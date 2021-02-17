package ye.golovnya.streamr.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import ye.golovnya.streamr.dtos.SearchRequestDto;
import ye.golovnya.streamr.dtos.SearchResponseDto;

@FeignClient(name = "streamr-api", url = "${streamr.microservices.api-utelly}")
public interface StreamrApiUtellyClient {

    @PostMapping(path = StreamrApiUrlConstants.SEARCH)
    SearchResponseDto search(@RequestBody SearchRequestDto searchRequestDto);
}

