#example of integer arithmetic
declare -i CumDirSize=0
declare -i DirSize
declare -i SizeDiff
for file in $(ls); do  
#  echo $(du -b $file | cut -d'	' -f1)  ####
  FileSize=$(du -b $file | cut -d'	' -f1)
  CumDirSize=$CumDirSize+$FileSize
done
echo CumDirSize=$CumDirSize
DirSize=$(du -b -s | cut -d'	' -f1) 
echo DirSize=$DirSize
SizeDiff=$DirSize-$CumDirSize
echo SizeDiff=$SizeDiff

#$(find . -mtime -9999 -print); do
