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


![carbon(4)](https://user-images.githubusercontent.com/87986166/190922395-83fa29f7-07df-4bf3-a930-8d00df20dbc3.png)

- Informar si una operación es válida.

![image](https://user-images.githubusercontent.com/87986166/190922464-9e151d42-3933-4b9d-aa80-3c9a3899de73.png)

Para eso creé un método que valide si una operación es válida dentro del servicio llamado OperationService. Este método se ve así:

![image](https://user-images.githubusercontent.com/87986166/190922520-982a7caf-826b-4ea6-b568-cf8e1d641bf6.png)

