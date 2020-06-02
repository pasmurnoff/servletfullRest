package Zadaniyezach;

public class Foods {

    private String price;
    private String title;
    private String category;
    private int id;

    public Foods() {
    }

    public Foods(String price, String title, String login, int id) {
        this.price = price;
        this.title = title;
        this.category = login;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
