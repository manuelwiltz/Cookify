package at.bhitm.cookify;

import at.bhitm.entities.Drink;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DrinkRepository extends MongoRepository<Drink, String> {

    List<Drink> findByTitleLike(String title);

}
