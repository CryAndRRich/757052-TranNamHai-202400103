package aims.store;

import java.util.ArrayList;
import aims.disc.DigitalVideoDisc;

public class Store {
    public ArrayList<DigitalVideoDisc> itemsInStore = new ArrayList<DigitalVideoDisc>();

    public void addDVD(DigitalVideoDisc dvd) {
        itemsInStore.add(dvd);
        System.out.println("Added DVD: " + dvd.getTitle() + " to the store");
    }

    public void removeDVD(DigitalVideoDisc dvd) {
        int j = 0;
        for (int i = 0; i < itemsInStore.size(); i++) {
            if (dvd.isMatch(itemsInStore.get(i).getTitle())) {
                j = i;
                break;
            }
        }
        itemsInStore.remove(j);
    }
    
    public DigitalVideoDisc findDVD(String title) {
        for (int i = 0; i < itemsInStore.size(); i++) {
            if(itemsInStore.get(i).isMatch(title)) {
                return itemsInStore.get(i);
            }
        }
        return null;
    }

    public void getInfo() {
        for(int i = 0; i < itemsInStore.size(); i++) {
            System.out.println(itemsInStore.get(i).toString());
        }
    }

    public int getNumberDVDs() {
        return itemsInStore.size();
    }

    public void print() {
        System.out.println("***********************STORE***********************");
        if (itemsInStore.isEmpty()) {
            System.out.println("The store is currently empty");
        } else {
            for (int i = 0; i < itemsInStore.size(); i++) {
                System.out.println((i + 1) + ". " + itemsInStore.get(i).toString());
            }
        }
        System.out.println("***************************************************");
    }
}