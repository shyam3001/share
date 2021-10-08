import os, re

list = [ file for file in os.listdir('.') if file.startswith('participants') ]

for file in list:
    fin = open(file,'r')

    lines = sorted(fin.readlines()[1:])
    dict = {}
    for line in lines:
        line = line.split(',')
        if len(line) > 4:
            k = line[0]
            v = int(line[4])
            if k in dict:
                dict[k] = dict[k] + v
            else:
                dict[k] = v

    fout = open('attendance_'+file[13:], 'w')
    fout.write('Name, Duration\n')
    for k, v in dict.items():
        res = '{0}, {1}h {2}m\n'.format(k, v//60, v%60)
        fout.write(res)

    fin.close()
    fout.close()
