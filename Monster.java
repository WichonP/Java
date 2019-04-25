import java.io.*;
import java.util.Random;
public class Monster
{
      protected int hp; //declared attributes
      protected int maxHp;
      protected int level;
      protected int dmg;
      protected int exp;
      protected String name;

      Item item;

      public Monster(String name) //defined attributes
        {
           level = 1;
           hp = 100;
           maxHp = 100;
           exp = 0;
           dmg = 0;
           this.name = name;
           int randItem = (int)(Math.random()*2);
           if(randItem == 0)
                item = new Item("hpPotion");
            else    
                item = new Item("mpPotion");
        }
        public Item getItem(){
            return item;
        }

        public int getMaxHp() {
            return maxHp;
        }
    
        public int getHp() {
            return hp;
        }
    
        public int getLevel() {
            return level;
        }
        
        public int getExp(){
            return exp;
        }

        public String getName(){
            return name;
        }

        public int getDMG(){
            return dmg;
        }

        public void takingDMG(int dmg){

             hp -= dmg;
             if(hp < 0){
                hp = 0;
             }
        }

}