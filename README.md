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

## How to Play

- You have to access the menus of your game in sequential manner.
- In each menu, you can enter the respective number of operation that you want to do.
- During the start of game, you many choose whether to continue your progress or just to start a new game.

>[!warning]
>Make sure to give the proper **integer value** as the input for the apt situation.

### <a name="game-menu"></a>Game Menu

```
---------------------------------------
|            Main Menu                |
---------------------------------------
    1. Select a Profile
    2. Create a New Profile
    3. See your current Profile
    4. See your Army Details
    5. Change your Name
    6. Visit Market Place
    7. Start a New Battle
    8. Quit Game
---------------------------------------
Enter the number of the option you want to select: 

```

>[!note]
> If you are stating new game, you have to create a player profile to continue playing.

1. Profile Selection
	- Selects the player profile to work with.
2. Profile Creation
	- Creates a new player profile with sequential prompts.
3. Displays current profile stats
4. Displays current army stats
5. Prompts the **name change** menu
6. Goes to market menu
	- Redirects to [Market Menu](#market-menu).

### <a name="market-menu"></a>Market Menu

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

### <a name="battle-menu"></a> Battle Menu

```
-------------------------------
Select an opponent to Battle : 
-------------------------------

Random opponent selected
------------------------
    Opponent        : GeraltofRivia
    Opponent's XP   : 32.0

What do you want to do?
    1. Challenge this opponent
    2. Skip to another opponent
    3. Go back
Please enter the corresponding option : (1/2/3)
```

Once the player wants to battle, he enters this menu.

>[!note]
>The matchmaking procedure is, selecting a **random player**  from the player profiles that already exists in the game's database.

1. Start battle with current player 
2. Skip the battle
	- Matchmaking starts again with the next player.
3. Canceling the battle, and going back to the [Main Menu](#game-menu)
