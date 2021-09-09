#Course: ITI 1120
#Assignment 1
#Saber, Amin
#0300059636

##########################
#Question 1
##########################
"""
(int, int) -> (boolean)
No preconditions
Checks to see if the two numbers make up a pythagorean pair.
"""
def pythagorean_pair(a,b):
    c= (a**2+b**2)**0.5

    return(c**2==a**2+b**2)

##########################
#Question 2
##########################
"""
(int)->(number)
precondition: speed is bigger than 0
Converts a speed from miles/hour to kilometer/hour.
"""
def mh2kh(s):
    kh = s*1.60934

    return kh


##########################
#Question 3 Ask teacher
##########################
def in_out(xs,ys,side):
    """
    (float, float, float) -> (bool)
    Precondition: side is a non negative number
    Takes three numbers as input, where xs and ys represent the coordinates of the bottom left corner of a square
    and side represents the length of the side of the square. The user inputs a coordinate and the function prints
    true if the coordinate given is inside the square and false if not.
    """
    coordinate_x=float(input("Enter a number for the x coordinate of a query point: "))
    coordinate_y=float(input("Enter a number for the y coordinate of a query point: "))
    
    x_side = xs+side
    y_side= ys+side

    return(xs <= coordinate_x <= x_side and ys <= coordinate_y <=y_side)

##########################
#Question 4
##########################
"""
(int)->(boolean)
Precondition: n is a positive two digit number
Checks to see if the number is dividable by 9 or includes the number 9 and returns the boolean.
"""

def safe(n):
    return(not(9 == n%10 or 0 == n%9 or n>90))

##########################
#Question 5
##########################
"""
(str,str,int) -> (str)
Precondition: The year has to be a positive number and the name and quote have to be strings
Returns the year the quote was created, the name of the person that the quote comes from
and the quote itself
"""
def quote_maker(quote, name, year):

    return(print('In ', year, ', a person called ' + name + ' said: ' + '"'+quote+ '"', sep=""))
    
##########################
#Question 6
##########################
"""
This function asks the user to input a quote, a name and a year and
runs the quote_maker function
"""
def quote_displayer():
    quote= input("Give me a quote")
    name= input("Who said that?")
    year= input("What year did he/she say that")

    print(quote_maker(quote, name, year))

##########################
#Question 7  Ask teacher
##########################

def rps_winner():
    """
Precondition: The choices have to be spelt the way it is told
This fuction displays the winner of a game of rock, paper and scissors.

    """
    player1 = input("""What choice did player 1 make?
Type one of the following options: rock, paper, scissors:""")
    
    player2 = input("""What choice did player 2 make?
Type one of the following options: rock, paper, scissors:""")

    winner = player1 == 'rock' and player2 == 'scissors' or player1 == 'paper' and player2=='rock' or player1 == 'scissors' and player2 == 'paper'


    draw = (player1==player2)

    print("Player 1 Wins. That is ", winner, "\n It is a tie. That is ", draw, sep="")
    
    

##########################
#Question 8  
##########################
"""
(int)->(number)
Precondition: x has to be a positive real number
This function takes the number x and passes it through the equation 10^4*y=x+3 to find y.
"""
def fun(x):
    import math
    y=(math.log10(x+3))/4
    return y

##########################
#Question 9  
##########################

"""
Precondition: The name is a sting
Using the name given this function makes a border made out of stars around it.

"""

def ascii_name_plaque(name):

    __name__ = '  __'+name+'__  '

    stars=len(__name__)

    print ("*"*(stars+2))
    print ('*'+ ' '*stars +'*')
    print ("*"+__name__+"*")
    print ('*'+ ' '*stars +'*')
    print ("*"*(stars+2))

##########################
#Question 10  
##########################
"""
This function draws a car

"""


def draw_car():

    import turtle
    s=turtle.Screen()
    t=turtle.Turtle()

    
    t.penup()
    t.goto(-500,0)
    t.pendown()
    t.goto(350,0)

    t.begin_fill()
    t.penup()
    t.goto(300,35)
    t.pendown()
    t.forward(50)
    t.left(90)
    t.forward(50)
    t.left(90)
    t.forward(30)
    t.penup()
    t.left(180)
    t.forward(15)
    t.pendown()
    t.left(90)
    t.forward(100)
    t.left(90)
    t.forward(155)
    t.left(90)
    t.forward(150)
    t.left(90)
    t.forward(120)
    t.penup()
    

    t.color('aqua')
    t.end_fill()


    
    t.pencolor('black')
    t.goto(-30,185)
    t.pendown()
    t.goto(180,185)
    t.penup()
    
    t.begin_fill()
    t.pencolor('black')
    
    t.goto(180,185)
    t.pendown()
    t.right(180)
    t.goto(125,300)
    t.forward(250)
    t.goto(-250,185)
    t.goto(180,185)
    t.penup()


    
    t.color('grey')
    t.end_fill()

    t.begin_fill()
    t.pencolor('black')

    t.pendown()
    t.goto(180,35)
    t.goto(-180,35)
    t.right(180)
    t.forward(150)
    t.left(90)
    t.forward(150)
    t.color('aqua')
    t.end_fill()
    
    t.pencolor('black')
    t.forward(115)
    t.penup()

    t.begin_fill()

    
    t.goto(-125,35)
    t.pendown()
    t.goto(-350,35)
    t.forward(50)
    t.right(90)
    t.forward(50)
    t.right(180)
    t.forward(35)
    t.goto(-335,185)
    t.right(180)
    t.goto(-30,185)
    t.right(90)
    t.forward(150)
    t.right(90)
    t.forward(95)

    
    t.color('aqua')
    t.end_fill()


    t.begin_fill()
    t.pencolor('black')

    t.penup()
    t.goto(320,140)
    t.pendown()
    t.right(90)
    t.forward(35)
    t.right(90)
    t.forward(10)
    t.right(90)
    t.forward(35)
    t.right(90)
    t.forward(10)
    t.right

    t.color('white')
    t.end_fill()

    
    t.begin_fill()
    t.pencolor('black')

    t.penup()
    t.goto(-20,150)
    t.pendown()
    t.right(90)
    t.forward(15)
    t.right(90)
    t.forward(40)
    t.right(90)
    t.forward(15)
    t.right(90)
    t.forward(40)


    t.color('black')
    t.end_fill()

    t.begin_fill()
    t.pencolor('black')

    t.penup()
    t.goto(-335,150)
    t.right(180)
    t.forward(35)
    t.left(90)
    t.forward(15)
    t.left(90)
    t.forward(35)
    t.left(90)
    t.forward(15)
    

    
    t.color('red')
    t.end_fill()




    t.begin_fill()
    t.pencolor('black')
    
    t.left(90)
    t.penup()
    t.goto(-240,0)
    t.pendown()
    t.circle(70)
    t.penup()

    t.color('black')
    t.end_fill()

    
    t.begin_fill()
    
    t.penup()
    t.goto(240,0)
    t.pendown()
    t.circle(70)
    t.penup()

    t.color('black')
    t.end_fill()

    
    t.begin_fill()

    t.goto(-240,30)
    t.down()
    t.circle(40)
    t.penup()

    t.color('gold')
    t.end_fill()

    t.begin_fill()

    t.goto(-240,70)
    t.down()
    t.circle(10)
    t.color('black')
    t.penup()
    t.end_fill()

    t.begin_fill()

    t.goto(240,30)
    t.down()
    t.circle(40)
    t.penup()

    t.color('gold')
    t.end_fill()

    t.begin_fill()

    t.goto(240,60)
    t.down()
    t.circle(10)
    

    t.color('black')
    t.end_fill()

    t.penup()
    t.goto(240,70)
    t.pendown()
    t.goto(240,120)

    t.penup()
    t.goto(240,70)
    t.pendown()
    t.goto(200,80)

    t.penup()
    t.goto(240,70)
    t.pendown()
    t.goto(200,30)

    t.penup()
    t.goto(240,70)
    t.pendown()
    t.goto(280,80)

    t.penup()
    t.goto(240,70)
    t.pendown()
    t.goto(280,30)

    t.penup()
    t.goto(-240,60)
    t.pendown()
    t.goto(-240,120)

    t.penup()
    t.goto(-240,70)
    t.pendown()
    t.goto(-200,80)

    t.penup()
    t.goto(-240,70)
    t.pendown()
    t.goto(-200,30)

    t.penup()
    t.goto(-240,70)
    t.pendown()
    t.goto(-280,80)

    t.penup()
    t.goto(-240,70)
    t.pendown()
    t.goto(-280,30)

    
##########################
#Question 11
##########################
"""
(int)-> (int)
Precondition: n is bigger or equal to 1
This functions finds the minimum number of times that a number needs to be divided by 2 in order to get a number equal
or greater to 1
"""
def alogical(n):
    import math
    
    x = (math.log(n,2))
    x = math.ceil(x)
    return x

##########################
#Question 12
##########################

def time_format(h,m):
    """
    (int,int) -> str
    Precondition: hours, h is between 0 and 23 and minutes, m is between 0 and 59 and both positive numbers
    This function prints the time as a descriptive string that indicates the time,
    wether it's x minutes past the hour given or half past the hour given or x minutes to the next hour
    
    """

    rounded_m = int(round(m/5)*5)

    if rounded_m==10:
        time= ("10 minutes past ",h," o'clock")
    elif rounded_m==15:
        time =("15 minutes past ",h," o'clock")
    elif rounded_m==20:
        time=("20 minutes past ",h," o'clock")
    elif rounded_m==25:
        time =("25 minutes past ",h," o'clock")
    elif rounded_m==30:
        time=("half past ",h," o'clock")
    elif rounded_m==35:
        time=("25 minutes to ",h+1," o'clock")
    elif rounded_m==40:
        time=("20 minutes to ",h+1," o'clock")
    elif rounded_m==45:
        time=("15 minutes to ",h+1," o'clock")
    elif rounded_m==50:
        time=("10 minutes to ",h+1," o'clock")
    elif rounded_m==55:   
        time=("5 minutes to ",h+1," o'clock")
    else:
        if h==23:
            h=0
            time=(h, " o' clock")
        else:
                if m>55:
                    time=(h+1, " o' clock")
                else:
                    time=(h, " o' clock")
    return (print(time))

##########################
#Question 13
##########################

"""
(number, number)-> number
Precondition: Both number have to be real non-negative numbers with two decimal places as input, payment is bigger than price
and the second decimal in payment is 0 or 5
This function returns a real number with 2 decimal places representing the change the customer should get in CAD
"""
    
def cad_cashier(price, payment):
    import math
    
    rounded_pr= price - math.floor(price)
    rounded_pr= rounded_pr *100
    rounded_pr = int(round(rounded_pr/5)*5)/100
    price = rounded_pr+math.floor(price)
    change = payment-price
    
    return round(change, ndigits=3)

##########################
#Question 14
##########################

def min_CAD_coins(price, payment):

    """
(number, number) -> (int,int,int,int,int)
Precondition:Both number have to be real non-negative numbers with two decimal places as input,
payment is bigger than price
and the second decimal in payment is 0 or 5
This function returns five numbers that represent the smalles number of coins that add up to the amount
owed to a customer 

    """

    import math
    change = cad_cashier(price, payment)
    change = int(change*100)

    t= change//200
    change = change-t*200
    
    l=change//100
    change = change-l*100

    q= change//25
    change = change-q*25
   

    d= change//10
    change = change-d*10
    
    n= (change+1)//5



  
     
    return (t,l,q,d,n)








