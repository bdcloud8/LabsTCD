package punic.aspects;

import punic.*;

public aspect BattleMediatorAspect {

    private BattleMediator mediator = new BattleMediator();

    // Перехватываем атаку
    pointcut attackExecution(Warrior attacker, Warrior target):
        execution(void punic.Warrior.attack(punic.Warrior)) &&
        this(attacker) &&
        args(target);

    // Полностью заменяем логику атаки
    void around(Warrior attacker, Warrior target): attackExecution(attacker, target) {

        System.out.println("=== Аспект Mediator контролирует атаку ===");

        if (attacker.isAlive() && target.isAlive()) {
            mediator.initiateAttack(attacker, target);
        } else {
            System.out.println("Атака невозможна: один из воинов мертв");
        }
    }

    // Перехват урона
    after(Warrior target, int damage):
        execution(void punic.Warrior.takeDamage(int)) &&
        this(target) &&
        args(damage) {

        mediator.notifyDamage(target, damage);
    }
}