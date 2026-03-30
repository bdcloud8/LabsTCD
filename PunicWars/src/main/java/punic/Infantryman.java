package punic;

public class Infantryman extends WarriorImpl {
    private WarriorSpecialization specialization;

    public Infantryman(WarriorSpecialization specialization) {
        this.type = "Пехотинец";
        this.health = 50 + (specialization != null ? specialization.getSpecialBonus() : 0);
        this.strength = 20;
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