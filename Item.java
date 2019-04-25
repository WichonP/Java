import java.io.*;

public class Item
    {
    private String name;
    private int value;

    public Item(String name)
    {
        this.name = name;
        if(name.equals("hpPotion")){
            value = 30;
        }else{
            value = 40;
        }
    }
    
    public int getValue(){
        return value;
    }

    public String getName(){
        return name;
    }


}