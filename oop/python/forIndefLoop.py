### # Measure some strings:;
words = ['cat', 'window', 'defenestrate']
for w in words:
    print w, len(w)

print ""
### insert a string into the loop
for w in words[:]:  # Loop over a slice copy of the entire list.
     if len(w) > 6:
         words.insert(0, w)
print w
