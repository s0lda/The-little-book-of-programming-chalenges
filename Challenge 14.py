'''
Write a program for a Higher / Lower guessing game
The computer randomly generates a sequence of up to 10 numbers between 1 and 13. The player each after seeing each number
in turn has to decide whether the next number is higher or lower.
If you can remember Brucie’s ‘Play your cards right’ it’s basically
that. If you get 10 guesses right you win the game.
Starting number : 12
Higher(H) or lower(L)? L
Next number 8
Higher(H) or lower(L)? L
Next number 11
You lose

Hints
Use a condition controlled loop (do until, while etc) to control the
game. Do not find yourself repeating the same code over and
over!
You don't need to remember all 10 numbers just the current number /next number. Don’t forget you’ll have to keep a count of the
number of turns they’ve had.

Extensions
Give the players two lives
Make sure only H or L can
be entered 
'''
import random

lives = 2
turns_left = 10
correct_guesses = 0
current_number = random.randint(1, 13)

print('Welcome in guess game. Let\'s see if you can guess if next number is lower or higher.')
print('I will give you 10 numbers, all you need to do if next number is higher or lower.')
print('If you think next number will be the same as current number, choose H.')
print('       ')
print('You have 2 lives. Be careful. Numbers will be from 1 to 13.')
print('  ')

while turns_left > 0 and lives > 0:
    
    next_number = random.randint(1, 13)
    print('Current number is:', current_number)
    guess = str(input('Is next number going to be higher or lower? L or H? '))
    turns_left -= 1

    if guess.lower() == 'l':
        if next_number > current_number:
            lives -= 1
            print('Wrong guess.')
        elif next_number < current_number:
            correct_guesses += 1
            print('That is right.')
    elif guess.lower() == 'h':
        if next_number >= current_number:
            correct_guesses += 1
            print('That is right.')
        elif next_number < current_number:
            lives -= 1
            print('Wrong guess.')
    else:
        lives -= 1
        print('Wrong answer. It have to be L or H.')
            
    
    print('Lives left:', lives)
    current_number = next_number
    
    if correct_guesses == 10:
        print('Champs Champ. You\'ve guessed all of the numbers right!')

    if lives == 0:
        print('You\'ve lost. No more lives left.')
        break
    