'''
Create a program with the following record structure
Structure Results
HomeTeam as string
HomeTeamScore as integer
AwayTeam as string
AwayTeamScore as integer
End Structure
Make an array of 20 Results
Create a program with a menu whose options are
1. Add a result
2. Search for all results for a team
Write the code to carry out these two things.
If option 1 is selected
 collect the result and add it to the end of the results array
If option 2 is selected
 Collect team name
 display all the results that in includes that team in either the
home or away team
Hint
Include a variable to store the current number of results
'''
scores = {
    'HomeTeam': [0, 0, 1, 1, 2, 2, 2, 1, 2, 2],
    'AwayTeam': [2, 1, 2, 2, 0, 1, 0, 2, 1, 1]
}



def add_result():
    print('0 = Lost Game, 1 = Draw, 2 = Win')
    choice = str(input('Do you want to add \'H\'ome or \'A\'way score? '))
    if choice.lower() == 'h':
        i = int(input('Please add Home score now. '))
        scores['HomeTeam'].append(i)
        print('Results at Home:', scores['HomeTeam'])
    elif choice.lower() == 'a':
        i = int(input('Please add Away score now. '))
        scores['AwayTeam'].append(i)
        print('Results Away:', scores['AwayTeam'])
    else:
        print('You didn\'t choose right option.')

def number_of_results():
    choice = str(input('Do you want to see \'H\'ome or \'A\'way results? '))
    if choice.lower() == 'h':
        total_scores = len(scores['HomeTeam'])
        print('Number of results for games at home are:', total_scores)
    elif choice.lower() == 'a':
        total_scores = len(scores['AwayTeam'])
        print('Number of results for games away are:', total_scores)
    else:
        print('You didn\'t choose right option.')
    
what_to_do = str(input('Do you want to \'A\'dd score or \'V\'iew scores? '))
if what_to_do.lower() == 'a':
    add_result()
elif what_to_do.lower() == 'v':
    number_of_results()
else:
    print('You didn\'t choose right option.')
