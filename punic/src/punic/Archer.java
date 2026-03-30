package punic;

public class Archer extends WarriorImpl {
    private WarriorSpecialization specialization;

    public Archer(WarriorSpecialization specialization) {
        this.type = "Лучник";
        this.health = 30 + (specialization != null ? specialization.getSpecialBonus() : 0);
        this.strength = 15;
        this.specialization = specialization;
    }

    @Override
    public String getSpecialization() {
        return specialization != null ? specialization.getSpecializationName() : "Обычный";
    }

    @Override
    public void info() {
        super.info();
        if (specialization != null) {
            System.out.println("  Специализация: " + specialization.getSpecializationName() +
                    " (" + specialization.getSpecialAbility() + ")");
        }
    }
}