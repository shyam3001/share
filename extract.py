# run (console output): python extract.py submission-folder-name
# run (file output): python extract.py submission-folder-name > result-file.txt

import os
import re
import sys

if len(sys.argv)==1:
    print('usage: python extract.py foldername')
    exit(0)

list = os.listdir(sys.argv[1])

for name in list:
    itnum = re.findall('[iI][tT][0-9]{8}', name);
    if len(itnum)==1:
        print(itnum[0])
    else:
        print('could not find IT number in this folder = ', name)
