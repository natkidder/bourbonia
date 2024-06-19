# functions and exporting
function localFunct
{
  export ExportedLocalFunctVar=ExportedLocalFunctVarValue
  LocalFunctVar=LocalFunctVarValue
}
localFunct
echo ExportedLocalFunctVar=$ExportedLocalFunctVar
echo LocalFunctVar=$LocalFunctVar
