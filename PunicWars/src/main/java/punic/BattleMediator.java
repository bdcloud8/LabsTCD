package punic;

import java.util.ArrayList;
import java.util.List;

public class BattleMediator {
    private List<Warrior> warriors = new ArrayList<>();
    private GameManager gameManager;

    public BattleMediator() {
        this.gameManager = new GameManager();
    }

    public void registerWarrior(Warrior warrior) {
        warriors.add(warrior);
    }

    public void initiateAttack(Warrior attacker, Warrior target) {
        if (!attacker.isAlive() || !target.isAlive()) {
            return;
        }

        System.out.println("\n--- Атака ---");
        System.out.println(attacker.getType() + " (" + attacker.getSpecialization() +
                ") атакует " + target.getType() + " (" + target.getSpecialization() + ")");

        int damage = calculateDamage(attacker, target);
        target.takeDamage(damage);

        // Обновляем счет через Singleton GameManager
        if (!target.isAlive()) {
            gameManager.addScore(10);
            System.out.println(target.getType() + " уничтожен! +10 очков");
        }
    }

    private int calculateDamage(Warrior attacker, Warrior target) {
        int baseDamage = attacker.getStrength();

        // Логика расчета урона в зависимости от типов
        if (attacker.getType().equals("Лучник") && target.getType().equals("Всадник")) {
            baseDamage += 5; // Лучники эффективны против конницы
            System.out.println("  Лучник эффективен против всадников! +5 урона");
        } else if (attacker.getType().equals("Всадник") && target.getType().equals("Пехотинец")) {
            baseDamage += 3; // Конница эффективна против пехоты
            System.out.println("  Всадник эффективен против пехоты! +3 урона");
        }

        return baseDamage;
    }

    public void notifyDamage(Warrior warrior, int damage) {
        System.out.println("  " + warrior.getType() + " получает " + damage + " урона");
        System.out.println("  Осталось здоровья: " + warrior.getHealth());
    }

    public Warrior findNearestEnemy(Warrior warrior, String enemyType) {
        // Упрощенная логика поиска ближайшего врага
        for (Warrior w : warriors) {
            if (w != warrior && w.isAlive() &&
                    (enemyType == null || w.getType().equals(enemyType))) {
                return w;
            }
        }
        return null;
    }

    public void displayBattleStatus() {
        System.out.println("\n=== Статус битвы ===");
        int aliveCount = 0;
        for (Warrior w : warriors) {
            if (w.isAlive()) {
                aliveCount++;
                w.info();
            }
        }
        System.out.println("Всего воинов в бою: " + aliveCount);
    }
}