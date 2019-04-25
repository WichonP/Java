import java.io.*;
import java.util.*;

public class Mage extends Novice
{
    public Mage(int count,Bag bag){
        super("Mage");
        hp = 150;
        maxHp = 150;
        mp = 200;
        maxMp = 200;
        maxExp = 100;
        dmg = 20;
        this.count = count;
        this.bag = bag;
    }
}