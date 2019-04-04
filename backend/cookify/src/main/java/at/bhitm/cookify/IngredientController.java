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

    @GetMapping("/getByName/{name}")
    public List<Ingredient> findByTitleLike(@PathVariable String name) {
        return repository.findByNameLike(name);
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

    @GetMapping("/insertTestData")
    public List<Ingredient> insertTestData() {

        /*Ingredient i1 = new Ingredient("Käse", "", false);
        Ingredient i2 = new Ingredient("Nudeln", "", false);
        Ingredient i3 = new Ingredient("Butter", "", false);
        Ingredient i4 = new Ingredient("Schinken", "", false);
        Ingredient i5 = new Ingredient("Eier", "6", false);

        repository.save(i1);
        repository.save(i2);
        repository.save(i3);
        repository.save(i4);
        repository.save(i5);*/

        Ingredient i1 = new Ingredient("Reis", "", false);
        Ingredient i2 = new Ingredient("Dinkel", "", false);
        Ingredient i3 = new Ingredient("Gnochi", "", false);
        Ingredient i4 = new Ingredient("Penne", "", false);
        Ingredient i5 = new Ingredient("Weizenkleie", "", false);
        Ingredient i6 = new Ingredient("Baguette", "", false);
        Ingredient i7 = new Ingredient("Blätterteig", "", false);
        Ingredient i8 = new Ingredient("Paniermehl", "", false);

        Ingredient i9 = new Ingredient("Ingwer", "", false);
        Ingredient i10 = new Ingredient("Knoblauch", "", false);
        Ingredient i11 = new Ingredient("Basilikum", "", false);
        Ingredient i12 = new Ingredient("Oregano", "", false);
        Ingredient i13 = new Ingredient("Petersilie", "", false);
        Ingredient i14 = new Ingredient("Paprika", "", false);
        Ingredient i15 = new Ingredient("Milch", "", false);
        Ingredient i16 = new Ingredient("Mais", "", false);
        Ingredient i17 = new Ingredient("Olivenöl", "", false);
        Ingredient i18 = new Ingredient("Quark", "", false);
        Ingredient i19 = new Ingredient("Lachs", "", false);
        Ingredient i20 = new Ingredient("Putenfleisch", "", false);

        Ingredient i21 = new Ingredient("Kalbsschnitzel", "", false);
        Ingredient i22 = new Ingredient("Salz", "", false);
        Ingredient i23 = new Ingredient("Zitrone", "", false);
        Ingredient i24 = new Ingredient("Mehl, glattes", "", false);
        Ingredient i25 = new Ingredient("Semmelbrösel", "", false);

        repository.save(i1);
        repository.save(i2);
        repository.save(i3);
        repository.save(i4);
        repository.save(i5);
        repository.save(i6);
        repository.save(i7);
        repository.save(i8);
        repository.save(i9);
        repository.save(i10);
        repository.save(i11);
        repository.save(i12);
        repository.save(i13);
        repository.save(i14);
        repository.save(i15);
        repository.save(i16);
        repository.save(i17);
        repository.save(i18);
        repository.save(i19);
        repository.save(i20);
        repository.save(i21);
        repository.save(i22);
        repository.save(i23);
        repository.save(i24);
        repository.save(i25);

        return repository.findAll();
    }

}
