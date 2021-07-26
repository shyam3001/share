import csv


def grade(mark):
    grade_table = [(90, 'A+'), (80, 'A'), (75, 'A-'), (70, 'B+'), (65, 'B'), (60, 'B-'), (55, 'C+'), (45, 'C'), (40, 'C-'), (35, 'D'), (30, 'E')]
    for v, g in grade_table:
        if mark >= v:
            return g
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
