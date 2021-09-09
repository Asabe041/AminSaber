

def split_tester(N, d):

    """
    (str, str)-> boolean
    Precondition: N must be a string of number and d must be a integer 
    This functions return True if the sequence of numbers is increasing and false otherwise
    it also prints a sequence of numbers given which have a length of (d) seperated by a comma

    """
    # Your code for split_tester function goes here (instead of keyword pass)
    # Your code should include  dosctrings and the body of the function
    i=0
    split=''
    number=''
    counter=0
    comma_splice=0
    increasing=0
    increasing_sequence=True
    for num in N:
        split=(split+num)
        i=i+1
        if i==int(d):
            if comma_splice+1 != (len(N)//int(d)):
                print(split,end=', ')
                split=''
                i=0
                comma_splice=comma_splice+1
            else:
                print(split)
                
            
    for num in N:
        number=number+num
        counter=counter+1
        if counter==int(d):
            if int(number) <= increasing:
                increasing_sequence=False
            increasing=int(number)
            counter=0
            number=''
    return increasing_sequence
    
                        
# you can add more function definitions here if you like       

def ascii_name_plaque(name):

    """
    (str)
    Precondition: The name is a sting
    Using the name given this function makes a border made out of stars around it.

    """

    __name__ = '  __'+name+'__  '

    stars=len(__name__)

    print ("*"*(stars+2))
    print ('*'+ ' '*stars +'*')
    print ("*"+__name__+"*")
    print ('*'+ ' '*stars +'*')
    print ("*"*(stars+2))

            
# main     
# Your code for the welcome message goes here, instead of name="Vida"
    
welcome= 'Welcome the increasingsplit tester function'
ascii_name_plaque(welcome)
name= input('What is your name? ')
ascii_name_plaque(name+', welcome to the increasing split tester function')
    
flag=True
while flag:
    question=input(name+", would you like to test if a number admits an increasing-split of give size? ")
    question=(question.strip()).lower()
    if question=='no':
        flag=False
   
    #YOUR CODE GOES HERE. The next line should be elif or else.
    elif question == 'yes':
        print('Good choice!')

        N = input('Enter a positive integer:' )
        N= (N.strip())
        
        if  N.isdigit() and int(N)>0:
            print('Input the split. The split has to divide the length of '+N+' by i.e.', len(N))
            d=input('')
            d=(d.strip())
            if d.isdigit():
                
                if len(N)%int(d)==0 and d.isdigit():
                    increasing=split_tester(N,d)
                    if increasing == True or len(N)==int(d):
                        print('The sequence is increasing')
                    else:
                        print('The sequence is not increasing')
                else:
                    print(d, ' does not divide ', len(N) )
                
            else:
                print('Input can only contain digits' )
                

            
        else:
            print(N, ' was not a positive integer')
        flag=True
        
    else:
        print('Please answer with yes or no')
        flag=True
        
#finally your code goes here too.
ascii_name_plaque('Good bye '+name+'!' )
