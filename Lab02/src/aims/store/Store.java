package aims.store;

import java.util.ArrayList;
import aims.disc.DigitalVideoDisc;

public class Store {
    public ArrayList<DigitalVideoDisc> items = new ArrayList<DigitalVideoDisc>();
    private static int count = 0;

    public void addDVD(DigitalVideoDisc dvd) {
        items.add(dvd);
        count++;
    }

    public void removeDVD(DigitalVideoDisc dvd) {
        int j = 0;
        for (int i = 0; i < count; i++) {
            if (dvd.isMatch(items.get(i).getTitle())) {
                j = i;
                break;
            }
        }
        items.remove(j);
        count--;
    }
    
    public DigitalVideoDisc findDVD(String title) {
        for (int i = 0; i < count; i++) {
            if(items.get(i).isMatch(title)) {
                return items.get(i);
            }
        }
        return null;
    }

    public void getInfo() {
        for(int i = 0; i < count; i++) {
            System.out.println(items.get(i).toString());
        }
    }

    public int getNumberDVDs() {
        return count;
    }
}