'''
Player 1 types in a word
Player 2 has to guess the word in 5 lives
The display would look like this
Word to guess: ******
You have 5 lives left - Letter? E
Word to guess: **EE*E
You have 5 lives left - Letter? Z
Word to guess: **EE*E
You have 4 lives left - Letter? 
'''
def hangman():
    lives = 5
    word = str(input('Please type in the word to guess. '))
    letters = []

    while lives != 0:
        guess = str(input('\nYou have %d lives left - Letter? ' % (lives)))
        letters.append(guess)
        for char in range(0, len(word)):
            if word[char] in letters:
                print(word[char], end= '')
            elif word[char] == ' ':
                print(' ', end= '')
            else:
                print('*', end= '')
        
        if guess not in word:
            lives -= 1

        if lives == 0:
            print('\nSorry, no more lives. Word to guess: %s' % (word))

        if len(letters) == len(word):
            break

hangman()