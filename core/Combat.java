package core;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

import characters.Character;
import characters.interfaces.IHealer;
import core.HomeGrounds.HomeGround;

public final class Combat {
    
    private Combat() {}  // Cannot be Instantiated
    
    public static String battle(Player challenger, Player opponent) {
        // Manage Order of HP and speed of both sides

        boolean battleContinue = true;
        HomeGround homeGround = opponent.getHomeGround();
        
        Army challengerArmy = challenger.cloneArmy();
        Army opponentArmy = opponent.cloneArmy();

        HomeGrounds.addHomeGroundStats(challenger.getName(), challengerArmy, opponent.getName(), opponentArmy, homeGround);

        PriorityQueue<Character> challengerSPD = new PriorityQueue<>(Comparator.comparingInt(Character::getSpeed).reversed());
        PriorityQueue<Character> challengerHP = new PriorityQueue<>(Comparator.comparingDouble(Character::getHealth));

        PriorityQueue<Character> opponentSPD = new PriorityQueue<>(Comparator.comparingInt(Character::getSpeed).reversed());
        PriorityQueue<Character> opponentHP = new PriorityQueue<>(Comparator.comparingDouble(Character::getHealth));

        for (Character character : challengerArmy.getCharacters()) {
            addToQueues(challengerSPD, challengerHP, character);
        }
        for (Character character : opponentArmy.getCharacters()) {
            addToQueues(opponentSPD, opponentHP, character);
        }

        List<Character> tempChallengerSPD = new ArrayList<>();
        List<Character> tempOpponentSPD = new ArrayList<>();

        for (int i = 0; i < 10; ++i) {

            battleContinue = refreshSpeedQueue(challengerSPD, tempChallengerSPD);
            if (!battleContinue) break;

            System.out.println("< Turn " + (i+1) + " >");
            System.out.print(challenger.getName() + "'s Turn: ");

            Character attacker;

            /*
            boolean doneMove = false;
            while (!doneMove) {   // Healers won't move if army is at full Health
                attacker = challengerSPD.poll();

            }
            */
            attacker = challengerSPD.poll();
            tempChallengerSPD.add(attacker);
            battleMove(challengerSPD, challengerHP, attacker, opponentSPD, opponentHP);
            HomeGrounds.homeGroundBonus(homeGround, challengerSPD, challengerHP, attacker, opponentSPD, opponentHP);

            battleContinue = refreshSpeedQueue(opponentSPD, tempOpponentSPD);
            if (!battleContinue) break;

            System.out.print(opponent.getName() + "'s Turn: ");
            
            attacker = opponentSPD.poll();
            tempOpponentSPD.add(attacker);
            battleMove(opponentSPD, opponentHP, attacker, challengerSPD, challengerHP);
            HomeGrounds.homeGroundBonus(homeGround, opponentSPD, opponentHP, attacker, challengerSPD, challengerHP);

            System.out.println();

        }

        refreshSpeedQueue(challengerSPD, tempChallengerSPD);
        refreshSpeedQueue(opponentSPD, tempOpponentSPD);

        if (opponentSPD.isEmpty()) return "Win!";  /// Add Xp and Gold change
        if (challengerSPD.isEmpty()) return "Loss!";
        return "Draw";
    }

    public static void battleMove(PriorityQueue<Character> attackerSPD, PriorityQueue<Character> attackerHP, Character attacker, PriorityQueue<Character> defenderSPD, PriorityQueue<Character> defenderHP) {

        Character target;

        // Implement taking turns
        // If army is at full health, move to next in Queue and execute Home bonus

        if (attacker instanceof IHealer) {
            target = attackerHP.poll();

            List<Character> maxHP = new ArrayList<>();      // Skip characters that are at max HP
            while (target != null && target.atMaxHP()) {
                maxHP.add(target);
                target = attackerHP.poll();
            }
            for (Character character : maxHP) {
                attackerHP.add(character);
            }

            if (target != null) {
                ((IHealer)attacker).heal(target);
                updateQueuesSpdHp(attackerSPD, attackerHP, target);
                return;
            }
            /*
            Character healer = attackerSPD.poll();        // Move on to an attacker instead
            attacker = attackerSPD.peek();                // homeGroundBonus() implementation needs to be modified for this to work properly
            attackerSPD.add(healer);
            */
            System.out.println(attacker.getName() + " has no one to heal. Army is at full health.");
            return;
        }

        target = defenderHP.poll();
        attacker.attack(target);
        updateQueuesSpdHp(defenderSPD, defenderHP, target);
        
    }

    public static boolean refreshSpeedQueue(PriorityQueue<Character> SPD, List<Character> tempSPD) {
        if (SPD.isEmpty()) {
            // System.out.println("Reset Order"); For Testing
            for (Character character : tempSPD) {
                if (character.isAlive()) {
                    SPD.add(character);
                    // System.out.println("Added " + character.getNameAndCategory());
                }
            }
            tempSPD.clear();
            if (SPD.isEmpty()) return false;
        }
        return true;
    }

    public static void updateQueuesSpdHp(PriorityQueue<Character> SPD, PriorityQueue<Character> HP, Character character) {
        if (!character.isAlive()) {
            SPD.remove(character);
            return;
        }
        HP.add(character);
    }

    public static void updateQueue(PriorityQueue<Character> queue, Character character) {
        if (queue.contains(character)) {
            queue.remove(character);
            queue.add(character);
        }
    }

    public static void addToQueues(PriorityQueue<Character> SPD, PriorityQueue<Character> HP, Character character) {
        SPD.add(character);
        HP.add(character);
    }

}