import java.util.ArrayList;
import Character.Character;
import HomeGround.HomeGround;

public class Battle {
    public ArrayList<Character> army1,army2;
    public Player p1,p2;
    public HomeGround home;
    public battleSub sub=new battleSub();

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

    //Following should be added in player class
    
        
    

//--------------------------------------------------------------------------------
//--------------------------------------------------------------------------------
//--------------------------------------------------------------------------------
//--------------------------------------------------------------------------------
public void fight(){
    Boolean bonusAttack=home.getName().equals("Hillcrest");
    Boolean bonusHeal=home.getName().equals("Arcane");
    this.home.buff(army1);
    this.home.buff(army2);

    Character O1=null,O2=null,D1=null,D2=null;
    System.out.println(name1+" vs "+name2);
    Boolean w1=true,w2=true;

    String attackOrder[]={"Archer","Knight","Mythical Creature","Mage","Healer"};
    String defenseOrder[]={"Healer","Mythical Creature","Archer","Knight","Mage"};
    int tmp1=0,tmp2=0;

    for(int j=0;j<5;j++){
        System.out.println("\nTurn "+(2*j+1)+":"+name1+"\n");


        //Offencer1 attack Defender2

        //Offencer1 character choosing
        sub.setOrderSpeed(army1);sub.setOrderToEqualStats(army1, attackOrder);
    for (int k = tmp1; k < 2 * (int) army1.size(); k++) {
        int i = k % army1.size();
    if(army1.get(i).getStatus()){
        O1=army1.get(i);
        tmp1=i+1;
        break;
    }
       
    }
    
    //Defender2 character choosing
    sub.setOrderDefence(army2);sub.setOrderToEqualStats(army2, defenseOrder);
   
    for (Character c2:army2) {
        if(c2.getStatus()){
            D2=c2;
            break;
        }
    }
    
    Boolean bonusAttack1=bonusAttack&&O1.getTribe().equals("Highlander");
    Boolean bonusHeal1=bonusHeal&&O1.getTribe().equals("Mystic");
        
    if(O1.getType().equals("Healer")){
        sub.setOrderHealth(army1);
        for(Character H:army1){
            if(H.getStatus()){
                if(H.getHealth()<H.getMaxHealth()){
                H.setHealth((H.getHealth()*0.1f+H.getHealth()));}

                System.out.println(O1.getName()+" heals "+H.getName());

                if(bonusAttack1){H.setHealth((0.2f*H.getHealth()*0.1f+H.getHealth()));}
                System.out.println(O1.getName()+" heals "+H.getName()+" again");
                
                if(bonusHeal1){O1.setHealth((O1.getHealth()*(1.1f)));
                System.out.println(O1.getName()+" self heal");}
                
                System.out.println(H.getName()+"'s health : "+H.getHealth());
                break;}
            }   
            
        
    }else{

        System.out.println(O1.getName()+" attacks "+D2.getName());
        float damage1=0.5f*(O1.getAttack())-0.1f*(D2.getDefense());

        if(bonusAttack1){System.out.println(O1.getName()+" attacks "+D2.getName()+" again");
        damage1=damage1+0.2f*0.5f*(O1.getAttack())-0.1f*(D2.getDefense());}

        if(bonusHeal1){O1.setHealth((O1.getHealth()*(1.1f)));
        System.out.println(O1.getName()+" self heal");}

        D2.setHealth(D2.getHealth()-damage1);
        
        if(D2.getHealth()<=0){
            D2.setHealth(0);
            }
            
            //Result of first attack
            System.out.println(D2.getName()+"'s health : "+D2.getHealth());
            System.out.println(O1.getName()+"'s health : "+O1.getHealth());
    }

    if(D2.getHealth()==0){
        System.out.println(D2.getName()+" died!");
        D2.setStatus(false);
        w2=false;
        for(Character c1:army2){
            if(c1.getStatus()){
                w2=true;
                //System.out.println(c1.getName()+" "+w2);
                break;
            }
        }if(!w2){break;}
    }

    //Offencer2 attack Defender1

        sub.setOrderSpeed(army2);sub.setOrderToEqualStats(army2, attackOrder);

        System.out.println("\nTurn "+(2*j+2)+":"+name2+"\n");

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
    sub.setOrderDefence(army1);sub.setOrderToEqualStats(army1, defenseOrder);

    for(Character c2:army1)
    {if(c2.getStatus()){
            D1=c2;
            break;
        }
    }
    
    Boolean bonusAttack2=bonusAttack&&O2.getTribe().equals("Highlander");
    Boolean bonusHeal2=bonusHeal&&O2.getTribe().equals("Mystic");
    
    if(O2.getType().equals("Healer")){
        sub.setOrderHealth(army2);
        for(Character H1:army2){
            if(H1.getStatus()){
                if(H1.getHealth()<H1.getMaxHealth()){
                H1.setHealth(H1.getHealth()*0.1f+H1.getHealth());}

                System.out.println(O2.getName()+" heals "+H1.getName());
                
                if(bonusAttack2){H1.setHealth((0.2f*H1.getHealth()*0.1f+H1.getHealth()));}
                System.out.println(O2.getName()+" heals "+H1.getName()+" again");
                
                if(bonusHeal2){O2.setHealth((O2.getHealth()*(1.1f)));
                System.out.println(O2.getName()+" self heal");}

                System.out.println(H1.getName()+"'s health : "+H1.getHealth());
                break;}
            }
    }else{
        System.out.println(O2.getName()+" attacks "+D1.getName());
        float damage2=0.5f*(O2.getAttack())-0.1f*(D1.getDefense());

        if(bonusAttack2){System.out.println(O2.getName()+" attacks "+D1.getName()+" again");
        damage2=damage2+0.2f*0.5f*(O2.getAttack())-0.1f*(D1.getDefense());}

        if(bonusHeal2){O2.setHealth((O2.getHealth()*(1.1f)));
        System.out.println(O2.getName()+" self heal");}

        D1.setHealth(D1.getHealth()-damage2);
        
        if(D1.getHealth()<=0){
            D1.setHealth(0);
            }
            
            //Result of second attack
            System.out.println(D1.getName()+"'s health : "+D1.getHealth());
            System.out.println(O2.getName()+"'s health : "+O2.getHealth());
    }

    if(D1.getHealth()==0){
        System.out.println(D1.getName()+" died!");
        D1.setStatus(false);
        w1=false;
        for(Character c2:army1){
            if(c2.getStatus()){
                w1=true;
                break;
            }}
        if(!w1){break;}

    }}
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
