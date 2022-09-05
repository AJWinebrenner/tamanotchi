# Tama-NOT-chi

### Development team:
- [Andrew Winebrenner](https://github.com/ajwinebrenner) 
- [Aoife Sandy Boyle](https://github.com/aoifeags) 
- [Cristian Rosca](https://github.com/Roscaaa) 
- [Nayan Gurung](https://github.com/Nayan-grg)
- [Will Burdett](https://github.com/WillBurdett)

## What is Tama-NOT-chi?
tamaNOTchi is a revamp of the classic pocket digital pet game Tamagotchi. Here, you can create your own pet or select one from an existing list. Play games to earn coins, feed your pet to keep them happy and work to upgrade your pet to its final form. You'll have to look after your pet and maintain a balanced diet otherwise your pet will get sick. If you forget to take care of your pet, their health will deteriorate and they may die.

## Run Locally
1. Ensure Docker Desktop is installed and running
2. inside tamanotchi_spring, use maven package to create .jar file
3. in the root directory use `make build` to create necessary images
4. `make run` to spin up containers, connect to http://localhost:3000

## How to Play

### Selecting your pet
Start by either choosing a pre-made pet or by creating your own pet from the home screen

### Happiness and Energy Meters
Just below your pet, you will see a happiness and energy meter. Be cautious of not letting these get too low or you'll risk your pet getting sick and dieing.

### Coins
To the right of your pet's name, you will see the number of coins that you have. Coins can be used to purchase items in the shop and can be earned by completing the mini-game.

### House
You can view your pet's current house from the bottom menu. You can upgrade your pet's house once you have earned enough coins which will boost your pet's happiness and give them the space to evolve.

### Shop
You can use your coins to buy food and medicine for your pet. Feed your pet to keep their happiness and energy levels high. Each item in the shop will affect your pet slightly differently. Make sure to maintain a balanced diet you run the risk of your pet getting sick.

### Game
You can earn coins by playing the mini-game! The mini-game requires you to memorise the position of a series of shapes in a grid before the shapes are hidden. Click the grid to reveal a shape and then try to find its matching counterpart. Once you have matched all of the object pairs, you win!

### Pet Variant
To the left of your pet's name, you will see your pet's variant or tier. As you keep your pet happy and play games, you will earn EXP. You must fulfil three criteria for your pet to evolve to the next variant:
- Your happiness and energy meters must be sufficiently high
- Your house must be upgraded to have enough room for your bigger pet
- You must have enough EXP accumulated from keeping your pet healthy and playing games


### Winning The Game
Once you have reached the max EXP on your pet's final variant, you win the game!

## Future Developments
- Implement additional mini-games for the user to play
- Further game balancing
- Variable rewards from mini games
- Introduce additional pet variants and stages 