package ye.golovnya.streamr.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ye.golovnya.streamr.entities.Show;

import java.util.List;
import java.util.Optional;

@Repository
public interface ShowRepository extends JpaRepository<Show, Long> {

    Optional<Show> findByTitle(String title);
}
