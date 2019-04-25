import java.io.*;
import java.util.*;

public class Bag{
    private ArrayList<Item> items;

    public Bag(){
        items = new ArrayList<Item>();
    }

    public ArrayList<Item> getItem(){
        return items;
    }

    public void putItem(Item item){
        items.add(item);
    }
}

