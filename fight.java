import java.util.ArrayList;
import Character.Character;
public class fight {
    public static Boolean CharacterVsCharacter(Character O,Character D,Boolean bonusAttack,Boolean bonusHeal,ArrayList<Character> army1,ArrayList<Character> army2,Boolean w){
    if(O.getType().equals("Healer")){
        battleSub.setOrderHealth(army2);
        for(Character H:army2){
            if(H.getStatus()){
                if(H.getHealth()<H.getMaxHealth()){
                H.setHealth(H.getHealth()*0.1f+H.getHealth());}

                System.out.println(O.getName()+" heals "+H.getName());
                
                if(bonusAttack){H.setHealth((0.2f*H.getHealth()*0.1f+H.getHealth()));}
                System.out.println(O.getName()+" heals "+H.getName()+" again");
                
                if(bonusHeal){O.setHealth((O.getHealth()*(1.1f)));
                System.out.println(O.getName()+" self heal");}

                System.out.println(H.getName()+"'s health : "+H.getHealth());
                break;}
            }
    }else{
        System.out.println(O.getName()+" attacks "+D.getName());
        float damage2=0.5f*(O.getAttack())-0.1f*(D.getDefense());

        if(bonusAttack){System.out.println(O.getName()+" attacks "+D.getName()+" again");
        damage2=damage2+0.2f*0.5f*(O.getAttack())-0.1f*(D.getDefense());}

        if(bonusHeal){O.setHealth((O.getHealth()*(1.1f)));
        System.out.println(O.getName()+" self heal");}

        D.setHealth(D.getHealth()-damage2);
        
        if(D.getHealth()<=0){
            D.setHealth(0);
            }
            
            //Result of second attack
            System.out.println(D.getName()+"'s health : "+D.getHealth());
            System.out.println(O.getName()+"'s health : "+O.getHealth());
    }

    if(D.getHealth()==0){
        System.out.println(D.getName()+" died!");
        D.setStatus(false);
        w=false;
        for(Character c2:army1){
            if(c2.getStatus()){
                w=true;
                break;
            }}

    }
    return w;
}
}

