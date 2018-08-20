package steam.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GamesController {
	
	@Autowired
	private GameDAO gameDAO;

	@GetMapping("/games")
	public Iterable<Game> games() {
		Iterable<Game> list = gameDAO.findAll();
		return list;
	}
	
	@GetMapping("/games/{id}")
	public @ResponseBody Game get(@PathVariable("id") String id) {
		Game game = gameDAO.getOne(id);
		
		if (game != null) {
			return game;
		}
		
		return null;
	}
	
	@PostMapping("/games")
	public @ResponseBody Game insert(@RequestBody Game game) {
		gameDAO.save(game);
		return game;
	}
	
	@PutMapping("/games")
	public @ResponseBody Game update(@RequestBody Game game) {
		gameDAO.save(game);
		return game;
	}
	
	@DeleteMapping("/games")
	public @ResponseBody Game delete(@RequestBody Game game) {
		gameDAO.delete(game);
		return game;
	}
}
