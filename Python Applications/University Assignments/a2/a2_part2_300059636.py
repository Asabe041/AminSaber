######################################
#Question 1
######################################


def min_enclosing_rectangle(radius,x,y):
    """
    (number,number,number)->number
    Precondition: 

    """
    if radius<0:
        return None
    else:
        coordinate_x=x-radius
        coordinate_y=y-radius
        return(coordinate_x,coordinate_y)

######################################
#Question 2
######################################
def series_sum():
    """
    ->number
    The function returns teh sumer of the following series 1000 + 1/12 + 1/22 + 1/32 + 1/42 + ... + 1/n2
    """
    x=0
    number=int(input('Please enter a positive integer:'))
    
    if number < 0:
        return None
    else:
        for n in range(1,number+1):
            x=x+1/n**2

        return (1000+x)
######################################
#Question 3
######################################
def pell(n):
    """
    (int)->int
    Takes one positive integer parameter and returns the nth Pell number, if n is negative returns None
    """
    if n<0:
        return None
    elif n==0 or n==1:
        pell_number=n
    else:
        pell_number=round(2*(((1+(2)**(1/2))**(n-1))-(1-(2)**(1/2))**(n-1))/ (2*(2)**(1/2)) + (((1+(2)**(1/2))**(n-2))-(1-(2)**(1/2))**(n-2))/ (2*(2)**(1/2)))
    return pell_number
    
######################################
#Question 4
######################################
def countMembers(s):
    """
    (str)
    This function counts the ammount of times an extraordinary characters are in a string
    """
    i=0
    for char in s:
        if char in "efghijFGHIJKLMNOPQRSTUVWX23456!\\,":
            i=i+1
    return i
        
    
######################################
#Question 5
######################################
def casual_number(s):
    """
    (str)->int
    This functions returns a the ammount of money one wrote as a number without any comma and fixes common mistakes like
    two negative signs
    """
    s=s.replace(',','')
    
    if s.isdigit() or s.count('-')==1:
        if len(s)==1 and s.count('-')==1:
            return None
        else:
            return int(s)
    else:
        return None
    
######################################
#Question 6
######################################
def alienNumbers(s):
    """
    str)->int
    This function returns the sum of the values that aliens use as numbers, t=1024, y=598, !=121, a=42, N=6, U=1
    """
    value_T=s.count('T')*1024
    value_y=s.count('y')*598
    value_ex=s.count('!')*121
    value_a=s.count('a')*42
    value_N=s.count('N')*6
    value_U=s.count('U')*1

    total=value_T+value_y+value_ex+value_a+value_N+value_U
    return total
    
    
######################################
#Question 7
######################################
def alienNumbersAgain(s):
    """
    (str)->int
    This function returns the sum of the values that aliens use as numbers, t=1024, y=598, !=121, a=42, N=6, U=1
    """
    total=0
    for char in s:
        if char in 'U':
            total= total+1
        if char in 'N':
            total= total+6
        if char in 'a':
            total=total+42
        if char in '!' :
            total= total+121
        if char in 'y' :
            total= total+598
        if char in 'T' :
            total= total+1024
        if char not in 'UNa!yT':
            total=total+0
    return total
            
        
######################################
#Question 8
######################################

def encrypt(s):
    """
    (str)->str
    This function returns a the string given but in inverse and with brings characters, on opposite sides, together
    for example:
    encrypt("Hello, world")
    'dHlerlolwo ,'
    
    """
    import math
    backwards=''
    encrypted=''
    for i in range(len(s)-1,-1,-1):
        backwards=backwards+s[i]
        
    for i in range(0,math.floor(len(s)//2)):
        encrypted=encrypted+backwards[i]+backwards[(len(s)-1)-i]

    if len(s)%2!=0:
        encrypted=encrypted+backwards[math.floor(len(s)//2)]
    return encrypted
        

######################################
#Question 9
######################################
def oPify(s):
    """
    (str)->str
    This functions returns a string with 'op' between two consecutive letters in the alphabet,
    if a character in the string is uppercase then either the o or the p would be aswell, whichever is touching it
    if there is a number then o and p would not be inserted before and after it 
    """
    sop=''
    if len(s)==1:
        sop=s
    else:    
        for i in range(0,len(s)-1):
            if s[i].isalpha() and s[i+1].isalpha():
                if s[i].isupper() and s[i+1].isupper():
                    sop=sop+s[i]+'OP'
                elif s[i].islower() and s[i+1].islower():
                    sop=sop+s[i]+'op'
                elif s[i].isupper() and s[i+1].islower():
                    sop=sop+s[i]+'Op'
                elif s[i].islower() and s[i+1].isupper():
                    sop=sop+s[i]+'oP'
            else:
                sop=sop+s[i]
                
        sop=sop+s[len(s)-1]
        
    return sop
        
######################################
#Question 10
######################################

def nonrepetitive(s):
    """
    (str)->boolean
    This functions checks a given string to see if it has the same subword twice in a row and returns True or False
    wether is true or not
    """
    s1=''
    if len(s)==0 or len(s)==1:
        return True
    
    for i in range(0,len(s)):
        for count in range(1,len(s)+1):
            s1=s[i:i+count]
            if s1==s[i+count:2*count+i]:
                return False
            

    return True


















        









    
