package Core;

import java.util.ArrayList;
import java.util.HashMap;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.IOException;
import java.io.Serializable;

import Utils.ScannerUtil;

public class GameSaveManager implements Serializable {

    private int profileCount;
    private ArrayList<String> userNameList = new ArrayList<String>();
    private HashMap<Integer, Player> playerMap = new HashMap<Integer, Player>();

    public GameSaveManager() {}

    public void saveGameInsructions() {
        System.out.println("---------------------------------------------");
        System.out.println("-> Preserve your progress for future battles!");
        System.out.println("-> Do you want to save the game? (y/n)");
        System.out.println("---------------------------------------------\n");

        String save = ScannerUtil.scanner.nextLine();

        if (save.isEmpty()) {
            save = ScannerUtil.scanner.nextLine();
        }

        if (save.equals("y") || save.equals("Y")) {
            saveGame();
        }
        else {
            System.out.println("Game not saved. Exiting...\n");
        }
    }

    public void saveGame() {
        this.profileCount = Profile.getProfileCount();
        this.userNameList = Profile.getUserNameList();
        this.playerMap = Profile.getPlayerMap();

        try {
            FileOutputStream savefile = new FileOutputStream("GameSave.ser");
            ObjectOutputStream saveObj = new ObjectOutputStream(savefile);
            saveObj.writeObject(this);
            saveObj.close();
            System.out.println("Game saved successfully! Exiting...\n");
        } catch (IOException e) {
            System.out.println("Error: " + e);
            e.printStackTrace();
            System.out.println("Unsuccessful, Game not saved. Exiting...\n");
        } catch (Exception e) {
            System.out.println("Error: " + e);
            e.printStackTrace();
            System.out.println("Unsuccessful, Game not saved. Exiting...\n");
        }
    }

    public void loadGameInstructions() {
        System.out.println("-----------------------------------------------");
        System.out.println("-> Embark on your adventure where you left off!");
        System.out.println("-> Do you want to load the saved game? (y/n)");
        System.out.println("-----------------------------------------------\n");

        String load = ScannerUtil.scanner.nextLine();

        if (load.isEmpty()) {
            load = ScannerUtil.scanner.nextLine();
        }

        if (load.equals("y") || load.equals("Y")) {
            loadGame();
        }
        else {
            System.out.println("Game not loaded. Exiting...\n");
        }
    }

    public void loadGame() {
        try {
            FileInputStream loadfile = new FileInputStream("GameSave.ser");
            ObjectInputStream loadObj = new ObjectInputStream(loadfile);
            GameSaveManager loadedGame = (GameSaveManager) loadObj.readObject();
            loadObj.close();
            Profile.setProfileCount(loadedGame.profileCount);
            Profile.setUserNameList(loadedGame.userNameList);
            Profile.setPlayerMap(loadedGame.playerMap);

            for (Player p : loadedGame.playerMap.values()) {
                p.setHomeGroundInGameLoad(p.getHomeGroundName());
            }

            System.out.println("Game loaded successfully! Exiting...\n");
        } catch (IOException e) {
            System.out.println("Error: " + e);
            e.printStackTrace();
            System.out.println("Unsuccessful, Game not loaded. Exiting...\n");
        } catch (ClassNotFoundException e) {
            System.out.println("Error: " + e);
            e.printStackTrace();
            System.out.println("Unsuccessful, Game not loaded. Exiting...\n");
        } catch (Exception e) {
            System.out.println("Error: " + e);
            e.printStackTrace();
            System.out.println("Unsuccessful, Game not loaded. Exiting...\n");
        }
    }

}
