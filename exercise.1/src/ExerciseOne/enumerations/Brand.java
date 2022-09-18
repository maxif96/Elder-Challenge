package ExerciseOne.enumerations;

import java.time.LocalDate;

public enum Brand {

    VISA((LocalDate.now().getYear() - 2000d) / LocalDate.now().getMonthValue()),
    NARA(LocalDate.now().getDayOfMonth() * 0.5),
    AMEX(LocalDate.now().getMonthValue() * 0.1);

    private final double interest;

    private Brand (double interest){
        this.interest = interest;
    }

    public double getInterest(){
        return this.interest;
    }

}
