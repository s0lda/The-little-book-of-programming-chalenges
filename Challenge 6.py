'''
Make a game for seeing how good people are at
guessing when 10 seconds have elapsed.
Algorithm
 Tell them to hit enter key when ready
 Get the first time in seconds
 Get them to hit the enter key when they think time has elapsed
 Get the second time in seconds
 Subtract first time from the second time
 Tell them how close to 10 the answer was. 
'''

from datetime import datetime
import keyboard

print('Guess 10 seconds')
print('Press Enter when you ready to start and then press Enter again to stop the timer.')
print('Let see if you can guess when 10 seconds have elapsed.')
print('                     ')
print('Are you ready to start? Press Enter.')
if keyboard.read_key() == 'enter':
    start = datetime.now().second
    print('Start')


print('Press Enter again after 10 seconds.')
keyboard.wait('enter')

if keyboard.read_key() == 'enter':
    stop = datetime.now().second
    print('Stop')
            
delta = stop - start

if delta == 10:
    print('Bang on Time!')
elif delta < 10:
    early = 10 - delta
    print(early, 'second(s) too early, wait a bit longer next time.')
elif delta > 10:
    late = delta - 10
    print(late, 'second(s) too late. Next time you need to do it quicker.')
