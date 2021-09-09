def two_length_run(l):
    """
    (list)->boolean
    Precondition: numbers in the list 
    This function return true or false wether in the given list there is at least one run
    of length 2 or more of the same number
    """
    for i in range(0,len(l)-1):
        if l[i]==l[i+1]:
            return True
    return False

#main
numbers_list=[]
strings_for_list = input("Please input a list of numbers sepertated by space: ").strip().split()
for num in strings_for_list:
    numbers_list.append(float(num))

veri=two_length_run(numbers_list)
print(veri)
