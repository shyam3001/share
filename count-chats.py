import os, re

list = [ file for file in os.listdir('.') if file.endswith('_Recording.txt') ]

for file in list:
    fin = open(file,'r')
    
    result = []
    lines = fin.readlines()
    for line in lines:
        names = re.split(r'\t', line) 
        if len(names) == 3:
            name = names[1][:-1]
            result.append(name)

    fout = open(file[:-4]+'_counts.csv', 'w')
    fout.write('Name, Count\n')

    result = {x: result.count(x) for x in set(result) }
    for k,v in result.items():
        fout.write(k + "," + str(v) + '\n')
    
    fin.close()
    fout.close()