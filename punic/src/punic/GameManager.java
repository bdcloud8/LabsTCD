package punic;

public class GameManager {
    // Единственный экземпляр (Singleton)
    private static GameManager instance;

    private int score = 0;
    private int round = 1;
    private boolean gameRunning = false;
    private BattleMediator battleMediator;

    // Приватный конструктор
    private GameManager() {
        System.out.println("Game Manager создан (Singleton)");
    }

    // Глобальная точка доступа
    public static GameManager getInstance() {
        if (instance == null) {
            instance = new GameManager();
        }
        return instance;
    }

    public void startGame() {
        gameRunning = true;
        System.out.println("=== Игра 'Пунические войны' началась! ===");
        System.out.println("Используется паттерн Singleton для управления игрой");
    }

    public void endGame() {
        gameRunning = false;
        System.out.println("=== Игра завершена ===");
        System.out.println("Финальный счет: " + score);
    }

    public void addScore(int points) {
        score += points;
        System.out.println("Счет увеличен на " + points + ". Текущий счет: " + score);
    }

    public void nextRound() {
        round++;
        System.out.println("=== Раунд " + round + " ===");
    }

    public boolean isGameRunning() {
        return gameRunning;
    }

    public void setBattleMediator(BattleMediator mediator) {
        this.battleMediator = mediator;
    }

    public BattleMediator getBattleMediator() {
        return battleMediator;
    }
}