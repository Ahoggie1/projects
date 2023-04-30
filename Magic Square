# This program uses Python to create a magic square of the user's desired size where all rows, columns, 
#and diagonals add up to the same number.

import random

#create a magic square with proportions of the user-inputed size, whose rows, columns, and 
# diagonals all sum to the same number
def Magic_square_Maker(size): 
    Magic_Square = [[0 for column in range(size)] for row in range(size)] #populates an empty 2D list of the user-inputed size with all "0's"
    row = 0
    column = size // 2
    Magic_Square[row][column] = 1 #places the 1 in the first row, middle column
    for num_count in range(2, (size**2 + 1)): 
        row = (row - 1) % size 
        column = (column + 1) % size
        if Magic_Square[row][column] == 0:
            Magic_Square[row][column] = num_count 
        else: 
            row = (row + 2) % size
            column = (column - 1) % size
            Magic_Square[row][column] = num_count
    printHelper(Magic_Square, size) #will call the function to print the Magic Square in 2D format
    return Magic_Square

#randomly generate 3x3 squares and count the number of iterations it takes to perfectly match a Magic 3x3 square
def Match_Perfect_Square(Magic_Square):
    print ("\nRandomly creating the values in a 3x3 Magic Square")
    Magic_Square = recursiveFlatten(Magic_Square) #call the function to flatten the 2D square into a 1D list
    print ("\n", Magic_Square, " Flattened 3x3 Square\n")
    it_count = 0
    random_square = []
    while random_square != Magic_Square:
        random_square = []
        while len(random_square) < 9: #fill the empty random square with random integers from 1-9
            rand_num = random.randint(1,9)
            if rand_num not in random_square:
                random_square.append(rand_num)
        it_count += 1
    print (random_square, "Match")
    print ("It took", it_count, "attempts to create a random square \
that perfectly matches the Magic Square")


#flatten the 2D list into a 1D list
def recursiveFlatten(Magic_Square):
    if Magic_Square == []:
        return Magic_Square
    else:
        return Magic_Square[0] + recursiveFlatten(Magic_Square[1:])
            
#print the Magic Square in 2D format
def printHelper(Magic_Square, Sized):
    for row in range(Sized):
        print ("\n\n")
        for column in range(Sized):
            print ("\t", Magic_Square[row][column], end = " " )
    return (Magic_Square, Sized)


#main section begins here

print ("This program creates an odd-sided Magic Square where the \
sum of each row, column, and diagonal add up to the same number.")
print ("Only for the 3x3 Magic Square, the program will count how many iterations \
it takes to create a perfect duplicate of the 3x3 magic square.")


size = int(input("Enter the desired size of the Magic Square: "))
MagicSquare = Magic_square_Maker(size)

sum_of_side = 0
row = 0
for column in range(size):
    sum_of_side += MagicSquare[row][column]
print ("\n\nThe sum of each row, column, and diagonal is:", sum_of_side)

if size == 3:
    Match_Perfect_Square(MagicSquare)
