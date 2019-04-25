import java.util.*;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;


public class GUI extends JFrame{
    Novice novice;
    Monster monster;
    public GUI(){
        super("Deknarok");
        novice = new Novice("Novice");
        monster = new BaphometJr();
        
        Container c = getContentPane();
        c.setLayout(new GridLayout(2, 1));
        JPanel p1 = new JPanel();
        p1.setLayout(new GridLayout(1, 2));
        JPanel pic = new JPanel();
        pic.setLayout(new BoxLayout(pic, BoxLayout.Y_AXIS));
        
        ImageIcon classN = new ImageIcon("Novice.png");
        ImageIcon classS = new ImageIcon("warrior3.png");
        ImageIcon classM = new ImageIcon("mage2.png");
        JLabel character = new JLabel(classN);

        JPanel pic2 = new JPanel();
        pic2.setLayout(new BoxLayout(pic2, BoxLayout.Y_AXIS));
        ImageIcon bapho = new ImageIcon("Bapho.gif");
        ImageIcon baphoJr = new ImageIcon("BaphoJr2.gif");
        JLabel mons = new JLabel(baphoJr);

        pic.add(chacter);
        pic2.add(mons);
        p1.add(pic);
        p1.add(pic2);
        c.add(p1);

        JPanel p2 = new JPanel();
        p2.setLayout(new GridLayout(1, 3));
        JPanel status = new JPanel();
        status.setLayout(new BoxLayout(status, BoxLayout.Y_AXIS));
        JLabel name = new JLabel(" Class : " + novice.getJob());
        JLabel level = new JLabel(" Level : " + novice.getLevel());
        JLabel hp = new JLabel(" HP : " + novice.getHp()+"/"+novice.getMaxHp());
        JLabel mp = new JLabel(" MP : "+ novice.showMp()+"/"+novice.getMaxMp());
        JLabel exp = new JLabel(" Exp : " + novice.showExp() + '/' + novice.getMaxExp());
        JLabel count = new JLabel(" Monster Kill : " + novice.getCount());

        JPanel statusM = new JPanel();
        statusM.setLayout(new BoxLayout(statusM, BoxLayout.Y_AXIS));
        JLabel nameM = new JLabel(" Name : " + monster.getName());
        JLabel levelM = new JLabel(" Level : " + monster.getLevel());
        JLabel hpM = new JLabel(" Hp : " + monster.getHp() + '/' + monster.getMaxHp());
        
        JPanel button = new JPanel();
        button.setLayout(new BoxLayout(button, BoxLayout.Y_AXIS));
        JButton attack = new JButton("   Attack   ");
        JButton heal = new JButton("     Heal    ");
        JButton inventory = new JButton(" Inventory");
        JLabel change = new JLabel("Change Class Now");
        JButton swordman = new JButton("Swordman");
        JButton mage = new JButton("Mage");
        change.setVisible(false);
        swordman.setVisible(false);
        mage.setVisible(false);
        
        attack.addActionListener(new ActionListener(){
        
            @Override
            public void actionPerformed(ActionEvent e) {
                monster.takingDMG(novice.getDMG());
                if(monster.getHp() > 0)
                    novice.takingDMG(monster.getDMG());
                else{
                    novice.takingEXP(monster.getExp());
                    if(Math.random()*100+1 < 80){
                        monster = new BaphometJr();
                        mons.setIcon(baphoJr);
                    }else{
                    monster = new Baphomet();
                    mons.setIcon(bapho);
                    }
                    novice.getKill();
                    novice.getBag().putItem(monster.getItem());
                    JOptionPane.showMessageDialog(c, "New Monster is " + monster.getName());
                    count.setText(" Monster Kill : " + novice.getCount());

                    
                }

                if(novice.getHp() <= 0){
                    novice = new Novice("Novice");
                    JOptionPane.showMessageDialog(c, "You Die Motherfucker!!");
                    name.setText(" Class : " + novice.getJob());
                    character.setIcon(classN);
                    count.setText(" Monster Kill : " + novice.getCount());
                }
                nameM.setText(" Name : " + monster.getName());
                levelM.setText(" Level : " + monster.getLevel());
                hpM.setText(" Hp : " + monster.getHp() + '/' + monster.getMaxHp());
                hp.setText(" HP : " + novice.getHp()+"/"+novice.getMaxHp());
                exp.setText(" Exp : " + novice.showExp() + '/' + novice.getMaxExp());
                level.setText(" Level : " + novice.getLevel());
                if(novice.getLevel() >= 10 && novice.getJob().equals("Novice")){
                    change.setVisible(true);
                    swordman.setVisible(true);
                    mage.setVisible(true);
                }
                
                
            }
        });

        heal.addActionListener(new ActionListener(){
        
            @Override
            public void actionPerformed(ActionEvent e) {
                novice.heal();
                hp.setText(" HP : " + novice.getHp()+"/"+novice.getMaxHp());
                mp.setText(" MP : "+ novice.showMp()+"/"+novice.getMaxMp());
                if(novice.showMp() == 0){
                    JOptionPane.showMessageDialog(c, "Your mp is empty");
                }
            }
        });

        inventory.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame inventory = new JFrame("INVENTORY");
                inventory.setLayout(new GridLayout(5,8));
                int amount = 0;

                for(Item item : novice.getBag().getItem()){
                    amount++;
                }


                for(Item item : novice.getBag().getItem()){
                    if(item.getName().equals("hpPotion")){
                        ImageIcon hpp = new ImageIcon("Hp.png");
                        JButton hpb = new JButton(hpp);
                        inventory.add(hpb);
                        hpb.addActionListener(new ActionListener(){
                            // int i=0;
                        
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                novice.useHp();
                                hp.setText(" HP : " + novice.getHp()+"/"+novice.getMaxHp());
                                JOptionPane.showMessageDialog(c, "You use HP potion");
                                inventory.dispose();
                                
                            }
                        });
                        
                    }else{
                        ImageIcon mpp = new ImageIcon("Mp.png");
                        JButton mpb = new JButton(mpp);
                        inventory.add(mpb);
                        mpb.addActionListener(new ActionListener(){
                        
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                novice.useMp();
                                mp.setText(" MP : "+ novice.showMp()+"/"+novice.getMaxMp());
                                JOptionPane.showMessageDialog(c, "You use MP potion");
                                inventory.dispose();
                               
                                
                            }
                        });
                    }
                }
                inventory.pack();
                inventory.setVisible(true);
            }
        });


        swordman.addActionListener(new ActionListener(){
        
            @Override
            public void actionPerformed(ActionEvent e) {
                novice = new Swordman(novice.getCount(),novice.getBag());
                JOptionPane.showMessageDialog(c, "Now! You are Swordman");
                name.setText(" Class : " + novice.getJob());
                level.setText(" Level : " + novice.getLevel());
                hp.setText(" HP : " + novice.getHp()+"/"+novice.getMaxHp());
                mp.setText(" MP : "+ novice.showMp()+"/"+novice.getMaxMp());
                exp.setText(" Exp : " + novice.showExp() + '/' + novice.getMaxExp());
                change.setVisible(false);
                swordman.setVisible(false);
                mage.setVisible(false);
                character.setIcon(classS);
            }
        });

        mage.addActionListener(new ActionListener(){
        
            @Override
            public void actionPerformed(ActionEvent e) {
                novice = new Mage(novice.getCount(),novice.getBag());
                JOptionPane.showMessageDialog(c, "Now! You are Mage");
                name.setText(" Class : " + novice.getJob());
                level.setText(" Level : " + novice.getLevel());
                hp.setText(" HP : " + novice.getHp()+"/"+novice.getMaxHp());
                mp.setText(" MP : "+ novice.showMp()+"/"+novice.getMaxMp());
                exp.setText(" Exp : " + novice.showExp() + '/' + novice.getMaxExp());
                change.setVisible(false);
                swordman.setVisible(false);
                mage.setVisible(false);
                character.setIcon(classM);
            }
        });


        status.add(new JLabel("-------------------------------------------"));
        status.add(name);
        status.add(level);
        status.add(hp);
        status.add(mp);
        status.add(exp);
        status.add(count);
        statusM.add(new JLabel("-------------------------------------------"));
        statusM.add(nameM);
        statusM.add(levelM);
        statusM.add(hpM);
        button.add(new JLabel("-------------------------------------------"));
        button.add(attack);
        button.add(heal);
        button.add(inventory);
        button.add(change);
        button.add(swordman);
        button.add(mage);
        
        p2.add(status);
        p2.add(button);
        p2.add(statusM);
        p2.setAlignmentX(0.5f);
        c.add(p2);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();

    }
    public static void main(String[] args){
        new GUI();
    }
}
