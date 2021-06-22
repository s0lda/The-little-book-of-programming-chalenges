'''
Write a procedure(sub) drawstars that will draw a sequence of
spaces followed by a sequence of stars. It should accept two parameters—the number of spaces and the number of stars.
E.g
Drawstars(3,5) would produce
_ _ _ * * * * * ( _ indicates a space!)

Extension
Now write a program using this procedure that will draw a pyramid whose base is a width specified by the user. E.g.
Enter base size of pyramid : 5
*
***
*****
(assume the user has to enter an odd number)    I did't assume. I've made sure it will be odd.

'''

while True:
    try:
        user_base = int(input('How many stars would you like in the base of your pyramid? '))
    except ValueError:
        print('You need to input odd number.')
    
    if user_base % 2 == 0:
        print('You need to input odd number.')
    else:
        break

def draw_stars(space: int, star: int):
    print(' ' * space, '*' * star)

def pyramid(base: int):
    base_space = 0
    space = int((base - 1) / 2)
    star = 1
    while star != base:
        draw_stars(space, star)
        star += 2
        space -= 1
    draw_stars(base_space, base)

pyramid(user_base)
