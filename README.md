# Elder-Challenge

Hola! Estos son los ejercicios 1,2 y 5 del Challenge Técnico para Eldar

Voy a tratar de explicar un poco como funciona lo que hice, y explicar el por qué lo hice de x manera y tratar de aclarar posibles dudas.

## Ejercicio 1

El tema de los intereses lo trabajé con un Enum de la siguiente manera:

![image](https://user-images.githubusercontent.com/87986166/190923937-fb82d89c-a342-46a7-b7f8-781bcefc0ba5.png)

Así, el programa es escalable con el tiempo, ya que si se quieren agregar más marcas, solamente habría que añadirlas en este Enum, junto con su respectiva forma de calcular la tasa de interés.

En este ejercicio debía crear una clase ejecutable que pudiera hacer lo siguiente: 

- Invocar un método que devuelva toda la información de una tarjeta.

![image](https://user-images.githubusercontent.com/87986166/190923720-a1b6b8ee-c50a-422e-a8e5-322a2b752faf.png)


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

### Resultado:

Dado estos objetos 

![image](https://user-images.githubusercontent.com/87986166/190923367-ef706834-b702-4814-b854-8c18cce1cd2b.png)

Obtendremos lo siguiente por pantalla:

![image](https://user-images.githubusercontent.com/87986166/190923392-35302b83-9251-4fa9-a4af-534988055023.png)

A través de operaciones ternarias, se imprimirá una cosa u otra:

![image](https://user-images.githubusercontent.com/87986166/190923548-be6b14d1-9394-40e4-a137-44f66c6f1177.png)

Esto es ilustrativo, es decir, si la operación no es valida solamente se está informando por pantalla, pero podríamos lanzar una excepción para abortar la ejecución de la operación:

![image](https://user-images.githubusercontent.com/87986166/190923674-9671ffa8-df3f-435c-86d8-eba77c7e6129.png)


![image](https://user-images.githubusercontent.com/87986166/190923651-d1e746e8-521d-4821-97e8-63985a9c28b6.png)


## Ejercicio 2

Debía crear una API Rest que reciba y responda en formato JSON, que permita consultar la tasa de una operación, informando marca de la tarjeta e importe.

Estructura:

![image](https://user-images.githubusercontent.com/87986166/190924004-cb16c45f-b50c-482d-b5e7-fec31ad2db37.png)

Creé dos entidades, Card y Operation, junto con un Enum para las marcas de las tarjetas y sus intereses

Card y Operation tienen una relación de ManyToOne, es decir una tarjeta puede realizar muchas operaciones, a su vez, una operación solo opera con una tarjeta.

Para poder consultar la tasa de una operación, junto con la tarjeta y el importe, es necesario que esté creada esa operación, así que creé un endpoint en OperationController que recibe un OperationRequestDTO que será guardado, y devuelve un OperationResponseDTO. Pero antes de crear una operación, es necesario haber creado una tarjeta primero para indicarle a la operación con qué tarjeta se operará, así que hice lo propio en CardController.

Así que veamos como se ve crear una operación en Postman: 

Para hacerlo, necesitamos mandar un JSON con el id de la tarjeta que va a operar, junto con el monto:

![image](https://user-images.githubusercontent.com/87986166/190924340-3f7fbc34-18fc-4784-90c4-253725dcb8f7.png)

Como podemos ver, solo en la respuesta a la creación de una operación obtenemos la tasa de la operación, marca de la tarjete, importe e importe total.

Podemos acceder a una operación ya creada y nos brindará los mismos datos:

![image](https://user-images.githubusercontent.com/87986166/190924435-6732e81e-3197-4cdf-87d7-5ccdf96481ea.png)

(Por alguna razón Postman se me ve con baja calidad, pido disculpas si no se aprecia bien)

Las request cuentan con validaciones como ser que el Cardholder no puede estar vacío:

![image](https://user-images.githubusercontent.com/87986166/190924506-3eca6132-9c4d-4551-b87f-9ec31867004f.png)

También se manejan las respectivas excepciones en caso de que una operación sea inválida (sea mayor a 1000) o que una tarjeta ya haya expirado. Estas excepciones están manejadas a través de un GlobalExceptionHandler, a través del cuál especifico que código de respuesta HTTP quiero retornar:

![image](https://user-images.githubusercontent.com/87986166/190924571-4ac7423b-f41a-4057-a505-fbe7d39a015b.png)

Como se puede ver, creé clases de excepciones específicas para cada tipo de error (Tarjeta expirada, monto incorrecto, marca inexistente, etc), ello para una mejor legibilidad y entendimiento del código.

Este es el save de Operation en el servicio:

![image](https://user-images.githubusercontent.com/87986166/190924649-ff297d06-2a66-4bac-bce6-c0e79d559a80.png)

Y este es el método que valida que todo esté correcto:

![image](https://user-images.githubusercontent.com/87986166/190924697-0a9405c7-76a6-4a03-ab41-d24a6c4d7c9f.png)

No realicé el CRUD completo porque creo que no era necesario para este ejercicio.

## Ejercicio 5

Realizado con programación funcional:

![image](https://user-images.githubusercontent.com/87986166/190924848-1a80b8ad-c5bd-4bc8-af80-3f3607381025.png)

Recorro el array y a cada elemento lo convierto en minúscula, en la parte del map referencio al método toLowerCase() de la clase String, lo cual es lo mismo a: word -> word.toLowerCase()
Finalizo recolectando con un joining que devuelve un String, y le indico que separe cada palabra con un espacio en blanco.

