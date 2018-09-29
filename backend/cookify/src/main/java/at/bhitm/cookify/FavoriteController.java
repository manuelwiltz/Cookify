package at.bhitm.cookify;

import at.bhitm.entities.Favorite;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("favorite")
public class FavoriteController {

    @Autowired
    private FavoriteRepository repository;

    @GetMapping("/all")
    public List<Favorite> getAll() {
        return repository.findAll();
    }

    /*@GetMapping("/getById")
    public List<Favorite> getByUserId(@RequestParam(value = "user_id") String user_id) {
        return repository.findByUer_id(user_id);
    }*/

    @PostMapping()
    public Favorite inserFavorite(@RequestBody Favorite favorite) {
        return repository.save(favorite);
    }

    @PutMapping()
    public Favorite updateFavorite(@RequestBody Favorite favorite) {
        Favorite f = repository.findById(favorite.getId()).orElse(null);
        if (f == null) {
            //return new NotFoundException();
        }
        return repository.save(favorite);
    }

    @DeleteMapping(path = "/delete/{id}")
    public void deleteFavorite(@PathVariable String id) {
        Favorite favoriteFromDb = repository.findById(id).orElse(null);
        repository.delete(favoriteFromDb);
    }

}
