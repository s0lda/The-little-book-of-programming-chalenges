'''
Write a program to work out how many days you have lived for.
Algorithm
 Enter date of birth
 Get today’s date
 Get the difference in days between the two dates
 Display result

Extension
Work out how many seconds you’ve lived for. 
'''
from datetime import datetime, date

today = date.today()

date_of_birth = input('What is your date of birth? YYYY-MM-DD ')
dob = datetime.strptime(date_of_birth, '%Y-%m-%d')
dob = dob.date()
delta = today - dob

print('You live', delta.days, 'days.')

seconds = delta.days * 24 * 60 * 60

print('You live', seconds, 'seconds.')

