package core;

import java.util.HashMap;
import java.util.PriorityQueue;

import characters.Character;

public class HomeGrounds {
    
    public enum HomeGround{
        HILLCREST("Hillcrest", "Highlander"),
        MARSHLAND("Marshland", "Marshlander"),
        DESERT("Desert", "Sunchild"),
        ARCANE("Arcane", "Mystic");

        private String name;
        private String characterType;

        HomeGround(String name, String characterType) {
            this.name = name;
            this.characterType = characterType;
        }

        public String getName() {
            return name;
        }

        public String getCharacterType() {
            return characterType;
        }
    }

    private static HashMap<String, HomeGround> characterHomegrounds = new HashMap<>();

    static {

        // Archers
        characterHomegrounds.put("Shooter", HomeGround.HILLCREST);
        characterHomegrounds.put("Ranger", HomeGround.HILLCREST);
        characterHomegrounds.put("Sunfire", HomeGround.DESERT);
        characterHomegrounds.put("Zing", HomeGround.DESERT);
        characterHomegrounds.put("Saggitarius", HomeGround.ARCANE);

        // Knights
        characterHomegrounds.put("Squire", HomeGround.MARSHLAND);
        characterHomegrounds.put("Cavalier", HomeGround.HILLCREST);
        characterHomegrounds.put("Templar", HomeGround.HILLCREST);
        characterHomegrounds.put("Swiftblade", HomeGround.HILLCREST);
        characterHomegrounds.put("Zoro", HomeGround.MARSHLAND);

        // Mages
        characterHomegrounds.put("Warlock", HomeGround.MARSHLAND);
        characterHomegrounds.put("Illusionist", HomeGround.ARCANE);
        characterHomegrounds.put("Enchanter", HomeGround.HILLCREST);
        characterHomegrounds.put("Conjurer", HomeGround.HILLCREST);
        characterHomegrounds.put("Eldritch", HomeGround.ARCANE);

        // Healers
        characterHomegrounds.put("Soother", HomeGround.DESERT);
        characterHomegrounds.put("Medic", HomeGround.HILLCREST);
        characterHomegrounds.put("Alchemist", HomeGround.ARCANE);
        characterHomegrounds.put("Saint", HomeGround.ARCANE);
        characterHomegrounds.put("Lightbringer", HomeGround.DESERT);

        // Mythical Creatures
        characterHomegrounds.put("Dragon", HomeGround.DESERT);
        characterHomegrounds.put("Basilisk", HomeGround.MARSHLAND);
        characterHomegrounds.put("Hydra", HomeGround.MARSHLAND);
        characterHomegrounds.put("Phoenix", HomeGround.DESERT);
        characterHomegrounds.put("Pegasus", HomeGround.ARCANE);
    }

    public static void addHomeGroundStats(Player player1, Player player2, HomeGround homeGround) {
        System.out.println("Entering " + homeGround.getName() + "...");
        System.out.println();
        System.out.println(player1.getName() + "'s Army: ");
        for (Character character : player1.getArmy().getCharacters()) {
            updateCharacterStats(character, homeGround);
        }
        System.out.println();
        System.out.println(player2.getName() + "'s Army: ");
        for (Character character : player2.getArmy().getCharacters()) {
            updateCharacterStats(character, homeGround);
        }
        System.out.println();
    }

    public static void updateCharacterStats(Character character, HomeGround homeGround) {
        HomeGround characterHomeground = getHomeGround(character);
        System.out.print(characterHomeground.getCharacterType() + " " + character.getName());
        switch (homeGround) {
            case HILLCREST:
                switch (characterHomeground) {
                    case HILLCREST:
                        character.addAttack(1);
                        character.addDefense(1);
                        System.out.println(" gains +1 Attack and +1 Defense in Hillcrest.");
                        break;
                    case MARSHLAND:
                        character.addAttack(1);
                        character.addDefense(1);
                        System.out.println(" gains +1 Attack and +1 Defense in Hillcrest.");
                    case DESERT:
                        character.addSpeed(-1);
                        System.out.println("'s Speed decreases by 1 in Hillcrest.");
                    default:
                        System.out.println("'s stats are unchanged in Arcane.");
                        break;
                }
                break;
            case MARSHLAND:
                switch (characterHomeground) {
                    case MARSHLAND:
                        character.addDefense(2);
                        System.out.println(" gains +2 Defense in Marshland.");
                        break;
                    case DESERT:
                        character.addAttack(-1);
                        System.out.println("'s Attack decreases by 1 in Marshland.");
                        break;
                    case ARCANE:
                        character.addSpeed(-1);
                        System.out.println("'s Speed decreases by 1 in Marshland.");
                        break;
                    default:
                        System.out.println("'s stats are unchanged in Marshland.");
                        break;
                }
                break;
            case DESERT:
                switch (characterHomeground) {
                    case DESERT:
                        character.addAttack(1);
                        System.out.println(" gains +1 Attack in Desert.");
                        break;
                    case MARSHLAND:
                        character.addHealth(-1);
                        System.out.println("'s Health decreases by 1 in Desert.");
                        break;
                    default:
                        System.out.println("'s stats are unchanged in Desert.");
                        break;
                }
                break;
            case ARCANE:
                switch (characterHomeground) {
                    case ARCANE:
                        character.addAttack(2);
                        System.out.println(" gains +2 Attack in Arcane.");
                        break;
                    case HILLCREST:
                    case MARSHLAND:
                        character.addSpeed(-1);
                        character.addDefense(-1);
                        System.out.println("'s Speed and Defense decrease by 1 in Arcane.");
                        break;
                    default:
                        System.out.println("'s stats are unchanged in Arcane.");
                        break;
                }
                break;
            default:
                break;
        }
    }

    public static HomeGround getHomeGround(Character character) {
        return characterHomegrounds.get(character.getName());
    }

    public static void homeGroundBonus(HomeGround homeGround, PriorityQueue<Character> attackerSPD, PriorityQueue<Character> attackerHP, Character attacker, PriorityQueue<Character> defenderSPD, PriorityQueue<Character> defenderHP) {
        if (!(getHomeGround(attacker) == homeGround)) return;
        
        switch (getHomeGround(attacker)) {
            case HILLCREST:
                System.out.print("-- Highlander Bonus Turn: ");
                attacker.addAttack(-attacker.getAttack()*0.8); // Attacks at 0.2 x Normal Attack
                Combat.battleMove(attackerSPD, attackerHP, attacker, defenderSPD, defenderHP);
                attacker.addAttack(attacker.getAttack()*5);  // Return to Normal
                break;
            case ARCANE:
                System.out.print("-- Mystic HP Increase: ");
                attacker.maxHPIncrease(attacker.getHealth()*0.1);
                Combat.updateQueue(attackerHP, attacker);
            default:
                break;
        }
    }

}