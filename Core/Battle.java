package Core;

import java.util.ArrayList;
import Character.Character;
import HomeGround.HomeGround;

public class Battle {
    public ArrayList<Character> army1,army2;
    public Player p1,p2;
    public HomeGround home;
    private String name1, name2;

    public Battle(Player attacker, Player defender) {
        this.home = defender.getHomeGround();

        this.p1 = attacker;
        this.p2 = defender;

        this.army1 = attacker.getArmy();
        this.army2 = defender.getArmy();

        this.name1 = attacker.getName();
        this.name2 = defender.getName();
    }

    public void resetHealth(ArrayList<Character> army){
        for(Character c:army){
            c.setHealth(c.getMaxHealth());
        }
    }

//--------------------------------------------------------------------------------
//--------------------------------------------------------------------------------
//--------------------------------------------------------------------------------
//--------------------------------------------------------------------------------
        public void fight(){
            //Checking whether its happens in a specific home ground
            //Some bonus turns and little more than buffing is happening for some tribes there
            Boolean bonusAttack=home.getName().equals("Hillcrest");
            Boolean bonusHeal=home.getName().equals("Arcane");

            //Buffing the army
            this.home.buff(army1);
            this.home.buff(army2);

            //These are the offencer and defender in each turn
            //O-Ofencer, D-Defender
            Character O1=null,O2=null,D1=null,D2=null;

            //Declaration of war or challenge
            System.out.println(name1+" vs "+name2);

            //These are for to check if all characters of the relevant army are dead
            Boolean w1=true,w2=true;

            //If the parameter for sorting is equal among characters the following order is used
            String attackOrder[]={"Archer","Knight","Mythical Creature","Mage","Healer"};
            String defenseOrder[]={"Healer","Mythical Creature","Archer","Knight","Mage"};

            //Thse will be used to select next character----The previous character can be skipped
            int tmp1=0,tmp2=0;

        for(int j=0;j<10;j++){
            System.out.println("\nTurn "+(2*j+1)+":"+name1+"\n");

            //Attack order
            battleSub.setOrderSpeed(army1);battleSub.setOrderToEqualStats(army1, attackOrder);

            //Selecting the relevant offencer
        for (int k = tmp1; k < 2 * (int) army1.size(); k++) {
            int i = k % army1.size();
            if(army1.get(i).getStatus()){
                O1=army1.get(i);
                tmp1=i+1;
                break;
            }
        }
            //Defend order
            battleSub.setOrderDefence(army2);battleSub.setOrderToEqualStats(army2, defenseOrder);

            //Selecting the relevant offencer
        for (Character c2:army2) {
            if(c2.getStatus()){
                D2=c2;
                break;
            }
        }

        //Check if any bonus events are there
        Boolean bonusAttack1=bonusAttack&&O1.getTribe().equals("Highlander");
        Boolean bonusHeal1=bonusHeal&&O1.getTribe().equals("Mystic");

        w2=fight.CharacterVsCharacter(O1, D2, bonusAttack1, bonusHeal1, army1, army2, w2);
        if(!w2){break;}

        /////////////////////////////////////////////////////////////////////
        /////////////////////////////////////////////////////////////////////
        /////////////////////////////////////////////////////////////////////
        //Offencer2 attack Defender1

        System.out.println("\nTurn "+(2*j+2)+" : "+name2+"\n");

        battleSub.setOrderSpeed(army2);battleSub.setOrderToEqualStats(army2, attackOrder);

        //Offencer2 character choosing
        for (int k = tmp2; k < 2 * (int) army2.size(); k++) {
            int i = k % army2.size();

            if(army2.get(i).getStatus()){
                O2=army2.get(i);
                tmp2=i+1;
                break;
            }
        }
        //Defender1 character choosing
        battleSub.setOrderDefence(army1);battleSub.setOrderToEqualStats(army1, defenseOrder);

        for(Character c2:army1)
        {if(c2.getStatus()){
                D1=c2;
                break;
            }
        }

        Boolean bonusAttack2=bonusAttack&&O2.getTribe().equals("Highlander");
        Boolean bonusHeal2=bonusHeal&&O2.getTribe().equals("Mystic");


        w1=fight.CharacterVsCharacter(O2, D1, bonusAttack2, bonusHeal2, army1, army2, w1);
        if(!w1){break;}
            }

        boolean draw,win1,win2;
        win1=w1&&(!w2);
        win2=(!w1)&&w2;
        draw=w1&&w2;
        checkVictory(win1,win2,draw);

            //Resetting the status of the characters
            this.home.resetBuff(army1);
            this.home.resetBuff(army2);
            resetHealth(army1);
            resetHealth(army2);

            for (int i = 0; i < army1.size(); i++) {
                army1.get(i).setStatus(true);
            }
        }

        private void checkVictory(Boolean win1, Boolean win2,Boolean draw) {
        if(win1){
            System.out.println("\n"+name1+" won!");
            p1.setXp(p1.getXp()+1f);
            p1.setGold((int)(p1.getGold()+p2.getGold()*0.1));
            p2.setGold((int)(p2.getGold()-p2.getGold()*0.1));
        }else if(win2){
            System.out.println("\n"+name2+" won!");
            p2.setXp(p2.getXp()+1f);
            p2.setGold((int)(p2.getGold()+p1.getGold()*0.1));
            p1.setGold((int)(p1.getGold()-p1.getGold()*0.1));
        }else if(draw){
        System.out.println("\n"+"It's a draw!");}

        System.out.println(name1+ "XP:"+p1.getXp()+" gold coins:"+p1.getGold());
        System.out.println(name2+ "XP:"+p2.getXp()+" gold coins:"+p2.getGold()+"\n");
        }
        }
