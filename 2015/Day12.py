import json;

def parse (sonj):
	red = False
	sum = 0
	if( isinstance(sonj, dict)):
		for obj in sonj:
			ans = parse(sonj[obj])
			red = ans[1]
			if (red):
				return (0, False)
			else:
				sum += ans[0]
	if( isinstance(sonj, (tuple, list))):
		for obj in sonj:
			sum += parse(obj)[0]
	if( isinstance(sonj, int)):
		sum += sonj;
	if( isinstance(sonj, str)):
		if (sonj == "red"):
			red = True
	return (sum, red)


with open ('Day12.json') as file:
	sonj = json.load(file)

print(parse(sonj))