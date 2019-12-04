#!/bin/bash
root="$1"
: > "$root"/draft_file.txt
: > "$root"/result_file.txt

for file in "$root"/*; do
	if [[ $file == *.java ]]; then
		privateFile=${file}
	fi
done


for f in "$root"/*; do
	if [ -d ${f} ]; then
		cp $privateFile ${f}
		basename "$f" | cut -d'_' -f 1 >> "$root"/draft_file.txt
		cd ${f}
		mkdir -p out
		javac -d out -cp ../junit-platform-console-standalone-1.5.2.jar *.java
		java -jar ../junit-platform-console-standalone-1.5.2.jar --class-path out --scan-classpath --disable-ansi-colors --disable-banner --details=flat >> ../draft_file.txt	
		cd ../..
	fi

done

javac Runner.java 
java Runner "$root"/"draft_file.txt" "$root"/"result_file.txt" 

echo "DONE"