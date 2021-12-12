'''
Write a program that will accept someone’s date of birth and
work out whether they can vote (i.e. Are they 18?)
'''
from datetime import datetime


today = datetime.now()
today = today.date()

date_of_birth = input('What is your date of birth? YYYY-MM-DD ')
dob = datetime.strptime(date_of_birth, '%Y-%m-%d')
dob = dob.date()

if (today.year - dob.year) < 18:
    print('Your are under age.')
elif (today.year - dob.year) == 18:
    if today.month < dob.month:
        print('You are under age.')
    elif today.month == dob.month:
        if today.day < dob.day:
            print('You are under age.')
        else:
            print('You are 18+.')
    else:
        print('You are 18+.')
else:
    print('You are 18+.')
