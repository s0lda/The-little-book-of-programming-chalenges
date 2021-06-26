'''
Write a program that will store names into an array.
As a new name is entered it will be added to the end of the array.
The user can keep adding names until they enter the dummy
value ‘exit’
Once this has been done the program will display any duplicate
names.
E.g.
Enter name: Bill
Enter name: Mary
Enter name: Anisha
Enter name: Mary
Enter name: exit
Mary is a duplicate.
Extension
Display how many times each name has been duplicated
'''

names: str = []

while True:
    try:
        name_input = str(input('Please enter the name. '))
        names.append(name_input)
        if name_input.lower() == 'exit':
            break
    finally:
        pass

def duplicates(names):
    duplicated = {}
    for name in names:
        if name in duplicated:
            duplicated[name] += 1
        else:
            duplicated[name] = 1

    duplicated = { key:value for key, value in duplicated.items() if value > 1}
    return duplicated

duplicates(names)

duplicated = duplicates(names)

for key, value in duplicated.items():
    print('You have name: %s, %d times in your list.' % (key, value))