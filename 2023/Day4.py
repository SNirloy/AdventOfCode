file = open("Day4.in", "r")
lines = file.readlines()

total = 0

for line in lines:
    card = line.split(": ")
    nums = card[1].split(" | ")
    wins = nums[0].split()
    choices = nums[1].split()
    #print(card[0])
    #print("Wins: ", wins)
    #print("Choices: ", choices)
    points = 0.5
    for win in wins:
        for choice in choices:
            if (win == choice):
                points *= 2
    total += int(points)
print(total)

total = 0

cards = {}
cNum = 1

for line in lines:
    card = line.split(": ")
    nums = card[1].split(" | ")
    wins = nums[0].split()
    choices = nums[1].split()
    matches = 0
    if (not cNum in cards):
        cards[cNum] = 1
    else:
        cards[cNum] += 1
    for win in wins:
        for choice in choices:
            if (win == choice):
                matches += 1
    for i in range (cNum + 1, cNum + matches + 1):
        if (not i in cards):
            cards[i] = cards[cNum]
        else:
            cards[i] += cards[cNum]
    cNum += 1
    #print(cards)
for i in range(1, cNum):
    #print(cards[i])
    total += cards[i]
print(total)
