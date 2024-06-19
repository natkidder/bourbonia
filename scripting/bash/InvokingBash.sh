# illustrates invoking bash
read -p 'export ENV=Echo.unx;sh'
export ENV=Echo.unx
sh
read -p 'bash --norc'
bash --norc
read -p 'bash --rcfile $train/Echo.unx'
bash --rcfile $train/Echo.unx
