'''
Write a program that will give the
students the answer to logic gate
questions e.g.

Enter logic gate : OR
Enter first input : 1
Enter second input :0
Result = 1
It should work for the logic gates OR, AND and XOR

Extension
Include NAND and NOR gates
I've included all of them.
'''

print('BUFFER, NOT, AND, OR, NAND, NOR, XOR, XNOR')
print('Input can be either 0 or 1.')

logic_gate = str(input('What logic gate do you want to work with? '))

if logic_gate.upper() == 'BUFFER':
    first = int(input('Input: '))
    if first == 0:
        print('Output: 0')
    elif first == 1:
        print('Output: 1')
elif logic_gate.upper() == 'NOT':
    first = int(input('Input: '))
    if first == 0:
        print('Output: 1')
    elif first == 1:
        print('Output: 0')
elif logic_gate.upper() == 'AND':
    first = int(input('First Input: '))
    second = int(input('Second Input: '))
    if first == 0 and second == 0:
        print('Output: 0')
    elif first == 0 and second == 1:
        print('Output: 0')
    elif first == 1 and second == 0:
        print('Output: 0')
    elif first == 1 and second == 1:
        print('Output: 1')
elif logic_gate.upper() == 'OR':
    first = int(input('First Input: '))
    second = int(input('Second Input: '))
    if first == 0 and second == 0:
        print('Output: 0')
    elif first == 0 and second == 1:
        print('Output: 1')
    elif first == 1 and second == 0:
        print('Output: 1')
    elif first == 1 and second == 1:
        print('Output: 1')
elif logic_gate.upper() == 'NAND':
    first = int(input('First Input: '))
    second = int(input('Second Input: '))
    if first == 0 and second == 0:
        print('Output: 1')
    elif first == 0 and second == 1:
        print('Output: 1')
    elif first == 1 and second == 0:
        print('Output: 1')
    elif first == 1 and second == 1:
        print('Output: 0')
elif logic_gate.upper() == 'NOR':
    first = int(input('First Input: '))
    second = int(input('Second Input: '))
    if first == 0 and second == 0:
        print('Output: 1')
    elif first == 0 and second == 1:
        print('Output: 0')
    elif first == 1 and second == 0:
        print('Output: 0')
    elif first == 1 and second == 1:
        print('Output: 0')
elif logic_gate.upper() == 'XOR':
    first = int(input('First Input: '))
    second = int(input('Second Input: '))
    if first == 0 and second == 0:
        print('Output: 0')
    elif first == 0 and second == 1:
        print('Output: 1')
    elif first == 1 and second == 0:
        print('Output: 1')
    elif first == 1 and second == 1:
        print('Output: 0')
elif logic_gate.upper() == 'XNOR':
    first = int(input('First Input: '))
    second = int(input('Second Input: '))
    if first == 0 and second == 0:
        print('Output: 1')
    elif first == 0 and second == 1:
        print('Output: 0')
    elif first == 1 and second == 0:
        print('Output: 0')
    elif first == 1 and second == 1:
        print('Output: 1')