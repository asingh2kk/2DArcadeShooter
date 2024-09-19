# 2D Shooter Game

## Project Overview

This is a 2D shooter game built in Java, featuring enemies with different states and behaviors. The game follows the object-oriented design principle and implements various game development patterns like builders and memento patterns to manage the states and actions of the game's entities.

## Features

- **Player and Enemy Mechanics**: The game includes a player character that can interact with various enemies.
- **Enemy Types**: Different types of enemies are created using the builder pattern (`NormalEnemyBuilder`, `HardEnemyBuilder`, etc.).
- **State Management**: Enemies operate under different states (such as `GonerState`, `FullState`, and `CriticalState`) to provide dynamic gameplay.
- **Game Interface**: Uses graphical components to render the game environment (`GraphFrame`, `GraphPanel`).

## Technologies Used

- **Programming Language**: Java
- **Design Patterns**: Memento Pattern, Builder Pattern
- **Graphical Interface**: Java Swing (`GraphFrame` and `GraphPanel`)

## Setup Instructions

1. **Clone the repository**:
   ```bash
   git clone https://github.com/yourusername/2DShooterGame.git
   ```

2. **Navigate to the project directory**:
   ```bash
   cd 2DShooterGame
   ```

3. **Compile the Java files**:
   You can use any IDE like IntelliJ IDEA or run the following command from the command line if `javac` is installed:
   ```bash
   javac -d out src/com/company/*.java
   ```

4. **Run the game**:
   After compiling the files, run the game using:
   ```bash
   java -cp out com.company.Main
   ```

## Usage

- **Player Controls**: The player can move and interact with enemies in the game using predefined controls (ensure to modify this section once you provide the actual control mechanisms).
- **Enemy Behavior**: Enemies appear with varying behaviors and states, making gameplay challenging and dynamic.
