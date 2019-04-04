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

    @GetMapping("/getById/{id}")
    public Drink findById(@PathVariable String id) {
        return repository.findById(id).orElse(null);
    }

    @GetMapping("/getByTitle/{title}")
    public List<Drink> findByTitleLike(@PathVariable String title) {
        return repository.findByTitleLike(title);
    }

    @GetMapping("/insertTestData")
    public List<Drink> insertTestData() {

        /*
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
        */

        Drink d2 = new Drink();

        d2.setId("sadjhzdzta");

        d2.setTitle("Tequila Sunrise");

        d2.setSubtitle("Ein Klassiker");

        d2.setThumbnail_url("https://www.gutekueche.at/img/rezept/18096/tequila-sunrise.jpg");

        d2.setIngredients(new ArrayList<Ingredient>() {{

            add(new Ingredient("Tequila", "4cl"));

            add(new Ingredient("Zitronensaft", "1cl"));

            add(new Ingredient("Orangensaft", "11cl"));

            add(new Ingredient("Grenadine", "1cl"));

        }});

        d2.setTime("5 min");

        d2.setDescription("Den Shaker mit 5 Eiswürfeln füllen, alle Zutaten bis auf Grenadine dazu geben und kräftig schütteln. (15 Sek.)\n" +

                "\n" +

                "In ein Longdrinkglas einige Crushed Ice geben und den Drink durch ein Barsieb dazugießen. Die Grenadine vorsichtig über einen Löffelrücken in das Glas gießen.\n" +

                "Nicht umrühren, warten bis der Sirup auf dem Glasboden ist und anschliessend mit Strohhalm und einer Zitronenscheibe servieren.");

        d2.setSteps(new ArrayList<String>() {{

            add("This is Step 1.");

            add("This is Step 2.");

            add("This is Step 3.");

        }});




        Drink d3 = new Drink();

        d3.setId("lhjagdasd");

        d3.setTitle("Banana Flip");

        d3.setSubtitle("Ein wunderbares Dessert Rezept.");

        d3.setThumbnail_url("https://www.gutekueche.at/img/rezept/18254/18254_banana-flip.jpg");

        d3.setIngredients(new ArrayList<Ingredient>() {{

            add(new Ingredient("Zitrone", "1 Stk"));

            add(new Ingredient("Bananen(reif)", "2 Stk"));

            add(new Ingredient("Buttermilch", "	1L"));

            add(new Ingredient("Zucker", "etwas"));

        }});

        d3.setTime("3 min");

        d3.setDescription("Die geschälten und in Stücke geschnittenen Bananen in einen Elektromixer geben und mit der kalten Buttermilch kräftig mixen.\n" +

                        "Das fertige Getränk mit etwas Zucker und Zitronensaft abschmecken. Das Getränk in Longdrinkgläser füllen.");

        d3.setSteps(new ArrayList<String>() {{

            add("This is Step 1.");

            add("This is Step 2.");

        }});





        Drink d4 = new Drink();

        d4.setId("iouhiusad");

        d4.setTitle("Frozen Peach");

        d4.setSubtitle("Der Frozen Peach ist ein fruchtiger Shake, der durch die Pfirsiche eine schmackhafte Süße bekommt.");

        d4.setThumbnail_url("https://www.gutekueche.at/img/rezept/17949/frozen-peach.jpg");

        d4.setIngredients(new ArrayList<Ingredient>() {{

            add(new Ingredient("Mangosirup", "2 cl"));

            add(new Ingredient("Orangensaft", "10 cl"));

            add(new Ingredient("Pfirsich", "2 Stk"));

            add(new Ingredient("Crushed Ice", "1/4 L"));

        }});

        d4.setTime("6 min");

        d4.setDescription("Pfirsiche waschen, schälen und entkernen und mit Crushed Ice auffüllen und pürieren.\n" +

                        "Mit Orangensaft und Mangosirup aufgießen, nochmal gut durchmixen und in ein Cocktailglas oder Sektglas geben.");

        d4.setSteps(new ArrayList<String>() {{

            add("This is Step 1.");

            add("This is Step 2.");

        }});




        Drink d5 = new Drink();

        d5.setId("basdjhgas");

        d5.setTitle("Orangen-Buttermilch-Shake");

        d5.setSubtitle("Ein Orangen-Buttermilch-Shake ist ein Ausgleichsshake vom stressigen Alltag.");

        d5.setThumbnail_url("https://www.gutekueche.at/img/rezept/18031/orangen-buttermilch-shake_.jpg");

        d5.setIngredients(new ArrayList<Ingredient>() {{

            add(new Ingredient("Orangensaft gepresst", "4 Stk"));

            add(new Ingredient("Grapefruitsaft gepresst", "2 Stk"));

            add(new Ingredient("Orange", "1 Stk"));

            add(new Ingredient("Buttermilch", "400 ml"));

            add(new Ingredient("Vanillinzucker", "15 g"));
            add(new Ingredient("Zucker", "75 g"));
        }});


        d5.setTime("5 min");

        d5.setDescription("Gut gekühlte Buttermilch, Säfte und Zucker im Mixer verquirlen und in vier Gläser füllen.\n" +

                        "Orange in Spalten schneiden und auf den Glasrand stecken. Sofort servieren.");

        d5.setSteps(new ArrayList<String>() {{

            add("This is Step 1.");

            add("This is Step 2.");

        }});



        repository.save(d2);
        repository.save(d3);
        repository.save(d4);
        repository.save(d5);

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
