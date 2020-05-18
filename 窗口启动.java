SET Server=你的服务器核心名.jar

SET SetX=4096
SET SetS=4096

SET SetNq=1536

SET SetCs=-XX:+UseConcMarkSweepGC -XX:+UseCMSCompactAtFullCollection -XX:CMSFullGCsBeforeCompaction=3 -XX:+CMSParallelRemarkEnabled -XX:+CMSScavengeBeforeRemark -XX:CMSInitiatingOccupancyFraction=68 -XX:+UseCMSInitiatingOccupancyOnly -XX:+ExplicitGCInvokesConcurrent -XX:+ExplicitGCInvokesConcurrentAndUnloadsClasses -XX:+CMSClassUnloadingEnabled -XX:TargetSurvivorRatio=90

SET SetEw=-XX:+UseFastAccessorMethods -XX:+AggressiveOpts -XX:+UseBiasedLocking -XX:+DisableExplicitGC -XX:+UseCompressedOops -server -d64 -Xincgc
set a=0
:head
title 你的服务器名 [重启次数: %a%]
cls
@echo. ---------------------------------------------------------------
@echo.
@echo.   ┏----------------- -------------------┓
@echo.   ┣ By:Bengcord      QQ:2824181493 ┫
@echo.   ┗----------------- -------------------┛
@echo. 
choice /t 2 /d y /n >nul
@echo.- 预备开服前工作准备...
choice /t 1 /d y /n >nul
@echo. 
@echo.- [ 设置开服内存：%SetS%MB-%SetX%MB ]
choice /t 1 /d y /n >nul
@echo. 
@echo.- [ 设置开服核心为：%Server% ]
choice /t 1 /d y /n >nul
@echo. 
@echo.- [ 设置开服优化参数：%SetCS% ]
choice /t 1 /d y /n >nul
@echo. 
@echo.- [ 设置开服额外参数：%SetEW% ]
choice /t 1 /d y /n >nul
@echo.
@echo.- 预备开服工作完毕,准备启动服务器,开服过程请耐心等待...
@echo.
@echo. ---------------------------------------------------------------
@echo.
java -Xmx%SetX%M -Xms%SetS%M -Xmn%SetNq%M %SetCs% %SetEw% -jar %Server%.jar nogui
@echo. 
@echo. ---------------------------------------------------------------
@echo.
@echo.                            服务器已关闭
@echo.                      服务器将在十秒后自动重启
@echo.                          已重启次数：%a%
@echo. 
@echo. ---------------------------------------------------------------
@echo. 
ping -n 10 127.1>nul
set /a a+=1
goto head
