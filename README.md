# Card Game

This is a card game project implemented in Java and built with Maven.

# Running and Testing the Card Game

This explains how to compile, package, run, and test your Java application using the provided shell script.

## Prerequisites

- JDK (Java Development Kit) installed on your system
- Maven build tool installed on your system

## Usage

1. Clone the repository to your local machine:

    ```bash
    git clone https://github.com/mikechiloane/card-game.git
    ```

2. Navigate to the project directory:

    ```bash
    cd card-game
    ```

3. Make sure the shell script (`run.sh`) is executable:

    ```bash
    chmod +x run.sh
    ```

### Running the Java Program

To compile, package, and run the Java program, execute the following command:

```bash
./run.sh
```

### Running the Tests

To run the tests, execute the following command:

```bash
./run.sh test
```

## Example Output

The output of the program should look like this:

```
Shuffling ... Shuffling ... Shuffling ...
Your hand: A♠ 3♣ 5♥ 9♦ K♦
You have: High Card
```

## Code Design Explanation

The provided code design already offers some flexibility and extensibility, but it can be further improved to
accommodate the mentioned requirements:

### 1. Replacing the Shuffling Algorithm:

Currently, the `FiveCardDraw` class accepts a `Shuffler` interface which allows different shuffling algorithms to be
plugged in. To replace the shuffling algorithm with a more realistic one, you can simply create a new class implementing
the `Shuffler` interface and inject it into the `FiveCardDraw` constructor.

For example:

```java
public class RealisticDeckShuffler implements Shuffler {
    @Override
    public void shuffleDeck(Deck deck) {
        // Implement realistic shuffling algorithm
    }
}
```

### Then, inject the new shuffler into the class:

```java
public class FiveCardDraw { 
    private final Deck deck;
    private final Shuffler shuffler;

    public FiveCardDraw(Deck deck, Shuffler shuffler) {
        this.deck = deck;
        this.shuffler = shuffler;
    }
}
```

### 2. Adding a New Game Variant:

To add a new game variant, you can create a new class implementing the `CardGame` interface and inject it into the `game`
variable in the Main class.

For example:

```java
public class TexasHoldem implements CardGame {
    @Override
    public void run() {
        // Implement Texas Hold'em game logic
    }
}
```

### Then, inject the new game variant into the Main class:

```java
public class Main {
    public static void main(String[] args) {
        CardGame game = new TexasHoldem();
        game.run();
    }
}
```

