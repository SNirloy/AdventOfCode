file = open("Day6.in", "r")
lines = file.readlines()

times = []
distances = []

sTimes = lines[0].split(":")
theTimes = sTimes[1].split()
for i in theTimes:
    times.append(int(i))

sDists = lines[1].split(":")
theDists = sDists[1].split()
for i in theDists:
    distances.append(int(i))

total = 1
"""
for i in range(len(times)):
    count = 0
    for test in range(times[i] + 1):
        num = test * (times[i] - test)
        if (num > distances[i]):
            count += 1
    total *= count
print(total)
"""
sTime = ""
sDist = ""
for i in theTimes:
    sTime += i
for i in theDists:
    sDist += i

fullTime = int(sTime)
fullDist = int(sDist)

print(fullTime)
print (fullTime // 2)
print(fullDist)

nums = range(fullTime // 2 + 1)
indexR = len(nums)
indexL = 0
index = (indexR - indexL) // 2
"""
value = index * (fullTime - index)
while (value != fullDist):
    if (value < fullDist):
        indexL = index
    else:
        indexR = index
    index = (indexR - indexL) // 2 + indexL
    value = index * (fullTime - index)
    print(indexL, indexR, index, value, fullDist, (len(nums) - index) * 2)
"""

index = 4826340
count = 0
print(index * (fullTime - index))
index += 1
print(index * (fullTime - index))
print(index)

value = index * (fullTime - index)
while (value > fullDist):
    count += 1
    index += 1
    value = index * (fullTime - index)

print(count)
