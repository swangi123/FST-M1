name = input("What is your name: ")
age = int(input("How old are you: "))
result = name + " is {} years old"
print(result.format(age))

year = str( ( 2022 - age ) + 100 )
print( name + " will be 100 years old in the year " + year )




