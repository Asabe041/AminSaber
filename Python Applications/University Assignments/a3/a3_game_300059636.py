import random

# Read and understand the docstrings of all of the functions in detail.


def make_deck(num):
    '''(int)->list of int
        Returns a list of integers representing the strange deck with num ranks.

    >>> deck=make_deck(13)
    >>> deck
    [101, 201, 301, 401, 102, 202, 302, 402, 103, 203, 303, 403, 104, 204, 304, 404, 105, 205, 305, 405, 106, 206, 306, 406, 107, 207, 307, 407, 108, 208, 308, 408, 109, 209, 309, 409, 110, 210, 310, 410, 111, 211, 311, 411, 112, 212, 312, 412, 113, 213, 313, 413]

    >>> deck=make_deck(4)
    >>> deck
    [101, 201, 301, 401, 102, 202, 302, 402, 103, 203, 303, 403, 104, 204, 304, 404]
    
    '''
    l=[]
    for i in range(1,num+1):
        l=l+[100+i,200+i,300+i,400+i]
    return l

def shuffle_deck(deck):
    '''(list of int)->None
       Shuffles the given list of strings representing the playing deck

    Here you should use random.shuffle function from random module.
    
    Since shufflling is random, exceptionally in this function
    your output does not need to match that show in examples below:

    >>> deck=[101, 201, 301, 401, 102, 202, 302, 402, 103, 203, 303, 403, 104, 204, 304, 404]
    >>> shuffle_deck(deck)
    >>> deck
    [102, 101, 302, 104, 304, 103, 301, 403, 401, 404, 203, 204, 303, 202, 402, 201]
    >>> shuffle_deck(deck)
    >>> deck
    [402, 302, 303, 102, 104, 103, 203, 301, 401, 403, 204, 101, 304, 201, 404, 202]
    '''
    random.shuffle(deck)

def deal_cards_start(deck):
     '''(list of int)-> list of int

     Returns a list representing the player's starting hand.
     It is  obtained by dealing the first 7 cards from the top of the deck.
     Precondition: len(deck)>=7
     '''
     dealt_cards=[]
     for i in range(len(deck)-1,len(deck)-8,-1):
         dealt_cards.append(deck[i])
         deck.remove(deck[i])
     return dealt_cards
     


def deal_new_cards(deck, player, num):
    '''(list of int, list of int, int)-> None
    Given the remaining deck, current player's hand and an integer num,
    the function deals num cards to the player from the top of the deck.
    If len(deck)<num then len(deck) cards is dealt, in particular
    all the remaining cards from the deck are dealt.

    Precondition: 1<=num<=6 deck and player are disjoint subsets of the strange deck. 
    
    >>> deck=[201, 303, 210, 407, 213, 313]
    >>> player=[302, 304, 404]
    >>> deal_new_cards(deck, player, 4)
    >>> player
    [302, 304, 404, 313, 213, 407, 210]
    >>> deck
    [201, 303]
    >>>

    >>> deck=[201, 303]
    >>> player=[302, 304, 404]
    >>> deal_new_cards(deck, player, 4)
    >>> player
    [302, 304, 404, 303, 201]
    >>> deck
    []
    '''
    if 1<=num<=6:
        for i in range(len(deck)-1,len(deck)-(num+1),-1):
            player.append(deck[i])
            deck.remove(deck[i])


def print_deck_twice(hand):
    '''(list)->None
    Prints elements of a given list deck in two useful ways.
    First way: sorted by suit and then rank.
    Second way: sorted by rank.
    Precondition: hand is a subset of the strange deck.
    
    Your function should not change the order of elements in list hand.
    You should first make a copy of the list and then call sorting functions/methods.

    Example run:
    >>> a=[311, 409, 305, 104, 301, 204, 101, 306, 313, 202, 303, 410, 401, 105, 407, 408]
    >>> print_deck_twice(a)

    101 104 105 202 204 301 303 305 306 311 313 401 407 408 409 410 

    101 301 401 202 303 104 204 105 305 306 407 408 409 410 311 313 
    >>> a
    [311, 409, 305, 104, 301, 204, 101, 306, 313, 202, 303, 410, 401, 105, 407, 408]

    '''
    l1=[]
    l1=l1+hand
    l1.sort()
    
    for num in l1:
        print(num,end=' ')
    print('\n')
    l2=[]
    for i in range(14):
        for num in l1:
          if num%100==i:
              l2.append(num)
              
    for num in l2:
        print (num,end=' ')

    print()


def is_valid(cards, player):
    '''(list of int, list of int)->bool
    Function returns True if every card in cards is the player's hand.
    Otherwise it prints an error message and then returns False,
    as illustrated in the followinng example runs.

    Precondition: cards and player are subsets of the strange deck.
    
    >>> is_valid([210,310],[201, 201, 210, 302, 311])
    310 not in your hand. Invalid input
    False

    >>> is_valid([210,310],[201, 201, 210, 302, 310, 401])
    True
    '''
    for number in cards:
        if number not in player:
            print (number, ' not in your hand. Invalid input')
            return False
    return True
                

def is_discardable_kind(cards):
    '''(list of int)->True
    Function returns True if cards form 2-, 3- or 4- of a kind of the strange deck.
    Otherwise it returns False. If there  is not enough cards for a meld it also prints  a message about it,
    as illustrated in the followinng example runs.
    
    Precondition: cards is a subset of the strange deck.

    In this function you CANNOT use strings except in calls to print function. 
    In particular, you cannot convert elements of cards to strings.
    
    >>> is_discardable_kind([207, 107, 407])
    True
    >>> is_discardable_kind([207, 107, 405, 305])
    False
    >>> is_discardable_kind([207])
    Invalid input. Discardable set needs to have at least 2 cards.
    False
    '''
    x=1
    if len(cards)<2:
        print("Invalid input. Discardable set needs to have at least 2 cards.")
        return False
    
    else:
        for i in range(len(cards)-1):
            if (cards[i]%100)==(cards[i+1]%100):
                x=x+1
            else:
                x=1
            if x==2:
                return True 
        if x<2:
            return False


def is_discardable_seq(cards):
    '''(list of int)->True
    Function returns True if cards form progression of the strange deck.
    Otherwise it prints an error message and then returns False,
    as illustrated in the followinng example runs.
    Precondition: cards is a subset of the strange deck.

    In this function you CANNOT use strings except in calls to print function. 
    In particular, you cannot conver elements of cards to strings.

    >>> is_discardable_seq([313, 311, 312])
    True
    >>> is_discardable_seq([311, 312, 313, 414])
    Invalid sequence. Cards are not of same suit.
    False
    >>> is_discardable_seq([311,312,313,316])
    Invalid sequence. While the cards are of the same suit the ranks are not consecutive integers.
    False
    >>> is_discardable_seq([201, 202])
    Invalid sequence. Discardable sequence needs to have at least 3 cards.
    False
    >>> is_discardable_seq([])
    Invalid sequence. Discardable sequence needs to have at least 3 cards.
    False
    '''
    l=[]
    l=l+cards
    l.sort()
    x=1
    if len(cards)<3:
        print('Invalid sequence. Discardable sequence needs to have at least 3 cards.')
        return False
    for i in range(len(l)-1):
        if l[i]//100 != l[i+1]//100:
            print('Invalid sequence. Cards are not of same suit.')
            return False
    for i in range(len(l)-1):
        if l[i]%100==(l[i+1]%100)-1:
            x=x+1
        else:
            print("Invalid sequence. While the cards are of the same suit the ranks are not consecutive integers.")
            return False
            x=1
        if x==len(l):
            return True

    
def rolled_one_round(player):
    '''(list of int)->None
    This function plays the part when the player rolls 1
    Precondition: player is a subset of the strange deck

    >>> #example 1:
    >>> rolled_one_round(player)
    Discard any card of your choosing.
    Which card would you like to discard? 103
    103
    No such card in your hand. Try again.
    Which card would you like to discard? 102

    Here is your new hand printed in two ways:

    201 212 311 

    201 311 212 

    '''
    flag=True
    print('Discard any card of your choosing.')
    while flag==True:
        card_discarded=int(input('which card would you like to discard'))
        if card_discarded in player:
            player.remove(card_discarded)
            flag=False
        else:
            print('No such card in your hand. Try again.')
    print('\nHere is your new hand printed in two ways:\n')
    print_deck_twice(player)
    

def rolled_nonone_round(player):
     '''(list of int)->None
    This function plays the part when the player rolls 2, 3, 4, 5, or 6.
    Precondition: player is a subset of the strange deck

    >>> #example 1:
    >>> player=[401, 102, 403, 104, 203]
    >>> rolled_nonone_round(player)
    Yes or no, do you  have a sequences of three or more cards of the same suit or two or more of a kind? yes
    Which 3+ sequence or 2+ of a kind would you like to discard? Type in cards separated by space: 102 103 104
    103 not in your hand. Invalid input
    Yes or no, do you  have a sequences of three or more cards of the same suit or two or more of a kind? yes
    Which 3+ sequence or 2+ of a kind would you like to discard? Type in cards separated by space: 403 203

    Here is your new hand printed in two ways:

    102 104 401 

    401 102 104 
    Yes or no, do you  have a sequences of three or more cards of the same suit or two or more of a kind? no

    >>> #example 2:
    >>> player=[211, 412, 411, 103, 413]
    >>> rolled_nonone_round(player)
    Yes or no, do you  have a sequences of three or more cards of the same suit or two or more of a kind? yes
    Which 3+ sequence or 2+ of a kind would you like to discard? Type in cards separated by space: 411 412 413

    Here is your new hand printed in two ways:

    103 211 

    103 211 
    Yes or no, do you  have a sequences of three or more cards of the same suit or two or more of a kind? no

    >>> #example 3:
    >>> player=[211, 412, 411, 103, 413]
    >>> rolled_nonone_round(player)
    Yes or no, do you  have a sequences of three or more cards of the same suit or two or more of a kind? yes
    Which 3+ sequence or 2+ of a kind would you like to discard? Type in cards separated by space: 411 412
    Invalid sequence. Discardable sequence needs to have at least 3 cards.

    >>> #example 4:
    >>> player=[401, 102, 403, 104, 203]
    >>> rolled_nonone_round(player)
    Yes or no, do you  have a sequences of three or more cards of the same suit or two or more of a kind? alsj
    Yes or no, do you  have a sequences of three or more cards of the same suit or two or more of a kind? hlakj
    Yes or no, do you  have a sequences of three or more cards of the same suit or two or more of a kind? 22 33
    Yes or no, do you  have a sequences of three or more cards of the same suit or two or more of a kind? no
    '''

     flag=True
     melds=[]
     while flag:
        melds=[]
        question=input("Yes or no, do you have a sequence of three or more cards of the same suit or two or more of a kind? ")
        question=(question.strip()).lower()
        if question=='no':
            flag=False
        elif question == 'yes':
            cards= input('Which 3+ sequence or 2+ of a kind would you like to discard? Type in cards separated by space:' )
            cards= (cards.strip()).split()
            for num in cards:
                melds.append(int(num))
            print(melds)
            if is_valid(melds, player):
                if is_discardable_kind(melds) or is_discardable_seq(melds):
                    for num in melds:
                        player.remove(num)
                    print('\nHere is your new hand printed in two ways:\n')
                    print_deck_twice(player)
                    flag=True
                else:
                    melds=[]
                    flag=True
                    
            else:
                cards=[]
                melds=[]
                flag=True 
        else:
            flag=True



# main
print("Welcome to Single Player Rummy with Dice and strange deck.\n")
size_change=input("The standard deck  has 52 cards: 13 ranks times 4 suits.\nWould you like to change the number of cards by changing the number of ranks? ").strip().lower()

# YOUR CODE GOES HERE and in all of the above functions instead of keyword pass

if size_change=='yes':
    number_of_cards=input('Enter a number between 3 and 99, for the numbers of ranks: ').strip()
    hand=make_deck(int(number_of_cards))
    print('You are playing with a deck of ', int(number_of_cards)*4, ' cards')

else:
    hand=make_deck(13)
    print('You are playing with a deck of 52 cards')
    
shuffle_deck(hand)
player=deal_cards_start(hand)

print ('Here is your starting hand printed in two ways: \n')

print_deck_twice(player)
i=1
flag=True
while flag:
    print('Welcome to round ', i,'.')
    print('Please roll the dice.')
    dice=random.randint(1,6)
    if len(hand)<=dice:
        if 2<=dice<=6:
            print('You rolled the dice and it shows:',dice,' \nSince your rolled, ' ,dice , 'the following',dice ,' or', len(hand), ' (if the deck has less than n 3 cards will be added to your hand from the top of the deck.)')
            deal_new_cards(hand, player, len(hand))
            print ('Here is your starting hand printed in two ways: \n')

            print_deck_twice(player)


            rolled_nonone_round(player)
            print('Round ',i ,' completed.')
            i=i+1
            print('Welcome to round ', i,'. \nThe game is in empty deck phase.')
            for x in range(0,len(player)):
                rolled_one_round(player)
                print('Round ',i+x,' completed')
                x=x+1
            print('Congratulations, you completed the game in',(i+x)-1,' rounds.')
            flag=False
            
        else:
            print('You rolled the dice and it shows:',dice)
            rolled_one_round(player)
            print('Round ',i ,' completed.')
            i=i+1
            print('Welcome to round ', i,'. \nThe game is in empty deck phase.')
            rolled_nonone_round(player)
            for x in range(0,len(player)+1):
                rolled_one_round(player)
                print('Round ',i+x,' completed')
                x=x+1
            print('Congratulations, you completed the game in',(i+x)-1,' rounds.')
            flag=False
            
        
    else:
        if 2<=dice<=6:
            print('You rolled the dice and it shows:',dice, ' \nSince your rolled, ' ,dice ,'the following',dice ,' or', len(hand), ' (if the deck has less than n 3 cards will be added to your hand from the top of the deck.)')
            deal_new_cards(hand, player, dice)
            print ('Here is your starting hand printed in two ways: \n')

            print_deck_twice(player)


            rolled_nonone_round(player)
            print('Round ',i ,' completed.')
            i=i+1
        else:
             print('You rolled the dice and it shows:',dice)
             rolled_one_round(player)
             print('Round ',i ,' completed.')
             i=i+1
            
        
    
    
    








    




