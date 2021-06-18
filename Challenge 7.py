'''
Extend the program in Challenge 6 to make a
game for seeing how quick people are at typing the alphabet.
Algorithm
 Tell them to hit enter key when ready
 Get the first time in seconds (and minutes)
 Get them to type in the alphabet and hit enter
 Get the second time in seconds (and minutes)
 Check they have entered the alphabet correctly
 If they entered it correctly then
 Subtract first time from the second time
 Tell them how many seconds they took
 '''

from datetime import datetime

alphabet = 'abcdefghijklmnopqrstuvwxyz'

print('How fast can you type the alphabet?')
print('Press Enter when you ready to start, when you finish press Enter again.')
input('Press Enter and start typing the alphabet.')
start = datetime.now().second

test = input()
stop = datetime.now().second

delta = stop - start

if test.lower() == alphabet:
    if delta < 60:
        print('Took you', delta, 'seconds to finish it.')
    elif delta % 60 == 0:
        x = delta // 60
        if x == 1:
            print('Took you 1 minute to finish it.')
        elif x > 1:
            print('Took you', x, 'minutes to finish it.')
    elif delta > 60:
        y = delta // 60
        z = delta % (y * 60)
        if y == 1:
            print('You did it in', y, 'minute and', z, 'second(s).')
        else:
            print('You did it in', y, 'minutes and', z, 'second(s).')

elif test.lower() != alphabet:
    print('Not correct. Try again.')


