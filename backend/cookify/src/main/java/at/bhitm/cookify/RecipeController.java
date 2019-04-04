package at.bhitm.cookify;

import at.bhitm.entities.Ingredient;
import at.bhitm.entities.Recipe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
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

    @GetMapping("/getById/{id}")
    public Recipe findById(@PathVariable String id) {
        return repository.findById(id).orElse(null);
    }

    @PostMapping("/getByTitle/{title}")
    public List<Recipe> findByTitleLike(@PathVariable String title) {
        return repository.findByTitleLike(title);
    }

    @GetMapping("/insertTestData")
    public List<Recipe> insertTestData() {

        /*
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
        */

        Recipe r2 = new Recipe();

        r2.setId("aas987");
        r2.setTitle("Lasagne");

        r2.setSubtitle("Lasagne Bolognese");
        r2.setThumbnail_url("https://www.gutekueche.at/img/rezept/3999/lasagne-bolognese.jpg");

        r2.setIngredients(new ArrayList<Ingredient>() {{

            add(new Ingredient("Lasagneblätter", "12 Stk"));

            add(new Ingredient("Gouda", "200g"));

            add(new Ingredient("Butter", "2 El"));

            add(new Ingredient("Mehl", "2 El"));

            add(new Ingredient("Olivenöl", "1 Schuss"));

            add(new Ingredient("Muskat", "etwas"));

            add(new Ingredient("Pfeffer", "etwas"));

            add(new Ingredient("Rinderfaschiertes", "250g"));

            add(new Ingredient("Zwiebel", "1"));

            add(new Ingredient("Tomaten", "1 Dose"));
            add(new Ingredient("Tomatenmark", "5 El"));


        }});

        r2.setTime_sum("55 min");

        r2.setTime_cook("40 min");

        r2.setDescription("Öl in einem Topf erhitzen, Faschiertes darin anrösten. Zwiebeln, Karotte, Ketchup und Knoblauch dazu geben und weiter anbraten. Tomaten und Tomatenmark sowie alle Gewürze dazu und auf kleinster Stufe ca. 10 Min. köcheln lassen.\n" +

                "\n" +

                "Butter in einem Topf zerlassen, Mehl zufügen, mit einem Schneebesen sofort umrühren. Jetzt ganz langsam, unter ständigem rühren die Milch zufügen. Langsam aufkochen und rühren bis die Sauce dicklich ist. Mit Muskat und weißem Pfeffer würzen.\n" +

                "\n" +

                "Auflaufform mit Olivenöl einfetten. Nun abwechselnd die Lasagneblätter und Bolognesesauce einschichten, mit den Lasagneblätter beginnen, danach die Saucen usw. - mit der Sauce abschließen.\n" +

                "\n" +

                "Ganz zum Schluß oben drauf kommt die Bechamelsauce, nur noch frisch geriebenen Gouda drauf geben und im vorgeheizten Ofen, bei 180° Grad Heißluft ca. 30 Min. backen.");

        r2.setSteps(new ArrayList<String>() {{

            add("This is Step 1 of 4");

            add("This is Step 2 of 4");

            add("This is Step 3 of 4");

            add("This is Step 4 of 4");


        }});


        Recipe r3 = new Recipe();

        r3.setId("abc999");
        r3.setTitle("Reisfleisch");

        r3.setSubtitle("Beliebt für jeden Geschmack.");
        r3.setThumbnail_url("https://www.gutekueche.at/img/rezept/4317/reisfleisch_1470389463.jpg");

        r3.setIngredients(new ArrayList<Ingredient>() {{

            add(new Ingredient("Scheinefleisch", "0.5kg"));

            add(new Ingredient("Klare Suppe", "0,7L"));

            add(new Ingredient("Paprikapulver", "3 El"));

            add(new Ingredient("Reis", "300g"));

            add(new Ingredient("Öl", "1 Schuss"));

            add(new Ingredient("Salz", "etwas"));

            add(new Ingredient("Kümmel", "etwas"));

            add(new Ingredient("Majoran", "1 Tl"));

            add(new Ingredient("Zwiebel", "2"));

            add(new Ingredient("Lorbeerblatt", "1"));
            add(new Ingredient("Knoblauchzehe", "1 Stk"));


        }});

        r3.setTime_sum("60 min");

        r3.setTime_cook("40 min");

        r3.setDescription("Das Fleisch (Pute, Huhn oder Schwein am besten eignet sich Gulaschfleisch vom Schwein) in Würfel schneiden (ca. 3x3 cm).\n" +

                "\n" +

                "Die Zwiebeln schälen, klein schneiden und in einem großen Topf mit einem Schuss Öl anbraten - dabei ständig umrühren.\n" +

                "\n" +

                "Nun die Fleischwürfel zu den angerösteten Zwiebeln in den Topf geben und mit rösten lassen - die Hitze ein wenig reduzieren - dabei ständig rühren.\n" +

                "\n" +

                "Das Paprikapulver (süß und scharf) hinzufügen und mit der klaren Suppe (am besten eignet sich Rinderbrühe es schmeckt aber auch mit normalen Wasser) aufgießen - das Fleisch muss dabei von der Flüssigkeit komplett bedeckt sein. Gegebenenfalls Wasser noch hinzu." +


                "Salz, Pfeffer, Kümmel, Majoran, Lorbeerblatt und der kleingeschnittenen Knoblauchzehe und den Reis hinzufügen. Topf bei kleinerer Hitze (mit geschlossenem Deckel) für ca. 50-60 Minuten dünsten lassen, bis kein Wasser mehr vorhanden ist.");

        r3.setSteps(new ArrayList<String>() {{

            add("This is Step 1 of 5");

            add("This is Step 2 of 5");

            add("This is Step 3 of 5");

            add("This is Step 4 of 5");

            add("This is Step 5 of 5");

        }});


        Recipe r4 = new Recipe();

        r4.setId("sad019");
        r4.setTitle("Spareribs");

        r4.setSubtitle("Köstliche gegrillte Spareribs.");
        r4.setThumbnail_url("https://www.gutekueche.at/img/rezept/4962/spareribs.jpg");

        r4.setIngredients(new ArrayList<Ingredient>() {{

            add(new Ingredient("Öl", "2EL"));

            add(new Ingredient("Spareribs", "1kg"));

            add(new Ingredient("Chilisauce", "3 El"));

            add(new Ingredient("Honig", "2 El"));

            add(new Ingredient("Senf", "2 El"));

            add(new Ingredient("Kräuter", "etwas"));

            add(new Ingredient("Salz", "etwas"));

            add(new Ingredient("Pfeffer", "etwas"));

        }});

        r4.setTime_sum("230 min");

        r4.setTime_cook("50 min");

        r4.setDescription("Bei den Spareribs die Bindehaut auf der Innenseite vorsichtig abziehen.\n" +

                "\n" +

                "Für die Marinade alle Zutaten bis auf die Spareribs in einer Schüssel verrühren. Die Spareribs damit einstreichen und 3 Stunden im Kühlschrank ruhen lassen.\n" +

                "\n" +

                "Nun die Spareribs auf ein mit Alufolie belegtes Blech bei 150 Grad für ca. 30 Minuten im Backofen vorgaren. Hat den Vorteil, dass sich das Fleisch komplett vom Knochen löst.\n" +

                "\n" +

                "Dann den Grill einheizen und die Spareribs für 15-20 Min. auf den Grill legen, dabei öfters umdrehen, damit das Fett abtropfen kann." +

                "Die fertigen Spareribs mit Kräuterbutter und Ofenkartoffeln servieren.");

        r4.setSteps(new ArrayList<String>() {{

            add("This is Step 1 of 5");

            add("This is Step 2 of 5");

            add("This is Step 3 of 5");

            add("This is Step 4 of 5");

            add("This is Step 5 of 5");

        }});


        Recipe r5 = new Recipe();

        r5.setId("oof111");
        r5.setTitle("Apfeltiramisu");

        r5.setSubtitle("Ein Apfeltiramisu ist eine schöne und fruchtige Variation zu der herkömmlichen Variante.");
        r5.setThumbnail_url("https://www.gutekueche.at/img/rezept/1040/apfeltiramisu.jpg");

        r5.setIngredients(new ArrayList<Ingredient>() {{

            add(new Ingredient("Mascarpone", "500g"));

            add(new Ingredient("Magerquark", "250g"));

            add(new Ingredient("Naturjoghurt", "150g"));

            add(new Ingredient("Fruchtzucker", "4 El"));

            add(new Ingredient("Löffelbisquits", "300g"));

            add(new Ingredient("Apfelsaft", "etwas"));

            add(new Ingredient("Apfelmus", "500ml"));

            add(new Ingredient("Zimt", "etwas"));
            add(new Ingredient("Apfel", "2 Stk"));

        }});

        r5.setTime_sum("200 min");

        r5.setTime_cook("180 min");

        r5.setDescription("Für das Apfeltiramisu die Mascarpone, den Magertopfen, das Naturjoghurt und den Fruchtzucker zu einer Creme verrühren. \n" +

                "\n" +

                "Eine Schicht der Creme in eine Form geben und mit einer Schicht Biskotten bedecken. Diese mit Apfelsaft beträufeln und eine Schicht Apfelmus auftragen.\n" +

                "\n" +

                "Eine weitere Lage aus Creme, beträufelten Biskotten und Apfelmus auftragen.\n" +

                "\n" +

                "Mit einer Schicht Creme abschließen und mit Zimt bestreuen. " +
                "\n" +

                "Etwa 2-3 Stunden im Kühlschrank ziehen lassen.  " +
                "Die Äpfel waschen und in feine Stücke schneiden. Damit das Tiramisu garnieren.");

        r5.setSteps(new ArrayList<String>() {{

            add("This is Step 1 of 6");

            add("This is Step 2 of 6");

            add("This is Step 3 of 6");

            add("This is Step 4 of 6");

            add("This is Step 5 of 6");
            add("This is Step 6 of 6");

        }});


        Recipe r6 = new Recipe();

        r6.setId("oof969");
        r6.setTitle("Vanillekipferl");

        r6.setSubtitle("Die Vanillekipferl sind die Klassiker unter den Weihnachtskeksen.");
        r6.setThumbnail_url("https://www.gutekueche.at/img/rezept/3720/vanillekipferl.jpg");

        r6.setIngredients(new ArrayList<Ingredient>() {{

            add(new Ingredient("Mehl", "500g"));

            add(new Ingredient("Staubzucker", "160g"));

            add(new Ingredient("Butter", "400g"));

            add(new Ingredient("Mandeln,gerieben", "200g"));

            add(new Ingredient("Vanillezucker", "3Pkg"));

            add(new Ingredient("Staubzucker", "5EL"));

        }});

        r6.setTime_sum("90 min");

        r6.setTime_cook("75 min");

        r6.setDescription("Für die Vanillekipferl Mehl, Staubzucker, Vanillezucker, in kleine Stücke geschnittene Butter und die geriebenen Mandeln (oder Nüsse) zu einem Teig verarbeiten und diesen 1 Stunde (in Folie gewickelt) in den Kühlschrank legen.\n" +

                "\n" +

                "Danach den Teig aus dem Kühlschrank nehmen, auf einer bemehlten Arbeitsfläche eine Rolle formen (mit ca. 3-4 cm Durchmesser) und aus dieser Rolle ca. 1-1,5 cm dicke Scheiben abschneiden. Diese Scheiben zu Kipferl formen und auf ein mit Backpapier belegtes Blech bei 175°C für ca. 12-15 Minuten (Umluft) hellbraun backen." +
                "\n" +

                "Die noch warmen Kipferl in einer Mischung aus Staubzucker & Vanillezucker wälzen und danach vollständig abkühlen lassen.");

        r6.setSteps(new ArrayList<String>() {{

            add("This is Step 1 of 3");

            add("This is Step 2 of 3");

            add("This is Step 3 of 3");

        }});


        repository.save(r2);
        repository.save(r3);
        repository.save(r4);
        repository.save(r5);
        repository.save(r6);

        return repository.findAll();
    }

    @PostMapping()
    public Recipe insertRecipe(@RequestBody Recipe recipe) {
        insertIngredients(recipe);
        return repository.save(recipe);
    }

    @PostMapping("/getByIngredients")
    public List<Recipe> getByIngredients(@RequestBody Ingredient[] ingredients) {
        List<String> ingredientList = new ArrayList<>();
        for (int i = 0; i < ingredients.length; i++) {
            ingredientList.add(ingredients[i].getName());
            System.out.println("Ingredient: " + ingredients[i].getName());
        }
        
        List<Recipe> recipes = repository.findAll();
        List<Recipe> recipesLike = new ArrayList<>();
        for (int i = 0; i < recipes.size() - 1; i++) {
            for (int j = 0; j < recipes.get(i).getIngredients().size(); j++) {
                if (ingredientList.contains(recipes.get(i).getIngredients().get(j).getName()) && !recipesLike.contains(recipes.get(i))) {
                    recipesLike.add(recipes.get(i));
                }
            }
        }
        return recipesLike;
    }

    @PutMapping()
    public Recipe updateRecipe(@RequestBody Recipe recipe) {
        //insertIngredients(recipe);
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

    public void insertIngredients(Recipe recipe) {
        if (recipe.getIngredients() != null) {
            IngredientController ic = new IngredientController();
            List<Ingredient> newIngredients = recipe.getIngredients();
            List<Ingredient> oldIngredients = ic.findAll();

            for (int i = 0; i < newIngredients.size(); i++) {
                if (!newIngredients.contains(newIngredients.get(i))) {
                    ic.insertIngredient(newIngredients.get(i));
                }
            }
        }
    }

}
