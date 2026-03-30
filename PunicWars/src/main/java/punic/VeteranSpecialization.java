package punic;

public class VeteranSpecialization implements WarriorSpecialization {
    @Override
    public String getSpecializationName() {
        return "Ветеран";
    }

    @Override
    public int getSpecialBonus() {
        return 5; // +5 к силе
    }

    @Override
    public String getSpecialAbility() {
        return "Контр-атака";
    }
}