package Characters;
public class FrekkenBok {
    private boolean angry; // Злость Фрекен Бок
    private boolean startled; // Испугана ли она
    private boolean itemsStolen; // Украдены ли продукты

    public FrekkenBok() {
        this.angry = false;
        this.startled = false;
        this.itemsStolen = false;
    }

    // Злится
    public void getAngry() {
        this.angry = true;
        System.out.println("Фрекен Бок злющая и бранится!");
    }

    // Испугалась
    public void getStartled() {
        this.startled = true;
        System.out.println("Фрекен Бок испугана и ждет, что кто-то появится.");
    }

    // Украли продукты
    public void itemsStolen() {
        this.itemsStolen = true;
        System.out.println("Карлсон стащил молоко, сахар и какао у Фрекен Бок!");
    }

    // Сброс состояния
    public void reset() {
        this.angry = false;
        this.startled = false;
        this.itemsStolen = false;
    }
}