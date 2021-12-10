'''
Write a program to work out the areas of a rectangle.
Collect the width and lenght of the rectangle from the keyboard
Calculate the area
display the result.

Extension
display the volume of a cuboid.
See what happens when you
don't type in numbers! - Try
to explain what has happened and why
'''
import keyboard

while True:
    try:
        width = float(input('What is the width of your rectangle? '))
        break
    except ValueError:
        print('You need to use numbers.')

while True:
    try:
        length = float(input('What is the length of your rectangle? '))
        break
    except ValueError:
        print('You need to use numbers.')

area = width * length
print('Area of your rectangle is ' + str(area))
print('If your rectangle is a base of cuboid and you want me to calculate the volume of it, press enter. If not, press any other key. ')

while True:
    if keyboard.is_pressed('enter'):
        try:
            height = float(input('What is the height of your cuboid? '))
            volume = width * length * height
            print('The volume of your cuboid is ' + str(volume))
            break
        except ValueError:
            print('You need to use numbers.')
    elif keyboard.read_key() != 'enter':
        break
