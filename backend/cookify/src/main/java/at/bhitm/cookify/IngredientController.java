package at.bhitm.cookify;

import at.bhitm.entities.Ingredient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("ingredient")
public class IngredientController {

    @Autowired
    private IngredientRepository repository;

    @GetMapping()
    public List<Ingredient> findAll() {
        return repository.findAll();
    }

    @GetMapping("/insertTestData")
    public List<Ingredient> insertTestData() {

        Ingredient i1 = new Ingredient("Käse", "", false);
        Ingredient i2 = new Ingredient("Nudeln", "", false);
        Ingredient i3 = new Ingredient("Butter", "", false);
        Ingredient i4 = new Ingredient("Schinken", "", false);
        Ingredient i5 = new Ingredient("Eier", "6", false);

        repository.save(i1);
        repository.save(i2);
        repository.save(i3);
        repository.save(i4);
        repository.save(i5);

        return repository.findAll();
    }

    @PostMapping()
    public Ingredient insertIngredient(@RequestBody Ingredient ingredient) {
        return repository.save(ingredient);
    }

    @PutMapping()
    public Ingredient updateIngredient(@RequestBody Ingredient ingredient) {
        Ingredient i = repository.findById(ingredient.getId()).orElse(null);
        if (i == null) {
            //return new NotFoundException();
        }
        return repository.save(ingredient);
    }

    @DeleteMapping(path = "/delete/{id}")
    public void deleteIngredient(@PathVariable String id) {
        Ingredient ingredientFromDb = repository.findById(id).orElse(null);
        repository.delete(ingredientFromDb);
    }

}
