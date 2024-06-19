#! /bin/perl -w
use Win32::ODBC;

## This is a demonstration script which makes a connection to a SQL Server database.
## It uses the Win32::ODBC package, which comes standard with the ActivePerl 
## download.

## Establish the connection to SQL Server using a known DSN Connection
## The DSN is configured for Windows security, so I won't specify any login
## parameters. It is set to point to the Northwind database on the server.
my $DSN = "BP_TESTQA";

my $connection = new Win32::ODBC($DSN);

## Check to make sure the connection is valid
if (!$connection) {
    die "Could not open connection to DSN because of [$!]";
}


## Define a SQL Query and retrieve a result set based on that query.
## I want to return the name of all companies and the customerID they've been assigned.
my $SQL = "SELECT OID, Oname FROM tbl_onames WHERE Oname LIKE '134%'";

if($connection->Sql($SQL))
{
    ## A Call to the connection method will return a value. A non-zero value 
    ## is treated as true by Perl. The Sql method will only return a non-zero 
    ## value if it ran into an error.
    print "I could not execute the following statement:\n $SQL\n";
    print "I encountered this error:\n";
    print $connection->Error() . "\n";

    ## Closing the database connection 
    $connection->Close();

    ## Exiting the program 
    die;
}

## Print out a result of our query. Typically I'd do something more, here, but
## since this is script simply to show how to connect and retrieve data, I'll
## just list the contents to show retrieval has taken place. Fetch row is exactly
## as it sounds. It fetches the next row if used without parameters
print "The query returns the following list of onames:\n";

while ($connection->FetchRow())
{
    ## Translate the row into something usable. In this case I am changing
    ## to a hash so I can use key names (CustomerID, CompanyName) rather than
    ## integer values (0, 1). If I wanted to use integer values, I'd use the 
    ## Data() method instead of the DataHash() method.
    my %dataRow = $connection->DataHash();

    print $dataRow{OID} . " : " . $dataRow{Oname} . "\n";
}

## Closing the database connection
$connection->Close();

