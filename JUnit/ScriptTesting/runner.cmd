set root=%1

break>%root%\draft_file.txt
break>%root%\result_file.txt

FOR %%I IN (%root%\*.java) DO (
	FOR /D %%J IN (%root%\*) do (
		COPY %%I %%J
	)
)

FOR /D %%F IN (%root%\*) DO (
	
	FOR /F "tokens=1 delims=_" %%a in ("%%~nxF") do (
		@ECHO %%a >> %root%\draft_file.txt
	)

	cd %%F
	mkdir out
	javac -d out -cp ..\junit-platform-console-standalone-1.5.2.jar *.java
	java -jar ..\junit-platform-console-standalone-1.5.2.jar --class-path out --scan-classpath --disable-ansi-colors --disable-banner --details=flat >> ..\draft_file.txt	
	cd ..\..
)

javac Runner.java
java Runner %root%/"draft_file.txt" %root%/"result_file.txt"

@ECHO DONE
