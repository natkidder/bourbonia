if [ ${0##*/} = p51.unx ]; then
  echo you must source $0
  exit 2
fi
#$if mode=emacs
#  "\e-t": "df -a"
#$endif
bind "\C-t":clear-screen
echo press ctrl-t to clear the screen
