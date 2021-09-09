class Point:
    'class that represents a point in the plane'

    def __init__(self, xcoord=0, ycoord=0):
        ''' (Point,number, number) -> None
        initialize point coordinates to (xcoord, ycoord)'''
        self.x = xcoord
        self.y = ycoord

    def setx(self, xcoord):
        ''' (Point,number)->None
        Sets x coordinate of point to xcoord'''
        self.x = xcoord

    def sety(self, ycoord):
        ''' (Point,number)->None
        Sets y coordinate of point to ycoord'''
        self.y = ycoord

    def get(self):
        '''(Point)->tuple
        Returns a tuple with x and y coordinates of the point'''
        return (self.x, self.y)

    def move(self, dx, dy):
        '''(Point,number,number)->None
        changes the x and y coordinates by dx and dy'''
        self.x += dx
        self.y += dy

    def __eq__(self, other):
        '''(Point,Point)->bool
        Returns True if self and other have the same coordinates'''
        return self.x == other.x and self.y == other.y
    def __repr__(self):
        
        '''(Point)->str
        Returns canonical string representation Point(x, y)'''
        
        return 'Point('+str(self.x)+','+str(self.y)+')'
    def __str__(self):
        '''(Point)->str
        Returns nice string representation Point(x, y).
        In this case we chose the same representation as in __repr__'''
        return 'Point('+str(self.x)+','+str(self.y)+')'

class Rectangle(Point):

    def __init__(self, bottom_left_corner, top_right_corner, color):
         ''' (Point,number, number,colour) -> None
        initialize point coordinates to (xcoord, ycoor) and colour'''
         self.b = bottom_left_corner
         self.t = top_right_corner
         self.c = color


    def get_bottom_left(self):
        '''(Rectangle, Rectangle)-> Point
            returns the bottom left coordinates for the rectangle given
            '''
        return self.b

    def get_top_right(self):
        '''(Rectangle)-> Point
            returns the top right coordinates for the rectangle given
            '''
        return self.t
    
    
    def get_color(self):
        """
        (Rectangle)--> color
        returns the color of the rectangle
        """
        return self.c
    
    def reset_color(self, color):
        '''Rectangle, str ---> none
        changes the color of the rectangle to the one given
        '''
        self.c = color

    def get_perimeter(self):
        '''
        (rectangle)--->number
        returns the perimenter of the rectangle
        '''
        return (self.t.x-self.b.x)*2+(self.t.y-self.b.y)*2

    def get_area(self):
        '''rectangle--->number
            returns the area of the rectangle
            '''
        return (self.t.x-self.b.x)*(self.t.y-self.b.y)
    
    def move(self,sidex,sidey):
        """
        (rectangle, number, number)-->None
        moves the coordinates of the rectangle by the given amount of x and y

        """
        self.b.x+=sidex
        self.b.y+=sidey
        self.t.x+=sidex
        self.t.y+=sidey

    def intersects(self, other):
        
        if self.b.x > other.t.x or self.t.x < other.b.x or self.b.y > other.t.y or self.t.y < other.b.y:
            return False
            
        return True
    
    def contains(self,pointx,pointy):
        if pointx >=self.b.x and pointy>=self.b.y and pointx<=self.t.x and pointy<=self.t.y:
            return True
        else:
            return False

    def __eq__(self, other):
        '''(Point,Point)->bool
        Returns True if self and other have the same coordinates and colors'''
        return self.b == other.b and self.t == other.t and self.c == other.c
    
    def __repr__(self):
        '''(Point)->str
        Returns canonical string representation Point(x, y)
        '''
        return 'Rectangle('+str(self.b)+','+str(self.t)+',\''+self.c+'\')'
    
    def __str__(self):
        '''(Point)->str
        Returns nice string representation Point(x, y).
        In this case we chose the same representation as in __repr__'''
        return 'I am a '+self.c+' rectangle with bottom left corner at('+str(self.b.x)+', '+ str(self.b.y)+') and top right corner at ('+str(self.t.x)+', '+ str(self.t.y)+').'


class Canvas(Rectangle):

    def __init__(self):
        
        self.l1 = []
        


    def add_one_rectangle(self, rectangle):
        '''
        Canvas, rectangle ----> None
        Precondition: Element added has to come from class Rectangle)
        Given a rectangle appends it to a list of rectangles
        '''
        self.l1.append(rectangle)
        

    def count_same_color(self,color):
        counter=0
        for i in range(len(self.l1)):
            if Rectangle.get_color(self.l1[i])==color:
                counter+= 1
        return counter
        
    def total_perimeter(self):
        counter=0
        perimeter=0
        
        for rectangle in self.l1:
            counter = Rectangle.get_perimeter(rectangle)
            perimeter+=counter
            
        return perimeter

    def min_enclosing_rectangle(self):
        '''
        Canvas -> Rectangle
        Precondition: The canvas needs to hold at least 1 rectangle
        Find the minimum enclosing rectangle 
        '''
        maximx=self.l1[0].t.x
        maximy=self.l1[0].t.y
        minx=self.l1[0].b.x
        miny=self.l1[0].b.y
        bestx=0
        besty=0
        smallx=0
        smally=0
        
        for i in range(len(self.l1)):
            smallx = self.l1[i].b.x
            smally = self.l1[i].b.y
            bestx = self.l1[i].t.x
            besty = self.l1[i].t.y

            if smallx < minx:
                minx=smallx
            if smally < miny:
                miny = smally
            if bestx > maximx:
                maximx=bestx
            if besty > maximy:
                maximy=besty
                
        return Rectangle(Point(minx,miny), Point(maximx,maximy), "red")
                

    def common_point(self):
        '''
        Canvas-----> Bool
        Returns True if there is a common point in all rectangle, according to the helley thereom
        if every pair of rectangle intersect with eachother
        '''
        
        for i in range(len(self.l1)):
            for j in range(i, len(self.l1)-1):
                if Rectangle.intersects(self.l1[i], self.l1[j+1])==False:
                    return False
            
        return True 

        
    def __repr__(self):
        '''(Point)->str
        Returns canonical string representation Rectangle(Point(x,y), Point(x,y), "color")

        '''
        return 'Canvas('+ str(self.l1)+ ')'
    
    def __len__(self):
        '''(Point)->str
        Returns nice string representation Point(x, y).
        In this case we chose the same representation as in __repr__'''
        return len(self.l1)










    




