# checking readline
echo "$0"
if [ "$0" = "./p51_1.unx" ]; then
  echo source $0
  exit 1
fi

echo -e '\n' '  bind '\''"\C-t":clear-screen'\'''
bind '"\C-t":clear-screen'
echo -e '\n' '  bind '\''"\M-t":clear-screen'\'''
bind '"\M-t":clear-screen'
echo -e '\n' '  bind -l | grep clear-screen'
bind -l | grep clear-screen
echo -e '\n' '  bind -p | grep clear-screen'
bind -p | grep clear-screen
echo -e '\n' '  bind -P | grep clear-screen'
bind -P | grep clear-screen
echo -e '\n' '  bind -p | grep clear-screen > p51_1-1.unx'
bind -p | grep clear-screen > p51_1-1.unx
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
echo -e '\n' '  bind -u clear-screen'
bind -u clear-screen
cat p51_1-1.unx
echo -e '\n' '  bind -f p51_1-1.unx'
bind -f p51_1-1.unx
