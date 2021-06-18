'''
Write a program that will generate a
random playing card e.g. ‘9 Hearts’,
‘Queen Spades’ when the Enter key is
pressed.
Rather than generate a random number
from 1 to 52. Create two random numbers – one for the suit and one for the
card.

Extension
Make a loop structure so playing cards can keep being generated 
'''

import random
import keyboard

types = ['Clubs', 'Diamonds', 'Hearts', 'Spades']
ranks = ['Ace', '2', '3', '4', '5', '6', '7', '8', '9', '10', 'Jack', 'Queen', 'King']



print('Press Enter to pick a card.')
while True:
    keyboard.wait('Enter')
    x = random.randint(0, 3)
    y = random.randint(0, 12)
    card = ranks[y] + ' ' + types[x]
    print(card)
