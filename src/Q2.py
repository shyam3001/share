import csv

with open('File1.csv') as csv_file:
    csv_reader = csv.reader(csv_file, delimiter=',')
    data1 = list(csv_reader)
    headers1 = [data1[0]]
    list1 = data1[1:]
    dict1 = {list1[x][0]: list1[x][1:3] for x in range(len(list1))}

with open('File2.csv') as csv_file:
    csv_reader = csv.reader(csv_file, delimiter=',')
    data2 = list(csv_reader)
    headers2 = [data2[0]]
    list2 = data2[1:]
    dict2 = {list2[x][0]: [list2[x][1]] for x in range(len(list2))}

with open('File3.csv') as csv_file:
    csv_reader = csv.reader(csv_file, delimiter=',')
    data3 = list(csv_reader)
    headers3 = [data3[0]]
    list3 = data3[1:]
    dict3 = {list3[x][0]: [list3[x][1]] for x in range(len(list3))}

result = {}

for key in set().union(dict1, dict2, dict3):
    if key in dict1: result.setdefault(key, []).extend(dict1[key])
    if key in dict2: result.setdefault(key, []).extend(dict2[key])
    if key in dict3: result.setdefault(key, []).extend(dict3[key])

result_list = [[key, *(result[key])] for key in result]

print(result_list)