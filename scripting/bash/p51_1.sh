# checking readline
echo "$0"
if [ "$0" = "./p51_1.unx" ]; then
  echo source $0
  exit 1
fi

echo -e '\n' '  bind '\''"\C-t":""control-t(letter)""'\'''
bind '"\C-t":""control-t(letter)""'
echo -e '\n' '  bind '\''"\M-t":"escape, then t(letter)"'\'
bind '"\M-t":"escape, then t(letter)"'
echo -e '\n' '  bind -l | "grep t(letter)"'
bind -l | grep "t(letter)"
echo -e '\n' '  bind -p | "grep t(letter)"'
bind -p | grep "t(letter)"
echo -e '\n' '  bind -P | "grep t(letter)"'
bind -P | grep "t(letter)"
echo -e '\n' '  bind -p | "grep t(letter)" > p51_1-1.unx'
bind -p | grep "t(letter)" > p51_1-1.unx
read -p "--press enter--"
echo -e '\n' '  bind -v '
bind -v 
read -p "--press enter--"
echo -e '\n' '  bind -V '
bind -V 
read -p "--press enter--"
echo -e '\n' '  bind -s '
bind -s 
echo -e '\n' '  bind -S '
bind -S 
echo -e '\n' '  bind -r "\C-t"'
bind -r "\C-t"
echo -e '\n' '  bind -u escape, then t(letter)'
bind -u "escape, then t(letter)"
cat p51_1-1.unx
echo -e '\n' '  bind -f p51_1-1.unx'
bind -f p51_1-1.unx
