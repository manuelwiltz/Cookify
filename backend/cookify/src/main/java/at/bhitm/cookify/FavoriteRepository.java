package at.bhitm.cookify;

import at.bhitm.entities.Favorite;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FavoriteRepository extends MongoRepository<Favorite, String> {

    // public List<Favorite> findByUer_id(String user_id);

}
