package punic;

public class GameManager {

    private int score = 0;
    private int round = 1;
    private boolean gameRunning = false;
    private BattleMediator battleMediator;

    public GameManager() {
        System.out.println("Game Manager создан (обычный класс)");
    }

    public void startGame() {
        gameRunning = true;
        System.out.println("=== Игра 'Пунические войны' началась! ===");
        System.out.println("Singleton теперь реализован через AspectJ");
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