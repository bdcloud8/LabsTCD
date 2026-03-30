package punic;

public class Horseman extends WarriorImpl {
    private WarriorSpecialization specialization;

    public Horseman(WarriorSpecialization specialization) {
        this.type = "Всадник";
        this.health = 40 + (specialization != null ? specialization.getSpecialBonus() : 0);
        this.strength = 25;
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