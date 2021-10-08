import os, re

print('')
print('--------------------------------------------------------------------')
print('')
print('Welcome to the attendance duration counter\n')

list = [ file for file in os.listdir('.') if file.startswith('participants') ]

print('We found {0} files matching the Zoom chat log:'.format(len(list)))
for file_in in list:
    print(' - ' + file_in)
print('')

file_in = input('Enter input file name: ')
file_out = file_in+'_added.csv'

fin = open(file_in,'r')

lines = fin.readlines()[1:]
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

resultdict = {}
for k,v in dict.items():
    x = re.findall('[iI][tT]\d{8}', k)
    if len(x)>=1:
        k = x[0].upper()
    if k in resultdict:
        resultdict[k] = resultdict[k] + v
    else:
        resultdict[k] = v

dict = resultdict

fout = open(file_out, 'w')
fout.write('Name, Duration\n')
for k, v in sorted(dict.items()):
    res = '{0}, {1}h {2}m\n'.format(k, v//60, v%60)
    fout.write(res)

fin.close()
fout.close()

print('')
print('Written total attended duration to output file: {0}'.format(file_out))
print('')
print('--------------------------------------------------------------------')
print('')