'''
Write a program that will generate a random
playing card e.g. ‘9 Hearts’, ‘Queen Spades’
when the Enter key is pressed.
Rather than generate a random number from 1
to 52. Create two random numbers – one for the
suit and one for the card.
However we don't want the same card drawn twice. Update this
program by using an array to prevent the same card being dealt
twice from the pack of cards.
Convert this code into a procedure ‘DealCard’ that will display the
card dealt or ‘no more cards’.
Call your procedure 53 times!
Blackjack.
Play a game that draws two random cards (see above).
The player then decides to draw or stick.
If the score goes over 21 the player loses (goes ‘bust’).
Keep drawing until the player sticks.
After the player sticks draw two computer cards. If the player
beats the score they win.
Added complication : Aces can be 1 or 11! The number used is
whichever gets the highest score. 
'''
import random
import keyboard
import itertools

types = ['Clubs', 'Diamonds', 'Hearts', 'Spades']
ranks = ['Ace', '2', '3', '4', '5', '6', '7', '8', '9', '10', 'Jack', 'Queen', 'King']

deck_of_cards = list(map(' '.join, itertools.chain(itertools.product(ranks, types))))

player_score = 0
computer_score = 0
turn = 4

def deal_card():
    used_cards = []
    print('Press Enter to pick a card.')
    while len(used_cards) < 52:
        keyboard.wait('Enter')
        current_card = random.choice(deck_of_cards)
        if current_card not in used_cards:
            used_cards.append(current_card)
            deck_of_cards.remove(current_card)
            print(current_card)
            return current_card
        # print(used_cards) # can be on to print what cards have been dealt after every turn
    print('No more cards.')

def check_card():
    check = deal_card()
    if 'Ace' in check:
        return 'Ace'
    elif '2' in check:
        return 2
    elif '3' in check:
        return 3
    elif '4' in check:
        return 4
    elif '5' in check:
        return 5
    elif '6' in check:
        return 6
    elif '7' in check:
        return 7
    elif '8' in check:
        return 8
    elif '9' in check:
        return 9
    else:
        return 10

def game_turn():
    global turn
    while turn > 0:
        if turn % 2 == 0:
            result = check_card()
            global player_score
            if result == 'Ace' and (player_score + 11) <= 21:
                result = 11
                player_score += result
                print('Player gets %d points, total score: %d' % (result, player_score))
            elif result == 'Ace' and (player_score + 11) > 21:
                result = 1
                player_score += result
                print('Player gets %d points, total score: %d' % (result, player_score))
            else:
                player_score += result
                print('Player gets %d points, total score: %d' % (result, player_score))
            
        else:
            result = check_card()
            global computer_score
            if result == 'Ace' and (computer_score + 11) <= 21:
                result = 11
                computer_score += result
                print('Computer gets %d points, total score: %d' % (result, computer_score))
            elif result == 'Ace' and (computer_score + 11) > 21:
                result = 1
                computer_score += result
                print('Computer gets %d points, total score: %d' % (result, computer_score))
            else:
                computer_score += result
                print('Computer gets %d points, total score: %d' % (result, computer_score))
            
        turn -= 1
    print('Player %d points vs Computer %d points.' % (player_score, computer_score))
       
def blackjack():
    global turn
    global player_score
    global computer_score
    while player_score < 21 and computer_score < 21:
        game_turn()
        if player_score == 21 or computer_score == 21:
            if player_score == computer_score:
                turn = 0
                print('Draw.')
            elif player_score == 21:
                turn = 0
                print('Player Won.')
            elif computer_score == 21:
                turn = 0
                print('Computer Won.')
            break
        elif player_score > 21 or computer_score > 21:
            if player_score > 21 and computer_score > 21:
                turn = 0
                print('Both bust.')
            elif player_score > 21:
                turn = 0
                print('Player bust.')
            elif computer_score > 21:
                turn = 0
                print('Computer bust.')
            break
        else:
            choice = str(input('Do you want to draw another card? Y/N '))
            if choice.lower() == 'y':
                turn = 2
                blackjack()
            elif choice.lower() == 'n' or turn == 1:
                computer = [0, 1]
                computer_choice = random.choice(computer)
                if computer_choice == 1:
                    turn = 1
                    blackjack()
                else:
                    x = 21 - player_score
                    y = 21 - computer_score
                    if x < y:
                        print('Player won.')
                    elif x > y:
                        print('Computer won.')
                    else:
                        print('Draw.')
                    break

blackjack()
