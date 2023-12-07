file = open("Day5.in", "r")
lines = file.readlines()

#print(len(lines), lines)
mappings = []

line0 = lines[0].strip().split(": ")
strSeeds = line0[1].split()

seeds = []
for i in strSeeds:
    seeds.append(int(i))

lineNum = 3
mapping = []
while(lineNum < len(lines)):
    #print(lineNum)
    line = lines[lineNum]
    if (line == "\n"):
        mappings.append(mapping)
        mapping = []
        lineNum += 2
    else:
        line1 = line.split()
        line2 = []
        for i in line1:
            line2.append(int(i))
        mapping.append(line2)
        lineNum += 1
mappings.append(mapping)

locations = []

remap = []
for mapping in mappings:
    theSorted = []
    startMap = {}
    starts = []
    for row in mapping:
        starts.append(row[1])
        startMap[row[1]] = row
    starts.sort()
    for start in starts:
        theSorted.append(startMap[start])
    remap.append(theSorted)

for mapping in remap:
    for row in mapping:
        row[2] = row[1] + row[2] 
        row[0] = row[0] - row[1]

"""
for mapping in remap:
    for row in mapping:
        print(row)
"""         
#Now we need to start merging each mappings in order to see all possible changes
current = [[0, 0, 2 ** 32 ]]
# Remember: [change, start, end(inclusive)]
following = []
test = remap[0][0]
# A GOOD WAY TO MERGE THE TWO PARTS
trueMap = {}
cInd0 = 0
cInd1 = 0
rInd0 = 0
rInd1 = 0


def step(a, b):
    global cInd0
    global cInd1
    global rInd0
    global rInd1
    if (a):
        cInd1 += 1
        if (cInd1 == 2):
            cInd0 += 1
            cInd1 = 0
    if(b):
        rInd1 += 1
        if (rInd1 == 2):
            rInd0 += 1
            rInd1 = 0
    

aRange = []
val = 0
prev = -1

#print("Current: ", current)
#print("Remap[0]: ", remap[0])
for mapping in remap:
    while(cInd0 < len(current) and rInd0 < len(mapping)):
        # print("Curr Index 0:\t", cInd0)
        # print("Curr Index 1:\t", cInd1)
        # print("ReMap Index 0:\t", rInd0)
        # print("ReMap Index 1:\t", rInd1)
        #print("Looking at: ", current[cInd0][cInd1 + 1], remap[0][rInd0][rInd1 + 1])
        if (current[cInd0][cInd1 + 1] < mapping[rInd0][rInd1 + 1]):
            if(len(aRange) != 0):
                aRange.append(current[cInd0][cInd1 + 1])
                following.append(aRange)
                aRange = []
            if(cInd1 == 0):
                val += current[cInd0][0]
            else:
                val -= current[cInd0][0]
            aRange.append(val)
            aRange.append(current[cInd0][cInd1 + 1])
            step(True, False)
        elif(current[cInd0][cInd1 + 1] > mapping[rInd0][rInd1 + 1]):
            if(len(aRange) != 0):
                aRange.append(mapping[rInd0][rInd1 + 1])
                following.append(aRange)
                aRange = []
            if(rInd1 == 0):
                val += mapping[rInd0][0]
            else:
                val -= mapping[rInd0][0]
            aRange.append(val)
            aRange.append(mapping[rInd0][rInd1 + 1])
            step(False, True)
        else:
            if(len(aRange) != 0):
                aRange.append(current[cInd0][cInd1 + 1])
                following.append(aRange)
                aRange = []
            if(cInd1 == 0):
                val += current[cInd0][0]
            else:
                val -= current[cInd0][0]
            aRange.append(current[cInd0][0])
            aRange.append(current[cInd0][cInd1 + 1])
            step(True, True)
        #print("Holding: ", aRange)

    #print("Curr Index 0:\t", cInd0)
    #print("Curr Index 1:\t", cInd1)
    #print("ReMap Index 0:\t", rInd0)
    #print("ReMap Index 1:\t", rInd1)

    for i in range(len(following) - 1, -1, -1):
        if (following[i][1] == following[i][2]):
            following.pop(i)
    current = following
    following = []
    print(current)
print(current)



"""
def minLoc(val, index):
    #print(index, val)
    if (index == len(mappings)):
        locations.append(val)
    else: 
        mapping = mappings[index]
        found = False
        for row in mapping:
            if (val >= row[1] and val <= row[1] + row[2]):
                minLoc(row[0] + (val - row[1]), index + 1)
                found = True
        if (not found):
            minLoc(val, index + 1)


for i in range(0, len(seeds), 2):
    for j in range (seeds[i + 1]):
        seed = seeds[i] + j
        #print(seed)
        if (not seed in trueMap):
            trueMap[seed] = minLoc(seeds[i] + j, 0)

theMin = locations[0]
for i in locations:
    if (i < theMin):
        theMin = i
print (theMin)
"""







