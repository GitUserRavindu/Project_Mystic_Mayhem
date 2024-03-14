package core;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import gameutils.Utils;

import java.io.IOException;

public class SaveGame {
    private static final String FILE_PATH = "PlayerManagerData.ser"; // File name where the data will be saved

    // Method to serialize (save) the PlayerManager instance
    public static void saveGame(PlayerManager pm) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(FILE_PATH))) {
            out.writeObject(pm);
            System.out.println("Game data saved successfully.");
        } catch (IOException e) {
            System.out.println("An error occurred while saving the game data: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // Method to deserialize (load) the PlayerManager instance
    public static PlayerManager loadGame() {
        PlayerManager pm = null;
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(FILE_PATH))) {
            pm = (PlayerManager) in.readObject();
            System.out.println("Game data loaded successfully.");
        } catch (IOException e) {
            System.out.println("An error occurred while loading the game data: " + e.getMessage());
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("PlayerManager class not found: " + e.getMessage());
            e.printStackTrace();
        }
        return pm;
    }

    public static boolean saveExists() {
        File file = new File(FILE_PATH);
        return file.exists() && !file.isDirectory();
    }

    public static boolean checkSave() {
        if (saveExists()) {
            String choice = Utils.readString("A saved game was found. Do you want to load it? (Y/N)");
            if (choice.toUpperCase().equals("Y")) {
                return true;
            }
        }
        return false;
    }
}