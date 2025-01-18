package Food;

public class Feast {
    private boolean milk;
    private boolean sugar;
    private boolean cocoa;

    public Feast(boolean milk, boolean sugar, boolean cocoa) {
        this.milk = milk;
        this.sugar = sugar;
        this.cocoa = cocoa;
    }

    public void prepareFeast() {
        if (milk && sugar && cocoa) {
            System.out.println("Какао сварено на таганке у Карлсона. Пир удался!");
        } else {
            System.out.println("Не хватает ингредиентов для пира.");
        }
    }
}