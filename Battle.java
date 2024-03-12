import java.util.ArrayList;

import Character.Character;
public class Battle {
    public ArrayList<Character> army1,army2;
    public String home;

    public Battle(String home,ArrayList<Character> army1,ArrayList<Character> army2) {
        this.home = home;
        this.army1= army1;
        this.army2= army2;
    }
    public void Buff(ArrayList<Character> army){
        switch(home){
            case "Hillcrest":
                for(Character c:army){
                    if(c.getTribe().equals("Highlander")){
                        c.setAttack(c.getAttack()+1f);
                        c.setDefense(c.getDefense()+1f);
                    }else if(c.getTribe().equals("Marshlanders")){
                        c.setAttack(c.getSpeed()-1f);}
                }
                break;
            case "Marshland":
                for(Character c:army){
                    if(c.getTribe().equals("Marshlander")){
                        c.setDefense(c.getDefense()+2f);}
                    else if(c.getTribe().equals("Highlander")){
                        c.setAttack(c.getAttack()-1f);
                    }else if(c.getTribe().equals("Mystic")){
                        c.setSpeed(c.getSpeed()-1f);
                    }  
                }
                break;
            case "Desert":
                for(Character c:army){
                    if(c.getTribe().equals("Marshlander")){
                        c.setHealth(c.getHealth()-1f);
                    }else if(c.getTribe().equals("Sunchild")){
                        c.setAttack(c.getAttack()+1f);
                    }
                }
                break;
            case "Arcane":
                for(Character c:army){
                    if(c.getTribe().equals("Mystic")){
                        c.setAttack(c.getAttack()+2f);
                    }else if(c.getTribe().equals("Highlander")){
                        c.setSpeed(c.getSpeed()+1f);
                    }
                    else if(c.getTribe().equals("Marshlander")){
                        c.setSpeed(c.getSpeed()-1f);
                        c.setDefense(c.getDefense()-1f);
                    }
                }
                break;
            default:
                break;
        }
    }
    public void resetBuff(ArrayList<Character> army){
        switch(home){
            case "Hillcrest":
                for(Character c:army){
                    if(c.getTribe().equals("Highlander")){
                        c.setAttack(c.getAttack()-1f);
                        c.setDefense(c.getDefense()-1f);
                    }else if(c.getTribe().equals("Marshlanders")){
                        c.setAttack(c.getSpeed()+1f);}
                }
                break;
            case "Marshland":
                for(Character c:army){
                    if(c.getTribe().equals("Marshlander")){
                        c.setDefense(c.getDefense()-2f);}
                    else if(c.getTribe().equals("Highlander")){
                        c.setAttack(c.getAttack()+1f);
                    }else if(c.getTribe().equals("Mystic")){
                        c.setSpeed(c.getSpeed()+1f);
                    }  
                }
                break;
            case "Desert":
                for(Character c:army){
                    if(c.getTribe().equals("Marshlander")){
                        //c.setHealth(c.getHealth()+1f);
                    }else if(c.getTribe().equals("Sunchild")){
                        c.setAttack(c.getAttack()-1f);
                    }
                }
                break;
            case "Arcane":
                for(Character c:army){
                    if(c.getTribe().equals("Mystic")){
                        c.setAttack(c.getAttack()-2f);
                    }else if(c.getTribe().equals("Highlander")){
                        c.setSpeed(c.getSpeed()-1f);
                    }
                    else if(c.getTribe().equals("Marshlander")){
                        c.setSpeed(c.getSpeed()+1f);
                        c.setDefense(c.getDefense()+1f);
                    }
                }
                break;
            default:
                break;
        }
    }
    public void resetHealth(ArrayList<Character> army){
        for(Character c:army){
            c.setHealth(c.getMaxHealth());
        }
    }
    public void setOrder(ArrayList<Character> army){
        for(int i=0;i<5;i++){
            for(int j=0;j<5;j++){
                if(army.get(i).getSpeed()<army.get(j).getSpeed()){
                    Character temp=army.get(i);
                    army.set(i,army.get(j));
                    army.set(j,temp);
                }else if(army.get(i).getSpeed()==army.get(j).getSpeed()){
                    
            }
        }
    }
    public void fight(ArrayList<Character> army1,ArrayList<Character> army2,String name1,String name2){
        Buff(army1);
        Buff(army2);
        int i=0;
        System.out.println(name1+" vs "+name2);
        Boolean cont=true,w1=false,w2=false;
        while(cont){
            i++;
            for(Character c1:army1){
                if(c1.getStatus()){cont=true;w2=true;break;}
                else{cont=false;}
            }
            for(Character c1:army1){
                if(c1.getStatus()){cont=true;w1=true;break;}
                else{cont=false;}
            }
            for(int j=0;j<5;j++){
                System.out.println("Turn "+i+":"+name1);
                army1.get(j)
                System.out.println("Turn "+i+":"+name2);}
        }
        resetBuff(army1);
        resetBuff(army2);
        resetHealth(army1);
        resetHealth(army2);
    }
}
