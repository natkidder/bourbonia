# illustrates here-documents
# adding a string to a here-document
read -p 'adding a string to a here-document: cat >> file << xxxxx'
rm p165_2.txt
cat >> p165_2.txt <<cannae
text added to p165_2.txt
cannae
cat p165_2.txt

# Adding a comment
read -p 'add a comment line through :<< xxxxx'
: << xxxxx
multi-line comment of code
no errors here, it's just a comment
xxxxx

# multi-line variable
HereDocVar=$(cat <<xxxxx
line 1 of 2 of HereDocVar
line 2 of 2 of HereDocVar
xxxxx)
echo HereDocVar=$HereDocVar

# here-documents and expansion
read -p 'here-documents with quotes and expansion: <<"xxxxx"...xxxxx'
cat > p165_2.txt <<"xxxxx"
$((3+2)) $SHELL $(du)
xxxxx
cat p165_2.txt
read -p 'here-documents with backslashes and expansion: <<\xxxxx...xxxxx'
cat > p165_2.txt <<\xxxxx
$((3+2)) $SHELL $(du)
xxxxx
cat p165_2.txt

# here-documents and tabs
read -p 'with <<- and tabs'
cat > p165_3.txt <<princeton
	text with tab in front, here-doc specd with <<
princeton
cat >> p165_3.txt <<-morristown
	test with tab in from, here-doc specd with <<-
morristown
cat p165_3.txt

# using here-documents with read
echo -e '\n' '\t'' read state1 state2 state3 state4 <<xxxxx'
echo -e '\t' 'Delaware Maryland Virginia "West Virginia"'
echo -e '\t' 'xxxxx'
read state1 state2 state3 state4 <<xxxxx
Delaware Maryland Virginia "West Virginia"
xxxxx
echo $state1 $state2 $state3 $state4 

# variation

read -p 'cat <<< OneWordString'
cat <<< OneWordString

# adding user text to a here-document
rm p165.txt
echo 'first line' >> p165.txt
echo type the following, then some text followed by at return and a !
echo 'cat >> p165.txt << !'
cat p165.txt
