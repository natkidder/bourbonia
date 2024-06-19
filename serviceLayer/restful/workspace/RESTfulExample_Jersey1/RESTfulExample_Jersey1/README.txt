HelloWorldService: put in CREST or web browser   http://localhost:8080/RESTfulExample_Jersey1/rest/hello/<word>    where <word> can be any string

ReadFile: put in CREST or web browser   http://localhost:8080/RESTfulExample_Jersey1/rest/ReadFile/<filename>    where <filename> is a file in c:\tmp

Employee: put in CREST   http://localhost:8080/RESTfulExample_Jersey1/rest/user/employee   where the request entity is

    <Employee>
        <employeeName>[name]</employeeName>
    </Employee>

    where [name] can be any string

also, http://localhost:8080/RESTfulExample_Jersey1/rest/application.wadl will delineate the different resources

ensure you have Tomcat running in the local Eclipse workspace