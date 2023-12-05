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
        row[2] = row[1] + row[2] - 1
        row[0] = row[0] - row[1]

"""
for mapping in remap:
    for row in mapping:
        print(row)
"""         
#Now we need to start merging each mappings in order to see all possible changes
current = [0, 0, 2 ** 32 - 1]
# Remember: [change, start, end(inclusive)]
following = []
test = remap[0][0]
# A GOOD WAY TO MERGE THE TWO PARTS
    

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







