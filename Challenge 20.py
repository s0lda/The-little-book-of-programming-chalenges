'''
Create a Fibonacci sequence generator. (The Fibonacci sequence was originally used as a basic model
for rabbit population growth). The Fibonacci sequence goes like this.
0,1,1,2,3,5,8,13
The Nth term is the sum of the previous two terms. So in the
example above the next term would be 21 because it would be the
previous two terms added together (8+13).
You will need create a list of Fibonnaci numbers up to the 50th
term.
The program will then ask the user for which position in the sequence they want to know the Fibonacci value for (up to 50).
E.g
Which position in sequence? 6 (start counting at 0)
Fibonacci number is 8
Hint
You will need to store the sequence in an array of Long (these
numbers can get pretty big!)
'''

fibonacci_numbers = [0, 1]
for i in range(2, 50):
    fibonacci_numbers.append(fibonacci_numbers[i - 1] + fibonacci_numbers[i - 2])

num = int(input('What position of Fibbonaci list do you want to check? '))
print(fibonacci_numbers[num])