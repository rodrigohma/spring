package steam.config;

import org.springframework.data.jpa.repository.JpaRepository;

public interface GameDAO extends JpaRepository<Game, String>{

}
