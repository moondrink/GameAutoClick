用于不思议迷宫的密令自动输入，由于要输入中文，采用了Utf7ImeHelper。
Utf7ImeHelper地址：https://github.com/sumio/uiautomator-unicode-input-helper

编译方法可参考uiautomator介绍.txt中的说明。

使用方法：
1.安装Utf7Ime.apk;
2.将手机的默认输入法改为 UTF7 IME for UI Testing;
3.将编译好的jar包推送到手机端
adb push bin/AutoClick.jar /data/local/tmp/
4.执行自动化操作
adb shell uiautomator runtest AutoClick.jar
