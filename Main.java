import Character.Character;

public class Main {
    public static void main(String[] args) {
        CharacterRegistry.bundledCache(); // Making game character configurations

        // We use CharacterRegistry as a library to store the different configurations
        // of Characters, and we use name to return certain character
        Character a = CharacterRegistry.returnCharacter("Zing");
        Character b = CharacterRegistry.returnCharacter("Zing");
        Character c = CharacterRegistry.returnCharacter("Sunfire");

        // Player playerP = new Player();
        // Market market = Market.getInstance();
        // market.marketMenu(playerP, 200);

        System.out.println(a);
        System.out.println(b);

        a.setAttack(0);

        System.out.println(a.getAttack() + " " + b.getAttack());

        System.out.println(c.getName());
    }
}
