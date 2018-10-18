package at.a5bhitm.cookify.cookify.entities;

public class Ingredient {

    private String id;
    private String name;
    private String amount;
    private Boolean selected = false;

    public Ingredient() {
    }

    public Ingredient(String name, String amount) {
        this.name = name;
        this.amount = amount;
    }

    public Ingredient(String name, String amount, Boolean selected) {
        this.name = name;
        this.amount = amount;
        this.selected = selected;
    }

    public Ingredient(String id, String name, String amount, Boolean selected) {
        this.id = id;
        this.name = name;
        this.amount = amount;
        this.selected = selected;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public Boolean getSelected() {
        return selected;
    }

    public void setSelected(Boolean selected) {
        this.selected = selected;
    }

    @Override
    public String toString() {
        return "Ingredient{" +
                "name='" + name + '\'' +
                ", amount='" + amount + '\'' +
                ", selected=" + selected +
                '}';
    }
}
