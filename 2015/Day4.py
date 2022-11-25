#! python
import hashlib

deci = 1
stringDeci = str(deci)
stringHead = "bgvyzdsv"
byting = (stringHead + stringDeci).encode()
result = hashlib.md5(byting)
stringRes = result.hexdigest()

while (stringRes[:6] != "000000"):
	deci += 1
	stringDeci = str(deci)
	byting = (stringHead + stringDeci).encode()
	result = hashlib.md5(byting)
	stringRes = result.hexdigest()

print(str(deci))
