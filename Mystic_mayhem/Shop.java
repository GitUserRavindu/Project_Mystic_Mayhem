package Mystic_mayhem;

public class Shop {
    //Knights
    static Character knight ;
    //Mages
    static Character mage;
    //Mythical Creatures
    static Character mythicalCreatures ;
    //Archers
    static Character zing=new archer() ;
    //Healers
    static Character healer ;


    public static void display(){
        System.out.println("Welcome to the shop!");
        System.out.println("1. Buy");
        System.out.println("2. Sell");
        System.out.println("3. Exit");
    }
    public static void MakeCharactersToDisplay(){
        zing.zing();
    }

    public void display(Character character){
        System.out.println(character.getName());
        System.out.println("Health: " + character.getHealth());
        System.out.println("Attack: " + character.getAttack());
        System.out.println("Defense: " + character.getDefense());
        System.out.println("Gold: " + character.getGold());
    }

    public void display(Equipment equipment){
        System.out.println(character.getName());
        System.out.println("Health: " + character.getHealth());
        System.out.println("Attack: " + character.getAttack());
        System.out.println("Defense: " + character.getDefense());
        System.out.println("Gold: " + character.getGold());
    }
    public void buy(float gold, float prize, int army, int eq,Player player) {
        if (gold >= prize) {
            gold -= prize;
        } else {
            System.out.println("You don't have enough gold!");
        }
    }
    public void SetAttributes(Player player, int army, int eq){
        if(army>0){
            switch (army) {
                case 0:
                    
                break;
                case 1:
                
                break;
                case 2:
                
                break;
                case 3:
                
                break;
                case 4:
                
                break;
                default:
                break;
            }

        }
        if(eq>0){
            player.setEq(eq);
        }
    }
}
