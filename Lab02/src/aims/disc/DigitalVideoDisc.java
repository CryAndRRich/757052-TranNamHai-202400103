package aims.disc;

public class DigitalVideoDisc {
    private String title;
    private String category;
    private String director;
    private int length;
    private float cost;
    private int id;
    private static int num_of_discs = 0;

    public static int getNumofDiscs() {
        return num_of_discs;
    }
    
    public String getTitle() {
        return this.title;
    }

    public String getCategory() {
        return this.category;
    }

    public String getDirector() {
        return this.director;
    }

    public int getLength() {
        return this.length;
    }

    public float getCost() {
        return this.cost;
    }

    public int getID() {
        return this.id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public DigitalVideoDisc(String title) {
        super();
        this.title = title;
        num_of_discs++;
        this.id = num_of_discs;
    }

    public DigitalVideoDisc(String title, String category, float cost) {
        super();
        this.title = title;
        this.category = category;
        this.cost = cost;
        num_of_discs++;
        this.id = num_of_discs;
    }

    public DigitalVideoDisc(String director, String category, String title, float cost) {
        this.title = title;
        this.category = category;
        this.director = director;
        this.cost = cost;
        num_of_discs++;
        this.id = num_of_discs;
    }

    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        this.title = title;
        this.category = category;
        this.director = director;
        this.length = length;
        this.cost = cost;
        num_of_discs++;
        this.id = num_of_discs;
    }

    public boolean isMatch(String title) {
        return this.title.equals(title);
    }
    
    @Override
    public String toString() {
        return this.id + "." + this.title + "-" + this.category + "-" + 
               this.director + "-" + this.length + ": " + this.cost + "$";
    }
}