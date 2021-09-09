import string

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

def open_file():
    '''None->file object
    See the assignment text for what this function should do'''
    # YOUR CODE GOES HERE

    file_name=None
    while file_name==None:
        file_name = is_valid_file_name()
    f=open(file_name)
    return f
   
def remove_punctuations(line):
    '''
    (list)->list
    removes all punctuations from the list 
    '''
    newline=[]
    goodline=[]
    for w in line:
        for ch in string.punctuation:
            if ch in w:
                w=w.replace(ch,'')
                newline.append(w)
                remove_punctuations(newline)
        goodline.append(w)
                
    return goodline

def isallalpha(line):
    '''
    (list)->list
    removes the words that arent all alphabetic characters
    '''
    newline=[]
    for w in line:
        if w.isalpha():
            newline.append(w)
    return newline

def longerthan2(line):
    '''
    list->list
    if the word is shorter than 2 letters remove it
    '''
    for w in line:
        if len(w)<2:
            line.remove(w)
    return line
    
def read_file(fp):
    '''(file object)->dict
    See the assignment text for what this function should do'''
    # YOUR CODE GOES HERE
    D={
        }
    text_raw = fp.read().lower().splitlines()
    text1=[]
    text2=[]
    
    for i in range(len(text_raw)):
              text1.append(text_raw[i].split())
    for i in range(len(text1)):
        text2=[]
        text1[i]=remove_punctuations(text1[i])
        text1[i]=isallalpha(text1[i])
        text1[i]=longerthan2(text1[i])
        for words in text1[i]:
            text2.append(words)
        
        for w in text2:
            if w in D:
                if i+1 not in D[w]:
                    D[w].add(i+1)
            else:
                D[w]={i+1}
                    
    return D
        
    

def find_coexistance(D, query):
    '''(dict,str)->list
    See the assignment text for what this function should do'''
    # YOUR CODE GOES HERE
    query=query.lower().strip().split()
    query=remove_punctuations(query)
    list1=[]
    sorted_list=[]
    
    for word in query:
        list1.append(D[word])

    if len(list1)==1:
        for num in list1[0]:
            sorted_list.append(num)
    else:
        coexistance = set.intersection(*list1)
        
        for num in coexistance:
            sorted_list.append(num)
    
    sorted_list.sort()
    
    return sorted_list
    

##############################
# main
##############################
file=open_file()
d=read_file(file)
query=input("Enter one or more words separated by spaces, or 'q' to quit: ").strip().lower()

# YOUR CODE GOES HERE
flag=True

while flag:
    if query == 'q':
        break
        
    sorted_query=query.lower().strip().split()
    sorted_query=remove_punctuations(sorted_query)
    
    if set(sorted_query).issubset(d) and len(sorted_query)>0:
        x=find_coexistance(d, query)
        if len(x)>0:
            print('The one or more words you entered coexisted in the following lines of the file:')
            for num in x:
                print(num,end=' ')
            print()
        else:
            print('The one or more words you entered do not coexist in the file')
        query=input("Enter one or more words separated by spaces, or 'q' to quit: ").strip().lower()
    elif len(sorted_query)==0:
        print("Word '' not in the file.")
        query=input("Enter one or more words separated by spaces, or 'q' to quit: ").strip().lower()   
    else:
        print('Word '+ sorted_query[0]+' not in the file.')
        query=input("Enter one or more words separated by spaces, or 'q' to quit: ").strip().lower()
      

    













