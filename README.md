# Elder-Challenge

Hola! Estos son los ejercicios 1,2 y 5 del Challenge Técnico para Eldar

Voy a tratar de explicar un poco como funciona lo que hice, y explicar el por qué lo hice de x manera y tratar de aclarar posibles dudas.

## Ejercicio 1

En este ejercicio debía crear una clase ejecutable que pudiera hacer lo siguiente: 

- Invocar un método que devuelva toda la información de una tarjeta.

```
  String informationCard = card.toString();
```

Me pareció lo más óptimo simplemente sobreescribir el método ToString dentro de la clase Card:


![image](https://user-images.githubusercontent.com/87986166/190922577-a66343ea-b010-43ae-9ac7-9a74f1b61ce0.png)

- Informar si una operación es válida.

![image](https://user-images.githubusercontent.com/87986166/190922464-9e151d42-3933-4b9d-aa80-3c9a3899de73.png)

Para eso creé un método que valide si una operación es válida dentro del servicio llamado OperationService. Este método se ve así:

![image](https://user-images.githubusercontent.com/87986166/190922563-285b5858-980a-4005-bec9-b6b387d1ffce.png)

