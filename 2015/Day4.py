import hashlib

stringDeci = "609043"
stringHead = "abcdef"
byting = (stringHead + stringDeci).encode()
result = hashlib.md5(byting)
stringRes = result.hexdigest()
print(stringRes)

deci = 1
stringDeci = str(deci)
stringHead = "abcdef"
byting = (stringHead + stringDeci).encode()
result = hashlib.md5(byting)
stringRes = result.hexdigest()


print(stringRes)
