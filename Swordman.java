import java.io.*;
import java.util.*;

public class Swordman extends Novice
{
    public Swordman(int count,Bag bag){
        super("Swordman");
        hp = 200;
        maxHp = 200;
        mp = 100;
        maxMp = 100;
        maxExp = 100;
        dmg = 30;
        this.count = count;
        this.bag = bag;
    }
}