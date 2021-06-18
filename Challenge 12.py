'''
Write a program that will display all the factors of a number, entered by the user, that are bigger than 1.
(e.g. the factors of the number 12 are 6,4,3 and 2 because they divide into 12 exactly).
Hint
to find out whether a number X is a factor of Y use :
IF Y mod X =0 (there is nothing remaining when Y is divided by X)

Extension
Tell the user if the number they
entered is a prime number 
'''

num = int(input('Factors of what number do you want to know? '))
flag = False

if num > 1:
    for i in range(2, num):
        if (num % i) == 0:
            flag = True
            break

if flag:
    print(num, "is not a prime number")
else:
    print(num, "is a prime number")

def number_factors(num):
    factors = []
    for i in range(2, num):
        if num % i == 0:
            factors.append(i)
    print('Factors: ', factors)

number_factors(num)
