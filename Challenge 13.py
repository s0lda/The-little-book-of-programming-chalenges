'''
Write a program for a game where the computer generates a
random starting number between 20 and 30.
The player and the computer can remove 1,2 or 3 from the number in turns. Something like this...
Starting number : 25
How many do you want to remove? 3
22 left
Computer removes 2
20 left
The player who has to remove the last value to bring the number
down to 0 is the loser.
1 left
Computer removes 1
You win!
Easy option
Get the computer to choose a number between 1—3 at random
'''
import random

starting_number = random.randint(20, 30)
turn = 0

print('If you get 0 you will loose..')
print('Starting number is:', starting_number)

while starting_number > 0:
    if turn % 2 == 0:
        starting_number -= int(input('Choose number from 1 to 3: '))
        turn += 1
        print(starting_number)
        if starting_number <= 0:
            print('Player lost the game.')
    elif turn % 2 != 0:
        print('Computer is choosing.')
        starting_number -= random.randint(1, 3)
        turn += 1
        print(starting_number)
        if starting_number <= 0:
            print('Computer lost the game.')


