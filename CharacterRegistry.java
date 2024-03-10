import java.util.HashMap;

import Character.Archer;
import Character.Character;
import Character.Healer;
import Character.Knight;
import Character.Mage;
import Character.MythicalCreature;

public class CharacterRegistry {
    private static HashMap<String, Character> data = new HashMap<>();

    public static void addCharacter(String name, Character character)
    {
        data.put(name, character);
    }

    public static Character returnCharacter(String name)
    {
        return data.get(name).makeClone();
    }

    public static void bundledCache()
    {
        // Archers
        Archer shooter = new Archer();
        shooter.setName("Shooter");
        shooter.setPrize(80);
        shooter.setAttack(11f);
        shooter.setDefense(4f);
        shooter.setHealth(6f);
        shooter.setSpeed(9f);

        Archer ranger = new Archer();
        ranger.setName("Ranger");
        ranger.setPrize(115);
        ranger.setAttack(14f);
        ranger.setDefense(5f);
        ranger.setHealth(8f);
        ranger.setSpeed(10f);
        ranger.setTribe("Highlander");

        Archer sunfire = new Archer();
        sunfire.setName("Sunfire");
        sunfire.setPrize(160);
        sunfire.setAttack(15f);
        sunfire.setDefense(5f);
        sunfire.setHealth(7f);
        sunfire.setSpeed(14f);
        sunfire.setTribe("Sunchild");

        Archer zing = new Archer();
        zing.setName("Zing");
        zing.setPrize(200);
        zing.setAttack(16f);
        zing.setDefense(9f);
        zing.setHealth(11f);
        zing.setSpeed(14f);
        zing.setTribe("Sunchild");

        Archer saggitarius = new Archer();
        saggitarius.setName("Saggitarius");
        saggitarius.setPrize(230);
        saggitarius.setAttack(18f);
        saggitarius.setDefense(7f);
        saggitarius.setHealth(12f);
        saggitarius.setSpeed(17f);
        saggitarius.setTribe("Mystic");

        // adding everything to the hashmap
        addCharacter("Zing", zing);
        addCharacter("Sunfire", sunfire);
        addCharacter("Ranger", ranger);
        addCharacter("Archer", shooter);
        addCharacter("Saggitarius", saggitarius);

        // Healers
        Healer alchemist = new Healer();
        alchemist.setName("Alchemist");
        alchemist.setPrize(150);
        alchemist.setAttack(13f);
        alchemist.setDefense(13f);
        alchemist.setHealth(13f);
        alchemist.setSpeed(13f);
        alchemist.setTribe("Marshlander");

        Healer lightbringer = new Healer();
        lightbringer.setName("Lightbringer");
        lightbringer.setPrize(260);
        lightbringer.setAttack(17f);
        lightbringer.setDefense(15f);
        lightbringer.setHealth(19f);
        lightbringer.setSpeed(12f);
        lightbringer.setTribe("Sunchild");

        Healer medic = new Healer();
        medic.setName("Medic");
        medic.setPrize(125);
        medic.setAttack(12f);
        medic.setDefense(9f);
        medic.setHealth(10f);
        medic.setSpeed(7f);
        medic.setTribe("Highlander");

        Healer saint = new Healer();
        saint.setName("Saint");
        saint.setPrize(200);
        saint.setAttack(16f);
        saint.setDefense(14f);
        saint.setHealth(17f);
        saint.setSpeed(9f);
        saint.setTribe("Mystic");

        Healer soother = new Healer();
        soother.setName("Soother");
        soother.setPrize(95);
        soother.setAttack(10f);
        soother.setDefense(8f);
        soother.setHealth(9f);
        soother.setSpeed(6f);
        soother.setTribe("Sunchild");

        // adding everything to the hashmap
        addCharacter("Alchemist", alchemist);
        addCharacter("Lightbringer", lightbringer);
        addCharacter("Medic", medic);
        addCharacter("Saint", saint);
        addCharacter("Soother", soother);

        // Knights
        Knight cavelier = new Knight();
        cavelier.setName("Cavalier");
        cavelier.setPrize(110);
        cavelier.setAttack(10f);
        cavelier.setDefense(12f);
        cavelier.setHealth(7f);
        cavelier.setSpeed(10f);

        Knight squire = new Knight();
        squire.setName("Squire");
        squire.setPrize(85);
        squire.setAttack(8f);
        squire.setDefense(9f);
        squire.setHealth(7f);
        squire.setSpeed(8f);
        squire.setTribe("Marshlander");

        Knight swiftblade = new Knight();
        swiftblade.setName("Swiftblade");
        swiftblade.setPrize(250);
        swiftblade.setAttack(18f);
        swiftblade.setDefense(20f);
        swiftblade.setHealth(17f);
        swiftblade.setSpeed(13f);
        swiftblade.setTribe("Marshlander");

        Knight templar = new Knight();
        templar.setName("Templar");
        templar.setPrize(155);
        templar.setAttack(14f);
        templar.setDefense(16f);
        templar.setHealth(12f);
        templar.setSpeed(12f);
        templar.setTribe("Sunchild");

        Knight zoro = new Knight();
        zoro.setName("Templar");
        zoro.setPrize(155);
        zoro.setAttack(14f);
        zoro.setDefense(16f);
        zoro.setHealth(12f);
        zoro.setSpeed(12f);
        zoro.setTribe("Sunchild");

        // adding everything to the hashmap
        addCharacter("Cavalier", cavelier);
        addCharacter("Squire", squire);
        addCharacter("Swiftblade", swiftblade);
        addCharacter("Templar", templar);
        addCharacter("Zoro", zoro);

        // Mages
        Mage conjurer = new Mage();
        conjurer.setName("Conjurer");
        conjurer.setPrize(195);
        conjurer.setAttack(18f);
        conjurer.setDefense(15f);
        conjurer.setHealth(14f);
        conjurer.setSpeed(12f);
        conjurer.setTribe("Highlander");

        Mage eldritch = new Mage();
        eldritch.setName("Eldritch");
        eldritch.setPrize(270);
        eldritch.setAttack(19f);
        eldritch.setDefense(17f);
        eldritch.setHealth(18f);
        eldritch.setSpeed(14f);
        eldritch.setTribe("Mystic");

        Mage enchanter = new Mage();
        enchanter.setName("Enchanter");
        enchanter.setPrize(160);
        enchanter.setAttack(16f);
        enchanter.setDefense(10f);
        enchanter.setHealth(13f);
        enchanter.setSpeed(16f);
        enchanter.setTribe("Highlander");

        Mage illusionist = new Mage();
        illusionist.setName("Illusionist");
        illusionist.setPrize(120);
        illusionist.setAttack(13f);
        illusionist.setDefense(8f);
        illusionist.setHealth(12f);
        illusionist.setSpeed(14f);
        illusionist.setTribe("Mystic");

        Mage warlock = new Mage();
        warlock.setName("Warlock");
        warlock.setPrize(100);
        warlock.setAttack(12f);
        warlock.setDefense(7f);
        warlock.setHealth(10f);
        warlock.setSpeed(12f);
        warlock.setTribe("Marshlander");

        // adding everything to the hashmap
        addCharacter("Conjurer", conjurer);
        addCharacter("Eldritch", eldritch);
        addCharacter("Enchanter", enchanter);
        addCharacter("Illusionist", illusionist);
        addCharacter("Warlock", warlock);

        //Mythical Creatures
        MythicalCreature basilisk = new MythicalCreature();
        basilisk.setName("Basilisk");
        basilisk.setPrize(165);
        basilisk.setAttack(15f);
        basilisk.setDefense(11f);
        basilisk.setHealth(10f);
        basilisk.setSpeed(12f);
        basilisk.setTribe("Marshlander");

        MythicalCreature dragon = new MythicalCreature();
        dragon.setName("Dragon");
        dragon.setPrize(120);
        dragon.setAttack(12f);
        dragon.setDefense(14f);
        dragon.setHealth(15f);
        dragon.setSpeed(8f);
        dragon.setTribe("Sunchild");

        MythicalCreature hydra = new MythicalCreature();
        hydra.setName("Hydra");
        hydra.setPrize(205);
        hydra.setAttack(12f);
        hydra.setDefense(16f);
        hydra.setHealth(15f);
        hydra.setSpeed(11f);
        hydra.setTribe("Marshlander");

        MythicalCreature pegasus = new MythicalCreature();
        pegasus.setName("Pegasus");
        pegasus.setPrize(340);
        pegasus.setAttack(14f);
        pegasus.setDefense(18f);
        pegasus.setHealth(20f);
        pegasus.setSpeed(20f);
        pegasus.setTribe("Mystic");

        MythicalCreature phoenix = new MythicalCreature();
        phoenix.setName("Phoenix");
        phoenix.setPrize(275);
        phoenix.setAttack(17f);
        phoenix.setDefense(13f);
        phoenix.setHealth(17f);
        phoenix.setSpeed(19f);
        phoenix.setTribe("Sunchild");

        // adding everything to the hashmap
        addCharacter("Basilisk", basilisk);
        addCharacter("Dragon", dragon);
        addCharacter("Hydra", hydra);
        addCharacter("Pegasus", pegasus);
        addCharacter("Phoenix", phoenix);
    }
}