package at.bhitm.cookify;

import at.bhitm.entities.Ingredient;
import at.bhitm.entities.Recipe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("recipe")
public class RecipeController {

    @Autowired
    private RecipeRepository repository;

    @GetMapping()
    public List<Recipe> findAll() {
        return repository.findAll();
    }

    @GetMapping("/insertTestData")
    public List<Recipe> insertTestData() {

        Recipe r = new Recipe();
        r.setId("asdf1234");
        r.setTitle("Wiener Schnitzel");
        r.setSubtitle("Das original 'Wiener Schnitzel' ist vom Kalb");
        r.setThumbnail_url("https://static.chefkoch-cdn.de/ck.de/rezepte/110/110923/946471-420x280-fix-wiener-schnitzel.jpg");
        r.setIngredients(new ArrayList<Ingredient>() {{
            add(new Ingredient("Kalbsschnitzel", "600g"));
            add(new Ingredient("Eier", "3"));
            add(new Ingredient("Salz", ""));
            add(new Ingredient("Butter", "250g"));
            add(new Ingredient("Zitrone", "1"));
            add(new Ingredient("Mehl, glattes", "600g"));
            add(new Ingredient("Semmelbrösel", ""));
        }});
        r.setTime_sum("30 min");
        r.setTime_cook("20 min");
        r.setDescription("Vom Fleischer schöne Kalbsschnitzel schneiden lassen und diese am den Rändern leicht einschneiden. Die Schnitzel mit Klarsichtfolie bedecken und zart plattieren (klopfen). Die Stärke der Schnitzel ist individuell auf den persönlichen Geschmack abgestimmt, misst jedoch im Normalfall ca. 6 mm. Die Schnitzel beidseitig gleichmäßig salzen.\n" +
                "\n" +
                "Die Eier mit einer Gabel leicht verschlagen. Die Kalbsschnitzel in Mehl beidseitig wenden, durch die Eier ziehen und danach in Semmelbröseln wenden, die Brösel dabei nur zart andrücken. Die Schnitzel leicht abschütteln und überschüssige Brösel entfernen.\n" +
                "\n" +
                "Reichlich Butterschmalz in einer passenden Pfanne ca. 2 – 3 cm hoch erhitzen. Die Schnitzel in das heiße Fett legen und unter wiederholtem Schwingen der Pfanne bräunen. Dann mittels einer Fleischgabel vorsichtig wenden und von der anderen Seite fertig backen. Mit einer Backschaufel aus der Pfanne heben.\n" +
                "\n" +
                "Die Schnitzel abtropfen lassen, mit Küchenkrepp das überschüssige Fett abtupfen und mit einer Zitronenspalte garniert servieren.\n");
        r.setSteps(new ArrayList<String>() {{
            add("This is Step 1");
            add("This is Step 2");
            add("This is Step 3");
            add("This is Step 4");
            add("This is Step 5");
        }});

        Recipe r1 = new Recipe();
        r1.setId("xyz987");
        r1.setTitle("Spaghetti aglio");
        r1.setSubtitle("Spaghetti mit Knoblauch und Olivenöl, scharf");
        r1.setThumbnail_url("https://static.chefkoch-cdn.de/ck.de/rezepte/145/145239/764587-420x280-fix-spaghetti-aglio-olio-e-peperoncino.jpg");
        r1.setIngredients(new ArrayList<Ingredient>() {{
            add(new Ingredient("Spaghett1", "300g"));
            add(new Ingredient("Knoblauchzehen", "4"));
            add(new Ingredient("Petersilie", "1/2 Bund"));
            add(new Ingredient("Chillishoten", "3"));
            add(new Ingredient("Olivenöl", "6 EL"));
            add(new Ingredient("Meersalz mit Pfeffer", "etwas"));
            add(new Ingredient("Zitrone", "1"));
        }});
        r1.setTime_sum("15 min");
        r1.setTime_cook("15 min");
        r1.setDescription("Die Spaghetti in Salzwasser bissfest kochen.\n" +
                "\n" +
                "Inzwischen die Knoblauchzehen abziehen und in Scheiben schneiden. Die Petersilie waschen, trocken schütteln und die Blättchen abzupfen. Die Chilischoten zerstoßen. Die Zitrone heiß waschen und in Scheiben schneiden.\n" +
                "\n" +
                "Die Spaghetti abgießen und abtropfen lassen.\n" +
                "\n" +
                "In einer großen Pfanne das Olivenöl erhitzen. Knoblauch, Petersilienblättchen und Chili kurz darin anbraten, die Zitronenscheiben dazugeben und mitbraten. Die Spaghetti dazugeben und darin schwenken. Mit Meersalz und Pfeffer würzen.\n" +
                "\n" +
                "Vor dem Servieren die Zitronenscheiben herausnehmen.");
        r1.setSteps(new ArrayList<String>() {{
            add("This is Step 1 of 5");
            add("This is Step 2 of 5");
            add("This is Step 3 of 5");
            add("This is Step 4 of 5");
            add("This is Step 5 of 5");
        }});

        repository.save(r);
        repository.save(r1);

        return repository.findAll();
    }

    @PostMapping()
    public Recipe insertRecipe(@RequestBody Recipe recipe) {
        return repository.save(recipe);
    }

    @PutMapping()
    public Recipe updateRecipe(@RequestBody Recipe recipe) {
        Recipe r = repository.findById(recipe.getId()).orElse(null);
        if (r == null) {
            //return new NotFoundException();
        }
        return repository.save(recipe);
    }

    @DeleteMapping(path = "/delete/{id}")
    public void deleteRecipe(@PathVariable String id) {
        Recipe recipeFromDb = repository.findById(id).orElse(null);
        repository.delete(recipeFromDb);
    }

}
