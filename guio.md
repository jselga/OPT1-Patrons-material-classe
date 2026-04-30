# Tutorial: Conversor de temperatures amb Java Swing i NetBeans

## Objectiu

Crear una aplicació gràfica senzilla amb Java Swing i l'editor visual de NetBeans que converteixi una temperatura en graus Celsius a graus Fahrenheit.

## Resultat esperat

L'aplicació ha de tenir:

- un camp de text per introduir la temperatura en Celsius
- un botó per executar la conversió
- una etiqueta per mostrar el resultat en Fahrenheit

## Abans de començar

Cal tenir:

- NetBeans instal·lat
- un JDK configurat correctament
- nocions bàsiques de projecte Java

## 1. Crear el projecte

1. Obre NetBeans.
2. Ves a `File > New Project`.
3. Selecciona:
   - `Categories`: `Java`
   - `Projects`: `Java Application`
4. Fes clic a `Next`.
5. Escriu el nom del projecte:
   - `ConversorTemperatures`
6. Tria la ubicació on es guardarà.
7. Desmarca l'opció `Create Main Class`.
8. Fes clic a `Finish`.

## 2. Crear la finestra principal

1. Fes clic dret sobre el projecte.
2. Selecciona `New > JFrame Form`.
3. Escriu el nom de la classe:
   - `ConversorGUI`
4. Fes clic a `Finish`.

Aquesta classe serà la finestra principal de l'aplicació.

## 3. Configurar la finestra

1. Selecciona el `JFrame` a l'Inspector.
2. A la finestra de propietats, canvia el títol (`title`) a:
   - `Conversor Celsius`

## 4. Afegir els components

Des de la paleta de components, arrossega aquests elements a la finestra:

- `JTextField`
- `JLabel`
- `JButton`
- `JLabel`

Organitza'ls de manera que quedi:

- el camp de text a la part superior esquerra
- una etiqueta a la seva dreta amb el text `Celsius`
- el botó a sota del camp de text
- una altra etiqueta a la dreta del botó per mostrar el resultat

## 5. Canviar el text dels components

Canvia el text visible dels components:

- `JTextField`: deixa'l buit
- `JButton`: `Convertir`
- `JLabel` superior: `Celsius`
- `JLabel` inferior: `Fahrenheit`

Per fer-ho a NetBeans:

1. Fes doble clic sobre cada component a l'àrea de disseny.
2. Modifica el text que surt per defecte.
3. En el cas del `JTextField`, esborra el text inicial perquè el camp quedi buit.
4. En el cas del `JButton`, substitueix el text per `Convertir`.

També ho pots fer des de la finestra de propietats, modificant la propietat `text` del component seleccionat.

Nota important:

- quan esborres el text del `JTextField`, NetBeans pot reduir-ne l'amplada automàticament
- si això passa, selecciona el `JTextField` i el `JButton` alhora fent `Shift + clic`
- després fes clic dret i tria `Same Size > Same Width`

Així el camp de text i el botó quedaran alineats i amb una amplada semblant.

## 6. Posar noms de variable útils

Canvia el nom de les variables dels components des de l'Inspector:

- `tempTextField`
- `celsiusLabel`
- `convertButton`
- `fahrenheitLabel`

Això farà que el codi sigui més fàcil d'entendre.

## 7. Crear l'esdeveniment del botó

1. Fes clic sobre el botó `Convertir`.
2. Clic dret.
3. Selecciona:
   - `Events > Action > actionPerformed`

NetBeans crearà automàticament un mètode per escriure el codi que s'executarà quan es premi el botó.

## 8. Escriure la lògica de conversió

Dins del mètode `convertButtonActionPerformed`, afegeix aquest codi:

```java
double tempCelsius = Double.parseDouble(tempTextField.getText());
double tempFahr =  (tempCelsius * 1.8 + 32);
fahrenheitLabel.setText(String.format("%.2f",tempFahr) + " Fahrenheit");
```

## 9. Explicació del codi

Aquest codi fa tres coses:

1. Llegeix el text introduït i el converteix a número.
2. Aplica la fórmula de conversió:
   - `F = C * 1.8 + 32`
3. Mostra el resultat a l'etiqueta inferior.

En aquesta versió fem servir `double` per poder treballar amb decimals, per exemple `37.5` o `18.25`.

## 9.1. Com s'han d'escriure els decimals

`Double.parseDouble(...)` llegeix els nombres decimals amb punt:

- correcte: `37.5`
- correcte: `18.25`
- incorrecte: `37,5`

Si l'usuari escriu una coma en lloc d'un punt, el programa donarà error. 
## 10. Executar l'aplicació

1. Executa el projecte amb `Run Main Project`.
2. Si NetBeans ho demana, indica que `ConversorGUI` serà la classe principal.
3. Prova l'aplicació introduint un valor, per exemple:
   - `60`
   - `37.5`
4. Comprova que mostra:
   - `140.0 Fahrenheit`
   - `99.5 Fahrenheit`

## 11. Limitacions de la versió inicial

Aquesta primera versió funciona, però té algunes limitacions:

- no valida si l'usuari escriu text no numèric
- la lògica està directament dins la finestra
- encara no hi ha separació entre interfície i càlcul

## 12. Idea clau per al següent pas

Aquest exemple ens serveix per aprendre a:

- crear una interfície amb NetBeans
- afegir components Swing
- gestionar un esdeveniment de botó

En el següent exemple veurem com separar millor el codi amb el patró MVC:

- `Model`: fa els càlculs
- `View`: mostra la interfície
- `Controller`: connecta la vista amb la lògica

## Exercicis proposats

1. Modifica l'aplicació perquè també converteixi de Fahrenheit a Celsius.
2. Afegeix control d'errors si l'usuari no escriu un número.
3. Modifica el programa perquè també accepti valors escrits amb `,`.
4. Canvia el text de l'etiqueta de resultat perquè inicialment estigui buit.
