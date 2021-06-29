'''
Create a simple treasure hunt game.
Create a two-dimensional array of integers 10 by 10.
In a random position in the array store the number 1.
repeat
Get the user to enter coordinates where they think the treasure is.
If there is a 1 at this position display ‘success’.
Until they find the treasure
'''
import numpy as np
import random

def board():
    board = np.random.randint(0, 1, size=(10, 10))

    target_x = random.randint(0, 9)
    target_y = random.randint(0, 9)

    board[target_x, target_y] = 1
    return board

def get_coordinates():
    user_x = int(input('Please enter value X.'))
    user_y = int(input('Please enter value Y.'))
    return user_x, user_y


def check(board, get_coordinates):
    if np.where(board() == 1) == get_coordinates():
        print('Success.')
        return True
    else:
        print('Keep looking.')
        return False


while check(board, get_coordinates) == False:
    check(board, get_coordinates)
