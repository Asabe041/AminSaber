import random

def create_network(file_name):
    '''(str)->list of tuples where each tuple has 2 elements the first is int and the second is list of int

    Precondition: file_name has data on social netowrk. In particular:
    The first line in the file contains the number of users in the social network
    Each line that follows has two numbers. The first is a user ID (int) in the social network,
    the second is the ID of his/her friend.
    The friendship is only listed once with the user ID always being smaller than friend ID.
    For example, if 7 and 50 are friends there is a line in the file with 7 50 entry, but there is line 50 7.
    There is no user without a friend
    Users sorted by ID, friends of each user are sorted by ID
    Returns the 2D list representing the frendship nework as described above
    where the network is sorted by the ID and each list of int (in a tuple) is sorted (i.e. each list of friens is sorted).
    '''
    friends = open(file_name).read().splitlines()
    
    network=[]
    number_of_users=friends[0]
    friends.pop(0)
    l_of_friends=[]
    friends_of_user=[]
    friends_of_users=[]
    new_l=[]
    lst=[]
    
    for pair in friends:
        l_of_friends.append(pair.split())

    l=[l_of_friends[0][0]]

    for  j in range(len(l_of_friends)-1):
        if l_of_friends[j][0] != l_of_friends[j+1][0]:
            l.append(l_of_friends[j+1][0])
    
    
    for i in range(len(l)):
        for counter in range(len(friends_of_users)):
            if int(l[i]) in friends_of_users[counter]:
                friends_of_user.append(int(l[counter]))
                
        for number in l_of_friends:
            if number[0] == l[i]:
                friends_of_user.append(int(number[1]))
            
        friends_of_users.append(friends_of_user)
        friends_of_user=[]

    for n in l:
        lst.append(int(n))
    lst.sort()

    for i in range(len(lst)):
        network.append((lst[i], friends_of_users[i]))
    
        
    lst2=[]
    for i in range(len(l_of_friends)):
        if int(l_of_friends[i][1]) not in lst2:
            lst2.append(int(l_of_friends[i][1]))
    
    
    
    for ele in lst2:
        if ele not in lst:
            new_l.append(ele)
    
    
    new_l.sort()
    adding_list=[]
    for number in new_l:
        i=0
        while i < len(network):
            if number in network[i][1]:
                adding_list.append(network[i][0])
                
            i=i+1
        network.append((number, adding_list))
        adding_list=[]
        
        
    network.sort()
    

    # YOUR CODE GOES HERE
    
    return network

def getCommonFriends(user1, user2, network):
    '''(int, int, 2D list) ->list
    Precondition: user1 and user2 IDs in the network. 2D list sorted by the IDs, 
    and friends of user 1 and user 2 sorted 
    Given a 2D-list for friendship network, returns the sorted list of common friends of user1 and user2
    '''
    common=[]
    b=0
    e = len(network) - 1
    
    d=0
    f= len(network) - 1
    
    while b != e + 1:
        mid = (b + e) // 2
        if network[mid][0] < user1:
            b=mid+1
        else:
            e=mid-1
            
   
    if 0 <= b < len(network) and network[b][0] == user1:
        i_user1=b

    while d != f + 1:
        milieu = (d + f) // 2
        if network[milieu][0]<user2:
            d= milieu+1
        else:
            f= milieu-1
            
    if 0 <= d < len(network) and network[d][0] == user2:
        i_user2 = d
        
    for num in network[i_user1][1]:
            if num in network[i_user2][1]:
                common=common+[num]
        
        
    # YOUR CODE GOES HERE
   
    return common

    
def recommend(user, network):
    '''(int, 2Dlist)->int or None
    Given a 2D-list for friendship network, returns None if there is no other person
    who has at least one neighbour in common with the given user and who the user does
    not know already.
    
    Otherwise it returns the ID of the recommended friend. A recommended friend is a person
    you are not already friends with and with whom you have the most friends in common in the whole network.
    If there is more than one person with whom you have the maximum number of friends in common
    return the one with the smallest ID. '''

    # YOUR CODE GOES HERE
    b=0
    e = len(network) - 1
    index=0
    temp_max=0
    curr_max=0
    
    while b != e + 1:
        mid = (b + e) // 2
        if network[mid][0] < user:
            b=mid+1
        else:
            e=mid-1
    if 0 <= b < len(network) and network[b][0] == user:
        i_user=b


        
    i=0
    while i<len(network):
        if network[i][0]!=user and user not in network[i][1]:
            temp_max=len(getCommonFriends(user,network[i][0],network))
        if temp_max>curr_max:
            curr_max=temp_max
            savenum=network[i][0]
        i=i+1

    if curr_max==0:
        return None

    return savenum
    
def k_or_more_friends(network, k):
    '''(2Dlist,int)->int
    Given a 2D-list for friendship network and non-negative integer k,
    returns the number of users who have at least k friends in the network
    Precondition: k is non-negative'''
    
    # YOUR CODE GOES HERE
    i=0
    m=0
    while m < len(network):
        if len(network[m][1]) >= k:
            i=i+1
        m=m+1
    
    return i
 

def maximum_num_friends(network):
    '''(2Dlist)->int
    Given a 2D-list for friendship network,
    returns the maximum number of friends any user in the network has.
    '''
    # YOUR CODE GOES HERE
    x=0
    for num in network:
        if len(num[1])>x:
            x=len(num[1])
        
    return x
    

def people_with_most_friends(network):
    '''(2Dlist)->1D list
    Given a 2D-list for friendship network, returns a list of people (IDs) who have the most friends in network.'''
    max_friends=[]
    # YOUR CODE GOES HERE
    x=maximum_num_friends(network)
    for num in network:
        if len(num[1])==x:
            max_friends.append(num[0])

    return max_friends
    

def average_num_friends(network):
    '''(2Dlist)->number
    Returns an average number of friends overs all users in the network'''

    # YOUR CODE GOES HERE
    average=[]
    for num in network:
        for number in num[1]:
            average.append(number)
        
    average_friends=len(average)/len(network)
    
    
    return average_friends

def knows_everyone(network):
    '''(2Dlist)->bool
    Given a 2D-list for friendship network,
    returns True if there is a user in the network who knows everyone
    and False otherwise'''
    
    # YOUR CODE GOES HERE
    for num in network:
        if len(num[1])==len(network)-1:
            return True
    return False

####### CHATTING WITH USER CODE:

def is_valid_file_name():
    '''None->str or None'''
    file_name = None
    try:
        file_name=input("Enter the name of the file: ").strip()
        f=open(file_name)
        f.close()
    except FileNotFoundError:
        print("There is no file with that name. Try again.")
        file_name=None
    return file_name 

def get_file_name():
    '''()->str
    Keeps on asking for a file name that exists in the current folder,
    until it succeeds in getting a valid file name.
    Once it succeeds, it returns a string containing that file name'''
    file_name=None
    while file_name==None:
        file_name=is_valid_file_name()
    return file_name


def get_uid(network):
    '''(2Dlist)->int
    Keeps on asking for a user ID that exists in the network
    until it succeeds. Then it returns it'''
    
    # YOUR CODE GOES HERE
    
    while 1<2:
        try:
            user_id= int(input('Enter an integer for a user ID').strip())
            for num in network:
                if user_id == num[0]:
                    return user_id
                    not_user_id=False
                    
            print('That was not an integer. Please try again.')
                    
        except ValueError:
            print('That was not an integer. Please try again.')
        
    

##############################
# main
##############################

# NOTHING FOLLOWING THIS LINE CAN BE REMOVED or MODIFIED

file_name=get_file_name()
    
net=create_network(file_name)

print("\nFirst general statistics about the social network:\n")

print("This social network has", len(net), "people/users.")
print("In this social network the maximum number of friends that any one person has is "+str(maximum_num_friends(net))+".")
print("The average number of friends is "+str(average_num_friends(net))+".")
mf=people_with_most_friends(net)
print("There are", len(mf), "people with "+str(maximum_num_friends(net))+" friends and here are their IDs:", end=" ")
for item in mf:
    print(item, end=" ")

print("\n\nI now pick a number at random.", end=" ")
k=random.randint(0,len(net)//4)
print("\nThat number is: "+str(k)+". Let's see how many people has that many friends.")
print("There is", k_or_more_friends(net,k), "people with", k, "or more friends")

if knows_everyone(net):
    print("\nThere at least one person that knows everyone.")
else:
    print("\nThere is nobody that knows everyone.")

print("\nWe are now ready to recommend a friend for a user you specify.")
uid=get_uid(net)
rec=recommend(uid, net)
if rec==None:
    print("We have nobody to recommend for user with ID", uid, "since he/she is dominating in their connected component")
else:
    print("For user with ID", uid,"we recommend the user with ID",rec)
    print("That is because users", uid, "and",rec, "have", len(getCommonFriends(uid,rec,net)), "common friends and")
    print("user", uid, "does not have more common friends with anyone else.")
        

print("\nFinally, you showed interest in knowing common friends of some pairs of users.")
print("About 1st user ...")
uid1=get_uid(net)
print("About 2st user ...")
uid2=get_uid(net)
print("Here is the list of common friends of", uid1, "and", uid2)
common=getCommonFriends(uid1,uid2,net)
for item in common:
    print(item, end=" ")

    
