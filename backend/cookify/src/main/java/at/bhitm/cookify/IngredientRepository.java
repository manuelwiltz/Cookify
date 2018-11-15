package at.bhitm.cookify;

import at.bhitm.entities.Ingredient;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IngredientRepository extends MongoRepository<Ingredient, String> {

    List<Ingredient> findByNameLike(String name);
}
