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

- Informar si una tarjeta es válida para operar.

![image](https://user-images.githubusercontent.com/87986166/190922652-32b67526-9296-4113-a149-0a0e58cab4b2.png)

Al igual que en el punto anterior, lo hice a través de un método en la clase servicio:

![image](https://user-images.githubusercontent.com/87986166/190922667-fb21eac8-8f61-4ceb-85fd-281a631a8e9a.png)

- Identificar si una tarjeta es igual a otra.

Para este punto investigué (ya que ignoro muchas cosas sobre tarjetas de crédito o débito), y en teoría no existen dos tarjetas con el mismo número de tarjeta. Así que simplemente sobreescribí los métodos equals y hash code para que ambos métodos tengan en cuenta el número de tarjeta para determinar si dos tarjetas son iguales o no:

![image](https://user-images.githubusercontent.com/87986166/190922827-b07e25fd-40cd-4e1f-bc6a-8507a30ca3fa.png)

Equals & Hash code:

![image](https://user-images.githubusercontent.com/87986166/190922952-e1e9c4a2-ae68-4215-8d28-1687eb756fd5.png)

También se podrían haber incluido, junto con el número de tarjeta, la fecha de expiración y el card holder a la hora de validar si son la misma tarjeta.

- Obtener la tasa de una operación informando marca e importe. 

Veamos primero la clase Operation:

![image](https://user-images.githubusercontent.com/87986166/190923115-9edbba5a-7230-49c7-a982-a345bbf69106.png)

Está compuesta por el monto y por la tarjeta que está operando.

Así que, con esos datos creé un método que devolviera un String informando la marca de la tarjeta, el importe, la tasa de interés, y el total:

Método: 

![image](https://user-images.githubusercontent.com/87986166/190923196-8725be21-0cd3-48e2-b52c-043effcc8f2c.png)

Llamando al método:

![image](https://user-images.githubusercontent.com/87986166/190923091-f6c8c131-e5d5-4e29-b042-adee7b8063e1.png)

Otra forma de hacerlo, sería que la clase Operation tuviera un atributos más, el total, entonces, en vez de devolver un String, devolveríamos un objeto Operación con todos los datos.

Resultado:

Dado estos objetos 

![image](https://user-images.githubusercontent.com/87986166/190923367-ef706834-b702-4814-b854-8c18cce1cd2b.png)

Obtendremos lo siguiente por pantalla:

![image](https://user-images.githubusercontent.com/87986166/190923392-35302b83-9251-4fa9-a4af-534988055023.png)

A través de operaciones ternarias, se imprimirá una cosa u otra:

![image](https://user-images.githubusercontent.com/87986166/190923512-4ce2c0eb-57fb-4714-afbb-fc5765162979.png)


También podríamos lanzar una excepción en caso de que una operación no sea válida o la tarjeta haya expirado:

