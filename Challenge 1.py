'''
Write a program that will display a joke
Don’t display the punchline until the reader
hits the enter key.
Extension
display the punchline in a different colour
'''

from termcolor import colored
import keyboard

print('If you want me to tell you a joke, press ENTER.. if you don\'t like jokes, press any other key.')
while True:
    try:  
        if keyboard.is_pressed('enter'):
            print(colored('Why don\'t scientists trust atoms?', 'red'))
            print(colored('Because they make up everything.', 'green'))
            break
        elif keyboard.read_key() != 'enter':
            break
    except:
        break
