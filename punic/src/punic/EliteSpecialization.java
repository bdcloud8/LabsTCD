package punic;

public class EliteSpecialization implements WarriorSpecialization {
    @Override
    public String getSpecializationName() {
        return "Элитный";
    }

    @Override
    public int getSpecialBonus() {
        return 10; // +10 к здоровью
    }

    @Override
    public String getSpecialAbility() {
        return "Двойная атака";
    }
}