import java.io.*;
import java.util.Random;
public class Novice
{
      protected int hp; //declared attributes
      protected int maxHp;
      protected int mp;
      protected int maxMp;
      protected int exp;
      protected int money;
      protected int level;
      protected int maxExp;
      protected int dmg;
      protected int count;
      protected String job;

      Bag bag;

      public Novice(String job) //defined attributes
        {
           level = 1;
           hp = 100;
           maxHp = 100;
           mp = 100;
           maxMp = 100;
           count = 0;
           exp = 0;
           money = 0;
           maxExp = 10;
           dmg = 90;
           this.job = job;
           

           bag = new Bag();
        }
        public void useHp(){
            int idxOfHp = 0;
            if(hp + new Item("hpPotion").getValue() >= maxHp){
                hp = maxHp;
            }
            else{
                hp += new Item("hpPotion").getValue();
            }
            for(Item item : bag.getItem()){
                idxOfHp = item.getName().indexOf("hpPotion");
                if(idxOfHp != -1){
                    break;
                }
            }
            bag.getItem().remove(idxOfHp);
        }

        public void useMp(){
            int idxOfMp = 0;
            if(mp + new Item("mpPotion").getValue() >= maxMp){
                mp = maxMp;
            }
            else{
                mp += new Item("mpPotion").getValue();
            }
            for(Item item : bag.getItem()){
                idxOfMp = item.getName().indexOf("mpPotion");
                if(idxOfMp != -1){
                    break;
                }
            }
            bag.getItem().remove(idxOfMp);
        }
        public Bag getBag(){
            return bag;
        }
        public int getMaxHp() {
            return maxHp;
        }
    
        public int getHp() {
            return hp;
        }
    
        public int getMaxMp() {
            return maxMp;
        }
    
        public int getMp() {
            return mp;
        }
    
        public int getExp() {
            return exp;
        }
        
        public int getCount(){
            return count;
        }

        public int getMaxExp() {
            return maxExp;
        }

        public void takingEXP(int exp){
            this.exp += exp;
            isLevelUP();
        
        }
    
        public int getLevel() {
            return level;
        }
        
        public int getKill(){
            count++;
            return count;
        }
    
        public String getJob() {
            return job;
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

      /* public void revive(){
            level = 1;
            hp = 100;
            maxHp = 100;
            mp = 100;
            maxMp = 100;
            exp = 0;
            money = 0;
            maxExp = 10;
            dmg = 10;
       } */

        
        public int heal() //increase Hp 80 point
        {
            if(mp >= 20){
                hp += 30;
                mp -= 20;
                if(hp >= maxHp){
                    hp = maxHp;
                 }
            }else{
                mp = 0;
            }

            return hp;
        }
        public int showHp() 
        {
            if(hp >= maxHp){
                hp = maxHp;
            }
                return hp;
        }
        public int showMp(){
            if(hp >= maxMp){
                hp = maxMp;
            }
            return mp;
        }
        public int showExp() //show EXP and increase with random 0-3
        {
            Random rand = new Random();
            return exp ; // = exp + rand.nextInt(3) ;
        }
        public int showMoney() //show Money and increase with random 0-4
        {
            Random rand = new Random();
            //money = money + rand.nextInt(4);
            return money ;
        }
        public void isLevelUP()
        {
            if(level < 10){
            while(exp >= maxExp)
            {   
               exp -= maxExp;
               level++;                
               maxExp = (int)(maxExp * 1.4);
                
            }
        }else{
            exp = maxExp;
        }
            
        }
   
       /* public int doHp() //show Hp and decrease with random 0-2 if Hp lower 30 use heal
        {
            Random rand = new Random();
            hp = hp - rand.nextInt(2) ;

            if(hp < 70){
                hp = heal(hp);
              return  hp;
            }
            else
                return hp;
        }

        public int doExp() //show EXP and increase with random 0-3
        {
            Random rand = new Random();
            return exp = exp + 1 ;
        }

        public int doMoney() //show Money and increase with random 0-4
        {
            Random rand = new Random();
            money = money + rand.nextInt(4);
            return money ;
        }*/
        public void attack()
        {
            Random rand = new Random();
            hp = hp - rand.nextInt(4);
            exp = exp + rand.nextInt(8);
            money = money + rand.nextInt(50);
        }
        public void changeJobTo(String nameOfJob) {
        job = nameOfJob;
    }
        public void setStatusClass(int level, int newHp, int newMp, Bag bag){
            this.level = level ;

            maxHp = newHp;
            hp = maxHp;

            maxMp = newMp;
            mp = maxMp;

            this.bag = bag;
        }
}