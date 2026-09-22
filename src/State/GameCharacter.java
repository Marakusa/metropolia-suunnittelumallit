package State;

public class GameCharacter {

    private String name;
    private int level;
    private int experience;
    private int health;

    private CharacterState state;

    public GameCharacter(String name) {
        this.name = name;
        this.level = 1;
        this.experience = 0;
        this.health = 100;

        this.state = new NoviceState(this);
    }

    public void train() {
        state.train();
    }

    public void meditate() {
        state.meditate();
    }

    public void fight() {
        state.fight();
    }

    public void setState(CharacterState state) {
        this.state = state;
    }

    public CharacterState getState() {
        return state;
    }

    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    public int getExperience() {
        return experience;
    }

    public int getHealth() {
        return health;
    }

    public void addExperience(int amount) {
        experience += amount;
    }

    public void addHealth(int amount) {
        health += amount;

        if (health > 100) {
            health = 100;
        }
    }

    public void removeHealth(int amount) {
        health -= amount;

        if (health < 0) {
            health = 0;
        }
    }

    public void increaseLevel() {
        level++;
    }

    public void showStatus() {
        System.out.println();
        System.out.println("=================================");
        System.out.println("Character: " + name);
        System.out.println("Level:     " + state.getLevel());
        System.out.println("Level No:  " + level);
        System.out.println("Experience: " + experience);
        System.out.println("Health:     " + health + "/100");
        System.out.println("=================================");

        state.showAvailableActions();
        System.out.println();
    }
}
