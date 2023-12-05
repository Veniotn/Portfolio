returnStatus=0

# Only show colours on local "Git Bash" terminal
passFormat="if [ $TERM = "xterm" ]; then tput sgr0 && tput setaf 2; fi"
failFormat="if [ $TERM = "xterm" ]; then tput sgr0 && tput setaf 1; fi"
normalFormat="if [ $TERM = "xterm" ]; then tput sgr0; fi"

# If not on Linux set output to .exe
unameValue="$(uname -s)"
echo "Testing OS Platform: $unameValue"
fileExtension=".exe"
if [  $unameValue = "Linux" ] || [  $unameValue = "Darwin" ] ; then
    fileExtension=".out"
fi

echo "Running tests..."
echo

./a$fileExtension > /dev/null 2>&1 <<'EOF'
55
&
57
EOF

if [ $? -eq 0 ] ; then
  eval "$passFormat"
  echo "Pass: Program exited zero"
else
  eval "$failFormat"
  echo "Fail: Program did not exit zero"
  returnStatus=1
fi

output_1=$(./a$fileExtension <<'EOF'
55
&
57
EOF
)

# don't worry about extra whitespace in the output
newOutput_1=""
while read line
do
  newOutput_1=$newOutput_1$(echo "$line" | xargs)
done <<< "$output_1"

expected_output_1="The result is: 00000000000000000000000000110001 - 49"

# Use contains so we ignore additional output or input prompts
if grep -q "$expected_output_1" <<< "$newOutput_1"; then
  eval "$passFormat"
  echo "Test #1 (55 & 57) - Pass: Output is correct"
else
  eval "$failFormat"
  echo "Test #1 (55 & 57) - Expected '$expected_output_1' but got: $newOutput_1"
  returnStatus=1
fi

echo

./a$fileExtension > /dev/null 2>&1 <<'EOF'
37
|
16
EOF

if [ $? -eq 0 ] ; then
  eval "$passFormat"
  echo "Pass: Program exited zero"
else
  eval "$failFormat"
  echo "Fail: Program did not exit zero"
  returnStatus=1
fi

output_2=$(./a$fileExtension <<'EOF'
37
|
16
EOF
)

# don't worry about extra whitespace in the output
newOutput_2=""
while read line
do
  newOutput_2=$newOutput_2$(echo "$line" | xargs)
done <<< "$output_2"

expected_output_2="The result is: 00000000000000000000000000110101 - 53"

# Use contains so we ignore additional output or input prompts
if grep -q "$expected_output_2" <<< "$newOutput_2"; then
  eval "$passFormat"
  echo "Test #2 (37 | 16) - Pass: Output is correct"
else
  eval "$failFormat"
  echo "Test #2 (37 | 16) - Expected '$expected_output_2' but got: $newOutput_2"
  returnStatus=1
fi

echo

./a$fileExtension > /dev/null 2>&1 <<'EOF'
29
^
34
EOF

if [ $? -eq 0 ] ; then
  eval "$passFormat"
  echo "Pass: Program exited zero"
else
  eval "$failFormat"
  echo "Fail: Program did not exit zero"
  returnStatus=1
fi

output_3=$(./a$fileExtension <<'EOF'
29
^
34
EOF
)

# don't worry about extra whitespace in the output
newOutput_3=""
while read line
do
  newOutput_3=$newOutput_3$(echo "$line" | xargs)
done <<< "$output_3"

expected_output_3="The result is: 00000000000000000000000000111111 - 63"

# Use contains so we ignore additional output or input prompts
if grep -q "$expected_output_3" <<< "$newOutput_3"; then
  eval "$passFormat"
  echo "Test #3 (29 ^ 34) - Pass: Output is correct"
else
  eval "$failFormat"
  echo "Test #3 (29 ^ 34) - Expected '$expected_output_3' but got: $newOutput_3"
  returnStatus=1
fi

echo

./a$fileExtension > /dev/null 2>&1 <<'EOF'
33
<<
3
EOF

if [ $? -eq 0 ] ; then
  eval "$passFormat"
  echo "Pass: Program exited zero"
else
  eval "$failFormat"
  echo "Fail: Program did not exit zero"
  returnStatus=1
fi

output_4=$(./a$fileExtension <<'EOF'
33
<<
3
EOF
)

# don't worry about extra whitespace in the output
newOutput_4=""
while read line
do
  newOutput_4=$newOutput_4$(echo "$line" | xargs)
done <<< "$output_4"

expected_output_4="The result is: 00000000000000000000000100001000 - 264"

# Use contains so we ignore additional output or input prompts
if grep -q "$expected_output_4" <<< "$newOutput_4"; then
  eval "$passFormat"
  echo "Test #4 (33 << 3) - Pass: Output is correct"
else
  eval "$failFormat"
  echo "Test #4 (33 << 3) - Expected '$expected_output_4' but got: $newOutput_4"
  returnStatus=1
fi

echo

./a$fileExtension > /dev/null 2>&1 <<'EOF'
132
>>
4
EOF

if [ $? -eq 0 ] ; then
  eval "$passFormat"
  echo "Pass: Program exited zero"
else
  eval "$failFormat"
  echo "Fail: Program did not exit zero"
  returnStatus=1
fi

output_5=$(./a$fileExtension <<'EOF'
132
>>
4
EOF
)

# don't worry about extra whitespace in the output
newOutput_5=""
while read line
do
  newOutput_5=$newOutput_5$(echo "$line" | xargs)
done <<< "$output_5"

expected_output_5="The result is: 00000000000000000000000000001000 - 8"

# Use contains so we ignore additional output or input prompts
if grep -q "$expected_output_5" <<< "$newOutput_5"; then
  eval "$passFormat"
  echo "Test #5 (132 >> 4) - Pass: Output is correct"
else
  eval "$failFormat"
  echo "Test #5 (132 >> 4) - Expected '$expected_output_5' but got: $newOutput_5"
  returnStatus=1
fi

echo

./a$fileExtension > /dev/null 2>&1 <<'EOF'
567
-
EOF

if [ $? -eq 1 ] ; then
  eval "$passFormat"
  echo "Pass: Program exited with correct error code"
else
  eval "$failFormat"
  echo "Fail: Program did not exit with correct error code"
  returnStatus=1
fi

output_6=$(./a$fileExtension <<'EOF'
567
-
EOF
)

# don't worry about extra whitespace in the output
newOutput_6=""
while read line
do
  newOutput_6=$newOutput_6$(echo "$line" | xargs)
done <<< "$output_6"

expected_output_6="Sorry, bad operator."

# Use contains so we ignore additional output or input prompts
if grep -q "$expected_output_6" <<< "$newOutput_6"; then
  eval "$passFormat"
  echo "Test #6 (567 -) - Pass: Output is correct"
else
  eval "$failFormat"
  echo "Test #6 (567 -) - Expected '$expected_output_6' but got: $newOutput_6"
  returnStatus=1
fi

echo
if [ $returnStatus -eq 0 ] ; then
    eval "$passFormat"
    echo "All tests passed."
else
    eval "$failFormat"
    echo "One or more tests failed."
fi

eval "$normalFormat"

echo
exit $returnStatus