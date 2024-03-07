import Equipment.Equipment;

public class Shop {
    public static void display(){
        System.out.println("Welcome to the shop!");
        System.out.println("1. Buy");
        System.out.println("2. Sell");
        System.out.println("3. Exit");
    }
    public static void MakeCharactersToDisplay(){
        ;
    }

    public void display(Character character){
        ;
    }

    public void display(Equipment equipment){
        ;
    }
    public void buy(float gold, float prize, int army, int eq,Player player) {
        if (gold >= prize) {
            gold -= prize;
        } else {
            System.out.println("You don't have enough gold!");
        }
    }
    public void SetAttributes(Player player, int army, int eq){
        if (army > 0) {
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
            //player.setEq(eq);
        }
    }
}
