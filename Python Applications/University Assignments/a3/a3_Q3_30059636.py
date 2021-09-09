def longest_run(l):
    """
    (list)->int
    Precondition: numbers in the list 
    This function returns the length of the longest run
    """
    accumulator=1
    x=1
    y=0
    if len(l)==0:
        x=0
    else:
        for i in range(len(l)-1):
            if l[i]==l[i+1]:
                accumulator=accumulator+1
                x=accumulator
            else:
                y=x
                accumulator=1
            if x<y:
                x=y
            
    return x

#main
numbers_list=[]
strings_for_list = input("Please input a list of numbers sepertated by space: ").strip().split()
for num in strings_for_list:
    numbers_list.append(float(num))

length_of_run=longest_run(numbers_list)
print('The length of the longest run is', length_of_run)
