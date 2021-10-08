import os, re

print('')
print('--------------------------------------------------------------------')
print('')
print('Welcome to the chat counter\n')

list = [ file for file in os.listdir('.') if file.endswith('_Recording.txt') ]

print('We found {0} files matching the Zoom chat log:'.format(len(list)))
for file_in in list:
    print(' - ' + file_in)
print('')

file_in = input('Enter input file name: ')
file_out = file_in+'_counts.csv'

fin = open(file_in,'r')

result = []
lines = fin.readlines()
for line in lines:
    names = re.split(r'\t', line) 
    if len(names) == 3:
        name = names[1][:-1]
        result.append(name)

fout = open(file_out, 'w')
fout.write('Name, Count\n')

result = {x: result.count(x) for x in set(result) }
for k,v in result.items():
    fout.write(k + "," + str(v) + '\n')

fin.close()
fout.close()

print('')
print('Written interaction count to output file: {0}'.format(file_out))
print('')
print('--------------------------------------------------------------------')
print('')