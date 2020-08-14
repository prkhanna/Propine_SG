 Feature: Proline Date Parser

 
 @Regression
 Scenario Outline: Checking for the  date formats
  Given Enter the date in '<enter>' input field
 Then Click on submit button
 Then Check the output '<result>' field 
 
 Examples: 
 |  enter        |  result     |
# |               | Invalid date|
 | #$%@          | Invalid date|
 | abcd          | Invalid datee|
 #|18021988       | Invalid date|
# |2020           |Wed Jan 01 2020 00:00:00 GMT+0000|
# |01/01/2020     |Wed Jan 01 2020 00:00:00 GMT+0000|
# |01-01-2020     |Wed Jan 01 2020 00:00:00 GMT+0000|
# |3/3/2020       |Tue Mar 03 2020 00:00:00 GMT+0000|
# |Feb 15 2020    |Sat Feb 15 2020 00:00:00 GMT+0000|
# |February 2 2020|Sun Feb 02 2020 00:00:00 GMT+0000|
# |0              |Sat Jan 01 2000 00:00:00 GMT+0000|
# |-50            |Sun Jan 01 1950 00:00:00 GMT+0000|
# |+50            |Sat Jan 01 2050 00:00:00 GMT+0000|
# |test@123       | Invalid date|
 |Feb 31 2020    | Invalid date|
 
 