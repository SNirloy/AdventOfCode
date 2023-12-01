file = open("Day1.in", "r")
lines = file.readlines()

total = 0
nums = {
    "one": 1, "two":2, "three": 3, "four":4, "five":5, "six":6, "seven":7, "eight":8, "nine":9,
    }

def toNum(string):
    if (string == "one"):
        return 1
    elif(string == "two"):
        return 2
    elif(string == "three"):
        return 3
    elif(string == "four"):
        return 4
    elif(string == "five"):
        return 5
    elif(string == "six"):
        return 6
    elif(string == "seven"):
        return 7
    elif(string == "eight"):
        return 8
    elif(string == "nine"):
        return 9
    else:
        return 0


for line in lines:
    num1 = 0
    num2 = 0
    #print("length: ", len(line), line)
    for i in range(len(line)):
        char = ord(line[i])
        #print(char)
        if (char >= 48 and char <= 57):
            if (num1 == 0):
                num1 = char - 48
            else:
                num2 = char - 48
        else:
            if( i + 5 <= len(line)):
                #print(line[i: i+5], toNum(line[i: i+5]))
                if (num1 ==0):
                    num1 = toNum(line[i: i+5])
                elif( toNum(line[i:i+5]) != 0):
                    num2 = toNum(line[i:i+5])
            if( i + 4 <= len(line)):
               # print(line[i: i+4], toNum(line[i: i+4]))
                if (num1 ==0):
                    num1= toNum(line[i: i+4])
                elif(toNum(line[i:i+4]) != 0):
                    num2 = toNum(line[i:i+4])
            if( i + 3 <= len(line)):
                #print(line[i: i+3], toNum(line[i: i+3]))
                if (num1 ==0):
                    num1 = toNum(line[i: i+3])
                elif(toNum(line[i:i+3]) !=0):
                    num2 = toNum(line[i:i+3])
            #print(num1, num2)
    if(num2 == 0):
        num2 = num1

    total += num1*10 + num2
print(total)
