```
___  ___          _   _         ___  ___            _                    
|  \/  |         | | (_)        |  \/  |           | |                   
| .  . |_   _ ___| |_ _  ___    | .  . | __ _ _   _| |__   ___ _ __ ___  
| |\/| | | | / __| __| |/ __|   | |\/| |/ _` | | | | '_ \ / _ \ '_ ` _ \ 
| |  | | |_| \__ \ |_| | (__    | |  | | (_| | |_| | | | |  __/ | | | | |
\_|  |_/\__, |___/\__|_|\___|   \_|  |_/\__,_|\__, |_| |_|\___|_| |_| |_|
         __/ |                                 __/ |                     
        |___/                                 |___/
```

A CLI, turn based fantasy battle game. Created as a project under **CS1040**

# Installation


# How to Play

## Interfaces 

- You have to access the menus of your game in sequential manner
- In each menu, you can enter the respective number of operation that you want to do.

>[!warning]
>Make sure to give the proper **integer value** as the input for the apt situation.

### Start Menu

### Market Menu

```
----------------------------
Welcome to the Market Place!
----------------------------
What you want to do today? Please select an option: 
    1. Buy Army or Equipment
    2. Sell Army
    3. Check the balance of your gold coins
    4. Exit
Please enter the corresponding number: (1/2/3/4)
```

This is the kind of the interface of the Market menu.
1. For buying related operations
	- Re-directs the user to the market menu if the user is not eligible to buy the respective army or the equipment.
	- When buying new equipment for character, the already present equipment will be discarded(**no refunding**).
2. Selling Army
	- We can choose the  character that we already have, to sell. And the **refunding** happens when we replace the character.
3. Checking  the balance
	- Prints out the current gold coins of the player.
4. Exist
	- Exits out of the market and goes to the [Game Menu](#game-menu).
### Battle Menu
System.out.println("___  ___          _   _         ___  ___            _                    ");
System.out.println("|  \\/  |         | | (_)        |  \\/  |           | |                   ");
System.out.println("| .  . |_   _ ___| |_ _  ___    | .  . | __ _ _   _| |__   ___ _ __ ___  ");
System.out.println("| |\\/| | | | / __| __| |/ __|   | |\\/| |/ _` | | | | '_ \\ / _ \\ '_ ` _ \\ ");
System.out.println("| |  | | |_| \\__ \\ |_| | (__    | |  | | (_| | |_| | | | |  __/ | | | | |");
System.out.println("\\_|  |_/\\__, |___/\\__|_|\\___|   \\_|  |_/\\__,_|\\__, |_| |_|\\___|_| |_| |_|");
System.out.println("         __/ |                                 __/ |                     ");
System.out.println("        |___/                                 |___/                      ");
### <a name="game-menu"></a>Game Menu

## Game Flow

# How the Project is strucutured



