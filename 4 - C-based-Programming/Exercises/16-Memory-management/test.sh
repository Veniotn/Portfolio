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

./a$fileExtension -a two three four > /dev/null 2>&1

if [ $? -eq 1 ] ; then
  eval "$passFormat"
  echo "Pass: Program exited with correct error code"
else
  eval "$failFormat"
  echo "Fail: Program did not exit with correct error code"
  returnStatus=1
fi

output_1=$(./a$fileExtension -a two three four 2>&1)

# don't worry about extra whitespace in the output
newOutput_1=""
while read line
do
  newOutput_1=$newOutput_1$(echo "$line" | xargs)
done <<< "$output_1"

expected_output_1="Sorry, bad number of command line arguments."

# Use contains so we ignore additional output or input prompts
if grep -q "$expected_output_1" <<< "$newOutput_1"; then
  eval "$passFormat"
  echo "Test #1: Too Many Args - Pass: Output is correct"
else
  eval "$failFormat"
  echo "Test #1: Too Many Args - Expected '$expected_output_1' but got: $newOutput_1"
  returnStatus=1
fi

echo

./a$fileExtension -s > /dev/null 2>&1

if [ $? -eq 1 ] ; then
  eval "$passFormat"
  echo "Pass: Program exited with correct error code"
else
  eval "$failFormat"
  echo "Fail: Program did not exit with correct error code"
  returnStatus=1
fi

output_2=$(./a$fileExtension -s 2>&1)

# don't worry about extra whitespace in the output
newOutput_2=""
while read line
do
  newOutput_2=$newOutput_2$(echo "$line" | xargs)
done <<< "$output_2"

expected_output_2="Sorry, bad number of command line arguments."

# Use contains so we ignore additional output or input prompts
if grep -q "$expected_output_2" <<< "$newOutput_2"; then
  eval "$passFormat"
  echo "Test #2: Too Few Args - Pass: Output is correct"
else
  eval "$failFormat"
  echo "Test #2: Too Few Args - Expected '$expected_output_2' but got: $newOutput_2"
  returnStatus=1
fi

echo

./a$fileExtension -x 5 > /dev/null 2>&1

if [ $? -eq 1 ] ; then
  eval "$passFormat"
  echo "Pass: Program exited with correct error code"
else
  eval "$failFormat"
  echo "Fail: Program did not exit with correct error code"
  returnStatus=1
fi

output_3=$(./a$fileExtension -x 5 2>&1)

# don't worry about extra whitespace in the output
newOutput_3=""
while read line
do
  newOutput_3=$newOutput_3$(echo "$line" | xargs)
done <<< "$output_3"

expected_output_3="Sorry, bad operator."

# Use contains so we ignore additional output or input prompts
if grep -q "$expected_output_3" <<< "$newOutput_3"; then
  eval "$passFormat"
  echo "Test #3: Bad Operator - Pass: Output is correct"
else
  eval "$failFormat"
  echo "Test #3: Bad Operator - Expected '$expected_output_3' but got: $newOutput_3"
  returnStatus=1
fi

echo

./a$fileExtension -s 8 > /dev/null 2>&1 <<'EOF'
44
8
-5
12
78
2
-6
9
EOF

if [ $? -eq 0 ] ; then
  eval "$passFormat"
  echo "Pass: Program exited zero"
else
  eval "$failFormat"
  echo "Fail: Program did not exit zero"
  returnStatus=1
fi

output_4=$(./a$fileExtension -s 8 2>&1 <<'EOF'
44
8
-5
12
78
2
-6
9
EOF
)

# don't worry about extra whitespace in the output
newOutput_4=""
while read line
do
  newOutput_4=$newOutput_4$(echo "$line" | xargs)
done <<< "$output_4"

expected_output_4="The result is 142.0."

# Use contains so we ignore additional output or input prompts
if grep -q "$expected_output_4" <<< "$newOutput_4"; then
  eval "$passFormat"
  echo "Test #4: -s 8 - Pass: Output is correct"
else
  eval "$failFormat"
  echo "Test #4: -s 8 - Expected '$expected_output_4' but got: $newOutput_4"
  returnStatus=1
fi

echo

./a$fileExtension -a 7 > /dev/null 2>&1 <<'EOF'
12
18
6
-2
4
9
11
EOF

if [ $? -eq 0 ] ; then
  eval "$passFormat"
  echo "Pass: Program exited zero"
else
  eval "$failFormat"
  echo "Fail: Program did not exit zero"
  returnStatus=1
fi

output_5=$(./a$fileExtension -a 7 2>&1 <<'EOF'
12
18
6
-2
4
9
11
EOF
)

# don't worry about extra whitespace in the output
newOutput_5=""
while read line
do
  newOutput_5=$newOutput_5$(echo "$line" | xargs)
done <<< "$output_5"

expected_output_5="The result is 8.3."

# Use contains so we ignore additional output or input prompts
if grep -q "$expected_output_5" <<< "$newOutput_5"; then
  eval "$passFormat"
  echo "Test #5: -a 7 - Pass: Output is correct"
else
  eval "$failFormat"
  echo "Test #5: -a 7 - Expected '$expected_output_5' but got: $newOutput_5"
  returnStatus=1
fi

echo

./a$fileExtension -mx 9 > /dev/null 2>&1 <<'EOF'
-50
45
12
-4
65
17
1
0
EOF

if [ $? -eq 0 ] ; then
  eval "$passFormat"
  echo "Pass: Program exited zero"
else
  eval "$failFormat"
  echo "Fail: Program did not exit zero"
  returnStatus=1
fi

output_6=$(./a$fileExtension -mx 9 2>&1 <<'EOF'
-50
45
12
-4
65
17
1
0
EOF
)

# don't worry about extra whitespace in the output
newOutput_6=""
while read line
do
  newOutput_6=$newOutput_6$(echo "$line" | xargs)
done <<< "$output_6"

expected_output_6="The result is 65.0."

# Use contains so we ignore additional output or input prompts
if grep -q "$expected_output_6" <<< "$newOutput_6"; then
  eval "$passFormat"
  echo "Test #6: -mx 9 - Pass: Output is correct"
else
  eval "$failFormat"
  echo "Test #6: -mx 9 - Expected '$expected_output_6' but got: $newOutput_6"
  returnStatus=1
fi

echo

./a$fileExtension -mn 4 > /dev/null 2>&1 <<'EOF'
109
-21
4
-2
EOF

if [ $? -eq 0 ] ; then
  eval "$passFormat"
  echo "Pass: Program exited zero"
else
  eval "$failFormat"
  echo "Fail: Program did not exit zero"
  returnStatus=1
fi

output_7=$(./a$fileExtension -mn 4 2>&1 <<'EOF'
109
-21
4
-2
EOF
)

# don't worry about extra whitespace in the output
newOutput_7=""
while read line
do
  newOutput_7=$newOutput_7$(echo "$line" | xargs)
done <<< "$output_7"

expected_output_7="The result is -21.0."

# Use contains so we ignore additional output or input prompts
if grep -q "$expected_output_7" <<< "$newOutput_7"; then
  eval "$passFormat"
  echo "Test #7: -mn 4 - Pass: Output is correct"
else
  eval "$failFormat"
  echo "Test #7: -mn 4 - Expected '$expected_output_7' but got: $newOutput_7"
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