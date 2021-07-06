'''
The computer generates a 4 digit code
The user types in a 4 digit code. Their guess.
The computer tells them how many digits they guessed correctly

Extension : the computer tells them how many digits are
guessed correctly in the correct place and how many digits have
been guessed correctly but in the wrong place.
The user gets 12 guesses to either win – guess the right code. Or
lose – run out of guesses.
'''
import random

def codebreaker():
    number = random.randint(1000, 9999)
    guesses = 0

    while guesses < 12:
        user_guess = int(input('What 4 digit number you have in mind? '))
        number_list = [int(i) for i in str(number)]
        user_guess_list = [int(i) for i in str(user_guess)]
        if user_guess == number:
            print('That is the right number.')
            break
        else:    
            mutual = []
            for digit in number_list:
                if digit in user_guess_list:
                    mutual.append(digit)
            print('Numbers guessed correctly:', mutual)
            common = []
            for i, j in zip(number_list, user_guess_list):
                if i == j:
                    common.append(i)
            print('Numbers in the right place:', common)

        guesses += 1

    if guesses == 12:
        print('Sorry, run out of chances.')

codebreaker()