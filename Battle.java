import java.util.ArrayList;

import Character.Character;
import HomeGround.HomeGround;

public class Battle {
    public ArrayList<Character> army1,army2;
    public HomeGround home;

    public Battle(Player attacker, Player defender) {
        this.home = defender.getHomeGround();
        this.army1 = attacker.getArmy();
        this.army2 = defender.getArmy();
    }

    public int getPosition(String[] array, String element) {
        for (int i = 0; i < array.length; i++) {
            if (array[i].equals(element)) {
                return i;
            }
        }
        return -1; // return -1 if the element is not found in the array
    }

    public void resetHealth(ArrayList<Character> army){
        for(Character c:army){
            c.setHealth(c.getMaxHealth());
        }
    }

    //Following should be added in player class
    public void setOrderSpeed(ArrayList<Character> army){
        Character temp;
        ArrayList<Character> order = new ArrayList<Character>();
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5 - i - 1; j++) {
                if (army.get(j).getSpeed() < army.get(j + 1).getSpeed()) { // Modified condition
                    temp = army.get(j);
                    army.set(j, army.get(j + 1));
                    army.set(j + 1, temp);
                }
            }
        }
        }
        public void setOrderDefence(ArrayList<Character> army){
            Character temp;
            ArrayList<Character> order = new ArrayList<Character>();
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5 - i - 1; j++) {
                    if (army.get(j).getDefense() > army.get(j + 1).getDefense()) {
                        temp = army.get(j);
                        army.set(j, army.get(j + 1));
                        army.set(j + 1, temp);
                    }
                }
            }
            }
    public void setOrderToEqualStats(ArrayList<Character> army,String[] Order){
        int a=0,b=0;
        for(int i=0;i<5;i++){
            for(int j=0;j<5;j++){
                if(army.get(i).getSpeed()==army.get(a).getSpeed()){
                    b=i;
                    }else{
                        a=i;
                        break;
                    }
                }
            if(b-a>1){
                for(int k=a;k<b;k++){
                    if(getPosition(Order,army.get(k).getType())>getPosition(Order,army.get(k+1).getType())){
                        Character temp=army.get(k);
                        army.set(k,army.get(k+1));
                        army.set(k+1,temp);}}
            }}
        }

    public void fight(ArrayList<Character> army1,ArrayList<Character> army2,String name1,String name2){
        this.home.buff(army1);
        this.home.buff(army2);
        int i=0;
        float s1=0,s2=0;
        Character O1=null,O2=null,D1=null,D2=null;
        System.out.println(name1+" vs "+name2);
        Boolean cont=true,w1=false,w2=false;
        String attackOrder[]={"Archer","Knight","Mythical Creature","Mage","Healer"};
        String defenseOrder[]={"Healer","Mythical Creature","Archer","Knight","Mage"};
        ArrayList<Character> offencer1=new ArrayList<>(army1),defender1=new ArrayList<>(army1),offencer2=new ArrayList<>(army2),defender2=new ArrayList<>(army2);
        setOrderSpeed(offencer1);setOrderDefence(defender1);;
        setOrderToEqualStats(army1, attackOrder);setOrderToEqualStats(defender1, defenseOrder);
        setOrderSpeed(offencer2);setOrderDefence(defender2);
        setOrderToEqualStats(offencer2, attackOrder);setOrderToEqualStats(defender2, defenseOrder);

    for(int j=0;j<10;j++){
        System.out.println("\nTurn "+j+1+":"+name1+"\n");
        w1=false;

        //Offencer1 attack Defender2

        //Offencer1 character choosing
        for(int k=j%10;k<10;k++){
            if(offencer1.get(k).getStatus()){
                O1=offencer1.get(k);
                w1=true;
                break;
            }
            if(k==9){
                break;
            }
        }
        w2=false;
        //Defender2 character choosing
        for(int k=j%10;k<10;k++){
            if(defender2.get(k).getStatus()){
                D2=defender2.get(k);
                w2=true;
                break;
            }
            if(k==9){
                break;
            }
        }

        System.out.println(O1.getName()+" attacks "+D2.getName());

        //Battle happens
        float damage1=0.5f*(O1.getAttack())-0.1f*(D2.getDefense());
        D2.setHealth(D2.getHealth()-damage1);
        if(D2.getHealth()<=0){
            D2.setHealth(0);;
            D2.setStatus(false);}
        //Result of first attack
        System.out.println(D2.getName()+"'s health : "+D2.getHealth());
        System.out.println(O1.getName()+"'s health : "+O1.getHealth());
        if(D2.getHealth()==0){
            System.out.println(D2.getName()+" died!");
        }
    w2=false;

    if(w1&&w2){}else{
        break;}
    //Offencer2 attack Defender1

    System.out.println("\nTurn "+j+1+":"+name2+"\n");
    //Offencer2 character choosing
    for(int k=j%10;k<10;k++){
        if(offencer2.get(k).getStatus()){
            O2=offencer2.get(k);
            w2=true;
            break;
        }
        if(k==9){
            break;
        }
    }
    w1=false;
    //Defender1 character choosing
    for(int k=j%10;k<10;k++){
        if(defender1.get(k).getStatus()){
            D1=defender1.get(k);
            w1=true;
            break;
        }
        if(k==9){
            break;
        }
    }

    System.out.println(O2.getName()+" attacks "+D1.getName());

    //Battle happens
    float damage2=0.5f*(O2.getAttack())-0.1f*(D1.getDefense());
    D1.setHealth(D1.getHealth()-damage2);
    if(D1.getHealth()<=0){
        D1.setHealth(0);;
        D1.setStatus(false);}

    //Result of second attack
    System.out.println(D1.getName()+"'s health : "+D1.getHealth());
    System.out.println(O2.getName()+"'s health : "+O2.getHealth());
    if(D1.getHealth()==0){
        System.out.println(D1.getName()+" died!");}
        if(w1&&w2){}else{
            break;}
    }
    checkVictory(w1, w2);
        //Resetting the status of the characters
        this.home.resetBuff(army1);
        this.home.resetBuff(army2);
        resetHealth(army1);
        resetHealth(army2);
    }

private void checkVictory(Boolean w1, Boolean w2) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'checkVictory'");
}
}
