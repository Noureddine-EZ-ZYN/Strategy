# DP2

Illustration du design pattern **Stratégie** (Strategy) en Java : un contexte délègue une opération à une stratégie interchangeable, choisie dynamiquement à l'exécution.

## Structure du projet

```
src/main/java/net/noureddine
├── Main.java                  # Point d'entrée : choix interactif de la stratégie
├── Contexte.java              # Contexte : utilise la stratégie courante
├── Strategy.java              # Interface de la stratégie
├── DefaultStrategyImpl.java   # Stratégie par défaut
├── StrategyImpl1.java         # Stratégie concrète 1
├── StrategyImpl2.java         # Stratégie concrète 2
└── StrategyImpl3.java         # Stratégie concrète 3
```

## Principe

Toutes les stratégies implémentent la même interface `Strategy`. Le `Contexte` ne connaît que cette interface et peut changer de stratégie à tout moment avec `setStrategy`, sans modification de son code :

```java
Contexte contexte = new Contexte();          // stratégie par défaut
contexte.setStrategy(new StrategyImpl2());   // changement de stratégie
contexte.effectuerOperation();
```

Dans `Main`, la stratégie est instanciée dynamiquement par réflexion (`Class.forName("net.noureddine.StrategyImpl" + saisie)`) puis mise en cache dans une `Map`. Saisir `1`, `2` ou `3` sélectionne la stratégie correspondante.

## Prérequis

- JDK 26 (voir `pom.xml`)
- Maven

## Compilation et exécution

```bash
mvn compile
java -cp target/classes net.noureddine.Main
```
