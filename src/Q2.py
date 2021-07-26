import csv

def grade(mark):
    if mark >= 90:
        return 'A+'
    elif mark >= 80:
        return 'A'
    elif mark >= 75:
        return 'A-'
    elif mark >= 70:
        return 'B+'
    elif mark >= 65:
        return 'B'
    elif mark >= 60:
        return 'B-'
    elif mark >= 55:
        return 'C+'
    elif mark >= 45:
        return 'C'
    elif mark >= 40:
        return 'C-'
    elif mark >= 35:
        return 'D+'
    elif mark >= 30:
        return 'D'
    else:
        return 'F'

def calculate(marks):
    final_mark = float(marks[0])*0.3 + float(marks[1])*0.3 + float(marks[2])*0.4
    return [round(final_mark, 2), grade(final_mark)]

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

result_list = [[key, *(result[key]), *calculate(result[key][1:])] for key in result]

headers = []
headers.extend(*headers1)
headers.append(headers2[0][1])
headers.append(headers3[0][1])

with open('student.csv', 'w', newline ='') as f:
    write = csv.writer(f)
    write.writerow(headers)
    write.writerows(result_list)