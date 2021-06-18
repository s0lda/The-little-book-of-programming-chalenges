'''
Write a program that will work out the
distance travelled if the user enters in the
speed and the time.

Extension
Get the program to tell you the speed you would have to travel
at in order to go a distance within a certain time entered by the
user. 
'''

import keyboard

print('If you want me to tell you how far you traveled, press 1.')
print('If you want to find out how fast you need to drive to get somewhere on time, press 2. ')

def on_1():
    try:
        speed_1 = int(input('What was your speed an hour? '))
        time_1 = int(input('For how long have you been driving? Please input your time in minutes. '))
        distance_1 = (speed_1 / 60) * time_1
        print('Distance you have traveled is ' + str(round(distance_1, 2)) + ' km.')
    except ValueError:
        print('You need to use numbers.')
    
def on_2():
    try:
        distance_2 = int(input('How far do you want travel? Enter in km. '))
        time_2 = int(input('How long do you have to get there? Enter in minutes. '))
        speed_2 = distance_2/ time_2 * 60
        print('You need to drive ' + str(round(speed_2, 2)) + ' km/h to get there on time.')
    except ValueError:
        print('You need to use numbers.')

keyboard.add_hotkey('1', on_1)
keyboard.add_hotkey('2', on_2)

while True:
    try:
        if keyboard.wait('1'):
            break
        elif keyboard.wait('2'):
            break
    finally:
        break
        