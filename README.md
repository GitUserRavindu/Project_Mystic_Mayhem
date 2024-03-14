## Mystic Mayhem

core
    GameItem - Items like Characters and Equipment, contains basic getters, setters and maybe printers
    Player - Player objects, storing their details and army
    Army - Probably deleting this and replace with the Combat class, army HashMap directly in character
    HomeGround - Maybe we need this, maybe we don't
    PlayerManager - Creating new players, soting player details, finding players to battle

gameutils
    Console - Printing Messages to like game state, item details, and prompting player for inputs
    Utils - Utility functions like read a string prom user given a prompt, print a String[]
    SaveGame -
    GameLogic -

characters
    CharacterManager - Factory class for making characters (or Prototype implementation?)
    Character - Extends Game items, fields specific to Characters like armor and artifact, methods like attackCharacter()
    Archer, Knight, ... - overrides category
    Archer1, Archer2 ... - Sets base stats (overrides init method), and changes Name like Shooter, Ranger

Equipment
    EquipmentManager -
    