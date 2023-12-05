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
44.3
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
44.3
EOF
)

expected_output_1="That is 11.704 gallons."

# Use contains so we ignore additional output or input prompts
if grep -q "$expected_output_1" <<< "$output_1"; then
  eval "$passFormat"
  echo "Test #1 44.3(US) - Pass: Output is correct"
else
  eval "$failFormat"
  echo "Test #1 44.3(US) - Expected '$expected_output_1' but got: $output_1"
  returnStatus=1
fi

echo

./a$fileExtension > /dev/null 2>&1 <<'EOF'
154.6
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
154.6
EOF
)

expected_output_2="That is 40.845 gallons."

# Use contains so we ignore additional output or input prompts
if grep -q "$expected_output_2" <<< "$output_2"; then
  eval "$passFormat"
  echo "Test #2 154.6(US) - Pass: Output is correct"
else
  eval "$failFormat"
  echo "Test #1 154.6(US) - Expected '$expected_output_2' but got: $output_2"
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