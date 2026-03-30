package punic;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Пунические войны ===\n");

        GameManager game = GameManager.getInstance();
        game.startGame();


        // Создаем специализации
        WarriorSpecialization elite = new EliteSpecialization();
        WarriorSpecialization veteran = new VeteranSpecialization();

        // Создаем воинов с разными специализациями (Bridge)
        Warrior archer1 = new Archer(elite);
        Warrior archer2 = new Archer(veteran);
        Warrior infantry1 = new Infantryman(elite);
        Warrior infantry2 = new Infantryman(null); // Без специализации
        Warrior horseman1 = new Horseman(veteran);
        Warrior horseman2 = new Horseman(null); // Без специализации

        // 3. Демонстрация Mediator (ЛР6)
        BattleMediator mediator = new BattleMediator();
        game.setBattleMediator(mediator);

        // Регистрируем воинов у посредника
        mediator.registerWarrior(archer1);
        mediator.registerWarrior(archer2);
        mediator.registerWarrior(infantry1);
        mediator.registerWarrior(infantry2);
        mediator.registerWarrior(horseman1);
        mediator.registerWarrior(horseman2);

        // Устанавливаем позиции
        archer1.setPosition(10, 20);
        archer2.setPosition(15, 25);
        infantry1.setPosition(30, 40);
        infantry2.setPosition(35, 45);
        horseman1.setPosition(50, 60);
        horseman2.setPosition(55, 65);

        // Показываем начальный статус
        mediator.displayBattleStatus();

        // Симулируем бой через посредника
        System.out.println("\n4. СИМУЛЯЦИЯ БОЯ:");

        // Атаки через посредника
        archer1.attack(horseman1);  // Лучник атакует всадника
        infantry1.attack(archer2);   // Пехотинец атакует лучника
        horseman1.attack(infantry1); // Всадник атакует пехотинца

        // Показываем статус после боя
        mediator.displayBattleStatus();

        // 5. Раунд 2
        game.nextRound();
        System.out.println("\n5. РАУНД 2:");

        archer2.attack(horseman2);
        horseman2.attack(infantry2);

        mediator.displayBattleStatus();

        // Завершаем игру
        game.endGame();

        /*
        Singleton: Единственный GameManager управляет игрой
        Bridge: Воины и их специализации разделены
        Mediator: BattleMediator управляет всеми взаимодействиями
        */
    }
}