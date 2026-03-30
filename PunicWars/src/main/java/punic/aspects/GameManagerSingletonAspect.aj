package punic.aspects;

import punic.GameManager;

public aspect GameManagerSingletonAspect {

    // Храним единственный экземпляр
    private GameManager instance;

    // Перехватываем вызовы конструктора
    pointcut gameManagerCreation():
        call(punic.GameManager.new(..));

    // Контролируем создание объекта
    Object around(): gameManagerCreation() {
        if (instance == null) {
            System.out.println("Создание Singleton через аспект");
            instance = (GameManager) proceed();
        } else {
            System.out.println("Возврат существующего Singleton через аспект");
        }
        return instance;
    }
}