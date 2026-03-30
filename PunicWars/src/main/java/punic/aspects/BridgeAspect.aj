package punic.aspects;

import punic.*;

public aspect BridgeAspect {

    // Добавляем поле specialization каждому Warrior
    private WarriorSpecialization Warrior.specialization;

    // Добавляем setter через inter-type declaration
    public void Warrior.setSpecialization(WarriorSpecialization spec) {
        this.specialization = spec;
    }

    // Добавляем getter через inter-type declaration
    public WarriorSpecialization Warrior.getSpecializationObject() {
        return this.specialization;
    }

    // Перехватываем вызов getSpecialization и возвращаем название
    public String Warrior.getSpecialization() {
        if (specialization != null) {
            return specialization.getSpecializationName();
        } else {
            return "Без специализации";
        }
    }

    public int Warrior.getSpecialBonus() {
        if (specialization != null) {
            return specialization.getSpecialBonus();
        }
        return 0;
    }

    public String Warrior.getSpecialAbility() {
        if (specialization != null) {
            return specialization.getSpecialAbility();
        }
        return "Нет способности";
    }
}