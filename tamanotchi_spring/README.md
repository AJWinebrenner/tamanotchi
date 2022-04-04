# tamaNOTchi

Our Group: [Andrew](https://github.com/AJWinebrenner), [Aoife](https://github.com/aoifeags), [Cristian](https://github.com/Roscaaa), [Nayan](https://github.com/Nayan-grg), [Will](https://github.com/WillBurdett)

## Contents


## Introduction: What is tamaNOTchi? 
tamaNOTchi is a revamp of the classic pocket digital pet game Tamagotchi. Here, you can create your own pet or select one from an existing list. Play games to earn coins, feed your pet to keep them happy and work to upgrade your pet to its final form. You must be responsible - if you forget to take care of your pet, their health will deteriorate and they will die. You must also learn to maintain a balanced diet otherwise your pet will get sick. 

## Setup Instructions
1. Make sure that you have installed Java and PostgresQL (insert necessary installations here).
   <br><br>
2. Clone this repository:
      ``git clone git@github.com:AJWinebrenner/tamanotchi.git``
3. Open 'tamanotchi_spring' and 'tamanotchi_react' in separate windows in your IDE or code editor of choice
4. Create a new PostgresQL database called ``tamanotchi``. Type ``createdb tamanotchi`` in your terminal window. 
5. Use the ``tamanotchi.sql`` script to populate your ``tamanotchi`` database tables. Execute the entire sql script using a database client such as Postico. 

&nbsp;&nbsp;&nbsp;&nbsp;_**Note** — the DROP TABLES commands at the beginning of the sql script are not necessary if setting up database for the first time:_
```sql
DROP TABLE IF EXISTS pets;
DROP TABLE IF EXISTS variants;
DROP TABLE IF EXISTS houses;
DROP TABLE IF EXISTS foods;
```




## How to Play


## Project Structure and Entity Relationship Diagram


## Future Developments


