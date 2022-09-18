package ExerciseOne;

import ExerciseOne.enumerations.Brand;
import ExerciseOne.exceptions.AmountInvalidException;
import ExerciseOne.models.Card;
import ExerciseOne.models.Operation;
import ExerciseOne.service.OperationService;

import java.time.LocalDate;

public class Application {

    public static void main(String[] args) {

        // Creación de objetos

        Card card = new Card(Brand.VISA, 123456789123456L, "Maximiliano Falcone", LocalDate.of(2023, 9, 17));

        Card card2 = new Card(Brand.VISA, 12345678913456L, "Maximiliano Falcone", LocalDate.of(2023, 9, 17));

        Operation operation = new Operation(card, 9299d);

        // Toda la información de una tarjeta

        String informationCard = card.toString();

        // Devuelve true si la operación es válida, es decir si el monto es menor a 1000 pesos.

        boolean isAValidOperation = OperationService.isValidOperation(operation);

        // Devuelve true si la tarjeta es válida para operar, es decir si no ha expirado.

        boolean isAValidCard = OperationService.isValidCardToOperate(card);

        // Comprueba si una tarjeta es igual a otra

        boolean isTheSameCard = card.equals(card2);

        // El método traera la tasa de la operación, así como también la marca y el importe. Se lanzará una excepción si el valor del importe es 0.

        String interestRate = null;
        try {
            interestRate = OperationService.getInterestRate(operation);
        } catch (AmountInvalidException e) {
            throw new RuntimeException(e);
        }

        // Imprimiendo por pantalla todo lo requerido.

        System.out.println(informationCard);
        System.out.println("--------");

        System.out.println(isAValidOperation ? "La operación es válida."
                : "La operación no es válida ya que se ha consumido 1000 pesos o más.");

        System.out.println("--------");

        System.out.println(isAValidCard ? "Esta tarjeta es válida para operar."
                : "No puede operar con esta tarjeta debido a que ya ha expirado.");

        System.out.println("--------");

        System.out.println(isTheSameCard ? "Tarjetas iguales."
                : "Tarjetas diferentes.");

        System.out.println("--------");

        System.out.println(interestRate);


    }
}