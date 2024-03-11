import java.lang.reflect.Array;
import java.util.ArrayList;

public interface BattleFlow {
    public void setBonus(Player player, String ground);//Here max health should be updated.
    public void Battling(ArrayList<Character> army1, ArrayList<Character> army2);
    public void resetHealth(ArrayList<Character> army);//Updated max health will be used here.
    public void reSetBonus();//We can minus the bonus after the battle. Here max health should be again updated.
}
