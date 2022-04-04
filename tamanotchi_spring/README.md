# tamaNOTchi

###Tama-NOT-chi Development team: 
[Andrew Winebrenner](https://github.com/AJWinebrenner) <br> [Aoife Sandy Boyle](https://github.com/aoifeags) <br> [Cristian Rosca](https://github.com/Roscaaa) <br> [Nayan Gurung](https://github.com/Nayan-grg) <br> [Will Burdett](https://github.com/WillBurdett)

##What is tamaNOTchi? 
tamaNOTchi is a revamp of the classic pocket digital pet game Tamagotchi. Here, you can create your own pet or select one from an existing list. Play games to earn coins, feed your pet to keep them happy and work to upgrade your pet to its final form. You must be responsible - if you forget to take care of your pet, their health will deteriorate and they will die. You must also learn to maintain a balanced diet otherwise your pet will get sick. 

## Setup Instructions
1. Make sure that you have installed Java and PostgreSQL (EDIT insert necessary installations here - npx?).
   <br><br>
2. Clone this repository:
      ``git clone git@github.com:AJWinebrenner/tamanotchi.git``<br><br>
3. Open ``tamanotchi_spring`` and ``tamanotchi_react`` in separate windows in your IDE or code editor of choice <br><br>
4. Create a new PostgresQL database called ``tamanotchi``. Type ``createdb tamanotchi`` in your terminal window. <br><br>
5. Use the ``tamanotchi.sql`` script to populate your ``tamanotchi`` database tables. Execute the entire sql script using a database client such as Postico. 

&nbsp;&nbsp;&nbsp;&nbsp;_**Note** — the DROP TABLES commands at the beginning of the sql script are not necessary if setting up database for the first time:_
```sql
DROP TABLE IF EXISTS pets;
DROP TABLE IF EXISTS variants;
DROP TABLE IF EXISTS houses;
DROP TABLE IF EXISTS foods;
```
6. Install ``node_modules`` for ``tamanotchi_react`` application. Type ``npm install`` in your terminal window while in the ``tamanotchi-react`` directory. <br><br>
7. Ensure PostgreSQL is running <br><br>
8. Run the SpringBoot application. Run the ``Main.java`` file (Filepath: ``src/main/java/com/tamanotchi/Main.java``). <br><br>
9. Run the React application. Type ``npm start`` in your terminal window while in the ``tamanotchi-react`` directory.

## How to Play
###Selecting your pet
Start by either choosing a pre-made pet or by creating your own pet from the home screen

###Happiness and Energy Meters
Just below your pet, you will see a happiness and energy meter. Be cautious of not letting these get too low or you'll risk your pet getting sick and dieing. 

###Coins
To the right of your pet's name, you will see the number of coins that you have. Coins can be used to purchase items in the shop and can be earned by completing the mini-game. 

###House
You can view your pet's current house from the bottom menu. You can upgrade your pet's house once you have earned enough coins which will boost your pet's happiness and give them the space to evolve. 

###Shop
You can use your coins to buy food and medicine for your pet. Feed your pet to keep their happiness and energy levels high. Each item in the shop will affect your pet slightly differently. Make sure to maintain a balanced diet you run the risk of your pet getting sick. 

###Game
You can earn coins by playing the mini-game! The mini-game requires you to memorise the position of a series of shapes in a grid before the shapes are hidden. Click the grid to reveal a shape and then try to find its matching counterpart. Once you have matched all of the object pairs, you win!

###Pet Variant
To the left of your pet's name, you will see your pet's variant or tier. As you keep your pet happy and play games, you will earn EXP. You must fulfil three criteria for your pet to evolve to the next variant: <br>
• Your happiness and energy meters must be sufficiently high <br>
• Your house must be upgraded to have enough room for your bigger pet <br>
• You must have enough EXP accumulated from keeping your pet healthy and playing games. 


### Winning The Game
Once you have reached the max EXP on your pet's final variant, you win the game!

## Future Developments
• Implement additional mini-games for the user to play.

