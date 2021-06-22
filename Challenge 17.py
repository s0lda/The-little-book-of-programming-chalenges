'''
Write a function that will convert a UMS score into a grade. The
function will return ‘A’—> ‘U’.
The function will require a parameter to do its job: the mark
The formula for AS level is >=80% —>‘A’, >=70%—>‘B’, >=60%—>‘C’
etc.
Assume the maximum module mark is 100
Having written the function we want to use it three times.
Write a program with the function that allows the user to enter
two module AS scores and displays the grade. It then adds the two
results together and displays the students overall grade. E.g.
Enter Module 1 result: 78
Enter Module 1 result: 67
Result
Module 1 : B
Module 2: C
AS Level : B

Extension
Allow a maximum mark other than 100. This will require the user
to enter both the mark and maximum possible for that module.
The function will also require the maximum mark in order to calculate the grade so another parameter will be needed.
'''

max_mark = int(input('What is a maximum possible mark? '))
module_a = int(input('Please enter mark for Module A. '))
module_b = int(input('Please enter mark for Module B. '))
module_combined = (module_a + module_b) / 2

def as_converter(module):
    if module >= (max_mark / 100) * 80:
        return 'A'
    elif module >= (max_mark / 100) * 70:
        return 'B'
    elif module >= (max_mark / 100) * 60:
        return 'C'
    elif module >= (max_mark / 100) * 50:
        return 'D'
    elif module >= (max_mark / 100) * 40:
        return 'E'
    elif module >= (max_mark / 100) * 30:
        return 'F'
    else:
        return 'U'

print('Your score for Module A is:', as_converter(module_a))
print('Your score for Module B is:', as_converter(module_b))
print('Your AS level is:', as_converter(module_combined))