
##1.Switch on String
```java
//jdk7之前只支持integral types
//支持枚举
String day = "SAT";
switch (day) {
   case "MON": System.out.println("Monday"); break;
   case "TUE": System.out.println("Tuesday"); break;
   case "WED": System.out.println("Wednesday"); break;
   case "THU": System.out.println("Thursday"); break;
   case "FRI": System.out.println("Friday"); break;
   case "SAT": System.out.println("Saturday"); break;
   case "SUN": System.out.println("Sunday"); break;
   default: System.out.println("Invalid");
}
```

##2.Binary data with "0b"
```java
int b = 0b00000000000000000000000000000001; //32bits,rst: 1
int b = 0b0000_0000_0000_0000_0000_0000_0000_0001;
int number3 = 2_123_456;//seperate with _
```

##3.多异常捕捉
```java
catch(ClassNotFoundException|SQLException|Exception ex)
```
##4.关闭资源
```java
try (BufferedReader in  = new BufferedReader(new FileReader("in.txt"));
       BufferedWriter out = new BufferedWriter(new FileWriter("out.txt"))) {
       
     int charRead;
     while ((charRead = in.read()) != -1) {
        System.out.printf("%c ", (char)charRead);
        out.write(charRead);
     }
} catch (IOException ex) {
     ex.printStackTrace();
}

注：不再需要在finally中对资源进行关闭处理
```
##5.泛型缩写
```java
List<String> lst2 = new ArrayList<>();
```














