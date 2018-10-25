package at.bhitm.cookify;

import at.bhitm.entities.Drink;
import at.bhitm.entities.Ingredient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("drink")
public class DrinkController {

    @Autowired
    private DrinkRepository repository;

    @GetMapping()
    public List<Drink> findAll() {
        return repository.findAll();
    }

    @GetMapping("/getByTitle/{title}")
    public List<Drink> findByTitleLike(@PathVariable String title) {
        return repository.findByTitleLike(title);
    }

    @GetMapping("/insertTestData")
    public List<Drink> insertTestData() {

        Drink d = new Drink();
        d.setId("sdhkfskjdh398z598z");
        d.setTitle("Grüner Smoothie");
        d.setSubtitle("Ein leckerer Grüner Smoothie");
        d.setThumbnail_url("https://static.chefkoch-cdn.de/ck.de/rezepte/282/282658/834119-420x280-fix-gruener-smoothie.jpg");
        d.setIngredients(new ArrayList<Ingredient>() {{
            add(new Ingredient("Ananas", "1"));
            add(new Ingredient("Banane", "2"));
            add(new Ingredient("Kiwis", "2"));
            add(new Ingredient("Orangensaft", "200ml"));
            add(new Ingredient("Spinat", "1 Handvoll"));
        }});
        d.setTime("10 min");
        d.setDescription("Smoothies kennt inzwischen jeder, aber was ist mit einem grünen? Grüne Smoothies sind im Trend und mittlerweile gibt es für jeden etwas, selbst für Gemüsehasser. Dieses Rezept ist ein richtiges Einsteigerrezept, da ihr erstens eine wunderbare grüne Farbe bekommt und zweitens den Spinat nicht so sehr rausschmeckt. Spinat hat ein etwas erdiges Aroma, welches hier aber durch die Ananas übertönt wird.\n" +
                "\n" +
                "Zuerst die Ananas putzen, den Strunk heraus schneiden und das Fruchtfleisch mit dem Orangensaft pürieren. Nun die Bananen und Kiwis schälen, dazugeben und ebenfalls pürieren.\n" +
                "Solltet ihr jungen Spinat bekommen haben, diesen einfach waschen, dazugeben und ebenfalls durchmixen, bei großen Spinatblättern die Stiele entfernen und nur die Blätter in den Mixer geben. ");
        d.setSteps(new ArrayList<String>() {{
            add("This is Step 1.");
            add("This is Step 2.");
            add("This is Step 3.");
            add("This is Step 4.");
            add("This is Step 5.");
        }});

        Drink d1 = new Drink();
        d1.setId("kjgewwhg5oigfd498");
        d1.setTitle("Gelber Smoothie Kurkuma-Mango");
        d1.setSubtitle("Leckerer Murkuma-Mango Smoothie");
        d1.setThumbnail_url("https://static.chefkoch-cdn.de/ck.de/rezepte/303/303138/878369-420x280-fix-gelber-smoothie-kurkuma-mango.jpg");
        d1.setIngredients(new ArrayList<Ingredient>() {{
            add(new Ingredient("Banane", "1/2"));
            add(new Ingredient("Kurkume", "1"));
            add(new Ingredient("Mango", "1"));
            add(new Ingredient("Kokosöl", "1 TL"));
            add(new Ingredient("Zimt", "1/2 TL"));
            add(new Ingredient("Ingwer", "1/4 TL"));
            add(new Ingredient("Mandelmilch", "300 ml"));
        }});
        d1.setTime("10 min");
        d1.setDescription("Die Bananenhälfte in Stücke schneiden.\n" +
                "\n" +
                "Die Kurkumawurzel schälen und anschließend fein reiben. Achtung: Die Kurkumawurzel färbt stark ab, deswegen dabei eventuell Haushaltshandschuhe tragen.\n" +
                "\n" +
                "Die Mango schälen und das Fruchtfleisch grob schneiden.\n" +
                "\n" +
                "Nun wird der Mixer mit folgendem Inhalt bestückt: 1 TL Kokosöl, ½ TL Zimt, ¼ TL Ingwer, das Mango-Fruchtfleisch, die geschnittene Banane, Mandelmilch und Vanille-Extrakt bzw. -zucker.\n" +
                "\n" +
                "Alles kurz mixen. Dann den Mixer öffnen, Kurkuma hineingeben und den Mixer noch zweimal für ca. 20 Sekunden einschalten. Sollte der Mixer eine spezielle Smoothie-Funktion besitzen, dann natürlich diese nutzen.\n" +
                "\n" +
                "Nun darf serviert und getrunken werden. ");
        d1.setSteps(new ArrayList<String>() {{
            add("This is Step 1 of 5.");
            add("This is Step 2 of 5.");
            add("This is Step 3 of 5.");
            add("This is Step 4 of 5.");
            add("This is Step 5 of 5.");
        }});

        repository.save(d);
        repository.save(d1);

        return repository.findAll();

    }

    @PostMapping()
    public Drink insertDrink(@RequestBody Drink drink) {
        return repository.save(drink);
    }

    @PutMapping()
    public Drink updateDrink(@RequestBody Drink drink) {
        Drink d = repository.findById(drink.getId()).orElse(null);
        if (d == null) {
            //return new NotFoundException();
        }
        return repository.save(drink);
    }

    @DeleteMapping(path = "/delete/{id}")
    public void deleteDrink(@PathVariable String id) {
        Drink drinkFromDb = repository.findById(id).orElse(null);
        repository.delete(drinkFromDb);
    }

}
