package TemplateMethod;

public class Fighter {
    private final int id;
    private final int maxHealth;
    private int currentHealth;

    public Fighter(int id, int maxHealth) {
        this.id = id;
        this.maxHealth = maxHealth;
        this.currentHealth = maxHealth;
    }

    public String getStatus() {
        return "Fighter " + id + ": " + currentHealth + "/" + maxHealth + " HP";
    }

    public void takeDamage(int damage) {
        currentHealth -= damage;
        if (currentHealth < 0) {
            currentHealth = 0;
        }
    }

    public boolean isDead() {
        return currentHealth <= 0;
    }
}
