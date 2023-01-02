call runcrud
if "%ERRORLEVEL%" == "0" goto openbrowser
echo.
echo Compilation error
goto fail

:openbrowser
start chrome http://localhost:8080/crud/v1/tasks
goto stoptomcat
goto end

:fail
echo.
echo There was errors

:stoptomcat
call %CATALINA_HOME%\bin\shutdown.bat

:end
echo.
echo Work is finished