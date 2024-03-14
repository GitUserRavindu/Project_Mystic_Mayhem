import java.util.ArrayList;
import Character.Character;
public class battleSub {
  
public static int getPosition(String[] array, String element) {
    for (int i = 0; i < array.length; i++) {
        if (array[i].equals(element)) {
            return i;
        }
    }
    return -1; // return -1 if the element is not found in the array
}
public static void setOrderSpeed(ArrayList<Character> army){
    Character temp;
    for (int i = 0; i < army.size(); i++) {
        for (int j = 0; j < army.size() - i - 1; j++) {
            if (army.get(j).getSpeed() < army.get(j + 1).getSpeed()) { // Modified condition
                temp = army.get(j);
                army.set(j, army.get(j + 1));
                army.set(j + 1, temp);
            }
        }
    }
    }
public static void setOrderHealth(ArrayList<Character> army){
        Character temp;
        for (int i = 0; i < army.size(); i++) {
            for (int j = 0; j < army.size() - i - 1; j++) {
                if (army.get(j).getHealth() > army.get(j + 1).getHealth()) {
                    temp = army.get(j);
                    army.set(j, army.get(j + 1));
                    army.set(j + 1, temp);
                }
            }
        }
        }
public static void setOrderDefence(ArrayList<Character> army){
    Character temp;
    for (int i = 0; i < army.size(); i++) {
        for (int j = 0; j < army.size() - i - 1; j++) {
            if (army.get(j).getDefense() > army.get(j + 1).getDefense()) {
                temp = army.get(j);
                army.set(j, army.get(j + 1));
                army.set(j + 1, temp);
            }
        }
    }
    }

public static void setOrderToEqualStats(ArrayList<Character> army,String[] Order){
    int a=0,b=0;
for(int i=0;i<army.size();i++){
    for(int j=0;j<army.size();j++){
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
}
