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
    final_mark = float(marks[0]) * 0.3 + float(marks[1]) * 0.3 + float(marks[2]) * 0.4
    return [round(final_mark, 2), grade(final_mark)]


def file_read(file_name):
    with open(file_name) as csv_file:
        csv_reader = csv.reader(csv_file, delimiter=',')
        data = list(csv_reader)
        headers = [data[0]]
        data_list = data[1:]
        # print(headers)
        # print(data_list)

        data_dict = {data_list[x][0]: data_list[x][1:3] for x in range(len(data_list))}
        # print(data_dict)

        return headers, data_dict


def main():
    headers1, dict1 = file_read('File1.csv')
    headers2, dict2 = file_read('File2.csv')
    headers3, dict3 = file_read('File3.csv')

    result = {}

    for key in set().union(dict1, dict2, dict3):
        if key in dict1: result.setdefault(key, []).extend(dict1[key])
        if key in dict2: result.setdefault(key, []).extend(dict2[key])
        if key in dict3: result.setdefault(key, []).extend(dict3[key])

    # print(result)
    # result_list = [[key, *(result[key])] for key in result]
    result_list = [[key, *(result[key]), *calculate(result[key][1:])] for key in result]

    # print(result_list)

    headers = []
    headers.extend(*headers1)
    headers.append(headers2[0][1])
    headers.append(headers3[0][1])

    with open('student.csv', 'w', newline='') as f:
        write = csv.writer(f)
        write.writerow(headers)
        write.writerows(result_list)


if __name__ == "__main__":
    main()
