#used to illustrate 'source' and '.'
echo 'source or . this file, then try the '\''cdpwd'\'' function'
function cdpwd
{
  builtin cd $1
  echo 'you are in the '\'$(pwd)\'' directory'
}
