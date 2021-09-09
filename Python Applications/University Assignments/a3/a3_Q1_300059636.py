def count_pos(l):
    """
    (list)->int
    precondition: The list has to be full of numbers
    This functions returns the amount of positive numbers in a list
    """
    i=0
    for number in l:
        if number>0:
            i=i+1

    return i

#main
numbers_list=[]
strings_for_list = input("Please input a list of numbers sepertated by space: ").strip().split()
for num in strings_for_list:
    numbers_list.append(float(num))
    
number_over0=count_pos(numbers_list)
print('There are ', number_over0, ' positive numbers in your list')
