import java.util.ArrayList;

public class Battle implements BattleFlow {
    public static String ground;
    public ArrayList<Character> armyBuffed;
    @Override
    public void setBonus(Player player, String ground) {
        ground = player.getHomeGround();
        switch (ground) {
            case "Hillcrest":
                // armyBuffed = player.getArmy();
                // for (Character character : armyBuffed) {
                //     if (character.getTribe().equalsto("Highlander")) {
                //         character.setAttackPower(character.getAttackPower() * 1.2);
                //     }
                // }
                break;
            case "Marshland":
                    
                break;
            case "Desert":

                break;
            case "Arcane":
                        
                break;
        
            default:
                break;
        }
    }

    @Override
    public void Battling(ArrayList<Character> army1, ArrayList<Character> army2) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'Battling'");
    }

    @Override
    public void resetHealth(ArrayList<Character> army) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'resetHealth'");
    }

    @Override
    public void reSetBonus() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'reSetBonus'");
    }
    
    


    
}
