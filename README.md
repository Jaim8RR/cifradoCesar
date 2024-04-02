## Resolucion del los Ejercicios 10,11 y 12.  

### 10.- Cifrado César (https://es.wikipedia.org/wiki/Cifrado_C%C3%A9sar)
En criptografía, el cifrado César, también conocido como cifrado por desplazamiento, código de
César o desplazamiento de César, es una de las técnicas de cifrado más simples y más
usadas. Es un tipo de cifrado por sustitución en el que una letra en el texto original es
reemplazada por otra letra que se encuentra un número fijo de posiciones más adelante en el
alfabeto. Por ejemplo, con un desplazamiento de 3, la A sería sustituida por la D (situada 3
lugares a la derecha de la A), la B sería reemplazada por la E, etc. Este método debe su
nombre a Julio César, que lo usaba para comunicarse con sus generales.
Haz un programa java que recoja como parámetros de su método main, un primer parámetro
con un fichero de texto, y posteriormente un número (que se corresponderá con el
desplazamiento para el cifrado). Este programa deberá cifrar el texto y con el resultado escribir
un fichero nuevo (con el mismo nombre pero con extensión .cfr).

### 11.- Descifrado César
Haz un programa java que reciba como parámetros un fichero de texto y un desplazamiento.
Deberá realizar el descifrado y enviar el resultado a un fichero (con el mismo nombre pero con
extensión .uncfr).

### 12.- Descifrado César sin clave
Igual que el anterior, pero sólo recibirás el nombre del fichero a descifrar.
Para descifrar un texto cifrado, es necesario conocer el desplazamiento con el que se codificó
para recuperar la letra. No obstante, si no se conoce dicho desplazamiento, se puede deducir.
Si el texto está en español se sabe que, estadísticamente, la letra que más se utiliza es la letra
“e” (tanto mayúscula como minúscula). Por tanto, se puede asumir que la letra que más
aparece en el texto cifrado es la representación de la “e” y con ello deducir el desplazamiento.

####EJ: https://github.com/Jaim8RR/cifradoCesar/blob/main/txt.zip
