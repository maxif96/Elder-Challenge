package ExerciseOne.service;

import ExerciseOne.exceptions.AmountInvalidException;
import ExerciseOne.models.Card;
import ExerciseOne.models.Operation;

import java.time.LocalDate;

public class OperationService {

    public static boolean isValidOperation(Operation operation) {
        return operation.getAmount() < 1000 && operation.getAmount() > 0;
    }

    public static boolean isValidCardToOperate(Card card) {
        return card.getExpirationDate().isAfter(LocalDate.now());
    }

    public static String getInterestRate(Operation operation) throws AmountInvalidException {
        if (operation.getAmount() < 1) throw new AmountInvalidException("El monto debe ser mayor a 0");

        double amount = operation.getAmount();
        double interestRate = operation.getCard().getBrand().getInterest();
        double total = amount + (amount * interestRate / 100);

        return "--- Operation Resume ---" +
                "\n Card Brand: " + operation.getCard().getBrand() +
                "\n Amount: " + amount +
                "\n Interest Rate: " + interestRate +
                "\n Total Amount: " + total;
    }

}
