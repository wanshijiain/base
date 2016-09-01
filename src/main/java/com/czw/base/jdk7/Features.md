
##1.Switch on String
```java
//jdk7之前只支持integral types
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



















