'''
Create a two-dimensional array of integers 10 by 10.
Fill the array with random numbers in the range 0 to 15
Display the array on the screen showing the numbers.
'''

import numpy as np



rand_arr = np.random.randint(0, 16, size=(10, 10))
print(rand_arr)
