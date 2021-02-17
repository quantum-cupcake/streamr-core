package ye.golovnya.streamr.services.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ye.golovnya.streamr.dtos.ShowDetails;
import ye.golovnya.streamr.dtos.TopServiceDto;
import ye.golovnya.streamr.entities.Show;
import ye.golovnya.streamr.mappers.ShowMapper;
import ye.golovnya.streamr.repositories.ShowRepository;
import ye.golovnya.streamr.services.ShowService;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class JpaShowService implements ShowService {

    private final static Long NONE_FOUND = -1L;

    private final ShowRepository showRepository;
    private final ShowMapper showMapper;

    public JpaShowService(ShowRepository showRepository, ShowMapper showMapper) {
        this.showRepository = showRepository;
        this.showMapper = showMapper;
    }

    @Override
    @Transactional
    public Show getOrCreateShow(ShowDetails showDetails) {
        return showRepository.findByTitle(showDetails.getTitle()).orElseGet(
                () -> showMapper.showDetailsToModel(showDetails));
    }

    @Override
    @Transactional
    public void updateShow(Show show) {
        showRepository.saveAndFlush(show);
    }

    @Override
    public List<ShowDetails> getShows(Collection<Long> ids) {
        return showMapper.modelsToShowDetailsList(showRepository.findAllById(ids));
    }

    @Override
    public TopServiceDto getTopServiceForUser(Collection<Long> ids) {
        var shows = getShows(ids);
        var counts = shows.stream().map(ShowDetails::getServiceName)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        var maxCount = counts.values().stream().max(Comparator.naturalOrder()).orElse(NONE_FOUND);

        List<String> topServices;
        if(maxCount.equals(NONE_FOUND)) {
            topServices = Collections.emptyList();
        } else {
            topServices = counts.entrySet().stream()
                    .filter(entry -> entry.getValue().equals(maxCount))
                    .map(Map.Entry::getKey)
                    .collect(Collectors.toList());
        }
        return new TopServiceDto(shows, topServices);
    }
}
