public class Product {
    private String title;
    private int rating;
    private double price;
    private String category;

    public Product(String title, int rating, double price, String category) {
        this.title = title;
        this.rating = rating;
        this.price = price;
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public int getRating() {
        return rating;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return "Product{" +
                "title='" + title + '\'' +
                ", rating=" + rating +
                ", price=" + price +
                ", category='" + category + '\'' +
                '}';
    }
}
