file = open("Day3.in", "r")
lines = file.readlines()

arr = []
dirs = [[0, 1], [1, 0], [0, -1], [-1, 0], [1, 1], [-1, 1], [1, -1], [-1, -1]]

for line in lines:
    arr.append(line)

total = 0
usable = False
num = 0


for r in range (len(arr)):
    for c in range (len(arr[r])):
        if(arr[r][c] >= "0" and arr[r][c] <= "9"):
            num = num * 10 + int(arr[r][c])
            for change in dirs:
                newR = change[0] + r
                newC = change[1] + c
                if (newR >= 0 and newR < len(arr) and newC >= 0 and newC < len(arr)):
                    if (arr[newR][newC] != "." and (not (arr[newR][newC] >= "0" and arr[newR][newC] <= "9"))):
                        usable = True
        elif (usable and num > 0):
            total += num
            #print(num)
            usable = False
            num = 0
        else:
            num = 0
            usable = False
print (total)

total = 0
usable = False
num = 0

stars = {}
noted = None

for r in range (len(arr)):
    for c in range (len(arr[r])):
        if(arr[r][c] >= "0" and arr[r][c] <= "9"):
            num = num * 10 + int(arr[r][c])
            for change in dirs:
                newR = change[0] + r
                newC = change[1] + c
                if (newR >= 0 and newR < len(arr) and newC >= 0 and newC < len(arr)):
                    if (arr[newR][newC] == "*" and (not (arr[newR][newC] >= "0" and arr[newR][newC] <= "9"))):
                        usable = True
                        noted = (newR, newC)
        elif (usable and num > 0 and noted != None):
            #print(num)
            if (not (noted in stars)):
                stars[noted] = [num]
            else:
                stars[noted].append(num)
            usable = False
            num = 0
            noted = None
        else:
            num = 0
            usable = False

for star in stars:
    if (len(stars[star]) == 2):
        total += stars[star][0] * stars[star][1]
print (total)

