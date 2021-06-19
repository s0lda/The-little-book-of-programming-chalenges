'''
Write a program to count the number of words in a sentence.
The user enters a sentence.
The program responds with the number of words in the sentence.
Hint
Look for spaces and full stops in the string.

Extension
Develop a program that will
display a sentence backwards
after entered. 
'''


sentence = str(input('Please input your sentence: '))
word_count = len(sentence.split(' '))
print('There is %d words in your sentence.' % (word_count))
print('This is your sentence backwards:')
print(sentence[::-1])