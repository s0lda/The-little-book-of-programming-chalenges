'''
Guess the number game.
The computer selects a random number between 1 and 100.
The user keeps guessing which number the computer has chosen
until they get it right.
The computer responds ‘got it’ or ‘too high’ or ‘too low’ after each
guess.
After the user has guessed the number the computer tells them
how many attempts they have made.

Extension- Reverse the game. You think of a number. Get the
computer to guess a number and you respond with too high(H),
too low(L) or got it(G). Make sure the computer has a game
plan—don't just let it guess at random!
'''
import random

print('Do you want to guess the number or do you want me to guess?')
choice = input('Choose H for Human if you want to gues or C for Computer if you want computer to guess. ')

if choice.upper() == 'H':
    guess = 0
    number = random.randint(1, 100)
    attempts = 0

    print('Guess the number.')
    while guess != number:
        guess = int(input('Is it.. '))
        if guess == number:
            print('Got it.')
        elif guess < number:
            attempts += 1
            print('Too low.')
        elif guess > number:
            attempts += 1
            print('Too high.')

    print('Took you %s attempts to get it right.' % (attempts))
elif choice.upper() == 'C':
    secret_number = int(input('OK, pick a number between 1 and 100 and let Computer guess it. '))
    attempts = 0
    computer_choice = random.randint(1, 100)
    higher = 100
    lower = 1
    
    while computer_choice != secret_number:
        if computer_choice > secret_number:
            print('Computer is guessing it could be : %d' % (computer_choice))
            higher = computer_choice
            computer_choice = random.randint(lower, higher)
        elif computer_choice < secret_number:
            print('Computer is guessing it could be : %d' % (computer_choice))
            lower = computer_choice
            computer_choice = random.randint(lower, higher)
        else:
            print('Computer gave up.. joking only, he would never do that.')
        attempts += 1
    print('Computer guessed your number in %d attempts.' % (attempts))
    
else:
    print('You need to choose Human or Computer.')

